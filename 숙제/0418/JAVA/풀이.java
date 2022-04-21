1. UserVO
    package user;

    //VO는 Value Object의 약자.
    //Value Object에는 필드변수,생성자,getter,setter만 존재함.
    public class UserVO{
        private String ename; //직원 이름
        private String dname; //부서 이름
        private int sal;  //급여
        private int lv; //직원 레벨
        
        public UserVO(String ename, String dname, int sal){
            this.ename = ename;
            this.dname = dname;
            this.sal = sal;
        }
        //0. getter,setter 함수를 생성하시오. 
        public String getEname() {
            return ename;
        }
        public void setEname(String ename) {
            this.ename = ename;
        }
        public String getDname() {
            return dname;
        }
        public void setDname(String dname) {
            this.dname = dname;
        }
        public int getSal() {
            return sal;
        }
        public void setSal(int sal) {
            this.sal = sal;
        }
        public int getLv() {
            return lv;
        }
        public void setLv(int lv) {
            this.lv = lv;
        }
    }

2. UserService
    package user;
    import java.util.List;
    public class UserService implements UserServiceImple{
        // UserServiceImple에서 상속받은 메소드를 가지고 로직구현 할 것임
        
        //1. 부서이름이 DEVELOP인 사원 급여를 2배 인상하시오.
        public List<UserVO> updateSal(List<UserVO> list, String dname){
            // dname 파라미터에 DEVELOP을 받을 것임
            for(UserVO vo : list) {
                if(vo.getDname() == dname) {
                    vo.setSal(vo.getSal()*2);
                    System.out.println(vo.getEname()+"의 부서 :"+vo.getDname()+", 변경된 급여 : "+vo.getSal());
                }
            }
            return list;
        }
        //2. 급여가 0 ~ 100 : 1 레벨, 101 ~ 1000 : 2 레벨, 1001 이상부터는 3 레벨로 수정하시오.
        public List<UserVO> updateLv(List<UserVO> list){
            for(UserVO vo : list) {
                if(vo.getSal() >= 0 && vo.getSal() <= 100) {
                    vo.setLv(1);
                }
                if(vo.getSal() >= 101 && vo.getSal() <= 1000) {
                    vo.setLv(2);
                }
                if(vo.getSal() >= 1001) {
                    vo.setLv(3);
                }
                System.out.println(vo.getEname()+"의 급여 : "+vo.getSal()+", 레벨 :"+vo.getLv());
            }
            return list;
        }
        //3. 레벨 3이상 직원을 모두 해고하시오.
        public List<UserVO> deleteUser(List<UserVO> list, int lv){
            for(int i=0; i<list.size(); i++) {
                if(list.get(i).getLv() >= 3) {
                    list.remove(i);
                }
            }
            System.out.print("생존한 직원 : ");
            for(UserVO vo : list) {
                System.out.print(vo.getEname()+" ");
            }
            System.out.println();
            return list;
        }
        //4. 이름이 King인 직원의 모든 정보 조회.
        public UserVO selectUserByEname(List<UserVO> list, String ename){
            for(UserVO vo : list) {
                if(vo.getEname().equals(ename)) {
                    // ename 파라미터에 King 받을 것임
                    System.out.println(ename+"의 부서:"+vo.getDname()+", 레벨:"+vo.getLv()+", 급여:"+vo.getSal());
                }
            }
            return null;
        }
    }

3. UserServiceImple
    // 인터페이스를 생성해서 UserService에 상속해줄 것임
    package user;
    import java.util.List;
    public interface UserServiceImple {
        public List<UserVO> updateSal(List<UserVO> list, String dname);
        public List<UserVO> updateLv(List<UserVO> list);
        public List<UserVO> deleteUser(List<UserVO> list, int lv);
        public UserVO selectUserByEname(List<UserVO> list, String ename);
        // public 생략해도 사용가능
    }

4. MainController
    package user;
    import java.util.ArrayList;
    import java.util.List;
    public class MainController {
        public static void main(String args[]){
            List<UserVO> list = new ArrayList<UserVO>();
            list.add(new UserVO("Alex","DEVELOP",200));
            list.add(new UserVO("Max","DEVELOP",80));
            list.add(new UserVO("Brian","DEVELOP",100));
            list.add(new UserVO("mr.Hyun","MANAGER",300));
            list.add(new UserVO("Allen","DEVELOP",110));
            list.add(new UserVO("Katter","DEVELOP",220));
            list.add(new UserVO("Hooker","MANAGER",1500));
            list.add(new UserVO("King","MASTER",0));
            //여기서 문제 풀 것
            
            UserService service = new UserService();
            System.out.println("---");
            service.updateSal(list, "DEVELOP");
            System.out.println("---");
            service.updateLv(list);
            System.out.println("---");
            service.deleteUser(list, 0);
            System.out.println("---");
            service.selectUserByEname(list, "King");
            System.out.println("---");
        }
    }

5. 출력 결과
    ---
    Alex의 부서 :DEVELOP, 변경된 급여 : 400
    Max의 부서 :DEVELOP, 변경된 급여 : 160
    Brian의 부서 :DEVELOP, 변경된 급여 : 200
    Allen의 부서 :DEVELOP, 변경된 급여 : 220
    Katter의 부서 :DEVELOP, 변경된 급여 : 440
    ---
    Alex의 급여 : 400, 레벨 :2
    Max의 급여 : 160, 레벨 :2
    Brian의 급여 : 200, 레벨 :2
    mr.Hyun의 급여 : 300, 레벨 :2
    Allen의 급여 : 220, 레벨 :2
    Katter의 급여 : 440, 레벨 :2
    Hooker의 급여 : 1500, 레벨 :3
    King의 급여 : 0, 레벨 :1
    ---
    생존한 직원 : Alex Max Brian mr.Hyun Allen Katter King 
    ---
    King의 부서:MASTER, 레벨:1, 급여:0
    ---
