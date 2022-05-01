package final_test;

import java.util.ArrayList;
import java.util.List;

public class EmpService implements EmpServiceImpl{

	@Override
	public List<EmpVO> getEmpList(List<EmpVO> list) {
		for(EmpVO vo : list) {
			vo.setSal(vo.getSal()+EmpCode.SPECIAL_BONUS);
		}
		return list;
	}

	@Override
	public EmpVO getEmp(List<EmpVO> list) {
		int count = 0;
		int temp = 0;
//		for(EmpVO vo : list) {
//			if(vo.getSal()>temp) {
//				temp = vo.getSal();
//			}
//			count++;
//		}
//		System.out.println("급여가 가장 높은 사원 : "+list.get(count).getEmpno());
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getSal()>temp) {
				temp = list.get(i).getSal();
				count = i;
			}
		}
		System.out.println("급여가 가장 높은 사원 : "+list.get(count).getEname());
		return list.get(count);
	}

	@Override
	public int getCount(List<EmpVO> list, int sal) {
		int count = 0;
		for(EmpVO vo : list) {
			if(vo.getSal() <= sal) {
				count++;
			}
		}
		System.out.println("급여 300 이하 : "+count+"명");
		return count;
	}

	@Override
	public EmpVO setDept(EmpVO empVO) {
		DeptVO dept = new DeptVO(10, "SALES");
//		dept.setDeptno(10);
//		dept.setDname("SALES"); // 없어도 됨
		List<DeptVO> deptList = new ArrayList<DeptVO>();
		deptList.add(dept);
		empVO.setList(deptList);
		for(DeptVO dept1 : deptList) {
			System.out.println("부서이름 : "+dept1.getDname()+", 부서번호 : "+dept1.getDeptno());
		}
		return empVO;
	}

}