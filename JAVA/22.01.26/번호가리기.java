문제설명
전화번호가 문자열 phone_number로 주어졌을 때, 
전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수(메소드), solution을 완성해주세요.

제한조건
1. 문자형(String) phone_number을 받는 파라미터가 있어야 함.
2. return 타입은 String.
3. 메소드 이름은 solution.
4. 특정문자 추출 메소드를 사용할 것.
5. 문자길이 구하는 메소드는 length() 입니다.

첫 풀이

	public static String solution(String num) {
		for (int i = 0; i <= num.length() - 5; i++) {
			System.out.print("*");
		}
		String 뒷번호 = num.substring(num.length() - 4, num.length());
		return 뒷번호;
	}

	public static void main(String[] args) {
		String phone_number = "01033334444";
		String result = solution(phone_number);
		System.out.println(result);
	}

이렇게 써도 결과는 맞지만 메인이 아닌 곳에서 프린트를 하게 되면 나중에 알아보기 어려울 것 같다.
따라서 다음처럼 수정했음


풀이 수정
메소드 안의 프린트를 없애고 하나의 return으로 앞, 뒤 번호를 모두 표현함

	public static String solution(String num) {
		String 앞 = "";
		for (int i = 0; i <= num.length() - 5; i++) { 
			앞+="*";
		}
		String 뒷번호 = num.substring(num.length() - 4, num.length());
		return 앞 + 뒷번호;
	}

	public static void main(String[] args) {
		String phone_number = "01033334444";
		String result = solution(phone_number);
		System.out.println(result);
	}


수정2
위와 같지만 각각의 변수 이름을 알아보기 쉽게 영어로 표기하고,
변수들을 따로 빼서 정의해 줌


	public static String solution(String phone_number) {
		String answer = "";
		int EXCEPTION_COUNT = 4; // 4가 의미하는 바를 명확히 해주기 위해, 나중에 수정의 용이성을 위해
		int phoneNumberLen = phone_number.length();
		int temp = phoneNumberLen - EXCEPTION_COUNT;

		String firstAndSecondPhoneNumber = phone_number.substring(0, temp);
		String lastPhoneNumber = phone_number.substring(temp, phoneNumberLen);
		String star = "";
		for (int i = 0; i < firstAndSecondPhoneNumber.length(); i++) {
			star += "*";
		}
		//String 뒷번호 = phone_number.substring(phoneNumberLen - EXCEPTION_COUNT, phoneNumberLen);
		answer = star + lastPhoneNumber;
		return answer;
	}

	public static void main(String[] args) {
		String phone_number = "01033334444";
		String result = solution(phone_number);
		System.out.println(result);
	}
