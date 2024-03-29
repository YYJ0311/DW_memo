# Spring은?
    Spring 이란
        *JAVA*로 다양한 *애플리케이션(웹 또는 앱)*을 만들기 위한 *프레임워크*이다.
        (프레임워크 == 플랫폼)

    Spring을 배우는 이유
        자바스크립트는 노드js, 파이썬은 flask/장고, C는 asp 그리고 자바는 스프링이 대표적인 프레임워크이다. 이중 asp와 스프링이 가장 오래 되었다.
        초반에 스프링의 성능이 우세했기 때문에 자연스럽게 많이 사용하게 되었고 레퍼런스가 많이 쌓였기 때문에 검증된 프레임워크이며 따라서 기업에서 꾸준히 사용해오고 있다.
        (검증의 의미 : 회원 수 100만에서 부드럽고 오작동 없이 구동 가능한 경험으로 100만까지 커버할 수 있음을 증명함)

    Spring의 종류
        1. spring 레거시(일반 spring)
        2. spring boot (경량 spring)
        3. spring 전자정부프레임워크 (egov)

        1번과 3번이 매우 비슷하고, 요즘은 3번에서 2번으로 바꿔서 사용하려고 한다.

# Spring 3대장 개념
    IoC(Inversion of Control)
        제어의 역전
        객체의 생성부터 소멸까지 사용자가 관리하는 게 아닌, Spring에서 관리함
    DI(Dependenct Injection)
        Spring이 객체(클래스)가 필요하다면 외부에서 가져다가 주입(대입)하는 방식
        (객체(클래스)를 외부에서 가져다가 쓰기 때문에 new 연산자가 사라짐)
    AOP(Aspect Oriented Programming)
        관점 지향 프로그래밍
        여러 메소드(함수)에서 중복되는 코드가 있다면, 따로 모아서 재활용하는 것.

# Spring의 package
    스프링의 패키지는 3개부터 시작한다.
        .을 기준으로 패키지가 나뉨
        dw.yyj.study와 com.example.first_spring은 모두 3개의 패키지를 갖고 있음
    
    각 패키지의 의미
        첫번째 패키지 : com, io, kr 등
        두번쨰 패키지 : 회사이름 또는 조직이름
        세번째 패키지 : 프로젝트명
            ex) com.dw.board
            ex) com.naver.news

        패키지를 나눠서 알아보기 쉽게 만듦

# Spring과 같이 사용하는 친구들
    Spring만으로 어플리케이션을 개발하는데 한계가 있다
        (데이터베이스와 고객에게 보여줄 화면이 필요함)
    1. ORM
        스프링과 데이터베이스의 연결을 도와주며 데이터 생성, 호출, 삭제, 수정을 담당한다.
        종류 : MyBatis(수업에서 사용), JPA
            (MyBatis 먼저 공부한 뒤 필요하면 JPA 공부)
        springinitialzr에서 MyBatis와 MySQL Driver 추가해서 사용가능
    2. 빌드관리도구(Build Tool)
        필요한 기능을 쉽게 다운로드받을 수 있고, 서버에 업로드(배포)를 도와준다
        종류 : Gradle(사용), Maven
            (안드로이드에서도 Gradle을 사용함)
    3. 템플릿 엔진
        화면을 도와준다(백에 있는 데이터를 프론트로 보내는 역할).
        종류 : JSP(사용), Thymeleaf
        이전까지 백엔드가 구분없이 했는데 요즘 트렌드는 백엔드와 프론트의 업무를 정확히 구분짓고 있다. 
        템플릿 엔진은 백엔드 쪽이어서 만약 프론트 업무가 정확히 나누어진 회사에 가면 사용하지 않고, 대신 프론트개발자가 화면관리를 위해 뷰나 리액트를 사용할 것이다.
    4. 속성 파일
        계정 정보(데이터베이스 주소, 아이디, 비번)를 정의한다.
        종류 : yaml(사용), properties
            (properties가 yaml보다 알아보기 힘들어서 yaml 사용)
    5. 서버를 담당하는 Tomcat(사용)
    6. 그 외 optional로 Docker, GraphQL 등

