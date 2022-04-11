문제 설명
이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.

제한 조건
1. n과 m은 각각 1000 이하인 자연수입니다.
2. System.out.print()를 사용하면 가로로 출력됩니다.(한줄로 쭉 작성)
3. System.out.println()는 개행문자(엔터를 입력한 것 처럼).


	public static String solution(int x, int y) {
		String star = "";
		String blank = "\n"; // 줄바꿈
		if (x <= 1000 && y <= 1000) {
			for (int j = 0; j < y; j++) {
				for (int i = 0; i < x; i++) {
					star += "*";
				}
				star+=blank;
			}
		}
		return star;
	}

	public static void main(String[] args) {
		int x = 5;
		int y = 3;
		String result = solution(x, y);
		System.out.println(result);
	}


줄바꿈 \n 은 자바에서 잘 쓰지 않는다고 함
그리고 자바에서 줄바꿈은 여러 방법이 있는데 
\n : unix
\r : mac
\r\n : windows
각각 적용되는 시스템이 달라서 줄바꿈이 되지 않을 수 있다.
따라서 시스템에 따라 줄바꿈을 해주는 문자(개행문자)를 사용하는 것이 더 낫다.

1. System.getProperty("line.separator")
2. System.lineSeparator()

ex) System.out.println( "Hello" + System.lineSeparator() + "Bye");


메소드로 표현하면 위와같이 쓰면 될 거 같고..
별찍을 때 입력을 받기 때문에 굳이 메소드가 필요없이 메인에다 작성할 수 있다.


	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // ctrl + shift + o 입력
        System.out.println("가로세로 차례로 입력");
        int a = sc.nextInt();
        int b = sc.nextInt();
		for(int i=0; i<b; i++) {
			for(int j=0; j<a; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

