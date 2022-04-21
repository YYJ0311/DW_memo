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
		System.out.println("����Ʈ�� ���� ���� ȸ��");
		System.out.println(list.get(count).getUserNo()+", "+list.get(count).getPoint()+", "+list.get(count).getUserName()+", "+list.get(count).getVisitAt()+", "+list.get(count).getList());
		return list;
	}

	@Override
	public List<UserVO> getFindByName(List<UserVO> list, String word) {
		System.out.println("�ձ��ڿ� S�� �� ȸ��");
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
//		�������̵��� �����ϸ� �� ��. ���� throws�� ���� �� ������ Ʋ�ȴ�.
		System.out.println("���糯¥ ���� 90�ϵ��� �湮 ������ ȸ�� �޸� �������� ����");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA); // �������İ� ���� �ð� ����
		String strToday = formatter.format(Calendar.getInstance().getTime());
		Date today = null; // ���ó�¥
		Date visit = null; // �湮��¥
//		Date now = new Date(); // ���� �ð�
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
					System.out.println("���� : "+vo.getUserName()+", �湮�� : "+vo.getVisitAt()+", �޸�������� : "+vo.isSleeper());
				}
			} catch (ParseException e) {
				e.printStackTrace(); // ������ �����ϰڴٴ� ��
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