# JSP (Java Server Page)
    템플릿엔진이다.

    특징
        return이 파일이름
        jsp를 외부로 빼면 실행 안 됨. jsp는 java 패키지 안에 있어야 한다.
        jsp 프로젝트의 파일은 경로가 내부에 있다. (수업에서 이전까지 RestController로 만든 것들은 외부에 html 파일로 존재했음)
        jsp 안에서 ajax 사용 가능! but return을 파일이름으로 해야 되기 때문에 후처리가 필요함
            => 메소드 리턴타입에 @ResponseBody를 붙여서 json으로 리턴해줄 수 있음.
```java
예시
@PostMapping("/login")
public @ResponseBody boolean callLogin(@RequestBody Map<String, Object> data, HttpSession httpSession) {
    // 생략
    return true;
}
=> @ResponseBody를 사용해서 리턴타입을 boolean으로 지정하고 true 리턴해줌
```
    HTML에 Java 코드까지 사용할 수 있다.
        HTML = HTML + JS + CSS
        JSP = HTML + JS + CSS + JAVA

    JSTL과 그 등장배경
        jsp가 나오고 jstl이 나옴
        index.jsp에 java 소스가 너무 많아서 퍼블리셔가 어려움이 많았음 
            => jstl 출현 (jsp에서 java 코딩 X, jstl을 이용해서 java 코딩함)

# 스프링 파일 중 Application
    메인함수가 있는 곳으로, 실행(ctrl+f11)하면 컴퓨터가 서버가 된다.
    이제 ip를 이용해서 다른 사람에게 내가 만든 것을 보여줄 수 있음

    new로 다른 클래스를 호출하지 않아도 어노테이션을 보고 자동으로 읽어들인다.

    기본적으로는 수정하고 새로 실행하려면 terminate 버튼으로 중지한 뒤 실행시켜야 한다.(devtools로 자동 재시작 설정 가능)

    웹에서 http://아이피:포트번호/url 에 접속해서 결과를 확인할 수 있다.
        ex) 내가 스프링으로 작업한 결과물을 http://192.168.0.240:8080/index 또는 http://localhost:8080/index 로 접속해서 확인

# Controller
    url 요청을 받는 곳
    www.naver.com에 접속할 때 응답을 해주는 부분이 컨트롤러다.
    파일 구성 예시
        1. com.example.first_spring.controller 패키지 아래에
        2. MainController 클래스가 존재하고 
        3. @RestController 또는 @Controller를 입력해서 스프링에 컨트롤러라고 인식시켜주며
        4. @GetMapping로 정의한 url에 요청이 들어왔을 때 메소드의 리턴값을 보내준다.
    URL은 중복되면 안 된다
        다만, GET/POST/DELETE/PATCH 사이의 중복은 가능하다(HTTP 기능이 다른 경우엔 가능)
        ex) GetMapping("/naver/news") (O)
            GetMapping("/naver/news") (X)
            PostMapping("/naver/news") (O)
```java
package com.example.first_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 템플릿엔진을 아직 사용하지 않아서 Rest를 붙여줌(Rest API를 의미)
// 템플릿엔진을 사용하면 @Controller 를 사용한다.
// 이 표시로 컴퓨터는 이곳이 url을 요청받는 곳이라고 인식하게 됨.
public class MainController {
	@GetMapping("/index")
	public String call() {
		String word = "유영준 Hello World!";
		return word;
	}
}
```
```
    위와 같이 controller에 코드를 작성하게 되면 나중에 유지보수가 힘들어진다.
        => MVC 아키텍처 출현
```

# HTTP 기능
    1. GET
        데이터를 header(주소)에 심는다 => 입력한 주소가 파라미터로 들어감
        http 메소드 중 get(요청)을 사용한 것
        결과를 console이 아닌 http로 받는다(스프링 결과를 hyper text로 전송)
        @RequestBody를 사용하지 못하기 때문에 로그인과 같이 민감한 정보를 다룰 때 사용할 수 없다.
    2. POST
        데이터를 body에 심는다(header는 보이지만 body는 숨겨져 있다)
            => 회원가입할 때 보면, 개인정보는 숨겨져 있어서 주소창에서 확인할 수 없음
        중요한 정보를 보내거나, 데이터를 많이 보낼 때 사용한다(header는 보낼 수 있는 데이터의 양도 적다.)
        ex) 로그인 할 때 아이디와 비밀번호는 중요한 정보이다. 이 때 GET을 사용하면 정보가 유출되므로 로그인은 POST를 사용한다.
    3. DELETE
        MyBatis의 sql 쿼리 작성할 때 WHERE절에서 테이블의 PK를 조건으로 받아야 한다.
        PK를 적지 않으면 관련된 모든 게 삭제됨!
    4. PATCH
        수정하려는 테이블에 어떤 컬럼이 Not Null인지 꼭 확인해야 한다
            emp 테이블을 수정하는 경우 empno컬럼이 not null이기 때문에 데이터를 꼭 넣어줘야 함

    이런 기능들을 CRUD라고 부른다
        CRUD = 대부분의 컴퓨터 소프트웨어가 가지는 기본적인 데이터 처리 기능
        Create : post(insert)
        Read : get(select)
        Update : patch(update)
        Delete : delete(delete)

