// 1번
	1. x, y에 데이터를 넣고 x가 크면 x를 리턴, y가 크면 y를 리턴
	2. 단, x와 y에 데이터는 100을 넘을 수가 없다.

	public static int getSum02(int x, int y) {
		if (x > y) {
			if (x <= 100)
				return x;
		}
		if (y > x) {
			if (y <= 100)
				return y;
		}
		return 0; 
        // 컴퓨터는 혹시모를 if가 틀릴경우를 대비해서 마지막 줄에 return 0; 을 꼭 써줘야 한다.
		// 또는 else { return; } 으로 선택지를 없게 만들 수도 있다.
	}
    또는
    public static int getSum02(int x, int y) {
        if (x > 100 || y > 100) {
			return 0;
		}
		if (x > y) {
			return x;
		}
		if (y > x) {
			return y;
		}
		return 0;
    }

	public static void main(String[] args) {
		int x = 50;
		int y = 30;
		int 결과 = getSum02(x, y);
		System.out.println(결과);
	}

// 2번
    버블정렬