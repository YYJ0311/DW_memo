- 컴파일과 인터프리터 차이
컴파일 : 전체 소스코드를 보고 실행, 실행속도가 빠름 but 코드를 수정하려면 처음부터 다시
인터프리터 : 한줄씩 실행, 실행속도 느림, but 코드를 수정하고 즉시 실행됨!

- 자바는 데이터 타입이 class까지 9개!
1바이트 = 8비트

- 변수 이름 조건
    1) 명사
    2) 길이제한 없음
    3) 복합명사일 때 두번째 명사를 대문자로 쓰거나, _ 사용
    4) 보통 소문자 (대문자도 가능)
        소문자 변수는 값이 변경가능하다는 걸 의미
        ex) String name = "철수";
        대문자 변수는 값이 변경 불가능(상수값)
        ex) final double PI = 3.14;
            String ACTOR_NAME = "박서준";
    5) 중복 불가능

-  잔돈 계산
temp 변수를 만들어서 만원, 오천원 각각 나누고 남은 값을 다시 집어넣음
		int money = 57000;
		int man = 0;
		int ocheon = 0;
		int temp = 0;
		
		man = money / 10000;
		temp = money % 10000;
		ocheon = temp / 5000;
		temp = temp % 5000;

        System.out.println("거스름돈 이전 금액 : "+ money);
		System.out.println("만원 몇 장 ? :"+ man);
		System.out.println("오천원 몇 장 ? :"+ ocheon);
		System.out.println("최종 남은 금액은 ? :"+ temp + "원");

- 삼항 연산자
        int 손흥민 = (10 > 4) ? 10 : 30;

        System.out.println(손흥민);

        ==> 10 출력

- 간단한 ture/false 판단
    boolean을 안 썼지만 true or false로 출력된다.

	public static void main(String[] args) {
		int 메시 = 5;
		int 호날두 = 5;
		
		System.out.println(메시 != 호날두);
	}
    ===> false 출력됨

- 자바 파일 구성
    프로젝트 -> 패키지 -> 클래스

- 클린코드에선 else 를 권장하지 않음
    코드가 길어지면 컴퓨터가 생각할 시간이 늘어나기 때문.
    else를 쓰면 나중에 유지보수하기도 힘듦

- 스캐너
Scanner scan = new Scanner(System.in); 입력하고
ctrl + shift + o 누르면 위에 import 생성됨

- for문 읽는 순서
for (int i = 0; i < 10; ++i) {
    코드내용
}
    1. 초기문(선언문) : int 1 = 0;
    2. 조건식 : i < 10;
    3. 코드내용
    4. 반복작업식 : ++i

- 지역변수와 전역변수 구분하기
중괄호 밖에 있는 것이 전역변수

- break의 사용
   for(int i=0; i<3; ++i){
        if(i == 0){
            break;
        }
         System.out.println(i);
    }

여기서 출력되는 i 값은 없다!!
왜냐하면 프린트 함수가 for문 안에 있기 때문에 break로 인해서 건너뛰어진다.

다음에선 프린트 함수가 for문 밖에 있기 때문에 제대로 출력된다
		int index = 0;
		int array[] = { 30, 40, 50, 60, 10, 80 };
		for (index = 0; index < array.length; index++) {
			if (array[index] > 0 && array[index] < 100) {
				if (array[index] == 10) {
					break;
				}
			}
		}
		System.out.println(index);

- for 문을 while 문으로 바꾸기
    // 문제2. 1~100까지 중 짝수가 몇개인지 출력
    1-1. for 문
		int x = 0;
		for (int i = 1; i <= 100; ++i) {
			if ((i % 2) == 0) {
				++x;
			}
		}
		System.out.println("1~100까지 중 짝수의 개수는? : " + x + "개");

    1-2. while 문
        // 추가조건 : 카운트가 30이면 멈춤
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


    // 문제3. 1~10 총합은?
    2-1. for 문		
		int 합 = 0;
		for (int i = 1; i <= 10; ++i) {// ++i : 카운트 연산(1씩 세 줌)
			합 += i;
		}
		System.out.println("1~10까지 합은? : " + 합);

    2-2. while 문
		// 추가조건 : 55나오면 멈춤
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

- 구구단 메소드(이중 for 문)
		for(int i=2; i<=9; i++) {
			System.out.println(i+"단");
			for(int j=1; j<=9; j++) {
				System.out.println(i+"X"+j+"="+(i*j));
			}
		}

- 별찍기(이중 for문)
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

- for each 문
    for(int i : array) {
    }  
    : i를 0부터 array길이까지 하나씩 늘려가며 대입함

