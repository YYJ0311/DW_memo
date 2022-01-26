# JAVA
- 단축키
ctrl + d : 한 줄 지우기  
---
- IDE(통합 개발 환경)  
ex) egov, 이클립스, 인텔리 제이(유료), 안드로이드 스튜디오, 파이참, ...  
---
- 번역하는 방법 두가지  
1. 컴파일 (C, C++, JAVA, ...)
  전체 소스코드를 보고 실행, 인터프리터와 비교했을 때 실행속도가 빠름, 코드를 수정하고 실행하려면 처음부터 다시 해야 함  
2. 인터프리터 (Python, Java script, ...)
  한줄씩 실행, 컴파일과 비교했을 때 실행속도 느림, 코드를 수정하고 즉시 실행  
---
- 명칭  
DB : 데이터베이스 - 테이블 - 데이터
JAVA : 프로젝트 - 패키지 - 클래스(코드 파일)
---
- 암묵적 룰  
프로젝트명 : 소문자 or 대문자  
패키지 : 소문자  
클래스 : 첫글자는 대문자 (ex. Emp)

프로젝트, 패키지, 클래스 명은 "명사"로 해야한다.(동사 X)

---
- 자바의 데이터 타입은 class까지 9개  
- 1바이트(byte)는 8비트(bit)
- 많이 쓰는 데이터 타입  
숫자 : int(4바이트), long(8바이트)  
소수 : double(8바이트)  
논리 : boolean(1바이트)  
---
- 변수 이름 규칙
1. 명사
2. 길이제한 X
3. 복합명사일 때는 두번째 명사를 대문자로 쓰거나, _를 사용
 Ex. userInfo = user_info <==대부분 userInfo로 사용함
4. 소문자
 정해져 있는 상수값을 표기할 때는 대문자  
 Ex. double PI = 3.14
     int level = 6
 아닌 것들은 소문자를 사용
5. 중복 X
---
- 스캐너   
```
Scanner scan = new Scanner(System.in); // ctrl + shift + o 입력하면 위에 import 생성됨
		// 실무에서는 DB랑 연동해서 데이터를 사용하고 이 방법은 잘 안 씀
```
---
- 문제
```
		// 아래 배열을 선언하고 정렬하시오. 
		// 버블정렬
		System.out.print 내림차순 정렬 : ");
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
		for(int i=0; i<array44.length; i++) {
			System.out.print(array44[i]+" ");
		}
```
---
- 메소드 문법		
<접근지정자> <리턴타입> <함수 이름> (인자값)		

- 메소드 return		
메소드에서 if를 쓸 경우, 컴퓨터는 혹시모를 if가 틀릴경우를 대비해서 return 0; 을 쓰지 않으면 오류를 표시한다. 따라서 마지막 줄에 return 0;을 꼭 써줘야 한다.		
또는 else { return; } 으로 선택지를 없게 만들어서 마지막에 return을 안 쓸 수 있다.	
---
- 이클립스 한번에 수정하기		
더블클릭해서 하이라이트하고, alt + shift + r 누르고 변경
---
- 아이디 입력받기 문제
```
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
- get, set 함수 단축키		
Alt + Shift + s		
---
- 클래스는 필드변수(특성)와 메소드(행동)로 구성!
---
- 생성자 문제
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
---
- 삼항연산자 (if문 대체)
<조건>? <참일경우 실행할 내용> : <거짓일경우 실행할 내용>		
a > b ? printf("a가 크네") : printf("b가 크네");		
---
- 
