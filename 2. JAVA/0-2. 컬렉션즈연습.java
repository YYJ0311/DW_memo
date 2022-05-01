1. 컬렉션 ArrayList 1

    package 컬렉션즈;
    import java.util.ArrayList;

    class Student{
        String name;
        int age;
        String addr; // 사는 곳
        
        public Student() {
            // 기본 생성자
        }
        
        public Student(String name, int age, String addr) {
            this.name = name; // this == Student
            this.age = age;
            this.addr = addr;
        }
        
        public void setAge(int age) {
            this.age = age;
        }
        
        public int getAge() {
            return this.age;
        }
    }
    public class ArrayList_Study2 {
        public static void main(String[] args) {
            Student s1 = new Student("홍길동", 26, "부산");
            ArrayList<Student> list = new ArrayList<Student>();

            list.add(s1); // 0번째에 s1이 들어감
            list.get(0); // 0번째의 Student 클래스 호출 (Student 안에 들어있는 필드변수, 메소드도 같이 들어있다)
            String name = list.get(0).name;
            int age = list.get(0).age;
            String addr = list.get(0).addr;
            System.out.println(name); // 홍길동
            System.out.println(age); // 26
            System.out.println(addr); // 부산
            // 실무에서 많이 사용하는 방법임
            
            int age02 = list.get(0).getAge();
            // list의 0번째에 있는 class(Student) 안의 메소드(함수)를 호출
            System.out.println(age02); // 26
            list.get(0).setAge(33); // age를 33으로 set
            age02 = list.get(0).getAge(); // age02에 다시 get 값 대입
            System.out.println(age02); // 33
            
            Student s2 = new Student(); // 기본 생성자로 호출. 파라미터 없음.
            ArrayList<Student> list02 = new ArrayList<Student>(); // 위와 다른 list02 로 새로 정의
            list02.add(s2);
            String name02 = list02.get(0).name;
            System.out.println(name02); // null
            int age03 = list02.get(0).age;
            System.out.println(age03); // 0
            list02.get(0).setAge(10);
        }
    }