# Service
    비즈니스 로직, 계산 수행, 외부 API 호출을 수행하는 Java 클래스를 표시
    @Service 를 붙여서 스프링에게 서비스라고 인식시켜준다

    서비스의 메소드가 실행될 때, 쿼리가 진행되다가 오류가 나는 경우 오류 이전까지의 쿼리는 결과의 반영된 상태로 오류가 나게 된다. 이런 경우 나중에 수정하고 재실행하면 이전에 반영됐던 결과를 초기값으로 가지므로 우리가 원하는 값을 제대로 얻을 수 없다.
        => 메소드에서 에러가 나면 이전 시점의 커밋으로 되돌리는 어노테이션 사용함!
        @Transactional(rollbackFor = {Exception.class}) : 모든 에러에 대해서 롤백시킴
        @Transactional(rollbackFor = {NullPointerException.class}) : NullPointerException 에러만 롤백시킴

# Mapper
    DB 로직을 구현하는 곳
    mapper패키지 아래에는 class가 아닌 interface로 생성한다
    @Mapper 를 붙여서 스프링에게 매퍼라고 인식시켜준다

# MVC(Model View Controller)
    프로그래밍 로직을 "서로 영향 없이 쉽게 고칠 수 있는" 소프트웨어 디자인 패턴

    M : 비즈니스 로직과 DB연동 로직을 구현한다.
        비즈니스 로직은 Service에서, DB연동 로직은 Mapper에서 구현
    V : 최종 사용자에게 결과를 화면(UI)로 보여준다.
    C : url 요청을 받아서 화면과 모델을 연결시켜준다.
    
    MVC 연결구성
        Client---(URL)---Montroller---(vo/dto)---Service---(vo)---Mapper
                                                                  Mapper ---(ORM, Mybatis)(vo)---DB
        mapper와 연결해주는 MyBatis 파일에서 쿼리를 잘 짜면 service에서 짜는 비즈니스 로직이 줄어든다.
    
    3개의 계층을 베이스로 시작한다
        1. Service의 비즈니스 계층
        2. Client의 프리젠테이션 계층(컨트롤러에서 나온 결과)
        3. Mapper의 퍼시스턴스 계층
    
    모델 안에 2개의 계층(비즈니스, 퍼시스턴스)이 있다.

# MVC 메소드 이름 규칙
    Controller 
        1. call
        2. load
            ex) callEmpInfo(), loadEmpInfo()
    Service 
        1. get, set 
        2. 동사표현 사용(make, upload, download 등) / 명사 안 됨
    Mapper 
        1. find(select), save(insert, update) ===> JPA에서 많이 사용
        2. get, set
        3. 쿼리이름(select 메소드면 selectEmpList, update메소드면 updateEmpList, insert, delete 등) 

# JDBC
    자바에서 데이터베이스에 접속할 수 있도록 하는 자바 API
    MyBatis가 나오기 이전에 JDBC를 사용했다.
    단점
        쿼리를 호출할 때마다 DB에 계속 연결해야 한다(sql쿼리를 사용할 때마다 로그인을 해야되고, 쿼리가 많아질수록 로그인 횟수도 많아짐)
        예를들어 숙제에서 쿼리 5개를 짠다면 자바와 DB를 연결하는 로직을 5번 써야한다. 그리고 로그인도 5번해야 한다.
    사용 당시엔 최선의 방법이었지만 지금은 MyBatis같은 대안이 많기 때문에 사용하지 않는다.

