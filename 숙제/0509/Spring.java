컨트롤러
//문제 0. 급여 1500을 파라미터로 받고 부서가 10, 30에 속하는 사원 중 급여가 1500을 넘는 사원의 이름 및 급여 조회.
1. sal을 파라미터로 하는 주소 만들기
	@GetMapping("/emp/sal/{sal}")
	public List<EmpVO> callNameAndComm(@PathVariable("sal") int sal){
	}
//문제 1. emp에서 사수가 없는 사원 조회
	@GetMapping("/emp/mgr")
//문제 2. 1987년도를 파리미터로 받고 해당 년도에 입사한 사원 조회 
	@GetMapping("/emp/hiredate/year/{year}")
	public List<EmpVO> callYearEmp(@PathVariable("year") String year){
		return empService.getYearEmp(year);
	}
//문제 3. 12월를 파라미터로 받고 해당 월에 입사한 사원 중 급여가 가장 많은 사원 조회
	@GetMapping("/emp/hiredate/month/{month}")
	public List<EmpVO> callMonthEmp(@PathVariable("month") String month){
		return empService.getMonthEmp(month);
	}
//문제 4. MANAGER를 파라미터로 받고 job이 MANAGER 중 입사날짜가 가장 빠른 사원의 이름, 입사날짜, 급여 조회 
	@GetMapping("/emp/job/{jobName}")
	public List<EmpVO> callFastestHiredateEmp(@PathVariable("jobName") String job){
		return empService.getFastestHiredateEmp(job);
	}
//(join 문제)*문제 5. 사원번호 7782를 파라미터로 받고 해당 사원의 모든 정보(부서번호, 부서이름, 부서위치 포함) 조회
	@GetMapping("/emp/empno/{empno}")
	public List<EmpVO> callAllEmpInfo(@PathVariable("empno") int empno){
		return empService.getAllEmpInfo(empno);
	}

// --------------------------------------------------------------------------------------
비즈니스
//문제 2. 1987년에 입사한 사원 수가 3명 이하면 1981년에 입사한 사원으로 조회하시오.
//문제 3. 급여가 가장 높은 사원 조회
//문제 4. 입사날짜 빠른 사원 조회 (쿼리 2개필요 OR 쿼리하나로 해결 가능)

// --------------------------------------------------------------------------------------
퍼시스턴스
<!-- 문제 0. 부서가 10, 30에 속하는 사원 중 급여가 1500을 넘는 사원의 이름 및 급여 조회 -->
<!-- 문제 1. MGR이 NULL인 사원 이름, 직업, 급여 조회 -->
<!-- 문제 2. 특정 년도에 입사한 사원 이름, 직업, 입사날짜, 급여 조회-->
<!-- 문제 3. 입사 날짜가12월에 입사한 사원 이름, 급여 조회-->
<!-- 문제 4. 특정 job에 속한 사원번호, 사원 이름, 입사날짜 조회 -->
<!-- 문제 5. 특정 사원의 모든 정보 조회(emp, dept 테이블 조인) -->