2. 컬렉션 ArrayList 2
        package 컬렉션즈;
        public class EmpVO { //emp 테이블 클래스
            int empno; 
            String ename; 
            String job; 
            String hiredate; 
            int sal; 
            int deptno; 
            int comm;
            
            public EmpVO() {
                
            }
            
            public EmpVO(int empno, String ename, String job, String hiredate, int sal, int deptno, int comm){
                this.empno = empno;
                this.ename = ename;
                this.job = job;
                this.hiredate = hiredate;
                this.sal = sal;
                this.deptno = deptno;
                this.comm = comm;
            }
            
            public int getComm() {
                return comm;
            }
            public void setComm(int comm) {
                this.comm = comm;
            }
            public int getEmpno() {
                return empno;
            }
            public void setEmpno(int empno) {
                this.empno = empno;
            }
            public String getEname() {
                return ename;
            }
            public void setEname(String ename) {
                this.ename = ename;
            }
            public String getJob() {
                return job;
            }
            public void setJob(String job) {
                this.job = job;
            }
            public String getHiredate() {
                return hiredate;
            }
            public void setHiredate(String hiredate) {
                this.hiredate = hiredate;
            }
            public int getSal() {
                return sal;
            }
            public void setSal(int sal) {
                this.sal = sal;
            }
            public int getDeptno() {
                return deptno;
            }
            public void setDeptno(int deptno) {
                this.deptno = deptno;
            }
        }


        package 컬렉션즈;
        import java.util.ArrayList;
        import java.util.List;
        public class EmpMain {
            
            public static ArrayList<EmpVO> getEmpList(ArrayList<EmpVO> list){ // EmpVO를 담고있는 ArrayList를 파라미터로 받고 있다.
                for(int i = 0; i<list.size(); i++) {
                    System.out.println(list.get(i).empno);
                    System.out.println(list.get(i).ename);
                }
                return list;
            }
            
            public static String getValue(String name) { // static으로 함수 지정한 이유. 아래 main에서 static으로 정의했기 때문에 static함수 또는 new로 불러온 함수만 사용 가능하다.
                System.out.println("너의 이름은? "+name);
                return name;
            }
            
            public static void main(String[] args) {
                String name = "아이유";
                String result = getValue(name);
                
                ArrayList<EmpVO> list = new ArrayList<EmpVO>(); // ctrl + shift + o
        //		EmpVO emp = new EmpVO(7369, "SMITH", "CLERK", "1980-12-17", 800, 20); 와 list.add(emp); 를 아래와 같이 list.add(new EmpVO(~)); 1줄로 표현 가능
                list.add(new EmpVO(7369,"SMITH","CLERK","1980-12-17",800,20,0));
                list.add(new EmpVO(7499,"ALLEN","SALESMAN","1981-02-20",1600,30,300));
                list.add(new EmpVO(7521,"WARD","SALESMAN","1981-02-22",1250,30,500));
                list.add(new EmpVO(7566,"JONES","MANAGER","1981-04-02",2975,20,0));
                list.add(new EmpVO(7654,"MARTIN","SALESMAN","1981-09-28",1250,30,1400));
                list.add(new EmpVO(7698,"BLAKE","MANAGER","1981-05-01",2850,30,0));
                list.add(new EmpVO(7782,"CLARK","MANAGER","1981-06-09",2450,10,0));
                list.add(new EmpVO(7788,"SCOTT","ANALYST","1987-06-28",3000,20,0));
                list.add(new EmpVO(7839,"KING","PRESIDENT","1981-11-17",5000,10,0));
                list.add(new EmpVO(7844,"TURNER","SALESMAN","1981-09-08",1500,30,0));
                list.add(new EmpVO(7876,"ADAMS","CLERK","1987-07-13",1100,20,0));
                list.add(new EmpVO(7900,"JAMES","CLERK","1981-12-03",950,30,0));
                list.add(new EmpVO(7902,"FORD","ANALYST","1981-12-03",3000,20,0));
                list.add(new EmpVO(7934,null,"CLERK","1982-01-23",1300,10,0));
                
                // getEmpList(list); 
                // 위 list를 getEmpList함수에 넣으면 함수에 의해서 각각의empno와 ename이 출력됨
                
                // 아래 문제들은 각각 for문과 for each의 두 가지 방법으로 풀 것임
                System.out.println("---------------------------------");
                System.out.println("문제 1. 사원의 번호와 이름 출력");
                for(int i=0; i<list.size(); i++) {
                    System.out.println("사원번호 : "+list.get(i).empno+", 사원이름 : "+list.get(i).ename);
                }
                for(EmpVO vo : list) { // vo를 0번째부터 list의 길이까지 반복하겠다
                    System.out.println("for each 사원번호 : "+vo.empno+", 사원이름 : "+vo.ename);
                }
                System.out.println("---------------------------------");
                System.out.println("문제 2. 급여가 1300 달러 이상인 사원의 이름과 직업 조회");
                for(int i=0; i<list.size(); i++) {
                    if(list.get(i).sal >= 1300) {
                        System.out.println("사원이름 : "+list.get(i).ename+", 직업 : "+list.get(i).job);
                    }
                }
                for(EmpVO vo : list) {
                    if(vo.sal >= 1300) {
                        System.out.println("for each 사원이름 : "+vo.ename+", 직업 : "+vo.job);
                    }
                }
                System.out.println("---------------------------------");
                System.out.println("문제 3. 직업이 SALESMAN인 사원중 급여가 1400 달러 이상인 사원의 번호와 이름 조회");
                for(int i=0; i<list.size(); i++) {
                    if(list.get(i).job.equals("SALESMAN") && list.get(i).sal >= 1400) {
                        System.out.println("사원번호 : "+list.get(i).empno+", 사원이름 : "+list.get(i).ename);
                    }
                }
                for(EmpVO vo : list) {
                    if(vo.job.equals("SALESMAN") && vo.sal >= 1400) {
                        System.out.println("for each 사원번호 : "+vo.empno+", 사원이름 : "+vo.ename);				
                    }
                }
                System.out.println("---------------------------------");
                System.out.println("문제 4. 입사년도가 1981년도인 사원의 번호와 이름 조회");
                for(int i=0; i<list.size(); i++) {
        //			if(list.get(i).hiredate.substring(0,4).equals("1981")) {
                        // substring 말고 split으로 풀어보기
                    if(list.get(i).hiredate.split("-")[0].equals("1981")) {
                        System.out.println("사원번호 : "+list.get(i).empno+", 사원이름 : "+list.get(i).ename);
                    }
                }
                for(EmpVO vo : list) {
                    if(vo.hiredate.split("-")[0].equals("1981")) {
                        System.out.println("for each 사원번호 : "+vo.empno+", 사원이름 : "+vo.ename);
                    }
                }
                System.out.println("---------------------------------");
                System.out.println("문제 5. 직업이 MANAGER인 사원 수 조회");
                int count = 0;
                for(int i=0; i<list.size(); i++) {
                    if(list.get(i).job.equals("MANAGER")) {
                        count++;
                    }
                }
                System.out.println(count+"명");
                int countForEach = 0;
                for(EmpVO vo : list) {
                    if(vo.job.equals("MANAGER")) {
                        countForEach++;
                    }
                }
                System.out.println("for each "+countForEach+"명");
                System.out.println("---------------------------------");
                System.out.println("문제 6. 사원 중 급여를 가장 많이 받는 사원의 번호와 이름, 입사년도 조회");
                int temp = 0;
                int count02 = 0;
                for(int i=0; i<list.size(); i++) {
                    if(list.get(i).sal > temp) {
                        temp = list.get(i).sal;
                        count02 = i;
                    }
                }
        //		System.out.println("사원번호 : "+list.get(count02).empno+", 사원이름 : "+list.get(count02).ename+", 입사년도 : "+list.get(count02).hiredate.substring(0,4));
                System.out.println("사원번호 : "+list.get(count02).empno+", 사원이름 : "+list.get(count02).ename+", 입사년도 : "+list.get(count02).hiredate.split("-")[0]);
                int tempForEach = 0;
                int topEmpnoForEach = 0; // 사원번호
                String topEnameForEach = null; // 사원이름
                String topHirdate = null; // 입사년도
                for(EmpVO vo : list) {
                    if(vo.sal > tempForEach) {
                        tempForEach = vo.sal;
                        topEmpnoForEach = vo.empno;
                        topEnameForEach = vo.ename;
                        topHirdate = vo.hiredate.split("-")[0];
                    }
                }
                System.out.println("사원번호 : "+topEmpnoForEach+", 사원이름 : "+topEnameForEach+", 입사년도 : "+topHirdate);
                System.out.println("---------------------------------");
                System.out.println("문제 7. 부서번호별 수 조회 ex) 20: 2명, 30: 3명");
                int group01 = 0;
                int group02 = 0;
                for(int i=0; i<list.size(); i++) {
                    if(list.get(i).deptno == 20) {
                        group01++;
                    }
                    if(list.get(i).deptno == 30) {
                        group02++;
                    }
                }
                System.out.println("부서번호가 20인 사람수 : "+group01+", 30인 사람수 : "+group02);
                int group20ForEach = 0;
                int group30ForEach = 0;
                for(EmpVO vo : list) {
                    if(vo.deptno == 20) {
                        group20ForEach++;
                    }
                    if(vo.deptno == 30) {
                        group30ForEach++;
                    }
                }
                System.out.println("부서번호가 20인 사람수 : "+group20ForEach+", 30인 사람수 : "+group30ForEach);
                System.out.println("---------------------------------");
                System.out.println("문제 8. 입사월이 02월인 사원 수 조회");
                int count03 = 0;
                for(int i=0; i<list.size(); i++) {
        //			if(list.get(i).hiredate.substring(5,7).equals("02")){
                    if(list.get(i).hiredate.split("-")[1].equals("02")) {
                        count03++;
                    }
                }
                System.out.println(count03+"명");
                int countForEach01 = 0;
                for(EmpVO vo : list) {
                    if(vo.hiredate.split("-")[1].equals("02")) {
                        countForEach01++;
                    }
                }
                System.out.println("for each "+countForEach01+"명");
                System.out.println("---------------------------------");
                System.out.println("문제 B-1. comm을 받은 사원 수와 직업, 이름 조회");
                int count04 = 0;
                for(int i=0; i<list.size(); i++) {
                    if(list.get(i).comm != 0) {
                        count04++;
                        System.out.println("사원이름 : "+list.get(i).ename+", 직업 : "+list.get(i).job);	
                        }
                }
                System.out.println("총 "+count04+"명");
                int countForEach02 = 0;
                for(EmpVO vo : list) {
                    if(vo.comm != 0) {
                        countForEach02++;
                        System.out.println("for each 사원이름 : "+vo.ename+", 직업 : "+vo.job);
                    }
                }
                System.out.println("for each 총 "+countForEach02+"명");
                System.out.println("---------------------------------");
                System.out.println("문제 B-2. emp에 있는 사원의 급여 평균");
                int sum = 0; // 급여 합
                int count05 = 0; // 사원 수
                for(int i=0; i<list.size(); i++) {
                    sum += list.get(i).sal;
                    count05++;
                }
                System.out.println("급여 평균 : "+sum/count05);
                System.out.println("---------------------------------");
                System.out.println("문제 B-3. 사원번호가 7844, 7876인 사원에게 comm 200을 지급하시오");
        //		for(int i=0; i<list.size(); i++) {
        //			if(list.get(i).empno == 7844 || list.get(i).empno == 7876) {
        //				list.get(i).comm = 200;
        //				System.out.println(list.get(i).empno+"의 comm : "+list.get(i).comm);
        //			}
        //		}
                // setComm() 사용
                for(int i=0; i<list.size(); i++) {
                    if(list.get(i).empno == 7844 || list.get(i).empno == 7876) {
                        list.get(i).setComm(200);
                        // list.get(i).comm = 200; 이라고 입력해도 아래 2가지 방법으로 불러오는데 문제는 없다. 근데 set으로 써야 될듯.
                        System.out.println(list.get(i).empno+"의 comm : "+list.get(i).getComm());
                        // setComm으로 값이 저장되어서 list.get(i).getComm() 또는 list.get(i).comm 으로 값을 불러올 수 있다
                    }
                }
                for(EmpVO vo : list) {
                    if(vo.empno == 7844 || vo.empno == 7876) {
                        vo.comm = 200;
                        System.out.println("for each 사원번호 "+vo.empno+"의 comm : "+vo.comm);
                    }
                }
                System.out.println("---------------------------------");
                System.out.println("문제 B-4. 사원이름이 null인 사원의 이름을 '데이터 없음'으로 수정하시오");
                for(int i=0; i<list.size(); i++) {
                    if(list.get(i).ename == null) {
                        System.out.println("사원이름 : "+list.get(i).ename);
                        list.get(i).ename = "데이터 없음";
                        System.out.println("수정 후 사원이름 : "+list.get(i).ename);
                    }
                }
                for(EmpVO vo : list) {
                    if(vo.ename == null) {
                        System.out.println("for each 초기 사원이름 : "+vo.ename);
                        vo.ename = "데이터 없음";
                        System.out.println("for each 수정 사원이름 : "+vo.ename);
                    }
                }
                // for each를 실행하기 전에 for문에서 이름이 null인 사원의 이름을 바꿨기 때문에 for each로 출력 안 됨
                System.out.println("---------------------------------");
                System.out.println("문제 B-5. 20번 부서가 올해 실적이 좋지 않습니다. 20번 부서를 모두 해고(제거)하시오");
        //		int count06 = 0; // 해고된 사원 수 체크
        //		int count07 = list.size(); // 전체 사원 수, 14
        //		for(int i=0; i<list.size(); i++) {
        //			if(list.get(i).deptno == 20) {
        //				count06++;
        //				list.remove(i);
        //			}
        //			System.out.println("남은 사원 이름 : "+list.get(i).ename+", 부서번호 : "+list.get(i).deptno);
        //		}
        //		System.out.println("남은 사원 수 : "+(count07-count06)+"명"); // 14-5=9
                int firedForEachCount = 0; // 해고된 사원 수 체크
                int totalForEach = list.size(); // 전체 사원 수, 14
                int count08 = 0; // 사원 자리수 체크
        //		for(EmpVO vo : list) {
        //			count08++; // 모든 사원 자리수 한개씩 지정
        //			System.out.println("남은 사원 이름 : "+vo.ename+", 부서번호 : "+vo.deptno);
        //		}
        //		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
                // String을 리턴받는 Predicate 이용해서 S로 시작하는 ename를 찾고 제거하는 로직
        //		Predicate<EmpVO> condition = check -> check.getEname().startsWith("S");
        //		list.removeIf(condition);
        //		for(EmpVO vo : list) {
        //			System.out.println(vo.ename);
        //		}
            }
        }
        // map, reduce, iterator 찾아보기


