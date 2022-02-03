step 1.
service 라는 이름의 패키지 만들기

step 2.
아래 3개 클래스 생성.
MainController.java
MainService.java
UserVO.java 

step 3.
UserVO, MainService UML은 아래와 같음

<img width="334" alt="UML" src="https://user-images.githubusercontent.com/67569810/151100518-46a4476d-cfa5-4bd6-a0bf-df4cea134648.png">


step 4.
MainController 파일에서 Main메소드 생성

step 5.
5-1. main 메소드에서 UserVO 클래스 호출(객체 생성)
5-2. main 메소드에서 MainService 클래스 호출(객체 생성)
5-3. MainService getUser 메소드 호출
5-4. getUser 메소드 로직 아래와 같이 추가할 것.
     파라미터에 1이상 100이하 숫자 입력.
     파라미터 데이터가 UserVO 필드변수 id에 대입.
     UserVO set 메소드 사용해서 id를 제외한 필드변수 데이터 대입.
5-5. main에서 getUser 메소드 리턴 결과 출력

public class UserVO {
	private int id; //필드변수
	private String name;
	private String email;
	private String phone;
	private boolean isLogin;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isLogin() {
		return isLogin;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
}


public class MainService {

	public void setUser(UserVO vo) {

	}

	public UserVO getUser(int id) {
		// 1. 리턴타입이 클래스임.
		// 2. UserVO를 호출(불러오기)해서 리턴 해야함.
		UserVO vo = new UserVO();
		// 파라미터 데이터를 UserVO 필드변수 id에 대입.
		// UserVO 필드변수 id에 파라미터 데이터를 대입 해야하는데,
		// UserVO 필드변수가 private 이라 접근할 수 없음.
		// 그래서 set과 get메소드 활용.
		vo.setId(id); // set 메소드 모두 작성!
		// set으로 UserVO 필드변수 id에 파라미터 데이터(int id)를 대입했음!!
		vo.setName("유영준");
		vo.setEmail("영준@네이버.com");
		vo.setPhone("010-6543-7480");
		vo.setLogin(true);
		return vo;
	}
}


public class MainController {
	public static void main(String[] args) {
		UserVO vo = new UserVO();
		// UserVO 클래스 호출
		MainService service = new MainService();
		// MainService 클래스 호출
		int id = 30;
		// 밑의 조건과 비교하기 위해 필요함
		if(id >= 1 && id<=100) {
			// 메소드 로직 조건 1. 파라미터에 1이상 100 이하 숫자 입력
			vo = service.getUser(id);
			// MainService getUser 메소드 호출!
			System.out.println("id : "+vo.getId());
			System.out.println("name : "+vo.getName());
		}
	}
}

