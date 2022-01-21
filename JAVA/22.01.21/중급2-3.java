키포인트) 스플릿 두번 쓰기!

1. 내 풀이
	public static void main(String[] args) {
		String query = "name=brian&addr=daejeon&age=30";
		String array[] = query.split("&");
		String name = "";
		String addr = "";
		int age = 0;
		for (int i = 0; i < array.length; i++) {
			String array01[] = array[i].split("=");
			if (i == 0) {
				name = array01[1];
				System.out.println("name : " + name);
			}
			if (i == 1) {
				addr = array01[1];
				System.out.println("addr : " + addr);
			}
			if (i == 2) {
				int temp = Integer.parseInt(array01[1]);
				age = temp;
				System.out.println("age : " + age);
			}
		}
	}

2. 선생님 풀이
	public static void main(String[] args) {
		String query = "name=brian&addr=daejeon&age=30";
		String name = "";
		String addr = "";
		int age = 0;
		String array[] = query.split("&");
		for (int i = 0; i < array.length; i++) {
			String temp[] = array[i].split("=");
			for (int j = 0; j < temp.length; j++) {
				if (i == 0) {
					name = temp[j];
				}
				if (i == 1) {
					addr = temp[j];
				}
				if (i == 2) {
					if (j == 1) {
						age = Integer.parseInt(temp[j]);
					}
				}
			}
		}
		System.out.println("name : " + name);
		System.out.println("addr : " + addr);
		System.out.println("age : " + age);
	}