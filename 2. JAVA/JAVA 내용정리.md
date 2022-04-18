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

	- int, double, boolean은 앞 글자가 소문자인데 String은 대문자인 이유 : String이 Class라서!

# 데이터타입
	- 그 데이터가 문자인지, 실수인지, 논리형인지, 정수형인지 데이터의 타입을 지정함
	- 자바의 데이터 타입은 class까지 총 9개
	- 1바이트(byte)는 8비트(bit)
	- 값의 종류와 기본 타입까지만 알아두면 된다 (로봇개발이나 펌웨어 쪽은 메모리를 아끼기 위해 데이터 크기도 중요하지만 그 외에는 기본만.)
	- 파일을 실행시키면 메모리에 쌓인다. 메모리가 클수록 여러개의 파일을 실행시킬 수 있다.

	많이 쓰는 데이터 타입  
		숫자 : int(4바이트), long(8바이트)  
		소수 : double(8바이트)  
		논리 : boolean(1바이트)
		
	데이터 타입이 대문자이면 클래스라고 생각하면 됨

	정적 : Int, Double, Char, Float, 배열([])
	동적 : String, Class, 배열
		* Heap Area(동적을 관리하는 영역, Heap 메모리에 저장됨)
	컴퓨터 내부에서 정적타입과 동적타입을 관리하는 영역이 다름

	class 파일을 많이 만들어서 사용하다보면 Heap 영역에서 오류가 나게 된다.
	(Heap에 더이상 저장 공간이 없으면 서버가 다운됨)

	Heap을 튜닝하는 건 시니어 개발자나 엔지니어의 몫

	동적타입인 클래스는 heap 메모리 공간에 저장되는데 저장될 때 고유번호를 받는다(메모리 주소)
	문자를 비교할 때, == 를 사용하면 문자를 비교하는 것이 아니라 해당 주소를 비교한다. 따라서 equals()를 사용해서 비교한다!

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
	
	클래스는 필드변수(특성)와 메소드(행동)로 구성된다.

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

	GET, SET 메소드를 쓰는 이유
		필드변수 접근지정자를 private으로 설정함으로써 다른 클래스 파일에서 불러올 수 없음(보안성)
		1. private 필드변수를 생성자로 접근할까?
			장점) 클래스 호출과 동시에 값 초기화
			단점) 유지보수 힘듦 ( 필드변수가 많아지면 많아질수록)
		2. 필드변수마다 메소드(get, set)를 생성할까?
			장점) 유지보수 편리
			단점) 필드변수가 추가될 때마다 메소드를 만들어야 함
            => 이클립스에서 자동으로 생성해 준다!(단점 상쇄)
		
# 생성자
	1. 생성자는 함수이다(특수함수)
	2. 생성자는 return이 없다
	3. 함수이름은 클래스이름과 동일해야 한다
	4. 기본 생성자 존재

	생성자를 사용하는 이유
		필드변수(전역변수)에 값을 대입하기 위해서
		(필드변수는 클래스 안에 있는 모든 메소드에서 사용이 가능하다)

	생성자와 일반함수의 차이 
		: 생성자는 return을 정의하지 않는다.
        이유 
			: 생성자는 파라미터 값을 받아서 결과를 처리하고 return하는 게 아니라 값을 초기화하는게 목적이기 때문
	
	new는 자바 특징이 아니라 객체 지향 언어의 특징이다. 자바스크립트에도 존재함.


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

# 플래그(FLAG)
	상태를 기록하고 처리 흐름을 제어하기 위한 boolean형 변수
	flag 값이 true 냐 false냐에 따라 서로 다른 코드를 실행시킨다
		ex) 회원가입할 때 양식에 맞게 쓰면 true, 아니면 false. 
			플래그 값이 true면 회원 저장, false면 뒤로가기 혹은 "다시 입력하세요" 출력
