
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