# 이클립스에서 MyBatis의 사용
    1. 수업에서 MyBatis로 MySQL에 연결해서 sql 쿼리를 작성할 때 사용하는 DML은 auto commit 된다.(디비버의 디폴트 설정과 같음)
        원래는 DML은 자동커밋되지 않고 commit()을 따로 입력 해야하고, DDL은 auto commit 된다.
        ==> auto commit의 유무가 DDL(CREATE, DROP, ALTER)과 DML(SELECT, INSERT, DELETE, UPDATE)의 핵심 차이점

        따라서 auto commit 되는 MyBatis의 쿼리나 디비버를 실무에서 사용할 때는 auto commit을 끄고 사용해야 한다!
    
    2. MyBatis sql쿼리에서 INSERT, DELETE, UPDATE의 return은 int형이다.
        삽입된, 지워진, 업데이트된 행의 수가 return 된다.

    3. sql 쿼리에서 like 이용한 문법이 다르다
        first를 주소로 받아서 비교할 때,
        기존 MySql : where ENAME like #{first}%
        MyBatis : where ENAME like CONCAT(#{first}, '%')
            => CONCAT은 여러 문자열의 텍스트를 합치는 함수
            ex) CONCAT("The"," ","sun"," ","will"," ","come"," ","up"," ","tomorrow.")  ===>  The sun will come up tomorrow.

        like 사용은 MySql, Oracle, MsSql에서 모두 다르다

    4. sql 쿼리에서 부등호 사용
        (추측)MtBatis sql 쿼리에서 부등호를 두개 이상 쓰면 오류나는 것 같다.
        해결방법) 1. <![CDATA[ 쿼리작성 ]]> 형태로 감싸준다.
                 2.  "<"  대신 "&lt;" /// ">"  대신 "&gt;" ///  "<=" 대신 "&lte;" /// ">=" 대신 "&gte;"
                 (&lte;(<=)와 &gte;(>=)는 MyBatis 쿼리에서 사용 안 됐음)
