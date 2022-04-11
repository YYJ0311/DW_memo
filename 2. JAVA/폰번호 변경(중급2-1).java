문제설명
상원이는 깜빡하고 고객 핸드폰 번호를 암호화 하지 않고 저장 했다.  
핸드폰 번호 가운데와 뒷자리를 x로 변경하자.

제한사항
앞자리가 010이 아니라면 "핸드폰 번호를 변경해야 합니다." 출력.
핸드폰 번호 중간자리와 끝자리가 4개이면 x4개, 3개면 x3개
ex) 010-333-0000 -> 010-xxx-xxxx

내 풀이
		String phone = "017-404-1234";
		String array[] = phone.split("-"); // -를 경계로 나눠서 배열 생성
		if (array[0] != "010") {
			System.out.println("핸드폰 번호를 변경해야 합니다.");
		}
		if (array[1].length() == 3 || array[2].length() == 3) {
			array[1] = "-XXX";
		}
		if (array[1].length() == 4 || array[2].length() == 4) {
			array[2] = "-XXXX";
		}
		for (String str : array) { 
			System.out.print(str);
		}

틀렸음
이대로 출력하면 array[1] 또는 array[2]가 3일때 array[2]의 값이 지정되지 않았고,
array[1] 또는 array[2] 가 4일 때 array[1]의 값이 지정되지 않았다.
그리고 각각을 지정해줬다 하더라도 원하는 답을 정확히 출력하지 못한다.
따라서 아래와같이 for문을 하나 더 만들고 그 아래에서 조건을 거는 방식으로 하는게 맞다!

        
선생님 풀이
        String phone = "017-404-1234"; // 배열은 for문으로 해결해야한다.
        String array[] = phone.split("-");
        for(int i =0; i<array.length; i++) {
        	int len = array[i].length();
        	if(i==0 && !array[i].equals("010")) { //0번째가 010 이 아니라면!
        		System.out.println("핸드폰 번호를 변경해야 합니다.");
        	}
        	if(i>0) {
        		if(len == 3) {
        			array[i] = "-XXX";
        		}
        		if(len ==4) {
        			array[i] = "-XXXX";
        		}
        	}
        }
		for(String str : array){
			System.out.print(str);
		}