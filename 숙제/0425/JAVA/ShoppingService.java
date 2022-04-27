package shopping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ShoppingService implements ShoppingServiceImpl{
	@Override
	public List<UserVO> getUserList(List<UserVO> list) {
		for(UserVO vo : list) {
			System.out.println(vo.getUserNo()+", "+vo.getPoint()+", "+vo.getUserName()+", "+vo.getVisitAt());
		}
		return list;
	}

	@Override
	public List<UserVO> getFindByName(List<UserVO> list, String word) {
		System.out.println("앞글자에 S가 들어간 회원");
		for(UserVO vo : list) {
			boolean name = vo.getUserName().startsWith(word);
			if(name) {
				System.out.println(vo.getUserNo()+", "+vo.getPoint()+", "+vo.getUserName()+", "+vo.getVisitAt());
			}
			// 다른 방법
			// String firstName = list.get(i).getUserName().substring(0, 1);
			// if(firstName.equals(word)){
			// 	System.out.println("사원 번호 : "+list.get(i).getUserNo()+", 사원 이름 : "+list.get(i).getUserName()+", 포인트 : "+list.get(i).getPoint()+", 방문 날짜 : "+list.get(i).getVisitAt()+", 방문 날짜 : "+list.get(i).isSleeper());
			// }
		}
		return list;
	}

	@Override
	public List<UserVO> updateNotSleeperToSleeper(List<UserVO> list, int days) {
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
		return list;
	}
	
	@Override
	public int getSleeperUserCount(List<UserVO> list) {
		System.out.println("휴면계정 인원 수");
		int sleepCount = 0;
		for(UserVO vo : list) {
			if(vo.isSleeper()) {
				sleepCount++;
			}
		}
//		for(int i=0; i<list.size(); i++) {
//			if(list.get(i).isSleeper()) {
//				sleepCount++;
//			}
//		}
		System.out.println(sleepCount+"명");
		return sleepCount;
	}

	@Override
	public List<UserVO> updatePoint(List<UserVO> list, int point) {
		System.out.println("휴면계정이 아닌 회원에게 100포인트 지급");
		for(UserVO vo : list) {
			if(!vo.isSleeper()) {
				vo.setPoint(vo.getPoint()+100);
			}
			System.out.println(vo.getUserName()+", "+vo.getPoint());
		}
		return list;
	}

	@Override
	public UserVO getPointRankerUser(List<UserVO> list) {
		int temp = 0;
		int count = 0;
//		for(int i=0; i<list.size(); i++) {
//			if(list.get(i).getPoint() > temp) {
//				temp = list.get(i).getPoint();
//				count = i;
//			}
//		}
		int countEach = 0; // 회원 자리수 체크
		int tempEach = 0; // 임시저장 & 비교
		int save = 0; // 회원 자리수 저장 & 호출
		for(UserVO vo : list) {
			if(vo.getPoint() > tempEach) {
				tempEach = vo.getPoint();
				save = countEach;
			}
			countEach++; // 매 회전마다 카운트를 하나씩 올려서 원하는 값의 위치 체크
		}
		System.out.println("포인트가 가장 많은 회원");
//		System.out.println(list.get(count).getUserNo()+", "+list.get(count).getPoint()+", "+list.get(count).getUserName()+", "+list.get(count).getVisitAt());
		System.out.println(list.get(save).getUserNo()+", "+list.get(save).getPoint()+", "+list.get(save).getUserName()+", "+list.get(save).getVisitAt());
		return list.get(count);
	}

	@Override
	public List<UserVO> getPurchaseRankerUser(List<UserVO> list, ProductVO vo, int userNo) {
		System.out.println("구매이력이 있는 회원 조회");
		List<ProductVO> productList = new ArrayList<ProductVO>(); // ProductVO를 사용하기 위해 인스턴스화
//		for(UserVO vo2 : list) {
//			userNo = vo2.getUserNo();
//			if(vo2.getList() != null) {
////				구매 리스트를 null로 체크할 수 있는지?
//				System.out.println(vo2.getUserName()+", "+userNo);
//			}
//		}
		return null;
	}
}