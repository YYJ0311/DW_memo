배열
	무의미한 나열을 막기위해 사용함.
	반복문과 같이 씀
	int array[] = {2,4,6,9};
	System.out.println("array 두번째 데이터 : "+array[1]);
	System.out.println("array의 길이 : "+array.length);
	for(int i=0; i<array.length; i++) {
		System.out.println("배열에 있는 인덱스 값 : "+array[i]);
	}

// 1번
    배열에서 홀수 짝수 찾기

    int array[] = {2,4,6,9};
	for(int i=0; i<array.length; i++) {
		if ((array[i] % 2) != 0) {
			System.out.println("array의 홀수는 : "+array[i]);
		}
		if ((array[i] % 2) == 0) {
			System.out.println("array의 짝수는 : "+array[i]);
		}
    }

// 2번
    배열의 합

    int array[] = { 2, 4, 6, 9 };
	int sum = 0; // 합의 변수를 미리 지정해줘야 한다!
	for (int i = 0; i < array.length; i++) {
		sum += array[i]; // sum = sum + array[i] 와 같음
	}
	System.out.println(sum);

// 3번
    배열의 인덱스 대입, 불러오기

	int array[] = { 2, 4, 6, 9 };
	array[0] = 10; // 0번째 인덱스 10으로 대입
	System.out.println(array[0]); 
	for(int index=0; index<array.length; index++) {
		if(index == 1) {
			System.out.println(array[index]);
		}
	}

// 4번
수정필요(버블정렬)
    배열 인덱스 중 가장 큰 수 찾기

	int array[] = { 2, 4, 6, 9 };
	array[0] = 10; // 0번째 인덱스 10으로 대입
	System.out.println(array[0]); 
	for(int index=0; index<array.length; index++) {
		if(index == 1) {
			System.out.println(array[index]);
		}
	}

	System.out.print("내림차순 정렬 : ");
	int array44[] = {5,11,2,0,7};
	int a = 0; // 임시 저장
	for(int i=0; i<array44.length; i++) {
		for(int j=0; j<(array44.length-1); j++) { //중복계산을 빼기 위해 길이-1
			if(array44[i] > array44[j]) {
				a = array44[i]; //하나의 값을 a에 저장
				array44[i] = array44[j]; // j값을 i위치로 보냄
				array44[j] = a;
			}
		}
	}
	for(int i=0; i<array44.length; i++) {
		System.out.print(array44[i]+" ");
	}
    
// 5번
	메소드

	public static int 배열받아보자(int[] array) {
		int x = array[0];
		System.out.println(x);
		return 0;
	}

	public static void main(String[] args) {
		int array[] = { 10, 5, 3, 4 };
		배열받아보자(array);
	}

	==> 0