3. hash
    package 컬렉션즈;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.LinkedList;
    import java.util.List;
    import java.util.Map;

    class OneSoju{
        // 디폴트로 OneSoju의 부모는 Object
    }

    public class Hash_Study {
        public static void main(String[] args) {
            ArrayList<String> list = new ArrayList<String>(); // ArrayList
    //		HashMap<String,String> map = new HashMap<String,String>(); // HashMap
    //		// 왼쪽이 key, 오른쪽이 value
    //		map.put("1", "참이슬"); // HashMap에 데이터 넣기!
    //		map.put("2", "처음처럼");
    //		map.put("a", "한라산");
            
            // hashmap의 value는 key로 접근 (json과 같음)
    //		System.out.println(map.get("1")); // 참이슬
    //		System.out.println(map.get("a")); // 한라산
            
            HashMap<String,Object> map = new HashMap<String,Object>();
            map.put("b", 13);
    //		Value에 Object를 쓰면 문자, 숫자 다 가능하다
    //		HashMap Value에 Object를 하는 이유!
    //		Value에 어떤 값(데이터타입)이 올지 예상 불가능하기 때문에 Object로 데이터타입을 모두 받는다.
            System.out.println(map.get("b")); // 13
            
    //		원래는 위처럼 쓰지 않고 왼쪽에 부모를 쓰고 오른쪽에 자식을 쓴다 
    //		왼쪽에 부모를 쓰는 이유 : 부모 아래의 다른 타입(자식)으로도 사용가능하기 때문
    
            List<String> list2 = new ArrayList<String>();
            list2 = new LinkedList<String>();
    //		list2 하나로 ArrayList와 LinkedList 모두 받을 수 있음
            
            OneSoju onesoju = new OneSoju();
            Map<String,Object> map2 = new HashMap<String,Object>();
            map2.put("c",onesoju);
    //		** 모든 클래스는 디폴트로 Object를 상속받는다. 즉, Object가 부모 클래스이다.
    //		따라서 Object로 정의한 Value에 onesoju도 들어갈 수 있다!
        }
    }


