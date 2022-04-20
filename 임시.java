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
        list = service.updateSal(list, "DEVELOP");
        list = service.updateLv(list);
        list = service.deleteUser(list, 2);
        for(UserVO vo : list) {
        	System.out.println("사원 이름 : "+vo.getEname()+", 부서 이름 : "+vo.getDname()+", 직원 급여 : "+vo.getSal()+", 직원 레벨 : "+vo.getLv());
        }
        
        
        
//        System.out.println("---");
//        service.selectUserByEname(list, "King");
//        System.out.println(list);
//        System.out.println("---");
        // 클래스를 파라미터로 받는 것 = 약한 결합
        // list 하나로 계속 사용하는 것 = 약한 결합
    }
}


package user;

import java.util.List;

/**
 * @author yyj
 * @Date 2022. 4. 20.
 * comment :
 */
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
    			sal = sal;
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
    	for(int i=0; i<list.size(); i++) {
    		int temp = list.get(i).getLv();
    		if(temp >= lv) {
    			list.remove(i);
    		}
    	}
        return list;
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
    		}
    	}
        return null;
    }
}