```java
	public static void main(String[] args) {
		boolean isFlag = false; // true or false만 온다.
		int num = 10;
		int num_2 = 20;
		if (num == num_2) {
			isFlag = false; // 상태 제어
		}
		if (isFlag) { // true를 의미
			System.out.println("true 입니다.");
		}
		if (!isFlag) { // false를 의미
			System.out.println("false 입니다.");
		}
		if (5 == 5) {
			isFlag = true;
		}
		if (isFlag) {
			int sum = 0;
			for (int i = 0; i < 5; i++) {
				sum += i;
			}
			System.out.println("true일때만 실행하는 로직예제" + sum);
		}
		if (!isFlag) {
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				sum += i;
			}
			System.out.println("false일때만 실행하는 로직예제" + sum);
		}
	}
```
		
# 코딩규칙
	1. 플래그를 남발하지 말 것
	2. boolean 타입의 변수를 사용할 때는 이름 앞에 is를 붙이자
		ex) isResult, isTrue
	3. 변수(or 메소드) 이름은 길면 길수록(표현을 잘 해줄수록) 좋다

# 생성자와 함수의 차이
	생성자와 함수는 목적이 다르다
	1. 생정자는 초기화, 함수는 로직을 처리 or 리턴
	2. 생성자는 reuturn이 없다
	3. 생성자 이름은 클래스 이름과 동일해야 한다
		(클래스 이름과 다르면 함수로 인식함)

# 상속
	중복된 행위들을 상속으로 묶는다
	공통행위를 하는 클래스를 따로 만든다
	객체지향 프로그래밍에 존재함

	상원 class
		출근하다()
	근환 class
		출근하다()
	인석 class
		출근하다()
	
	가 있다면, 공통기능 클래스를 만들어서 기능을 가져다 쓴다
		공통기능 class 
			출근하다()
	
	공통기능 : 부모 클래스(or 슈퍼 클래스)
	상원, 근환, 인석 : 자식 클래스(or 서브 클래스)

	- 메소드와 필드변수를 제공하는 주체가 부모이다
	- 자식 클래스는 부모의 기능(메소드, 필드변수)를 사용할 수 있지만 반대는 사용 못 함
	- 모든 클래스의 부모는 Object (디폴트로 Object를 상속받고 있음)
	- 자바는 C++과 다르게 다중 상속이 없다 (부모는 1명)

	문법
	extends : 상속
	class Pizza extends Object{
		<!-- 피자가 object를 상속하다 -->
		<!-- 부모가 Object, 자식이 Pizza -->
	}

# 필드 변수를 getter, setter 메소드로 접근하는 이유
```java
class StoreSub{
	int money;
	public int sumMoney(int money) {
		int sum = this.money += money;
		// sum = this.money = this.money + money 
		// 왼쪽 money는 StoreSub에 있는 money, 오른쪽에 있는 money는 파라미터 money
		return sum;
		// = return this.money
	}
}
public class Store {
	public static void main(String[] args) {
		// StoreSub s = new StoreSub();
		// s.money = 100;
		// s.money += 100;
		// System.out.println(s.money);
		// 실무에서는 보안상 이유 때문에 필드변수(위에선 money)를 private으로 만들기 때문에 위와같이 직접 접근할 수 없음
		// private한 필드변수는 메소드를 활용해서 접근해야 한다.

		StoreSub s = new StoreSub(); // 객체(필드변수 money) 생성. money = 0
		// 원래는 이렇게 클래스를 불러오면, 사용한 뒤 그 마지막을 표현해 줘야 한다. (C++은 소멸하는 문법(~StoreSub();)을 직접 타이핑 함)
		// 하지만 자바는 객체를 생성하고나서 자동으로 소멸시켜 주기 때문에 따로 적지 않음.
		int result = s.sumMoney(100); // 100
		result = s.sumMoney(100); // 200
		System.out.println(result);
	}
}
```

# static main 함수에서 사용 가능함 함수
```java
    static main(){
		// 메인 함수에서 사용 가능한 함수는 2가지
        // 1. 스태틱 함수
        // 2. new로 불러온 함수 (heap에 있는 동적타입)
    }
```

