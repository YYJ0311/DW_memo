문제 설명
String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요. 
seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.

제한 사항
seoul은 길이 1 이상, 1000 이하인 배열입니다.
seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
숫자에서 문자 변환 메소드는 Integer.toString()를 사용합니다.
문자와 문자를 비교할 때는 equals()를 사용합니다.

입출력 예
"김서방은 1에 있다"


원소의 길이가 의미하는 게 무엇인지 헷갈림
array 인덱스 각각의 문자길이를 의미하는 건가?

맞다!! 인덱스 각각의 길이를 구하는 방법 기억하기!
array[i].length()


	public static String solution(String[] seoul) {
		int len = seoul.length;
		String answer = "Kim";
		if (len >= 1 && len <= 1000) {
			for (int i = 0; i < len; i++) {
				if (seoul[i].length() >= 1 && seoul[i].length() <= 20) {
					if (seoul[i].equals(answer)) {
						answer = Integer.toString(i);
						return answer;
					}
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		String array[] = { "Jane", "Kim" };
		String result = solution(array);
		System.out.println("김서방은 " + result + "에 있다");
	}


for 다음에 오는 if문 아래에 seoul[i].length()의 값을 출력해 보면 Jane 과 Kim의 길이인 4와 3이 나옴을 확인할 수 있다!!