```java
부등호 예시
    WHERE
        <![CDATA[
		hiredate >= '1980-12-17' 
		and hiredate <= '1982-01-23'
		]]>

    또는

    WHERE 
        hiredate >= '1980-12-17' 
        and hiredate &lt;= '1982-01-23'
```       
    5. if 사용
        MyBatis에 boolean형이 없어서 다음처럼 사용한다
        String isName = "true"
        if(isName.equals("true")
```java
	<select id="selectEmpMgr" resultType="EmpVO">
	SELECT 
        *
	FROM emp 
	WHERE 1=1
	// 1=1은 의미없음
	<if test='isMgr.equals("true")'> // isMgr을 파라미터로 받고 있지만 test에는 #{}으로 표현하지 않는다
		AND mgr IS NOT NULL		
	</if>
	<if test='isMgr.equals("false")'>
		AND mgr IS NULL	
	</if>
    // 파라미터로 받는 isMgr이 true면(url에서 true로 입력받으면) mgr이 null이 아닌 사원을 조회하고, false면 null인 사원을 조회한다. if의 사용은 단순히 where 절의 조건으로 들어가는 것임.
	</select>

    // MyBatis에서 if 사용을 최소화 하는게 좋다. 오류 찾기 힘듦
```
    MyBatis의 단점 : 디버깅을 못 한다.
        => 디버깅을 할 수 없기때문에 sql 쿼리로 많이 작성하는 것은 지양해야 한다.

# @AutoWired
    @AutoWired를 쓰면 new를 쓰지 않고 원하는 클래스를 호출할 수 있다.
    객체 생성과 소멸을 Spring이 관리(제어)해 준다.
        => 스프링의 개념 중 하나인 IoC(Inversion of Control, 제어의 역전)
    스프링이 제어하는 클래스를 Bean 클래스라고 한다.
```java
public class MainController {
    @Autowired
    private MainService service;
    // @Autowired로 @Service가 붙은 MainService와 연결해줌
    @GetMapping("/userList")
    public List<UserVO> callUserList(){
        return service.getUserList();
    }
}
```

# @Component
    내가 직접 작성한 클래스를 스프링에게 빈(스프링이 관리하는 클래스)으로 등록하라는 의미
    => @Bean과 같이 다른 클래스에서 사용시 new를 쓸 필요 없다. (스프링이 대신함)

    @Bean과 차이
        Bean은 스프링이 만들고 스프링이 관리하는 클래스
        Component는 내가 만들고 스프링이 관리하는 클래스

# RESTful 과 QueryString
    URL을 요청받는 방법이다.
    RESTful은 / 를 기준으로, Query String은 ?, & 기준으로 주소를 나눈다.
    주소에 RESTful과 QueryString을 섞어서 쓴다.

    REST
        Representational State Transfer
        자원을 이름으로 구분하여 해당 자원의 상태(정보)를 주고 받는 모든 것을 의미함
        ‘REST API’를 제공하는 웹 서비스를 ‘RESTful’하다고 할 수 있다.

    RESTful
        - RESTful은 REST원리를 따르는 시스템을 지칭
        - 주소(URL)을 의미있게 네이밍 하는 방법
        - 주소만 보고 어떤 내용인지 알 수 있게끔 만든다.
            ex) 1. 무신사 기본 화면은 com/app, 상품페이지에선 com/app/goods/~ 로 표시됨
                2. /emp/empno/7000
        - @PathVariable 를 사용해서 파라미터를 받는 주소를 만들 수 있다.
            /emp/job/{job}/sal/{sal} 에서 {} 값을 파라미터에 대입
        - 규칙
            1-1. 주소 이름은 동사 X -> 명사로 작성
                ex) 특정 멤버에게 comm 100을 줄 때,
                    /member/insert/100 (X)
                    /member/no/123 (O) 로 쓰고 Get이 아닌 Post로 작성하면 됨
            1-2. 주소 이름은 대문자 X -> 소문자로 작성
            1-3. 그룹을 의미할 땐 s를 붙임(복수명사 사용)
                ex) /members
            1-4. 핸드폰을 소유하고 있는 학생 조회 (리소스 간에 연관 관계가 있는 경우)
                주소 자체에 have의 개념이 있다.
                    /students/phone
                특정 학생에게 1번이 부여되어 있는 경우
                    /students/1/phone
                130번 번호를 가진 고객 주문 리스트 조회 (고객이 주문을 갖고 있음)
                    /customers/130/orderList
                    /customers/130/order/list
                    /customers/130/order-list ==> 주소에서 _를 쓰지 않음
                20번 번호를 가진 유저의 핸드폰 고유번호는 AA123
                    /users/20/phone/AA123
                사원번호가 7000 사원의 사수 번호가 3000
                    /emp/7000/mgr/3000
                    /emp/empno/7000/mgr/mgrno/3000 => 주소가 너무 길어지는 것도 안 좋기 때문에 팀회의를 거쳐서 생략이 필요함
            1-5. 주소 마지막에는 / 를 붙이지 않는다.
                ex) www.naver.com/news 까지만 쓴다
            
        구글에 Restful 규칙 검색해보기
            https://velog.io/@pjh612/REST-API-URI-%EA%B7%9C%EC%B9%99        
```java
public class EmpController {
	@Autowired
	private EmpService empService;
	@GetMapping("/emp/no/{empNo}")
	// {}의 의미 : 중괄호 안에 있는 걸 파라미터로 넘기겠다!
	public EmpVO callEmp(@PathVariable("empNo") int empNo) {
		return empService.getEmp(empNo);
	}
}
```

    QueryString
        검색(필터링)할 때 많이 사용
            ex) 게시판

