0. 클래스와 메소드와 생성자
    class Pizza{
        int money; 
        // 전역변수 (필드변수)는 디폴트로 값이 초기화 되어있음(= 0 또는 = "null"이 들어있음)
        // int money = 0;
        public int getMoney() {
            return 0;
        }
        // 클래스파일을 만들면 디폴트 생성자가 만들어짐!
        // public Pizza() {} 라는 생성자가 디폴트로 만들어져 있다
        public Pizza() {
            // 만약 () 안에 파라미터를 입력할 경우, 아래에서 사용하는 Pizza의 생성자(괄호) 안에도 같은 데이터 타입을 가지는 파라미터를 입력해야 된다.
            // Pizza(int x)라고 적은 경우 Pizza(int x) 또는 Pizza(10)같이 만듦
            this.money = 10;
            // this = Pizza 클래스
        }

    public class Study0405 {
    // .java 파일에 public class가 2개 이상 올 수 없음(파일 이름임)
        public static void main(String[] args) {
            Pizza p = new Pizza();
            // () : 생성자(메소드), 정의하지 않은 생성자를 쓸 수 있는 이유는 디폴트로 존재하기 때문!
            // Pizza라는 클래스도 데이터타입
            // 여기서 this를 쓰면 그건 Study0405를 의미
        }
    }

1. 피자와 고객
	public class Pizza {
		public void 도우를만들다() {
			System.out.println("도우 만드는 중~");
		}

		public void 토핑을추가하다(String 토핑) {
			System.out.println(토핑 + " 토핑 추가!");
		}
		
		private void 비법소스를첨가하다() { // private
			System.out.println("최고급 트러플 오일 듬뿍!");
		}

		public void 피자를굽다() {
			System.out.println("피자 굽는 중~");
		}
	}
	// Pizza 클래스(객체=object)가 각각의 메소드를 담고 있다.

	public class Client {
		public static void main(String[] args) {
			int x = 10; 
			Pizza 하와이안피자_치즈듬뿍 = new Pizza();
			// Pizza를 객체(==인스턴스)화 했다 == Pizza 클래스 호출
			// 데이터타입 : Pizza(클래스), 변수 : 하와이안피자_치즈듬뿍
			하와이안피자_치즈듬뿍.도우를만들다();
			하와이안피자_치즈듬뿍.토핑을추가하다("버섯");
			하와이안피자_치즈듬뿍.피자를굽다();

			Pizza 불고기피자 = new Pizza();
			불고기피자.도우를만들다();
			불고기피자.토핑을추가하다("페퍼로니");
			// 비법소스를첨가하다 메소드는 private이라서 불고기피자.비법소스를첨가하다();는 호출되지 않는다.
			// 메소드에 접근지정자를 private로 선언하면 외부 클래스에서 호출시 해당 메소드를 호출할 수 없다.
			불고기피자.피자를굽다();
		}
	}


2. 햄버거와 고객
    public class Hamburger {
        public void 빵굽다() {
            System.out.println("빵 굽는중~");
        }
        public String 패티추가하다(String 패티이름) { // void가 아니라서 return이 필요하다
            return 패티이름;
        }
        public int 주문수량(int 주문수량) { // 마찬가지로 return 필요
            return 주문수량;
        }
    }

    public class Client2 {
        public static void main(String[] args) {
            Hamburger 불고기버거 = new Hamburger();
            불고기버거.빵굽다();
            String 패티1 = 불고기버거.패티추가하다("불고기");
            System.out.println(패티1 + " 패티 추가");
            int 수량1 = 불고기버거.주문수량(5);
            System.out.println(수량1 + "개 주문");

            Hamburger 치즈버거 = new Hamburger();
            치즈버거.빵굽다();
            String 패티2 = 치즈버거.패티추가하다("치즈");
            System.out.println(패티2 + " 패티 추가");
            int 수량2 = 치즈버거.주문수량(3);
            System.out.println(수량2 + "개 주문");
        }
    }


3. 문자 메소드
    // 대문자 -> 소문자 변환 : toLowerCase()
    String result1 = name.toLowerCase();
    System.out.println(result1);

    // 소문자 -> 대문자 변환 : toUpperCase()
    String result2 = name.toUpperCase();
    System.out.println(result2);

    // *공백제거 : trim()
    String id = " 홍길동";
    String result3 = id.trim(); 
    System.out.println(result3);

    // *배열 나누기 : split()
    String phone = "010-1234-1234";
    String array[] = phone.split("-"); // 문자배열로 인식
    System.out.println(array[0]);
    System.out.println(array[1]);

    // *특수문자 제거 : replace("","")
    String password = "123@";
    result1 = password.replace("@", "");
    System.out.println(result1);

    // replace를 이용한 문자 중간의 공백 제거
    String password2 = " 123 123 123 ";  // trim()으로는 문자 중간에 오는 공백을 제거할 수 없다!
    result1 = password2.replace(" ", "");
    System.out.println(result1);


4. 피자
    public Class Pizza{
    // 피자 클래스에는 피자에 관련된 변수와 함수만 위치한다.
    // 클래스는 필드변수(전역변수)와 메소드로만 구성!!
        int 햄;
        String 피자이름;
        
        public void 도우를만들다(){
            int x = 0;
            ..코드..
        }
    }

    public class 피자스쿨{
        // 조건) 클래스와 메소드를 실행해서 결과 값을 보고 싶을 때
        // 자바는 메인함수만 앎!
        // 외부 클래스 파일을 불러올 때 메인함수에서 해야함!
        // 메소드도 메인함수에서 불러와야 함
        public static void main(String[] args){
            Pizza 치즈피자 = new Pizza();
        // <데이터타입> <변수이름> <대입> <클래스>
            치즈피자.햄 = 100;
            // . 을 찍어서 해당 클래스 변수 혹은 메소드 불러오기 가능!
            치즈피자.도우를만들다();
            // 치즈피자.햄 = "햄추가요!"; <== 오류남! 위에서 햄을 int로 정의했기 때문
            
            Pizza 불고기피자 = new Pizza();
            불고기피자.햄 = 50;

            불고기피자 = 치즈피자;
            // 기존 불고기피자 데이터 없어짐
            // 불고기피자.햄 의 값이 100이 됨

            Pizza pizza[] = new Pizza();
            // 클래스도 데이터타입이기 때문에 배열선언 가능
            // 이런 객체배열은 제네릭으로 대체되어서 사용 안 함
        }
    }


5. 이태원클라쓰
    public class 이태원클래스 {
        public String 주인공; 
        public String 동료; 
        // public이 디폴트값이라 안 써도 되지만 써주는게 낫다
        // 실무에서는 필드변수를 private으로 함!
        
        public void 학교를때려치다(String name) {
            this.주인공 = name;
            // 필드변수 앞에는 this를 찍어줌 : 한 눈에 보기 쉬움
            // 앞에 this가 붙은 변수는 필드변수라고 생각하면 된다!
            System.out.println(name+ "가 학교를 나갔습니다..");
        }
    }

    public class JTBC {
        public static void main(String[] args) {
            이태원클래스 일부작 = new 이태원클래스(); // 이태원클래스파일을 불러옴
            일부작.주인공 = "박새로이";
            일부작.동료 = "조이서";
            String name = 일부작.주인공;
            System.out.println(일부작.동료);
            일부작.학교를때려치다(name);
            
            이태원클래스 이부작 = new 이태원클래스();
            이부작.주인공 = "손흥민";
            이부작.동료 = "황희찬";
            String name1 = 이부작.주인공;
            System.out.println(이부작.동료);
            이부작.학교를때려치다(name1);
        }
    }


6. 연습
    class 학원 {
        int 학생수; // 디폴트 0
        String 교사이름; // 디폴트 null
        public 학원(){ 
            // 디폴트 생성자를 사용하고 싶으면 이렇게 적어줘야 함
        }
        public 학원(int 학생수, String 교사이름) {
            this.학생수 = 학생수; // 필드변수 초기화!
            this.교사이름 = 교사이름;
        }
    }

    public class 연습 {
        public static void main(String[] args) {
            학원 h1 = new 학원();
            int 학생수 = 16;
            String 교사이름 = "철수";
            System.out.println(h1.학생수); // 디폴트 값 0
            System.out.println(h1.교사이름); // 디폴트 값 null
            
            학원 h2 = new 학원(학생수, 교사이름);
            System.out.println(h2.학생수); // 대입한 값 16
            System.out.println(h2.교사이름); // 대입한 값 철수
        }
    }


7. 연습2
package 상속;
    class Movie {
        String name; // 영화관 이름
        String location; // 영화관 위치
        int count; // 직원 수
        public Movie() { 
            // 디폴트생성자를 무시하고 파라미터가 있는 생성자를 만들면 디폴트생성자는 없어짐
            // 디폴트 생성자를 사용하고 싶으면 따로 만들어야 한다
        }
        public Movie(String location) { // 위치 생성자
            this.location = location; // 필드변수 초기화
        }
        public Movie(String name, String location, int count) {
            this.name = name;
            this.location = location;
            this.count = count;
        }
        public int getMovie() { // 일반 메소드
            return 0;
        }
    }

    public class 연습2 {
        public static void main(String[] args) {
            String name = "DW";
            String location = "중앙로역"; 
            int count = 10;
            Movie Md = new Movie(); // new = 클래스 호출(객체화), 클래스이름 () = 클래스 생성자 호출
            Md.count = 5;
            Movie Mloc = new Movie(location);
            Movie Mall = new Movie(name, location, count);
            System.out.println("영화관 이름은 "+Md.name); // null
            System.out.println("위치는 "+Md.location); // null
            System.out.println("직원수는 "+Md.count); // 5(디폴트는 0이지만 5를 대입해줬음)
            System.out.println("영화관 이름은 "+Mloc.name); // null
            System.out.println("위치는 "+Mloc.location); // 중앙로역
            System.out.println("직원수는 "+Mloc.count); // 0
            System.out.println("영화관 이름은 "+Mall.name); // DW
            System.out.println("위치는 "+Mall.location); // 중앙로역
            System.out.println("직원수는 "+Mall.count); // 10
        }
    }


8. 연습3
package 상속;
    class 일식당 {
        // 실무에서 쓰는 생성자 대신 데이터 초기화 방법 (책에 없음!!!!)
        // 1. 필드변수 접근지정자에 private으로 선언
        // 2. 각 변수들마다 함수를 만들어 줌
        private String porkCutlet; // private이라서 get, set으로 받음
        public void setPorkCutlet (String porkCutlet) {
            // void를 이용해서 필드변수를 초기화
            this.porkCutlet = porkCutlet;
        }
        public String getPorkCutlet() {	
            return this.porkCutlet;
        }
    }

    public class 연습3 {
        public static void main(String[] args) {
            일식당 a = new 일식당();
            a.setPorkCutlet("안심돈까스");
            String 돈까스 = a.getPorkCutlet();
            System.out.println(돈까스);
            // 실무에선 이렇게 set과 get을 이용한다.
        }
    }

9. 연습4
    class 연습2 {
        private String porkCutlet;
        private String price;
        
        public String getPorkCutlet() {
            return porkCutlet;
        }
        public void setPorkCutlet(String porkCutlet) {
            this.porkCutlet = porkCutlet;
        }
        public String getPrice() {
            return price;
        }
        public void setPrice(String price) {
            this.price = price;
        }
    }
    // 주의점
    // 1. 실무에서 생성자로 필드변수 초기화 잘 안 함!
	// 2. set, get 함수 이용해서 필드변수 초기화
	// 3. set, get 함수가 있는 클래스에는 절대로 다른 함수를 정의하지 않는다
	//  ex) getSum, getResult 같은것 쓰지 않음
	// 4. set, get이 있는 클래스이름 뒤에 VO(Value Object)를 붙이자!
	//  VO대신 DTO(Data Transfer Object)라고 쓰기도 함

    public class 연습4 {
        public static void main(String[] args) {
            연습2 a = new 연습2();
            a.setPorkCutlet("황금치즈돈까스");
            a.setPrice("5만원");
            String 돈까스 = a.getPorkCutlet();
            String 가격 = a.getPrice();
            System.out.println(돈까스);
            System.out.println(가격);
        }
    }


10. 연습 5
    public class KoreaVO { // get, set 쓴 클래스 이름 뒤에 VO
        private String location; 
        private String addr;
        private String name;
        private int count;

        public String getLocation() {
            return location;
        }
        public void setLocation(String location) {
            this.location = location;
        }
        public String getAddr() {
            return addr;
        }
        public void setAddr(String addr) {
            this.addr = addr;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getCount() {
            return count;
        }
        public void setCount(int count) {
            this.count = count;
        }
    }

    public class Study {
        public static void main(String[] args) {
            KoreaVO k = new KoreaVO();
            k.setLocation("대전");
            String 지역 = k.getLocation();
            k.setAddr("중앙로역");
            String 주소 = k.getAddr();
            k.setName("유영준");
            String 대표자 = k.getName();
            k.setCount(10);
            int 지역수 = k.getCount();
            
            System.out.println(지역); // 대전
            System.out.println(주소); // 중앙로역
            System.out.println(대표자); // 유영준
            System.out.println(지역수); // 10
        }
    }


11. 피자2
    class Pizza{
        String 피자종류;
        int 피자조각;
    }

    class Study {
        public static Pizza getPizza(Pizza p) {
            p.피자조각 = 20;
            p.피자종류 = "치즈피자";
            return p;
        }
        public static Pizza getPizza() {
            Pizza p = new Pizza();
            p.피자조각 = 100;
            p.피자종류 = "불고기피자";
            return p;
        }
        
        public static void main(String[] args) {
            Pizza p = new Pizza();
            // 첫번째 방법
            p = getPizza(p);
            System.out.println("p 피자 조각 : "+p.피자조각);
            System.out.println("p 피자 종류 : "+p.피자종류);
            // 두번째 방법
            Pizza p2 = getPizza(p); 
            // p2는 new로 부른적이 없는데 부를 수 있는 이유!
            // => 파라미터에 new로 불러왔던 p를 넣었기 때문에 클래스를 리턴한다!
    //		p2.피자조각 = 1;
    //		p2.피자종류 = "포테이토피자";
            Pizza p3 = getPizza();
            System.out.println("p2 피자 조각 : "+p2.피자조각);
            System.out.println("p2 피자 종류 : "+p2.피자종류);
            System.out.println("p3 피자 조각 "+p3.피자조각);
            System.out.println("p3 피자 종류 "+p3.피자종류);
        }
    }


12. 커피
    class CoffeeVO { //VO 클래스에는 다른 메소드들이 안 온다.
        // 원래 CoffeeVO로 표기해주는게 맞음
        private String menu;
        private int syrup;
        
        public String getMenu() {
            return menu;
        }
        public void setMenu(String menu) {
            this.menu = menu;
        }
        public int getSyrup() {
            return syrup;
        }
        public void setSyrup(int syrup) {
            this.syrup = syrup;
        }
    }


    public class Study {
        public static void main(String[] args) {
            CoffeeVO cafe = new CoffeeVO(); // 파일을 호출할 때는 new + 생성자
            //americano.menu = "americano"; <= menu는 private이라 못 부름. get, set을 통해 부르자!
            cafe.setMenu("americano"); // set(세팅) 먼저, coffeeVO의 menu에 americano 영구저장됨
            String coffee = cafe.getMenu();
            System.out.println(coffee); // americano
            cafe.setMenu("latte");
            String coffee2 = cafe.getMenu();
            System.out.println(coffee2); // latte
            // 세팅(set)하고 얻고(get) 담는 변수만 바꿔서 반복해서 사용 가능
            // VO 클래스는 set하고 get이 전부
        }
    }


13. 