- 버블정렬
		System.out.print("내림차순 정렬 : ");
		int array44[] = {5,11,2,0,7};
		int a = 0; // 임시 저장
		for(int i=0; i<array44.length; i++) {
			for(int j=0; j<(array44.length-1); j++) { //중복계산을 빼기 위해 길이-1
				if(array44[i] > array44[j]) {
					a = array44[i]; //하나의 값을 a에 저장
					array44[i] = array44[j]; // j값을 i위치로 보냄
					array44[j] = a;
				}
			}
		}
		for(int i=0; i<array44.length; i++) { // array가 바로 출력이 안 돼서 이렇게 표현
			System.out.print(array44[i]+" ");
		}

- 메소드
    main은 자바에서 제일 먼저 실행되는 함수(기능)이다.
    접근지정자 : public / private / protected / default
    문법 : <접근지정자><리턴타입><함수이름>(파라미터)
    ex) public int getSum(int x, int y){

        }
    파라미터는 3개 이하로 작성하는 것이 암묵적 규칙(보기 쉽게하기 위함)

- 메소드를 사용하는 이유
    재사용성 증가
    코드 간결

- 거스름돈 구하기
	public static int 돈구하기(String money, int totalMoney) {
		int MAN = 10000;
		int OCHEON = 5000;
		int result = 0;
		if(money.equals("만원")) {
			result = totalMoney / MAN;
		}
		if(money.equals("오천원")) {
			result = totalMoney / OCHEON;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int totalMoney = 15000;
		int 몇장1 = 돈구하기("만원", totalMoney);
		int 몇장2 = 돈구하기("오천원", totalMoney);
		System.out.println("만원은 "+몇장1 +" 장");
		System.out.println("오천원은 "+몇장2 +" 장");
	}

- 메소드 오버로딩
    이름이 같은 여러개의 메소드를 중복 선언하여 사용의 편리성 제공
    조건
        1. 이름이 동일해야 함
        2. 인자의 개수가 달라야 함
        3. 인자의 타입이 달라야 함
        4. 동일한 클래스 파일 안에 있어야 함
    리턴타입은 상관없고 파라미터가 중요하다!
    ex) 	
    public int getSum(int x, int y) {
		return 0;
	}
	public int getSum(int x, int y, int z) { // 인자의 개수가 다름
		return 0;
	}
	public int getSum(int x, String y) { // 인자의 타입이 다름
		return 0;
	}

- 문자 메소드
    1. 대문자 변환
    변수.toUpperCase();
    2. 앞뒤 공백제거
    변수.trim();
    3. 문자배열 만들기
    변수.split("-"); // 문자를 - 기준으로 나눠서 배열로 만듦
    4. 특수문자 또는 공백 제거
    변수.replace("!", "");
    변수.replace(" ", "");

- 리턴 인자 문제
help(int x,int y):Pizza
메소드 이름 : help
인자 값 : int, int
리턴 값 : Pizza(String처럼 클래스 이름으로 읽는다.)

- 문자 고치기
	//조건 1. 아이디 길이가 10이하, 2이상
	//조건 2. 아이디를 대문자에서 소문자로 변경.
	//조건 3. 아이디에 '!'가 들어가면 안됨.
	//조건 4. 아이디에 문자 공백이 들어가면 안됨.
    public static String getResult(String id) {
		String temp = ""; // temp를 사용한 것이 내 풀이와 차이점
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

- 배열 만들고 수정하기
	//1.콤마로 배열생성
	//2.느낌표 제거할 것
  	//3.문자를 숫자로 변환 ex)int x = Integer.parseInt("100");
	//4.1000 미만 숫자 중 가장 큰 수 구하기
	//5.최종 결과값에서 곱하기 2를 해서 리턴 하기
	public static int getResult(String word) {
		String array[] = word.split(",");
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			String replaceStr = array[i].replace("!", "");
			int temp = Integer.parseInt(replaceStr);
			if (temp < 1000) {
				if (max < temp) {
					max = temp;
				}
			}
		}
		return max * 2;
	}

	public static void main(String[] args) {
		String word = "101,1,10,1000,!100!,2000";
		System.out.println(getResult(word));
	}

- 20일~27일 문제는 따로

- 생성자 문제
Pizza p = new Pizza();
데이터 타입 : Pizza
변수 명 : p
연산자 : = 
생성자 : Pizza() 
//수정) Pizza() or 기본생성자

Pizza p = new Pizza("치즈피자");
데이터 타입 : Pizza
변수 명 : p
연산자 : =
생성자 : Pizza("치즈피자") 
// 수정) Pizza("치즈피자") or String을 받는 생성자

Pizza p = null;
데이터 타입 :  Pizza
변수 명 : p
연산자 : =
데이터 : null
생성자 : 없음

Pizza p = null;
p.피자종류 = "치즈피자";
p.피자종류 값은? 
답 : 치즈피자 
// 수정) 오류 남!! 피자파일을 호출해야 피자파일 안에 있는 필드변수(메소드) 사용 가능!!
메인 또는 메소드에 p = new Pizza(); 추가로 입력해 주면 됨!

Pizza클래스 피자종류 필드변수는 String 타입이다.
p.피자종류 = "콤보피자"
데이터 타입 : String
변수 명 : p
//수정) p.피자종류