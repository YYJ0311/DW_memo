문제 설명
정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수(메소드), 
solution을 완성해주세요.

제한 조건
1. 정수 num을 받는 파라미터가 있어야 함.
2. return 타입은 String.
3. 메소드 이름은 solution.

	public static String solution(int num) {
		if (num % 2 == 0) {
			System.out.println("num : " + num);
			return "Even";
		}
		System.out.println("num : " + num);
		return "Odd";
	}

	public static void main(String[] args) {
		int 대입하는숫자 = 5;
		String result = solution(대입하는숫자);
		System.out.println(result);
	}