# Controller에서 CRUD 사용과 포스트맨 사용 방법
```sql
    1. CREATE(insert)(post)
        Controller : @PostMapping("/emp")
                     public int callEmpSet(@RequestBody EmpVO empVO) {
                        return empService.setEmp(empVO);
                     }
        sql 쿼리    : 	<insert id="insertEmp">
                            INSERT INTO emp
                            (
                                empno,
                                ename,
                                deptno,
                                hiredate
                            )
                            VALUES
                            (
                                #{empno},
                                #{ename},
                                #{deptno},
                                now()
                                -- hiredate는 지금 일자로 넣어 줌
                            )
                        </insert>
        포스트맨    : POST 선택, http://localhost:8080/emp 입력하고
                     body - raw - JSON에서 empno와 ename, deptno를 key로 하는 json 작성하고 Send로 업데이트(삽입된 행의 수가 리턴됨)
                     sql에서 파라미터로 받기로 한 empno, ename, deptno를 포스트맨의 JSON에서 모두 적을 필요는 없다. 적은 것만 insert 됨.
                     
	</insert>
    2. READ(select)(get)
        Controller : @GetMapping("/emp/job/{job}/sal/{sal}")
                     public List<EmpVO> callEmpName(@PathVariable("job") String job, @PathVariable("sal") int sal) {
                            return empService.getEmpName(job, sal);
                     }
                    --   url에 입력받을 파라미터({job}, {sal})에 @PathVariable를 붙인다
                    --   @PathVariable 뒤 "" 안의 이름과 메소드 {} 안의 이름은 일치해야 한다
        Mapper     : 파라미터에 @Param을 붙인다.
                    public List<EmpVO> selectEmpName(@Param("job") String job, @Param("sal") int sal);
        sql 쿼리    : 파라미터를 #{}로 담는다.	
                        <select id="selectEmpName" resultType="EmpVO">
                            SELECT
                                empno,
                                ename,
                                job,
                                comm
                            FROM emp
                            WHERE 
                                job = #{job}
                            and 
                                sal >= #{sal}
                        </select>
        포스트맨    : GET 선택, http://localhost:8080/emp/job/manager/sal/2500 입력하고 Send로 조회

    3. UPDATE(update)(patch)
        Controller : @PatchMapping("/emp")
                      public int callEmpUpdate(@RequestBody EmpVO empVO) {
                            return empService.getEmpUpdateCount(empVO);
                      }
                    --   @RequestBody가 파라미터로 넘어오는 EmpVO를 대신 new 해준다
        sql 쿼리    : where절에 empno(pk)를 조건으로 emp의 sal을 업데이트해줌
                        <update id="updateEmp">
                            UPDATE emp
                            SET 
                                sal = #{sal}
                            WHERE empno = #{empno}
                            -- 여기서 받는 #{}들은 postman에서 json으로 입력한 값들임
                        </update>
        포스트맨    : PATCH 선택, 주소를 http://localhost:8080/emp 로 입력하고
                        body - raw - JSON에서 empno와 sal을 key로 하는 json 작성하고 Send로 업데이트(변경된 행의 수가 리턴됨)

    4. DELETE(delete)(delete)
        Controller  : @DeleteMapping("/emp/empno/{empno}")
                      public int callEmpRemove(@PathVariable("empno") int empno) {
                            return empService.getEmpRemoveCount(empno);
                      }
        sql 쿼리    : 파라미터로 받은 empno를 #{}로 받음
                        <delete id="deleteEmp">
                            DELETE FROM emp
                            WHERE empno = #{empno}
                        </delete>
        포스트맨     : DELETE 선택, http://localhost:8080/emp/empno/8080 입력하면 해당하는 empno를 가진 emp가 삭제됨
```

# GetMapping으로 조회하면서 동시에 업데이트하기
```
문제) job이 manager이고 sal이 2500이상 받는 사원 comm 500으로 업데이트하고 해당 사원 이름, 직업, 커미션 조회
    필요한 것
        1. job이 manager이고 sal이 2500이상 받는 사원을 찾을 sql문
        2. 위 조건을 만족하면 comm을 500으로 업데이트하는 기능
        3. 업데이트 된 사원의 이름과 직업, 커미션을 조회하는 기능
```
```sql
Controller  :   -- 컨트롤러에서는 파라미터로 job과 sal을 받고 조회하는 기능을 만들어 준다.
                @GetMapping("/emp/job/{job}/sal/{sal}")
                public List<EmpVO> callEmpName(@PathVariable("job") String job, @PathVariable("sal") int sal) {
                    return empService.getEmpName(job, sal);
                }

Service     :   -- 서비스에서 comm의 업데이트와 조회가 같이 진행된다!
                @Transactional(rollbackFor = {Exception.class})
                public List<EmpVO> getEmpName(String job, int sal) {
                    -- 직업이 SALESMAN이면 null 리턴하는 조건의 로직 추가
                    if(job.equals("SALESMAN") || job.equals("salesman")) { 
                        -- 파라미터의 대소문자 구분함
                        return null;
                    }
                    List<EmpVO> list = empMapper.selectEmpName(job, sal);
                    -- 새로 불러온 리스트 안에 job과 sal의 조건을 만족하는 사원의 리스트를 넣어줌
                    int comm = 500;
                    int rows = 0;
                    for(int i=0; i<list.size(); i++) {
            			-- 추가 요청 ) 커미션을 기존거에 더해달라
            			-- int empComm = list.get(i).getComm();
            			-- list.get(i).setComm(empComm+comm);
                        list.get(i).setComm(comm);
                        -- 조건을 만족하는 사원의 리스트에 comm을 업데이트해줌
                        EmpVO vo = list.get(i);
                        -- 리스트가 아닌 EmpVO의 정보에 반영하기 위해서 새로 호출하고 리스트의 값을 넣어줌
                        vo.setComm(comm);
                        -- 이게 필요한가 확인하기!
                        rows += empMapper.updateEmp(vo);
                    }
                    if(rows > 0) {
                        return empMapper.selectEmpName(job, sal);
                    }
                    return null;
                }

Mapper      : 	1. 조건을 만족하는 사원 리스트를 담은 mapper
                public List<EmpVO> selectEmpName(
                    @Param("job") String job,
                    @Param("sal") int sal
                );
                2. 

sql쿼리      :  1. 입력받은 job과 sal을 조건을 만족하는 사원 조회 sql 쿼리문
                    <select id="selectEmpName" resultType="EmpVO">
                        SELECT
                            empno,
                            ename,
                            job,
                            comm
                        FROM emp
                        WHERE 
                            job = #{job}
                        and 
                            sal >= #{sal}
                    </select>
```

