문제설명
메소드 파라미터에 정수형 데이터 start와 end를 받는다.
array[]배열에서 가장 큰 수를 리턴한다.
리턴 받은 값을 리턴타입이 boolean인 isNum함수 파라미터에 넣는다.

제한사항
아래 메소드 생성
start는 0보다 클 수 없습니다.
end는 배열길이와 같아야 합니다.
max에 10보다 큰 수가 오면 0을 return 해야 합니다.

	public static boolean isNum(int max) {
		final int standardVal = 10;
		if (max < standardVal) {
			return true;
		}
		return false;
	}

	public static int getSum(int start, int end) {
		if(start <= 0) {
			int array[] = { 3, 8, 9 };
			end = array.length;
			int max = 0;
			for (int i = start; i < end; i++) {
				if (array[i] > max) {
					max = array[i]; // if절 대신 max = array[i]>max? max=array[i] : 0; 로 사용가능(삼항연산자)
				}
			}
			if (max > 10) {
				return 0;
			} else return max;
		}
		return 0;
	}

	public static void main(String[] args) {
		int start = 0;
		int end = 0;
		int max = getSum(start, end);
		boolean isFlag = isNum(max);
		System.out.print(isFlag);
	}
