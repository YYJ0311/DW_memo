// 1번
    int x = 5;
    int y = 6;
    
    if(x == y) {
        System.out.println("x랑 y는 같아요!");
    } // 중괄호를 써준다!
    else { 
        System.out.println("x랑 Y는 달라요!");//만약에 틀리다면, 새로 if 구문을 쓰는 대신에 사용
    } // 클린코드에선 else를 권장하지 않음. 코드가 길어지면 컴퓨터가 생각할 시간이 늘어나기 때문
    if(x != y) {
        System.out.println("x랑 y는 달라요!");
    }


    // A학점 90 ~ 100
    // B학점 80 ~ 89
    // C학점 70 ~ 79
    // D학점 69 이하
    int myScore = 50; // C학점
    if (myScore >= 80 && myScore < 90) {
        System.out.println("B학점입니다.");
    }
    if (myScore >= 70 && myScore < 80) {
        System.out.println("C학점입니다.");
    }
    if (myScore <= 69) {
        System.out.println("D학점입니다.");
    }
    if (myScore >= 90) {
        System.out.println("축하드립니다. " + "A학점입니다.");
    } else {
        System.out.println("좀 더 노력하세요.");
    }
    // 학사관리시스템도 이런 식으로 짜여있다.

// 2번
    int x = 5;
    int y = 10;
    int z = 5;
    if (x != y) {
        System.out.println("다릅니다.");
        if (x == z) {
            System.out.println("같습니다.");
        } else if (4 == 4) {
            System.out.println("같습니다.");
        }
    }

// 3번
else를 사용하게 되면 나중에 유지보수하기 힘들다!
    int x = 10;
    int y = 10;
    int num = 0;
    if (x == y) {
        num = x * y;
        if (x != y) {
            num = 0;
        } else {
            num = num * 2;
        }
    } else {
        num += num;
    }
    num = num + 100;
    System.out.println("num의 값은? : " + num);

    =====> num은 300
        1. 10*10
        2. 100*2
        3. 200+100

// 4번
짝수인지 홀수인지 구별하는 프로그램
    int value = 100;
    if ((value % 2) == 0) { // value % 2를 괄호로 묶어준다
    System.out.println("짝수입니다.");
    } else {
    System.out.println("홀수입니다.");
    }