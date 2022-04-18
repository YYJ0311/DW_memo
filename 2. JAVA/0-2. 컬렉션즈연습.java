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