문제 설명
배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 
이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 
총 몇번을 제거 해야할까요?
arr = [1, 1, 3, 3, 0, 1, 1] 이면 3을 return 합니다.
arr = [4, 4, 4, 3, 3] 이면 3을 return 합니다.

제한 사항
배열 arr의 크기(배열 길이) : 1,000,000 이하의 자연수
배열 arr의 원소(인덱스 값)의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
// 정수 조건 : 10으로 나눴을 때 
아래 메소드 작성


		int[] answer = {}; 
        // int[] answer = arr; 로 표기해주기 보단 일단 answer를 배열로 지정해 주고, 그 아래에서 arr 배열을 answer에 집어넣는걸로 표현해주는게 낫다.
		answer = arr; //수정함
		int len = answer.length;
		int count = 0;
		if (arr.length <= 1000000) {
			for (int i = 0; i < len - 1; i++) {
				if (arr[i] >= 0 && arr[i] <= 9) {
					int pre = arr[i]; // 디버깅 용도
					int next = answer[i + 1]; // 디버깅 용도
					if (pre == next) { // 위 변수들로 나타냄
					// if (arr[i] == answer[i + 1]) { 로 표현하기보다 위처럼 디버깅을 위한 변수(pre, next)를 지정하고 거기에 맞는 식으로 계산해 주는게 나중에 좋다!!
						++count; 
						//1개씩 더해주는 표현은 count += 1 대신 ++count로 쓰고 1보다 큰 수를 더할 땐 += 연산자 사용
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int array[] = { 1, 1, 3, 3, 0, 1, 1 };
		int array2[] = { 4, 4, 4, 3, 3 };
		System.out.println(solution(array));
		System.out.println(solution(array2));
	}