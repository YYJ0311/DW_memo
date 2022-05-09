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
```java
package com.example.first_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 템플릿엔진을 아직 사용하지 않아서 Rest를 붙여줌(Rest API를 의미)
// 템플릿엔진을 사용할 거면 @Controller 를 사용한다.
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
```
    어떤 ip가 접속을 했는지를 controller에서 확인할 수 있다.
        어떤 지역에서 들어왔는지 통계를 낼 수 있음
```
```java
public class ActorController {
	@Autowired
	private MainService service;
	//문제 1. 나이가 60 이하인 배우만 리턴하시오.
	@GetMapping("/actor/list")
	public List<UserVO> callUserList(HttpServletRequest request){
		String ip = request.getHeader("X-forwarded-For");
		if(ip == null) ip = request.getRemoteAddr();
		System.out.println("IP ===>"+ip);
		// 사이트에 접속하는 ip를 수집
		return service.getUserList();
	}
```
```
    request.getHeader("X-forwarded-For")로 ip를 부르는 이유
        http 안에 header와 body가 들어있고, header에는 ip주소가 들어있다.
        X-forwarded-For(XFF)는 HTTP 헤더 중 하나로, 원래의 IP 주소를 식별하기 위한 표준 헤더이다.

    header에 ip가 없는 경우(null) request.getRemoteAddr() 로 불러온다.
```

# Service
    비즈니스 로직, 계산 수행, 외부 API 호출을 수행하는 Java 클래스를 표시
    @Service 를 붙여서 스프링에게 서비스라고 인식시켜준다

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

# JDBC
    자바에서 데이터베이스에 접속할 수 있도록 하는 자바 API
    MyBatis가 나오기 이전에 JDBC를 사용했다.
    단점
        쿼리를 호출할 때마다 DB에 계속 연결해야 한다(sql쿼리를 사용할 때마다 로그인을 해야되고, 쿼리가 많아질수록 로그인 횟수도 많아짐)
        예를들어 숙제에서 쿼리 5개를 짠다면 자바와 DB를 연결하는 로직을 5번 써야한다. 그리고 로그인도 5번해야 한다.
    사용 당시엔 최선의 방법이었지만 지금은 MyBatis같은 대안이 많기 때문에 사용하지 않는다.

# DB에서의 DML
    DML은 데이터조작언어(SELECT, INSERT, DELETE, UPDATE(DELETE와 INSERT의 묶음))

# 메소드 이름 규칙
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

# RESTful
    컨트롤러에서 파라미터 받는 방법
    1. RESTful
    2. Query String : ?, &

    RESTful은 REST원리를 따르는 시스템을 지칭한다.
    주소(URL)을 의미있게 네이밍 하는 방법
    주소만 보고 어떤 내용인지 알 수 있게끔 만든다.
        ex) 무신사 기본 화면은 com/app, 상품페이지에선 com/app/goods/~ 로 표시됨
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

# 그 외
    @GetMapping
        http 메소드 중 get(요청)을 사용한 것
        결과를 console이 아닌 http로 받는다(스프링 결과를 hyper text로 전송)

    VO == DTO(Data Transfer Object)
        패키지 안에 VO/DTO 클래스 그리고 그 안에 getter, setter 메소드만 존재