# 제네릭 & 컬렉션즈
	실무에서 배열은 잘 사용하지 않고 컬렉션즈를 많이 사용한다
	프로그래밍을 하려면 자료구조를 알고, 구현할 줄 알아야 한다 (자료구조 : STACK, HEAP, 큐 등)
	그래서 원래는 자료구조를 공부하고나서 언어를 공부했지만 컬렉션즈의 등장으로 자료구조를 몰라도 언어를 공부할 수 있게 되었다 (컬렉션즈가 등장한 03년쯤부터 개발자 수 폭등함)

	이전까지 연관된 데이터(타입이 같은 데이터)를 관리하기 위해서 배열을 사용했다
		배열 선언 1
			int arr[] = [1,3,4,10,10,0,0]
			여기서 배열을 늘리기 위해서는 값을 하나씩 넣어줘야 한다
				arr[5] = 10;
		배열 선언 2
			int arr[] = new int[10];
				배열의 크기를 미리 지정 (위는 길이가 10인 배열)
	배열의 불편한 점 중 하나는 위와같이 한번 정해진 배열의 크기를 변경할 수 없다는 점이고, 이를 해결하기 위해서 컬렉션즈를 사용한다.

	컬렉션즈(컬렉션즈 프레임워크)
		컨테이너라고도 부르고(값을 담는 그릇이라는 의미), 담긴 값의 성격에 따라서 컨테이너의 성격이 조금씩 달라진다.
		자바에서는 다양한 상황에서 사용할 수 있는 여러 컨테이너를 제공하는데, 이걸 컬렉션즈 프레임워크라고 한다.

		Collection
			- Set
			- List
			- Queue
		Map

		Collection과 Map이라는 최상위 카테고리가 있고, 그 아래 다양한 컬렉션들이 존재한다.
			컬렉션 종류에는 ArrayList, HashMap, HashSet이 대표적이고, 이 중에서도 ArrayList를 정말 많이 사용함
			(select로 가져온 데이터를 ArrayList)에 담는다
```java
package 컬렉션즈;
import java.util.ArrayList;
public class ArrayList_Study {
	public static void main(String[] args) {
//		ArrayList<String> list; // ctrl + shift + o로 import 필요
		ArrayList<String> list = new ArrayList<String>();
		// <> : 제네릭
		// 제네릭 안에 지정된 데이터 타입에 의해서 ArrayList의 타입이 결정됨
		// * <>(제네릭) 안에는 클래스만 올 수 있다.
		// int -> Integer, double -> Double로 바꿔서 사용한다.
		list.add("시금치 파스타");
		list.add("곱창 파스타");
		list.add("곱창 파스타");
		list.add("곱창 파스타");
		list.add("곱창 파스타");
		// 데이터를 list에 삽입
		int len = list.size();
		System.out.println("list 길이는 : "+len); // 5

		String value = list.get(0); // 시금치 파스타
		String value02 = list.get(1); // 곱창 파스타
		
		// list에 저장된 곱창 파스타는 몇개인지 코딩으로 풀기
		// 자바에서 ==는 문자 비교를 의미하는게 아니라, 문자가 저장된 주소를 비교하는 것임. 따라서 문자비교는 equals를 사용!
		int count = 0;
		for(int i=0; i<len; i++) {
			if(list.get(i).equals("곱창 파스타")) {
				count++;
			}
		}
		System.out.println("곱창 파스타는 총 "+count+"개"); // 4개
		
		// int를 담는 ArrayList
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);
		list2.add(40);
		list2.add(60);
		list2.add(80);
		list2.add(30);
//		list2.remove(1); 
		// 제거되면 뒤에 있는 원소들이 앞으로 한칸씩 당겨짐 (컬렉션즈 나오기 전엔 이걸 모두 로직으로 구현해야 했다..)
		// 원소 각각이 주소를 갖고있고 하나가 지워지면 그 뒤에 있는 원소들의 주소가 하나씩 당겨진다 
		// = 지워진 원소의 주소가 다음 원소에게 넘어간다 => list의 특징

		// 문제 1. list에 추가된 숫자 총합
		int sum = 0;
		for(int i=0; i<list2.size(); i++){
			sum += list2.get(i);
		}
		System.out.println("총합 : "+sum); // 220

		// 문제 2. 40 제외하고 총합 구하기
		int sumExcept = 0;
		for(int i=0; i<list2.size(); i++) {
			if(list2.get(i) != 40) {
				sumExcept += list2.get(i);
			}
		}
		System.out.println("40을 제외한 총합 : "+sumExcept); // 180
	}
}
```