# json으로 Controller와 연결
    Controller의 결과를 받는게 웹이면 웹서버, 안드로이드면 안드로이드서버, 디바이스면 Iot서버가 된다. 그리고 이 모두는 json으로 연결돼 있다.

    웹
        웹은 json 또는 jsp로 데이터를 보낼 수 있다. 템플릿엔진을 사용하지 않으면 @RestController을 이용하여 데이터를 보낼 수 있다.
        Spring으로 구현한 API를 AJAX로 보내서 html에서 결과를 확인할 수 있다.
        url 요청을 받을 Controller에 @CrossOrigin을 붙여서 보안 허용이 필요하다.
    
# REST API 와 템플릿엔진 개발 차이
    1. REST API로 개발
        백엔드와 프론트를 구별함(json으로 통신함)

    2. 템플릿엔진으로 개발
        프론트가 백엔드에 붙어있음(Spring 안에 jsp가 있다)
        ===> 포스트맨으로 결과 볼 수 없고 jsp에서 봐야 함

# 암호화
    암호화 방법
        1. 단방향 암호 : 암호화하면 복호화할 수 없음
            ex) 주민번호, 핸드폰 번호
        2. 양방향 암호 : 암호화하면 복호화할 수 있음

    양방향에서 암호에서 복호화 방법
        public key를 가진 사람만 해독할 수 있음
            (암호화 한 사람이 key를 갖고 있고, 다른 사람에게 줄 수 있다)

    암호화도 각각의 이름과 알고리즘이 있는데 대표적으로 "SHA256" 이 있음

    Spring에서 암호화 사용(Spring security 사용)
        Spring security는 보안 관련 기능 패키지로 build.gradle에 다운로드 받아야 한다.

        1. 프로젝트 이름 패키지 아래에 conf 패키지를 생성함
            conf 는 암호화 설정과 관련된 패키지이다
            ex) com.dw.board.conf
        2. @Configuration 선언
            어노테이션을 붙여줌으로써 스프링에게 이게 설정파일이고 @bean 사용한다고 알려준다.
        3. @EnableWebSecurity 선언하고 상속받기
            https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/configuration/EnableWebSecurity.html

        Bean 클래스는 스프링에서 관리하는 클래스
            @Autowired 를 붙이면 스프링이 클래스를 관리해줌(스프링이 객체 생성과 소멸을 관리)
            암호화할 때 PasswordEncoder 인터페이스를 사용하기 위해 붙여준다.

# 에러 종류
    404
        1. 없는 url 입력
        2. url 오타
        3. @RestController 또는 @Controller 어노테이션 입력 X
        4. 다른 http 메소드를 사용한 경우(get해야되는데 post 사용)
    500
        1. 자바 코딩을 잘못함
        ex) 배열길이 10인데, 11번쨰 인덱스 호출
            쿼리 오타
            쿼리 결과 List인데 다른 걸로 받을 때
    403
        1. 권한 에러

# 통계를 낼 때 (게시판에서 학생수, 게시글 수, 작성자 수, 조회 수 등)
    1. 통계 테이블을 따로 만듦 <= 통계의 양이 방대할 때 사용
        (특정 시간이 되면 쿼리로 조회한 통계를 테이블에 insert함)
    2. 쿼리로 조회
        => 통계를 한번에 내기 위해 sqlmapper에서 서브쿼리로 조회함

