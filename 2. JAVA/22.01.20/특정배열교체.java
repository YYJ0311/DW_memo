문제설명
메소드 파라미터에 정수형 배열을 받는다.
배열 인덱스 값중 짝수인 값은 0으로 대입한다.
단, 인덱스 값중 짝수이고 300이 넘으면 0 대입을 무시한다.

내 풀이

	public static int[] getResult(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 300) { // 여기서 짝수라는 조건을 빼먹었음
			} else if ((array[i] % 2) == 0) { /
				array[i] = 0;
			}
		}
		return array;
	}

	public static void main(String[] args) {
		int array[] = { 120, 340, 200, 430, 33 };
		int result[] = getResult(array);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

선생님 풀이
    public static int[] getResult(){
    	int[] array = {120, 340, 200, 430, 33};
    	for(int i=0; i<array.length; i++){
    		if(array[i] < 300){ //if 안에 if 넣어서 표현함
    			if((array[i] % 2) == 0){
    				array[i] = 0;
        		}
    		}
    	}
        return array;
    }