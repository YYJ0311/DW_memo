/ : 몫, % : 나머지

// 1번
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

// 2번 
	거스름돈 (메소드)
	1. 돈을 입력받고 만원 몇장인지 return!
	2. 단, 만원 미만으로 파라미터값이 오면 0 리턴할 것
	
	public static int 거스름돈(int money) { // 메소드 시작
		final int MAN = 10000; // MAN 정의
		if (money < MAN) {
			return 0; 
		}
		int result = money / MAN; 
		return result;
	}

	public static void main(String[] args) {
		int money = 50000; 
		int 만원몇장 = 거스름돈(money); // 메소드 불러옴(호출)
		System.out.println(만원몇장+" 장"); 
	}

// 3번
	1부터 100까지 짝수 개수 구하기
	1. startNum이 endNum보다 크거나 같으면 return 0;
	2. endNum이 100을 초과하면 return 0;

	public static int getCount(int startNum, int endNum) {
		if (startNum >= endNum) { 
			return 0;
		}
		if (endNum > 100) {
			return 0;
		}
		int count = 0;
		for (int i = startNum; i < endNum; ++i) {
			if ((i % 2) == 0) {
				count += 1; // ++count;
			}
			// if(startNum >= endNum && endNum > 100) return 0;
		}
		return count;
	}

	public static void main(String[] args) {
		getCount(1, 100);
	}