# 수업에서 maven 프로젝트 생성하고 사용

jsp 프로젝트 생성
    스프링 initializr 이용
    Maven
    그룹 : com.study
    artifact : jsp
    자바 버전 : 11
    dependencies  : spring web
    이클립스에서 maven 프로젝트로 선택하고 import

jsp 설정
    maven의 dependencies는 pom.xml에 추가 & 저장 (gradle처럼 refresh하는 건 필요 없음)
        dependecies에 version을 안 쓰면 최신버전 다운로드 받는다.
        수업에서 JSTL, tomcat, devtools 추가함

    src/main 경로에서 source folder 이름 src/main/webapp 생성
    - webapp 아래에 폴더 WEB-INF 생성
    - WEB-INF 아래에 폴더 views 생성

# dependecy 코드 찾기
    구글에 maven repository 검색, https://mvnrepository.com/
    상단 검색창에 필요한 것 검색, 버전 선택해서 Maven/Gradle 코드 복붙해서 사용

# MyBatis와 JPA
    JPA
        Java에서 제공하는 ORM 기술의 표준 API
        구성요소
            1. javax.persistance 패키지로 정의된 API
            2. JPQL(Java Persistence Query Language)
            3. 객체/관계 메타 데이터
        사용자가 원하는 JPA 구현체를 선택해서 사용가능
        JPA 구현체
            Hibernate, EclipseLink, DataNucleus, OpenJPA, TopLink Essentials
            위 구현체들을 ORM 프레임워크라고 부름
        장점
            객체지향적으로 DB를 관리할 수 있기 때문에 비즈니스 로직에 집중 가능
            테이블 생성, 변경, 관리가 쉬움
            로직을 쿼리에 집중하기 보다는 객체 자체에 집중할 수 있음
        단점
            많은 내용이 감싸져 있기 때문에 어려움

        한국 일본 중국을 제외한 나라에선 JPA를 압도적으로 많이 사용한다.

    Mybatis
        개발자가 작성한 SQL을 mapping 해주는 SQL Mapper
        자바 객체를 실제 SQL문에 연결함
        원래 이름은 iBatis였는데 Google Code로 이전되면서 이름이 바뀜
        장점
            SQL쿼리들이 잘 최적화되어 있을 때 유용
        단점
            애플리케이션과 DB간에 잘 구조화되도록 하려면 많은 설정이 필요하므로 둘 간의 모든 조작을 하고자 할 때는 부적합
            
# 그 외, 정리 전
```
자바로 웹을 개발하는 방법
    1. 프레임워크(플랫폼)를 이용한 웹개발 (Spring)
    2. 프레임워크를 이용하지 않는 웹개발 (JSP & 서블릿)
프레임워크 종류(자바기준)
    Spring boot, Spring, Spring egov(우리나라에서 만든 것)
빌드 툴
    Gradle, Maven(XML)
```
```
수업시간에 만드는 프로젝트
주제 : dw 학생 게시판
    학생 테이블 : 학생 아이디(번호), 이름, 비밀번호, 생성일
    게시판 테이블 : 보드 아이디(번호), 학생 아이디(FK), 제목, 내용, 수정일, 최초작성일

    students 테이블
        학생아이디가 FK로 게시판 테이블에 있어야 학생번호로 이름(작성자)를 불러올 수 있다.
        1:n의 관계( 학생이 여러 게시글을 쓸 수 있음)

        만드는 것
            1. 회원가입 페이지에서 학생을 DB에 등록할 때 비밀번호를 암호화해서 저장하기

    board 테이블
        학생 테이블과 관계에서 학생id(FK)는 null이 허용됨 => 필요에 따라 not null 을 줌

        문제를 풀 때 sql쿼리로 먼저 풀기
            쿼리를 잘 짜면 비즈니스 로직이 줄어 듦 (데이터를 잘 다루면 웹/앱 다 잘 함!)

        만드는 것
            1. 로그인 한 유저만 게시판 페이지에 들어올 수 있게 만들기 => session 이용!
                우선 gradle에 session 다운로드하고, 다음 로직을 구현
                => 로그인이 성공하면 seesion에 이름을 담는다.
                => session에 있는 이름으로 페이지 이동을 결정한다.
                (StudentsRestController의 로그인 메소드와 map으로 학생조회 메소드를 이용)
```