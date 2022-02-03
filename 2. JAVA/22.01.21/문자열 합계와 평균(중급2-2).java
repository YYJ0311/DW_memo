문제설명
문자열 평균구하기

제한사항
점수중에 100점이 있다면 "100점 만점에 100점!" 출력.
평균 소수점 무시. (int형으로 받을 것)

내 풀이
문자열 내의 공백을 제거하고 int형으로 바꾸는게 핵심!

       public static void main(String[] args) {
    	String scores = "80, 70, 100, 31"; // 컬럼 하나에 값을 여러개 쓰는 경우
   		String array[] = scores.split(",");
   		int len = array.length;
   		int sum = 0;
   		for (int i = 0; i < len; i++) {
   			int x = Integer.parseInt(array[i].trim()); // trim을 써서 공백제거 필수!!
   			sum = sum + x;
   			if (x == 100) {
   				System.out.println("100점 만점에 100점!");
   			}
   		}
   		System.out.println("총점 : " + sum);
   		System.out.print("평균 : " + sum / len);
       }


선생님 풀이

	public static void main(String[] args) {
		String scores = "80, 70, 100, 31"; // 컬럼 하나에 값을 여러개 쓰는 경우
		String array[] = scores.split(",");
		int len = array.length;
		int sum = 0;
		for (int i = 0; i < len; i++) {
			String temp = array[i].trim();
			sum = sum + Integer.parseInt(temp);
			int num = Integer.parseInt(temp);
			if (num == 100) {
				System.out.println("100점 만점에 100점!");
			}
		}
		System.out.println("총점 : " + sum);
		System.out.print("평균 : " + sum / len);
	}

