# 객체지향언어
	- 자바는 객체 지향 언어이다.

	- 객체 = 클래스 들이 모여서 하나의 프로그램이 탄생함
			 객체를 사용하는 이유 : 업무 분담으로 일의 효율성을 위해서

	- 특징
		1. 캡슐화
			내부를 캡슐처럼 보호(클래스가 메소드를 담고 있음)
		2. 상속
			클래스를 부모와 자식으로 두고 부모의 기능을 물려받음
		3. 다형성
			같은 이름의 메소드가 다르게 구현 (메소드 오버로딩, 오버라이딩)

	- 클래스 파일 안에 클래스를 여러개 만들 수 있음. But, public class는 해당 클래스 파일에 한번만 올 수 있다! (퍼블릭 클래스는 고유함)

# 그 외
	- 자바 및 프로그래밍에서 "=" 는 "대입"의 의미

	- 이클립스 출력함수
		System.out.println("Hello World!");
		syso 입력하고 ctrl+스페이스바 누르면 자동완성됨
		ctrl + f11 누르면 Hello World 출력!

		int 메시 = 5;
		int 호날두 = 5;
		System.out.println("a와 b는 같은가요? " + (메시 == 호날두));
        ====> true

	- 명칭  
		DB : 데이터베이스 -> 테이블 -> 데이터
		JAVA : 프로젝트 -> 패키지 -> 클래스(코드 파일)
		(이클립스에서) src(프로젝트) -> study(패키지) -> Money(클래스)

	- 자바는 컴파일 언어라서 세미콜론을 찍어서 문장을 종료해 줘야 한다.
		(;를 찍어줘야 컴퓨터가 한 문장이라고 이해함)

	- 지역변수 : 중괄호 안에서만 존재, 전역변수 : 중괄호 밖에서도 존재


# 데이터타입
	그 데이터가 문자인지, 실수인지, 논리형인지, 정수형인지 데이터의 타입을 지정함
	- 자바의 데이터 타입은 class까지 총 9개
	- 1바이트(byte)는 8비트(bit)
	- 값의 종류와 기본 타입까지만 알아두면 된다 (로봇개발이나 펌웨어 쪽은 메모리를 아끼기 위해 데이터 크기도 중요하지만 그 외에는 기본만.)
		파일을 실행시키면 메모리에 쌓인다. 메모리가 클수록 여러개의 파일을 실행시킬 수 있다.
	- 많이 쓰는 데이터 타입  
		숫자 : int(4바이트), long(8바이트)  
		소수 : double(8바이트)  
		논리 : boolean(1바이트)
	- 데이터 타입이 대문자이면 클래스라고 생각하면 됨

# 자바 변수이름 규칙
	1. 명사
	2. 길이제한 없음
	3. 복합명사일 때는 두번째 명사를 대문자로 쓰거나 _를 사용
		ex) userInfo = user_info (대부분 userInfo같은 카멜표기법으로 사용)
	4. 소문자
		정해져 있는 상수값을 표기할 때는 대문자  
		ex) double PI = 3.14
			String ACTOR_NAME = '박서준'
		아닌 것들은 소문자를 사용(소문자 변수는 값이 변경 가능함을 의미)
		ex) String name = '철수'
			int level = 6
	5. 중복 불가능

	암묵적인 룰
	프로젝트명 : 소문자 or 대문자  
	패키지 : 소문자  
	클래스 : 첫글자는 대문자 (ex. Emp)
	각각의 이름은 명사여야 함(동사 X)

# 스캐너
	Scanner scan = new Scanner(System.in); // ctrl + shift + o 입력하면 위에 import 생성됨
		=> 실무에서는 DB랑 연동해서 데이터를 사용하고 이 방법은 잘 안 씀

<!-- 1번 -->
	System.out.print("이름을 입력하세요 ==>");
	String name = scan.next(); //문자를 입력할 때
	System.out.print("좋아하는 숫자를 입력하세요 ==>");
	int num = scan.nextInt(); // 숫자를 입력할 때
	System.out.println("안녕하세요 제 이름은 " + name + " 입니다.");
	System.out.println("제가 좋아하는 숫자는 " + num + " 입니다.");

<!-- 2번 -->
	Scanner scan = new Scanner(System.in); 
	System.out.print("숫자를 입력하세요 ==>");
	int value = scan.nextInt();
	// 문제 : 1 ~ 100 사이 숫자를 입력할 것
	// 조건 : if/else, 사칙연산을 사용, 변수는 value만 이용
	// 조건 : 100이 넘어가면 100이 넘었습니다 출력
	// 조건 : 1 ~ 100 안에 있는 숫자면 2의 배수인지 3의 배수인지 출력
	if (value >= 1 && value <= 100) {
		if ((value % 2) == 0) {
			System.out.println("2의 배수입니다.");
		}
		if ((value % 3) == 0) {
			System.out.println("3의 배수입니다.");
		}
	} else {
		System.out.println("100이 넘었습니다.");
	}

