1번 문제
    조건 
        1. 아이디 길이가 10이하, 2이상
        2. 아이디를 대문자에서 소문자로 변경.
        3. 아이디에 '!'가 들어가면 안됨.
        4. 아이디에 문자 공백이 들어가면 안됨.

    답
        public static String getResult(String id) {
            int len = id.length();
            String temp = ""; // if조건에 해당되지 않으면 temp를 return 해줄 것임
            if(len <= 10 && len >= 2){
                temp = id.toLowerCase(); 
                temp = id.replace("!", ""); 
                temp = id.replace(" ", ""); 
                return temp.trim(); // 마지막으로 trim까지. replace로 양 끝 공백이 안 지워지나?
            }
            return temp;
        }
        public static void main(String[] args) {
            String userID = "J a!va! ";
            String id = getResult(userID); // getResult 메소드에 userID를 파라미터로 넣은 것을 id로 지정
            System.out.println(id);
        }



2번 문제
    조건	
        1.콤마로 배열생성
        2.느낌표 제거할 것
        3.문자를 숫자로 변환 ex)int x = Integer.parseInt("100");
        4.1000 미만 숫자 중 가장 큰 수 구하기
        5.최종 결과값에서 곱하기 2를 해서 리턴 하기

    답
        public static int getResult(String word) {
            String array[] = word.split(",");
            int max = 0;
            for (int i = 0; i < array.length; i++) {
                String replaceStr = array[i].replace("!", "");
                int temp = Integer.parseInt(replaceStr);
                if (temp < 1000) {
                    if (max < temp) {
                        max = temp;
                    }
                }
            }
            return max * 2;
        }

        public static void main(String[] args) {
            String word = "101,1,10,1000,!100!,2000";
            System.out.println(getResult(word));
        }

