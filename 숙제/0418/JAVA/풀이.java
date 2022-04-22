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
import java.util.Iterator;
import java.util.List;

public class UserService implements UserServiceImple{
	// UserServiceImple에서 상속받은 메소드를 가지고 로직구현 할 것임
	
    //1. 부서이름이 DEVELOP인 사원 급여를 2배 인상하시오.
	@Override
    public List<UserVO> updateSal(List<UserVO> list, String dname){
    	// dname 파라미터에 DEVELOP을 받을 것임
//    	for(UserVO vo : list) {
//    		if(vo.getDname().equals(dname)) {
//    			vo.setSal(vo.getSal()*2);
//    			System.out.println(vo.getEname()+"의 부서 :"+vo.getDname()+", 변경된 급여 : "+vo.getSal());
//    		}
//    	}
    	for(int i=0; i<list.size(); i++) {
    		if(list.get(i).getDname().equals(dname)) {
    			int sal = list.get(i).getSal();
    			sal = sal * 2;
    			list.get(i).setSal(sal);
    		}
    	}
		return list;
		// for문으로 수정된 list를 반환함
    }
	
    //2. 급여가 0 ~ 100 : 1 레벨, 101 ~ 1000 : 2 레벨, 1001 이상부터는 3 레벨로 수정하시오.
    @Override
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
    @Override
    public List<UserVO> deleteUser(List<UserVO> list, int lv){
    	// 방법 1. Iterator 
    	for(Iterator<UserVO> iter = list.iterator(); iter.hasNext(); ) {
            UserVO str = iter.next();
            if(str.getLv() >= lv) {
                iter.remove();
            }
        }
        return list;
    	
    	// 방법 2. removeIf
    	list.removeIf(v->v.getLv() >= lv); 
        return list;

        // 방법 3. for문!
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getLv() >= lv){
				list.remove(i);
				--i; // 이게 핵심. 지웠다면 당겨진 배열을 위해 i를 하나 줄여준다.
			}
		}
		return list;
	}
    }
    
    //4. 이름이 King인 직원의 모든 정보 조회.
    @Override
    public UserVO selectUserByEname(List<UserVO> list, String ename){
//    	for(UserVO vo : list) {
//    		if(vo.getEname().equals(ename)) {
//    			// ename 파라미터에 King 받을 것임
//    			System.out.println(ename+"의 부서:"+vo.getDname()+", 레벨:"+vo.getLv()+", 급여:"+vo.getSal());
//    		}
//    	}
    	for(int i=0; i<list.size(); i++) {
    		String tempEname = list.get(i).getEname();
    		if(ename.equals(tempEname)) {
    			return list.get(i);
    			// UserVO 클래스로 리턴해야 되기 때문에 해당 리스트의 세부정보(Dname 등)는 리턴할 수 없다
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
    Alex의 급여 : 400, 레벨 :2
    Max의 급여 : 160, 레벨 :2
    Brian의 급여 : 200, 레벨 :2
    mr.Hyun의 급여 : 300, 레벨 :2
    Allen의 급여 : 220, 레벨 :2
    Katter의 급여 : 440, 레벨 :2
    Hooker의 급여 : 1500, 레벨 :3
    King의 급여 : 0, 레벨 :1
    ---
    남은 사원 명단
    사원 이름 : Alex, 부서 이름 : DEVELOP, 직원 급여 : 400, 직원 레벨 : 2
    사원 이름 : Max, 부서 이름 : DEVELOP, 직원 급여 : 160, 직원 레벨 : 2
    사원 이름 : Brian, 부서 이름 : DEVELOP, 직원 급여 : 200, 직원 레벨 : 2
    사원 이름 : mr.Hyun, 부서 이름 : MANAGER, 직원 급여 : 300, 직원 레벨 : 2
    사원 이름 : Allen, 부서 이름 : DEVELOP, 직원 급여 : 220, 직원 레벨 : 2
    사원 이름 : Katter, 부서 이름 : DEVELOP, 직원 급여 : 440, 직원 레벨 : 2
    사원 이름 : King, 부서 이름 : MASTER, 직원 급여 : 0, 직원 레벨 : 1
    ---
    이름:King, 부서:MASTER, 급여:0, 레벨:1