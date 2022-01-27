문제설명
철수는 명부작성에 이름과 온도를 쓰려고 한다.
해당 명부에는 1페이지에 10명만 작성할 수 있다.
명부에 58명이 작성했다고 가정하면 총 몇 페이지 명부가 작성되었을까?

제한사항
아래 메소드 생성
명부는 100명 이하까지 작성 가능합니다.
calcPage()함수 코드라인 10줄 이하로 작성.


내 풀이

	public static int calcPage(int totalCount, int rows) {
		if (totalCount <= 100) {
			int x = totalCount / rows;
			if (totalCount % rows < rows && totalCount % rows > 0) { // 앞 조건은 지워도 될듯
				x++;
			}
			return x;
		}
		return 0;
	}

	public static void main(String[] args) {
		int totalCount = 58; // 총 인원값
		int rows = 10; // 1페이지에 작성할 수 있는 기준값
		int pages = calcPage(totalCount, rows);
		System.out.println(pages + " 페이지");
	}



선생님 풀이

	public static int calcPage(int totalCount, int rows) {
		int totalPage = 0;
		if (totalCount <= 100) {
			totalPage = totalCount / rows; // 몫으로 페이지수 구함 1번째
			if ((totalCount % rows) > 0) {
				++totalPage;
			}
		}
		return totalPage;
	}

	public static void main(String[] args) {
	int totalCount = 58; // 총 인원값
	int rows = 10; // 1페이지에 작성할 수 있는 기준값
	int pages = calcPage(totalCount, rows);
	System.out.println(pages + " 페이지");
	}