<!-- 3번 -->
	Scanner scan = new Scanner(System.in);
	System.out.print("점수를 입력하세요 ==>");
	int value = scan.nextInt();
	// 점수가 90점 이상이면 A
	// 점수가 95점 이상이면 S
	// 조건. if/else를 사용할 것
	if(value >= 95 && value <= 100) {
		System.out.println("S");
	}
	if(value >= 90 && value < 95) {
		System.out.println("A");
	}

<!-- 4번 -->
	Scanner scan = new Scanner(System.in);
	// 90점 초과 A, 80점 초과 B, 70점 초과 C, 나머지 F
	// 조건. else if로 풀어볼 것
	int score = 88;
	if (score > 90) {
		System.out.println("A 학점");
	} else if (score > 80) { // 괄호 안에 && score <= 90 추가하는게 좋다.
		System.out.println("B 학점");
	} else if (score > 70) { // 괄호 안에 && score <= 80 추가하는게 좋다.
		System.out.println("C 학점");
	} else {
		System.out.println("F 학점");
	}

# 삼항연산자 (if문 대체)
	?를 기준으로 왼쪽엔 괄호(조건식), 오른쪽엔 :이 온다	
	(왼쪽 조건식이 정답이라면 :을 기준으로 왼쪽을 실행시키고, 거짓이면 오른쪽을 실행시킴)
	<조건>? <참일경우 실행할 내용> : <거짓일경우 실행할 내용>

	ex) a > b ? printf("a가 크네") : printf("b가 크네");
	ex) int 손흥민 = (10 > 4) ? 10 : 30;
		System.out.println(손흥민);
		==> 10 출력
	ex) 실무에서 회원이 로그인했는지를 괄호 안에서 체크하고 맞으면 home페이지로, 틀리면 login 페이지로 감  
		((조건) ? home : login )

# 논리연산자
	sql에서 같다의 표현 : =
	모든 프로그래밍에서 같다의 표현 : ==
	AND : &&
	OR : || 	

# 줄바꿈 방법		
	시스템종류에 따라		
	\n : unix		
	\r : mac		
	\r\n : windows		
	또는 다음으로 자동으로 시스템에 따른 줄바꿈을 사용할 수 있다.		
	1. System.getProperty("line.separator")		
	2. System.lineSeparator()		

# 반복문(for)
	- 코드의 중복을 제거
	- for 안에 변수 i = index의 i(암묵적인 룰)
		for(int i=0; i<10; ++i) { 
				(코 드) 
		}
	- int i : 초기문(선언문) / i<10 : 조건식 / ++i : 반복 작업식
	- 실행순서 : 선언문 -> 조건식 -> for문 중괄호 안의 코드 -> 반복 작업식

<!-- 문제 1. 1~10까지 중 짝수, 홀수 -->
	for (int i = 1; i <= 10; ++i) {
		if ((i % 2) == 0) {
			System.out.println(i + " 은(는) 짝수");
		}
		if ((i % 2) != 0) {
			System.out.println(i + " 은(는) 홀수");
		}
	}

<!-- 문제 2. 1~100까지 중 짝수는 몇개? -->
	int x = 0;
	for (int i = 1; i <= 100; ++i) {
		if ((i % 2) == 0) {
			++x;
		}
	}
	System.out.println("1~100까지 중 짝수의 개수는? : " + x + "개");

<!-- 문제 3. 1~10 총합 -->
	int 합 = 0;
	for (int i = 1; i <= 10; ++i) {
		합 += i;
	}
	System.out.println("1~10까지 합은? : " + 합);

<!-- 문제 4. break -->
	for(int i=0; i<5; i++) {
		System.out.println("밤하늘의 펄~~");
		if(i == 2) {
			break;
		}
	}

# 이중 for문
	첫번 for문의 선언문, 조건식을 실행하고 안에 있는 for문을 실행시킨다. 안에 있는 for문의 조건을 완성하면 다시 첫번 for문으로 올라가서 반복작업식을 거친 다음 다시 안에 있는 for문을 조건이 완성될 때까지 실행시키고, 다시 첫번 for문으로 올라가서 반복작업을 거친 다음 조건식에 해당되지 않을 때까지 반복한다. 첫번 for문의 조건식에 해당되지 않는다면 바로 직전까지 계산한 안에 있는 for문 값을 갖고 온다.

