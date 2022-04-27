package shopping;
import java.util.ArrayList;
import java.util.List;

public class MainMethodClass {
	public static void main(String[] args) {
		
		List<UserVO> userList = new ArrayList<UserVO>();
		userList.add(new UserVO(110,500,"BRIAN","2019-07-01 08:14:31"));
		userList.add(new UserVO(1000,500,"ALLEN","2020-03-01 14:30:31"));
		userList.add(new UserVO(120,800,"SANGWON","2021-05-11 18:20:31"));
		userList.add(new UserVO(130,1100,"KING","2022-04-21 09:10:31"));
		userList.add(new UserVO(140,300,"SMITH","2022-04-21 09:00:31"));
		userList.add(new UserVO(150,200,"SCOTT","2022-04-21 09:20:31"));
		userList.add(new UserVO(160,900,"WILLSON","2022-04-21 09:17:31"));
		userList.add(new UserVO(50,770,"SAM","2022-04-21 10:57:00"));
		
		ShoppingService service = new ShoppingService();
		System.out.println("---");
		//1. 회원 정보 조회.
		userList = service.getUserList(userList);
		
		System.out.println("---");
		//2. 회원 중 앞글자에 S가 들어간 회원 정보 조회.
		userList = service.getFindByName(userList, "S");
		
		System.out.println("---");
		//3. 현재날짜 기준으로 90일동안 방문 없었던 회원 휴먼 계정으로 수정.
		// 자바스크립트 date 찾아보기
		userList = service.updateNotSleeperToSleeper(userList, 90);
		
		System.out.println("---");
		//4. 휴먼계정 인원 수 조회.
		service.getSleeperUserCount(userList);
		
		System.out.println("---");
		//5. 휴먼계정이 아닌 회원에게 100포인트 추가 지급.
		userList = service.updatePoint(userList, 100);
		
		System.out.println("---");
		//6. 포인트가 가장 높은 회원 조회.(단, 중복데이터는 없다고 가정)
		service.getPointRankerUser(userList);
		
		System.out.println("---");
		//7. 특정 회원에게 상품구매 발생. 구매한 상품의 가격 5%가 포인트로 지급.

		System.out.println("---");
		//8. 구매이력이 있는 회원만 조회.
	}
}