Map과 VO 사용
    메소드 작성시 타입으로 VO를 안 쓰는 회사에선 Map을 사용함 (대부분 VO를 쓰긴 함)
    VO는 클래스의 변수이름으로만 사용하다보니 유지보수하기 더 편함
    
    특정 회사에서 사용 예
        1. select 할 때는 리턴 타입을 map으로 사용하고,
            장점 : 컬럼이름에 맞게 알아서 매핑됨
            단점 : 안에 어떤게 들어있는지 확인하기 어려움(sql 들어가서 확인해야 함)
        2. insert/delete/update 할 때는 리턴타입을 vo로 사용
            장점 : vo클래스에 미리 필드변수를 정의해서 문서화, 유지보수 가능 (어떤게 리턴될지 미리 알 수 있음)
                (중요한 건 무조건 vo로 사용)
            단점 : 테이블이 많아지고 join이 많아지면 변수를 전부 입력하는 노가다를 해야 됨

Map과 VO 차이
	1. Map은 key나 value에 null이 들어갈 일이 없다.
		굳이 map.put("null","null") 처럼 쓸 일이 없기 때문
		VO는 set을 안해주면 null이 된다.
	2. VO는 수정하기 번거롭다.
		VO에서 변수를 추가하거나 수정하기 위해서는 VO 클래스의 변수와 getter, setter메소드작성 그리고 setter사용까지의 과정이 필요하지만,
		Map은 map.put("","")만 쓰면 된다.
		하지만 Map의 경우 객체명을 직접 입력하면서 실수가 생길 수 있다.
	3. VO가 사용하기에 더 안정적이다.
		VO는 해당 클래스의 변수로 사용이 제한적이지만 
		Map은 Map<String, Object>와 같이 value를 Object로 선언하면서 key에 맞지 않는 타입이 들어갈 여지가 있다.

package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// vo(List사용)와 Map을 알아보자!
class 햄버거{
	private String 햄버거이름;
	private int 햄버거가격;
	private String 매장이름;
	
	public String get매장이름() {
		return 매장이름;
	}
	public void set매장이름(String 매장이름) {
		this.매장이름 = 매장이름;
	}
	public String get햄버거이름() {
		return 햄버거이름;
	}
	public void set햄버거이름(String 햄버거이름) {
		this.햄버거이름 = 햄버거이름;
	}
	public int get햄버거가격() {
		return 햄버거가격;
	}
	public void set햄버거가격(int 햄버거가격) {
		this.햄버거가격 = 햄버거가격;
	}
}

class EmpVO{
	private int empNo;
	private String ename;
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
}

public class 긴급점검50 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
//		컬렉션즈는 클래스만 담을 수 있다
//		List는 부모, ArrayList는 자식. 부모로 호출하면 List 뿐만 아니라 그 자식인 LinkedList나 Vector도 불러올 수 있다.
//		그리고 list2 = new LinkedList<String>(); 이렇게 재활용도 가능하다.
		list2.add("hello");
		list2.add("name");
		List<햄버거> list3 = new ArrayList<햄버거>();
		햄버거 불고기버거 = new 햄버거();
		불고기버거.set햄버거가격(3000);
		불고기버거.set햄버거이름("불고기버거");
		list3.add(불고기버거);
//		스프링의 MyBatis는 sql결과로 나온 데이터를 자동으로 new, set, add 해준다.
		
//		List도 Class이므로 다음도 가능하다 (실제로 이렇게 쓰지는 않음)
		List<ArrayList<String>> list4 = new ArrayList<ArrayList<String>>();
        // 이렇게 하면 리스트 안의 하나의 요소에 다시 리스트가 있음
//		-------------------------------------------------------------------
//		하나의 map에서 value로 String과 Integer모두 사용하고 싶다면 value를 Object로 하면 된다.
		Map<String,Object> map2 = new HashMap<String, Object>();
		map2.put("햄버거이름", "불고기버거"); // key와 value
		map2.put("햄버거가격", 1000);
		System.out.println(map2.get("햄버거이름"));
		System.out.println(map2.get("햄버거가격"));
		
		System.out.println(list3.get(0).get햄버거이름());
		System.out.println(list3.get(0).get햄버거가격());
//		list와 map의 결과는 같다.
		
//		문제) list3에 매장이름추가
//		우선 햄버거 클래스의 변수로 매장이름 추가
		불고기버거.set매장이름("롯데리아");
		list3.add(불고기버거);