4. ArrayList 3
문제
    MainService 클래스에서 MainUtil 클래스를 이용하여 문제풀 것.
    1. 전체 유저 호출
    2. 특정 유저 호출
    3. 특정 유저 삭제
    4. 모든 유저 급여 합 구하기

    package 상속3;
    import java.util.ArrayList;
    import java.util.List;

    class UserVO{
        private String name;
        private int sal; //급여
        
        public UserVO(String name, int sal){
            this.name = name;
            this.sal = sal;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getSal() {
            return sal;
        }
        public void setSal(int sal) {
            this.sal = sal;
        }
    }

    class MainUtil{
        public List<UserVO> getAllUsers(List<UserVO> list){ //전체 유저 호출
            return list;
        }
        public String getUser(List<UserVO> list, String name){ //특정 유저 호출
            for(UserVO vo : list) {
            	if(vo.getName().equals(name)) {
            		return vo.getName();
            	}
            }
            return null;
            // 입력받은 name이 list에 존재하는지 확인 후 존재하면 반환
        }
        public List<UserVO> deleteUser(List<UserVO> list, int index){
            list.remove(index);
            System.out.println(index+"번째 데이터가 지워졌습니다.");
            return list;
        }
        public int getUserTotalSal(List<UserVO> list){
            int sum = 0;
            for(UserVO vo : list) {
            	sum += vo.getSal();
            }
            // System.out.println("급여 총 합 : "+sum); 프린트 MainService에서 할 것임
            return sum;
        }
    }

    public class MainService extends MainUtil{
        public static void main(String[] args) {
            List<UserVO> list = new ArrayList<UserVO>();
            list.add(new UserVO("SMITH", 100));
            list.add(new UserVO("BRIAN", 300));
            list.add(new UserVO("ALLEN", 600));
            list.add(new UserVO("KING", 2000));
            
            // 1. 전체 유저 호출
            MainService main = new MainService();
            for(int i=0; i<list.size(); i++) { // 방법 1. for문
                String name = main.getAllUsers(list).get(i).getName();
                int sal = main.getAllUsers(list).get(i).getSal();
                System.out.println("이름 : "+name+", 급여 : "+sal);
            }
            for(UserVO vo : list) { // 방법 2. forEach
            	System.out.println("forEach 이름 : "+vo.getName()+", 급여 : "+vo.getSal());
            }
            System.out.println("---");
            
            // 2. ALLEN 호출
            String name = main.getUser(list, "ALLEN");
            System.out.println("호출한 유저 : "+name);
            System.out.println("---");
            
    		// 3. 2번째 유저(ALLEN) 삭제
            main.deleteUser(list, 2);
            System.out.println("남은 데이터");
            for(UserVO vo : list) {
            	System.out.println(vo.getName()+", "+vo.getSal());
            }
//            남은 데이터는 deleteUser 메소드와 관계 없으므로 여기다가 적어줌
            System.out.println("---");
            
            // 4. 모든 유저 급여 합
            int sum = main.getUserTotalSal(list);
            System.out.println("모든 유저의 급여 합 : "+sum);
            System.out.println("---");
        }
    }


5. 호출방법과 ArrayList
    package 연습;
    import java.util.ArrayList;
    import java.util.List;

    class Members{
        private String name;
        private List<String> stone = null;
        
        public List<String> getStone() {
            return stone;
        }
        public void setStone(List<String> stone) {
            this.stone = stone;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

    public class Avengers {
        public static Members printMemberName(Members member) {
            if(member == null) {
                member = new Members();
                member.setName("토르");
                System.out.println(member.getName());
            }
    //		System.out.println(member.getName());

            // 멤버 클래스에 stone을 추가
            List<String> list = new ArrayList<String>();
            list.add("파워스톤");
            list.add("타임스톤");
            member.setStone(list);
            return member;
        }
        public static void main(String[] args) {
            Members m = new Members();
            m.setName("토르");
            String name = m.getName();
            System.out.println("m => "+name); // m => 토르
            
            Members m2 = new Members();
            String name2 = m2.getName();
            System.out.println("m2 => "+name2); // m2 => null
    //		모든 클래스의 초기값은 null. 따라서 String의 초기값도 null.
    //		만약 Members m2 = m; 라고 해 주면, 토르가 출력됨
            
    //		printMemberName 메소드 사용
    //		방법 1
            Members m3 = new Members();
            printMemberName(m3);
        
    //		방법 2
            printMemberName(new Members());
            
    //		방법 3
            Members m4 = null; 
            printMemberName(m4); // m3가 null이어서 토르 출력

            List<String> list = new ArrayList<String>();
            list.add("소울스톤");
            list.add("마인드스톤");
            printMemberName(m3).setStone(list); 
            // printMemberName의 기존 리스트를 지우고 여기 있는 메인 메소드의 리스트를 새로 set
            System.out.println(m3.getStone());
            
            String powerStone = printMemberName(m3).getStone().get(0);
            String timeStone = printMemberName(m3).getStone().get(1);
            System.out.println(powerStone); // 파워스톤
            System.out.println(timeStone); // 타임스톤
            // printMemberName(m3) 로 접근하면 기존에 있는 리스트로 나옴
        }
    }


6. 긴급점검3
    package test;
    import java.util.ArrayList;
    import java.util.List;

    class Singer{
        public String SingerName;
        public Singer(String singerName) {
            this.SingerName = singerName;
        }
    }

    // 내 첫 풀이
    public class 긴급점검3 {
        public static List<Singer> getListSinger(ArrayList<Singer> list){
            for(int i=0; i<list.size(); i++) {
                System.out.println(list.get(i).SingerName);
            }
            
            return list;
        }
        public static Singer getSinger(Singer s){
            System.out.println(s.SingerName);
            return s;
        }
        public static void main(String[] args) {
            ArrayList<Singer> list = new ArrayList<Singer>();
            list.add(new Singer("김종국"));
            list.add(new Singer("서인국"));
            list.add(new Singer("방용국"));
            
            //1. getListSinger()이용해서 김종국, 서인국, 방용국 list 출력!
            getListSinger(list);
            System.out.println("---");
            
            //2. getSinger()이용해서 김종국만 출력!
            Singer s = new Singer("김종국");
            getSinger(s);
        }
    }

    // 선생님 풀이
    public class 긴급점검3 {
        public static List<Singer> getListSinger(){
            List<Singer> list = new ArrayList<Singer>();
            list.add(new Singer("김종국"));
            list.add(new Singer("서인국"));
            list.add(new Singer("방용국"));
            return list;
        }
        // getListSinger에서 리스트에 추가해 주었음
        
        public static Singer getSinger(){
            String name = "";
            for(int i=0; i<getListSinger().size(); i++) {
                if(getListSinger().get(i).SingerName.equals("김종국")) {
                    name = getListSinger().get(i).SingerName;
                }
            }
            // 방법1. s1
            Singer s1 = new Singer("김종국");
            // 방법2. s2
            Singer s2 = new Singer(name);
            return s2;
        }
        // getSinger에서 김종국을 리턴해 주었음
        
        public static void main(String[] args) {
            //1. getListSinger()이용해서 김종국, 서인국, 방용국 list 출력!
            List<Singer> singer = getListSinger();
            for(int i=0; i<singer.size(); i++) {
                System.out.println(singer.get(i).SingerName);
            }

            //2. getSinger()이용해서 김종국만 출력!
            Singer s = getSinger();
            System.out.println(s.SingerName);
        }
    }

    // 내 풀이의 문제점 : 메인에선 리스트를 받아와서 풀기만 하면 됨. 그리고 김종국을 출력하기 위해서는 기존 리스트에 김종국이 존재하는지 확인하는 과정이 필요함

7. 긴급점검4(함수를 바로 부르는 것과 변수에 담아 부르는 것의 차이)
    package test;
    class eed{
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
    public class 긴급점검4 {
        public static eed call() {
            eed e = new eed(); // 초기화
            return e;
        }
        public static void main(String[] args) {
            call().setName("아메리카노");
            String name = call().getName();
            System.out.println(name); // getName() 이전에 call()을 부름으로써 초기화됨
            eed e = call();
            e.setName("아메리카노");
            System.out.println(e.getName()); // 아메리카노
            // 함수를 바로 불러오는 것과 변수에 담아 불러오는 것은 차이가 있다!
            // call.getName 과
            // eed e= call();   e.getName()은 다르다.
        }
    }

8. 긴급점검6
    package test;

    import java.util.ArrayList;
    import java.util.List;

    class Movie{
        private String movieName;

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }
    }

    public class 긴급점검6 {
        // 1. List 데이터 타입 확인
        // 2. 객체 생성(인스턴스화)
        // 3. add
        // 4. for each
        public static List<Movie> getMovieList(){
            List<Movie> list = new ArrayList<Movie>();
            Movie m1 = new Movie();
            m1.setMovieName("로스트 시티");
            list.add(m1);
            Movie m2 = new Movie();
            m2.setMovieName("공기살인");
            list.add(m2);
            
            for(Movie m : list) {
                System.out.println(m.getMovieName());
            }
            return list;
        }
        public static void main(String[] args) {
            // 여기에 List<Movie> list = getMovieList(); 로 시작하고 Movie를 인스턴스화한 다음, set 하고 add하는 과정을 적어도 된다.
            getMovieList();
        }
    }

9. 긴급점검7
    package test;

    import java.util.ArrayList;
    import java.util.List;

    class Lunch{	
        private List<String> foodName;
        
        public List<String> getFoodName() {
            return foodName;
        }
        
        public void setFoodName(List<String> foodName) {
            this.foodName = foodName;
        }
    }

    public class 긴급점검7 {
        public static void main(String[] args) {
            List<String> list4 = new ArrayList<String>();
            list4.add("스바라시라멘");
            list4.add("우동");		
            Lunch lunch = new Lunch();
            lunch.setFoodName(list4);
            // add로 먼저 요소들을 추가하고 lunch를 부른다음, lunch에서 요소들을 담았던 리스트 추가
            
            for(String foodName : lunch.getFoodName()) {
                // lunch.getFoodName()의 리턴은 list
                System.out.println(foodName); // 로스트 시티 공기살인

            }
        }
    }

10. 긴급점검8
    package test;

    import java.util.ArrayList;
    import java.util.List;

    class Chef{
        private int chefAge;

        public int getChefAge() {
            return chefAge;
        }

        public void setChefAge(int chefAge) {
            this.chefAge = chefAge;
        }
    }
    public class 긴급점검8 {
        // 1. getChefList 이용해서 30, 40, 50, 60 추가
        public static List<Chef> getChefList(){
            List<Chef> list = new ArrayList<Chef>();
            Chef c1 = new Chef();
            c1.setChefAge(30);
            list.add(c1);
            
            Chef c2 = new Chef();
            c2.setChefAge(40);
            list.add(c2);
            
            Chef c3 = new Chef();
            c3.setChefAge(50);
            list.add(c3);
            
            Chef c4 = new Chef();
            c4.setChefAge(60);
            list.add(c4);
            return list;
        }
        
        // 2. getChefListCount 이용해서 나이가 50이상인 요리사 수 구하기
        public static int getChefListCount(List<Chef> list) {
            int count = 0;
            for(Chef c : list) {
                if(c.getChefAge() >= 50) {
                    count++;
                }
            }
            System.out.println(count);
            return count;
        }
        public static void main(String[] args) {
            getChefList();
            getChefListCount(getChefList());
        }
    }

    ** 긴급점검7과 8의 차이
        7에선 list에 계속 add하고 new로 호출해서 리스트를 set 했는데 8은 하나하나 호출하고 set 하고 add한 이유
        : 7의 list 타입이 string이어서 문자로 계속 추가가 가능했지만 8의 list 타입은 Chef이기 때문에 Chef를 선언하고나서 추가가 가능했다.
        그리고 8의 Chef의 변수도 private이라서 list.add(new Chef(60)); 로 입력도 불가능하다.

11. 긴급점검9
    package test;

    import java.util.ArrayList;
    import java.util.List;

    class FruitVO{
        private String fruitName;

        public String getFruitName() {
            return fruitName;
        }

        public void setFruitName(String fruitName) {
            this.fruitName = fruitName;
        }

    }

    class FruitService{
        public FruitVO getFruit(List<FruitVO> list, String fruitName) {
            for(FruitVO vo : list) {
                if(vo.getFruitName().equals(fruitName)) {
                    System.out.println("선택한 과일 : "+fruitName);
                }
            }
            return null;
        }
    }

    public class 긴급점검9 {
        // 1. List에 포도, 수박, 참외 추가
        public static void main(String[] args) {
            List<FruitVO> list = new ArrayList<FruitVO>();
            FruitVO f1 = new FruitVO();
            f1.setFruitName("포도");
            list.add(f1);
            
            FruitVO f2 = new FruitVO();
            f2.setFruitName("수박");
            list.add(f2);
            
            FruitVO f3 = new FruitVO();
            f3.setFruitName("참외");
            list.add(f3);
            
            // 2. getFruit을 이용해서 수박 출력
            FruitService service = new FruitService();
            service.getFruit(list, "수박");
        }
    }

12. 긴급점검10
    package test;

    import java.util.List;

    public interface MemberServiceImpl {
        public abstract List<MemberVO> getMemberList(List<MemberVO> list);
        String getMemberNo(List<MemberVO> list);
    }

    package test;

    import java.util.ArrayList;
    import java.util.List;

    class MemberVO{
        private String memberNo;
        private int sal;
        
        public int getSal() {
            return sal;
        }

        public void setSal(int sal) {
            this.sal = sal;
        }

        public void setMemberNo(String memberNo) {
            this.memberNo = memberNo;
        }

        public String getMemberNo() {
            return memberNo;
        }
    }

    class MemberCode{
        public static final double BONUS = 0.1;
        public static final int MAX_VALUE = 300;
    }

    class MemberServcie implements MemberServiceImpl{
        @Override
        public List<MemberVO> getMemberList(List<MemberVO> list) {
    //		for(MemberVO vo : list) {
    //		if(vo.getMemberNo().equals("200")){
    //			vo.setSal((int) (vo.getSal()*(1+MemberCode.BONUS)));
    //		}
    //	}
            for(int i=0; i<list.size(); i++) {
                if(list.get(i).getMemberNo().equals("200")) {
                    list.get(i).setSal((int)(list.get(i).getSal()*(1+MemberCode.BONUS)));
                }
            }
            return list;
        }

        @Override
        public String getMemberNo(List<MemberVO> list) {
            String memberNo = null;
            for(MemberVO vo : list) {
                if(vo.getSal() >= 300) {
                    memberNo = vo.getMemberNo();
                }
            }
            return memberNo;
        }
    }

    public class 긴급점검10 {
        // 1. member 100, 200, 300 추가. 급여도 같이 100, 200, 300
        // 2. member 번호가 200인 member는 급여 10% 인상된 list 리턴
        // 3. member 100, 200, 300 번호와 급여 출력
        // 4. getMemberNo를 이용해서 급여가 300 이상인 멤버의 번호를 리턴
        // 5. MemberService 안에 있는 메소드 2개를 MemberServiceImpl이라는 Interface를 생성 후 오버라이딩으로 수정할 것
        public static void main(String[] args) {
            // 1번
            MemberVO memberA = new MemberVO();
            memberA.setMemberNo("100");
            memberA.setSal(100);
            MemberVO memberB = new MemberVO();
            memberB.setMemberNo("200");
            memberB.setSal(200);
            MemberVO memberC = new MemberVO();
            memberC.setMemberNo("300");
            memberC.setSal(300);
            
            // 2번
            List<MemberVO> list = new ArrayList<MemberVO>();
            list.add(memberA);
            list.add(memberB);
            list.add(memberC);
            
            MemberServcie service = new MemberServcie();
            service.getMemberList(list);
            
            // 3번
            for(MemberVO vo : list) {
                System.out.println("멤버번호 : "+vo.getMemberNo()+", 급여 : "+vo.getSal());
            }
            
            // 4번
            System.out.println("급여가 300 이상인 멤버 번호 : "+service.getMemberNo(list));
        }
    }

