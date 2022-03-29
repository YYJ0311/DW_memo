/ : 몫, % : 나머지

int z = 10 / 5;  
System.out.println(z); // 2   
  
int temp = 10 % 5;  
System.out.println(temp); // 0 

// 몫과 나머지를 이용해서 잔돈 계산하기
// 조건 1. 변수 선언 X
// 조건 2. 사칙 연산을 이용해서 풀 것
내 풀이
	public static void main(String[] args) {
		int money = 57000;
		int man = money / 10000; // 만원
		int ocheon = (money-10000*man) / 5000; // 오천원
		int temp = (money-10000*man) % 5000 ; // 최종 거스름돈
		
		System.out.println("거스름돈 이전 금액 : "+ money);
		System.out.println("만원 몇 장 ? :"+ man);
		System.out.println("오천원 몇 장 ? :"+ ocheon);
		System.out.println("최종 남은 금액은 ? :"+ temp + "원");
	}

선생님 답
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

차이 
    : 나는 데이터 변수에서 바로 연산했고 선생님은 변수를 지정한 뒤, 값을 넣어가며 계산했다.
    재활용 가능한 변수를 활용하자