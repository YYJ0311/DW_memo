문제 설명
정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.

제한 조건
1. 정수형 타입 배열이 파라미터에 있어야 함.
2. return 타입은 double.
3. 메소드 이름은 solution.
4. int형으로 나누면 소수점이 무시됩니다.

결과값을 소수점으로 나타내기 위해 모든 변수들도 double로 표현하는 게 관건!

내 풀이

	public static double solution(int array[]) {
		// 리턴타입이 int면 소수점이 무시되므로 double로 표시
		double sum = 0;
		double avg = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		avg = sum / array.length;
		return avg;
	}
	public static void main(String[] args) {
		int array[] = { 1, 2, 3, 4 };
		double result = solution(array);
		System.out.println(result);
	}



선생님 풀이
조건 추가) arr은 길이 1이상 100 이하인 배열

    public double solution(int[] arr) {
        double answer = 0; // answer를 리턴하기 위해 지정함
        double sum = 0;
        int arrLen = arr.length; // 길이 지정
        if(arrLen >= 1 && arrLen <= 100){
        	for(int i=0; i<arrLen; i++){
        		sum += arr[i];
        	}
        	answer = sum / arrLen;
        }
        return answer;
    }


리턴할 것을 answer로 지정하고, 배열길이도 새로 지정해줬다.