<!-- 문제 1. 구구단 이중 for문 -->
	for(int i=2; i<=9; i++) {
		System.out.println(i+"단");
		for(int j=1; j<=9; j++) {
			System.out.println(i+"X"+j+"="+(i*j));
		}
	}

<!-- 문제 2. 별찍기 -->
	// if/else 사용 X, 전역변수 선언 X
	// 1.증가
	for(int i=0; i<5; i++) {
		for(int j=0; j<=i; j++) {
			System.out.print("*");
		}System.out.println();
	} 
	System.out.println();
	// 2. 감소
	for(int x=5; x>0; x--) {
		for(int y=0; y<x; y++) {
			System.out.print("*");
		}System.out.println();
	}

# for each문(향상된 for문)
	for(int i : array) { }
	배열의 길이만큼 하나씩 더해서 알아서 i에 대입해줌
```java
	int array[] = {10, 20, 30, 40 ,50};
	for(int number : array){
		System.out.println(number);
	}
```
# 반복문(while)
	int count = 0;
	while(true) {
		++count;
		if(count == 3) {
			break;
		}
	}
<!-- 위 for문제 while로 바꾸기 -->
<!-- 1번. 1~100까지 짝수 개수는? 카운트 30이면 멈춤 -->
	int i = 1;
	int count = 0;
	while (true) {
		++i;
		if ((i % 2) == 0) {
			++count;
			}
		if (count == 30) {
			break;
		}
	}
	System.out.println("count 30에서 멈춰! : " + count);

<!-- 2번. 1부터 차례대로의 총합이 55면 멈춰라 -->
	int sum = 0;
	int x = 1;
	while (true) {
		++x;
		sum = sum + x;
		if (sum == 55) {
			break;
		}
	}
	System.out.println("합 55에서 멈춰! : " + sum);

# 자바 문자비교
	string == 은 비교하고자 하는 대상의 주소(위치) 값을 비교함
	equals 는 대상의 값 자체를 비교함
	=> 자바 문자 비교는 equals로 한다.

# 메소드
	이클립스의 src = 소스파일을 의미
	
	메소드(함수, 기능)란?
		- 무언가를 개발하기 위해서 기능을 나눠야 함. 로봇의 각각의 기능을 쪼개야 함.      
		- 각 기능을 분리해서 개발(응집도는 높고 결합도는 낮게)해야 소프트웨어 품질 향상.           
		(로봇의 팔과 다리 소스를 결합도 높게 만들면 나중에 하나가 고장났을 때 둘 다 봐야하는 문제가 생긴다.)
		- 함수를 잘 만들어 놓으면 나중에 어딜가든 재사용할 수 있다!!  

	메소드 문법		
		<접근지정자> <리턴타입> <함수 이름> (인자값)
		- 함수 이름은 동사로 지정
		- 인자값(파라미터값)에는 제한이 없지만 최대 3개까지만 지정하는것이 암묵적 규칙
		- 리턴타입은 최종적으로 구하고자 하는 값의 데이터타입이다.

	접근지정자
		public, private, protected, 디폴트 접근지정자
		- 객체지향 언어는 대부분 4개의 접근지정자가 있다.     
		- 실무에서는 public과 private만 쓴다.
		- public으로 지정하면 다른 클래스파일에서 메소드를 재사용할 수 있고, private은 내부 클래스에서만 사용 가능하다.

	리턴타입
		메소드에서 반환하는 최종 결과값의 타입
		리턴 타입에는 데이터타입 8개(int, double, long, float, ...)와 클래스타입 1개(String) 총 9개가 위치한다.      
		리턴 타입이 없을 때는 void로 표현

	인자값(파라미터값)
		데이터 타입 8개 + 클래스 타입 1개
		인자값이 없을 때는 () 빈 괄호
		*** 인자값(파라미터값)은 3개 이하로 작성 : 보기 쉽게하기 위함

	return
		메소드에서 if를 쓸 경우, 컴퓨터는 혹시모를 if가 틀릴경우를 대비해서 return 0; 을 쓰지 않으면 오류를 표시한다. 따라서 마지막 줄에 return 0; 을 꼭 써줘야 한다. 또는 if( ~ ){ ~ }else { return; } 으로 선택지를 없게 만들어서 마지막에 return을 안 쓸 수 있다.	

	메소드를 사용하는 이유
		재사용가능, 코드 간결해짐
		메소드에 들어오는 값만 다르고 출력하는 방법은 같다

	println의 리턴타입은 없음(void) 그리고 괄호 안에 string이 온다.
	파라미터 순서에 맞게 값을 넣어줘야 한다.(순서가 다르면 오류발생)
	각 파라미터 값을 숫자로 대입하기 보다 그 파라미터를 나타내는 변수를 지정해 주는게 좋은 코드이다.
		int 순대개수 = 30; 
		int 내장 = 50;       
		순대국밥(순대개수,내장)
		=> int로 변수를 지정하고 파라미터 안에 변수 이름을 넣었음
	메소드 분리를 잘 하는 것이 중요!

	메소드 오버로딩(overloading)
		이름이 같은 여러개의 메소드를 중복선언하여 사용의 편리성 제공
		조건
			1. 메소드 이름이 동일해야 함
			2. 인자의 개수 or 타입이 달라야 함 => 파라미터가 중요!
			3. 동일한 클래스 파일 안에 있어야 함

		```java
		public int getSum(int x, int y) {
			return 0;

		}
		public int getSum(int x, int y, int z) { // 인자의 개수가 다름
			return 0;
		
		}
		public int getSum(int x, String y) { // 인자의 타입이 다름
			return 0;
		
		}
		```
		


