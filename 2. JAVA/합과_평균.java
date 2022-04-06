// 1번
    int 국어 = 100;
    int 수학 = 50;
    int 영어 = 88;
    int 과학 = 38;
    final int 과목수 = 4; // final : 상수를 의미
    int sum = 0; // 총합
    double avg = 0; // 평균. 소수점으로 나타내기 위해 데이터 타입 double 사용
    //총합, 평균점수는?
    
    sum = 국어+수학+영어+과학;
    avg = sum / 과목수;
    System.out.println("총합 점수는? :" + sum + "점");
    System.out.println("평균 점수는? :" + avg + "점");

    =====> 총합 점수는? :276점
    =====> 평균 점수는? :69.0점

// 2번
    1부터 max까지의 합 (메소드)
    public static int getSum(int max) {
		int sum = 0;
		for (int i = 1; i <= max; i++) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		int result = getSum(10); // 10이 위에 int max로 대입됨
		System.out.println(result);
	}

// 3번 
    합 (메소드)
    1. x, y에 데이터를 넣고, 더한 값을 리턴하는 메소드를 작성하고 main 메소드에 호출
	2. 단, x는 10 미만이면 x에 5를 대입

	public static int getSum(int x, int y) {
		if (x < 10) {
			x = 5; 
		int sum = x + y;
		return sum;
	}

	public static void main(String[] args) {
		int x = 2;
		int y = 10;
		int 총합은 = getSum(x, y);
		System.out.println(총합은);
	}