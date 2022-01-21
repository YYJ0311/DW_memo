정총무가 쏜다!!

문제설명
배열에서 원하는 값의 위치 찾기

배열에서 노홍철은 초밥집을 쐈고 나머지는 정총무가 쐈다.
노홍철이 쏜 값의 배열위치는?

제한사항
이름이 유재석, 박명수이면 0 반환
배열의 길이는 4보다 크지 않다

선생님 풀이

	public static int getList(String array[], String name) {
		int index = 0;
		if (name.equals("유재석") || name.equals("박명수")) { // 문자비교는 equals로 해야함!!
			return 0;
		}
		int len = array.length;
		if (len <= 4) {
			for (int i = 0; i < len; i++) {
				if (array[i].equals("초밥집")) { // array[i] 사용
					index = i;
				}
			}
		}
		return index;
	}

	public static void main(String[] args) {
		String 노홍철 = "초밥집";
		String array[] = { "편의점", "초밥집", "서점", "전집" };
		int result = getList(array, 노홍철); // 메소드에서 받아 온 값 getList를 int형 result에 넣어준다.
		System.out.println(result);
	}



원래 문제

    	public static int getList(String array[], String name){
	        int index = 0;
	}

	public static void main(String[] args) {
		String 노홍철 = "초밥집";
		String array[] = { "편의점", "초밥집", "서점", "전집" };
		getList(array, 노홍철);
	}