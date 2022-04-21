package shopping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ShoppingService implements ShoppingServiceImpl{
	@Override
	public List<UserVO> getUserList(List<UserVO> list) {
		int temp = 0;
		int count = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getPoint() > temp) {
				temp = list.get(i).getPoint();
				count = i;
			}
		}
		System.out.println("포인트가 가장 많은 회원");
		System.out.println(list.get(count).getUserNo()+", "+list.get(count).getPoint()+", "+list.get(count).getUserName()+", "+list.get(count).getVisitAt()+", "+list.get(count).getList());
		return list;
	}

	@Override
	public List<UserVO> getFindByName(List<UserVO> list, String word) {
		System.out.println("앞글자에 S가 들어간 회원");
		for(UserVO vo : list) {
			boolean name = vo.getUserName().startsWith(word);
			if(name) {
				System.out.println(vo.getUserNo()+", "+vo.getPoint()+", "+vo.getUserName()+", "+vo.getVisitAt()+", "+vo.getList());
			}
		}
		return list;
	}

	@Override
	public List<UserVO> updateNotSleeperToSleeper(List<UserVO> list, int days) {
//		public List<UserVO> updateNotSleeperToSleeper(List<UserVO> list, int days) throws ParseException {
//		오버라이딩은 수정하면 안 됨. 따라서 throws가 붙은 위 문장은 틀렸다.
		System.out.println("현재날짜 기준 90일동안 방문 없었던 회원 휴먼 계정으로 수정");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA); // 포맷형식과 기준 시간 변경
		String strToday = formatter.format(Calendar.getInstance().getTime());
		Date today = null; // 오늘날짜
		Date visit = null; // 방문날짜
//		Date now = new Date(); // 현재 시간
			try {
				for(UserVO vo : list) {
					String strVisitAt = vo.getVisitAt();
					today = formatter.parse(strToday);
					visit = formatter.parse(strVisitAt);
					long diff = (today.getTime() - visit.getTime()) / (1000*60*60*24);
					if(diff >= days) {
						vo.setSleeper(true);
					}else {
						vo.setSleeper(false);
					}
					System.out.println("유저 : "+vo.getUserName()+", 방문일 : "+vo.getVisitAt()+", 휴면계정여부 : "+vo.isSleeper());
				}
			} catch (ParseException e) {
				e.printStackTrace(); // 에러를 추적하겠다는 뜻
			}
		return null;
	}
	
	@Override
	public int getSleeperUserCount(List<UserVO> list) {
		return 0;
	}

	@Override
	public List<UserVO> updatePoint(List<UserVO> list, int point) {
		return null;
	}

	@Override
	public UserVO getPointRankerUser(List<UserVO> list) {
		return null;
	}

	@Override
	public List<UserVO> getPurchaseRankerUser(List<UserVO> list, ProductVO vo, int userNo) {
		return null;
	}
}