# 아이디 입력받기 문제
```java
	//조건 1. 아이디 길이가 10이하, 2이상
	//조건 2. 아이디를 대문자에서 소문자로 변경.
	//조건 3. 아이디에 '!'가 들어가면 안됨.
	//조건 4. 아이디에 문자 공백이 들어가면 안됨.
	public static String getResult(String id) {
		String temp = "";
		if(id.length() <= 10 && id.length() >=2){
			temp = id.toLowerCase();
			temp = temp.replace("!","");
			temp = temp.replace(" ","");//가운데 문자열 공백제거는 trim으로 불가능
			return temp.trim();
		}
		return temp;
	}
	public static void main(String[] args) {
		String userID = "J a!va! ";
		String id = getResult(userID);
		System.out.println(id);
	}

	* if 절 마지막에 trim으로 리턴하는 이유 : replace만으로도 공백이 다 지워지지만 나중에 코드를 보고 userID의 앞, 뒤에 공백이 있음을 알기 쉽게하기 위해 적어준다.
```

---
- 클래스는 필드변수(특성)와 메소드(행동)로 구성!
---

# 생성자 문제
```
2)
Pizza p = new Pizza();

데이터 타입 : Pizza
변수 명 : p
연산자 : = 
생성자 : Pizza() or 기본생성자

3) 
Pizza p = new Pizza("치즈피자");

데이터 타입 : Pizza
변수 명 : p
연산자 : =
생성자 : Pizza("치즈피자") or String을 받는 생성자

8) 
Pizza p = null;
p.피자종류 = "치즈피자";
p.피자종류 값은? 

답 : 오류 남!! 피자파일을 호출해야 피자파일 안에 있는 필드변수(메소드) 사용 가능!!
메인 또는 메소드에 p = new Pizza(); 추가로 입력해 주면 됨!

11)
Pizza클래스 피자종류 필드변수는 String 타입이다.
p.피자종류 = "콤보피자"
데이터 타입 : String
변수 명 : p.피자종류
연산자 :  =
데이터 : "콤보피자"
```

# UML(Unified Modeling Language)
	통합 모델링 언어(모델을 만드는 표준 언어)
	소프트웨어 초기 스케치 작업
	사용하는 이유
		1. 다른사람들과 의사소통 또는 설계 논의
		2. 전체 시스템 파악
		3. 유지보수를 위한 설계의 back-end 문서
![](UML%202022-01-24-16-21-28.png)
-는 private +는 public을 의미

아래 메소드 수정 필요

```java
	public class UserVO {
		private int age;
		private String name;
		private String nickName;
		private String addr;

		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getNickName() {
			return nickName;
		}
		public void setNickName(String nickName) {
			this.nickName = nickName;
		}
		public String getAddr() {
			return addr;
		}
		public void setAddr(String addr) {
			this.addr = addr;
		}
	}

	public class User {
		private int count;
		
		public boolean setUser(UserVO vo) { // 파라미터로 클래스를 받음
			return true; // boolean은 return을 true or false로 갖는다!
		}
		public int getUserCount() {
			return 0;
		}
		public int updateUser(UserVO vo) {
			return 0;
		}
		public int deleteUser(UserVO vo) {
			return 0;
		}
		public UserVO getUser(int id) {
			return null;
		}
	}

	public class UserCall {
		private User user;
		public static void main(String[] args) {
			User user = new User();
			UserVO vo = new UserVO();
			vo.setAddr("대전 충정로");
			vo.setAge(50);
			vo.setName("홍길동");
			vo.setNickName("몽키.D.길동");
			user.setUser(vo);
		}
	}
```