//		또는
		map2.put("매장이름", "롯데리아"); // 특이한 점) 기존 map2에 있던 햄버거이름과 햄버거가격 뒤에 들어가는게 아니라 그 사이로 매장이름이 들어감 
		
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
//		문제) mapList 0번째에 햄버거 이름과 가격을 추가
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("햄버거 이름", "게살버거");
		map3.put("햄버거 가격", 1000);
		mapList.add(map3);
		mapList.add(map2); // 리스트 확인용
		System.out.println(mapList); // [{map3}, {map2}] 로 출력됨
		System.out.println(mapList.get(0));
		
//		EmpVO를 담는 list
		List<EmpVO> empList = new ArrayList<EmpVO>();
		EmpVO vo = new EmpVO();
		vo.setEmpNo(10);
		vo.setEname("유영준");
		empList.add(vo);
		System.out.println(vo.getEmpNo()+", "+vo.getEname());
		
		List<Map<String, Object>> empMapList = new ArrayList<Map<String,Object>>();
		Map<String,Object> map4 = new HashMap<String, Object>();
		map4.put("empNo", 10);
		map4.put("ename", "유영준");
		empMapList.add(map4);
		System.out.println(empMapList);
//		list에 넣는 과정과 map에 추가하는 과정이 같다.
//		다만, list는 VO가 필요하고 Map은 VO없이 바로 데이터를 key와 value로 넣는다.
//		-------------------------------------------------------------------		
//		MyBatis는 DB에서 데이터를 불러와서 list의 add까지의 과정을 대신 해준 것처럼 map에서도 put의 과정을 대신 해준다.
//		DB의 데이터를 list에 set 해주는 걸 mapping이라고 함
//		Map으로 데이터 넣기
		Map<String,Object> SMITH = new HashMap<String,Object>();
		SMITH.put("empNo", 7369);
		SMITH.put("ename", "SMITH");
		
		Map<String,Object> ALLEN = new HashMap<String,Object>();
		ALLEN.put("empNo", 7499);
		ALLEN.put("ename", "ALLEN");
//		List로 데이터 넣기
		List<EmpVO> empList2 = new ArrayList<EmpVO>();
		EmpVO vo2 = new EmpVO();
		vo2.setEmpNo(7369);
		vo2.setEname("SMITH");
		empList2.add(vo2);
		
		EmpVO vo3 = new EmpVO();
		vo3.setEmpNo(7499);
		vo3.setEname("ALLEN");
		empList2.add(vo3);
//		쿼리 결과 컬럼과 VO에 있는 필드변수 이름은 동일해야 한다
//		but HashMap은 이름과 상관없이 바로 들어간다.
		
//		List에서 Get
		System.out.println(empList2.get(0).getEmpNo()); // 7369
		System.out.println(empList2.get(0).getEname()); // SMITH
//		Map에서 Get
		System.out.println(SMITH.get("empNo")); // 7369
		System.out.println(SMITH.get("ename")); // SMITH
	}
}

// --------------------------------------------------------------------
Controller
	@GetMapping("/emp/map/list")
	public List<Map<String, Object>> callEmpMapList(){
		return empService.getEmpMapList();
	}

Service
	public List<Map<String, Object>> getEmpMapList(){
		return empMapper.selectEmpMapList(); 
	}

Mapper
	public List<Map<String,Object>> selectEmpMapList();
//	String에 DB의 컬럼이 들어간다.

MyBatis sql
	<select id="selectEmpMapList" resultType="map">
		SELECT
			empno as a,
			// as로 컬럼의 이름을 바꾸면 조회되는 결과에도 반영된다(컬럼의 이름이 a로 바뀜)
			ename,
			job,
			sal,
			// list로 쓸 경우 아래 3개는 vo에 변수를 추가했어야 되지만 Map의 사용으로 vo클래스에 변수 추가 없이 사용 가능!
			// MyBatis가 map의 new와 put을 대신 해준다!
			// ex) Map<String,Object> CLARK = new HashMap<String,Object>();
			// CLARK.put("a", 7782);
			// CLARK.put("ename", "CLARK");
			e.deptno,
			d.dname,
			d.loc
		FROM emp AS e
		INNER JOIN dept AS d
		ON e.deptno = d.deptno
	</select>