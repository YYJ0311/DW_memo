IT 용어

수업에서 쓴 
    프레임워크 : Spring
    개발 언어 : Java
    DB : MySQL
    build tool : Gradle

# 오픈소스, IDE
    오픈 소스  
        : 소스 코드를 공개해 누구나 특별한 제한없이 사용하는 소프트웨어 (ex. Mysql, Java, http, 이클립스, git)  

    IDE (통합 개발 환경)  
        : egov, 이클립스, 인텔리 제이(유료), 안드로이드 스튜디오, 파이참 등.

            IDE 뭐 썼냐고 물어보면 이클립스 썼다고 말하면 됨.
            이클립스는 자바 X, 백엔드 언어 X, 백엔드 툴 X
            이클립스는 단순히 성능 좋은 메모장

            ex) 저는 자바를 배웠고, IDE는 이클립스를 사용했습니다.

# 서버
    서버란 서비스를 제공하는 주체이다.  
    HTML -> 웹 서버 -> DB 서버(My SQL)
    *HTML에서 작성된 데이터는 웹 서버를 거쳐서 DB 서버에 저장된다.
    (HTML과 DB는 바로 연동이 불가능하기 때문)

    DB로 접속할 때 java, node.js, python과 같은 것들을 사용한다

    HTML : 클라이언트
    java(node.js 등) + DB : 서버    

    HTML --(전송구역)-- java --()-- DB
    전송구역에서 보통 json을 이용하여 전송한다

    json(JavaScript Object Notation)은 데이터 포맷 형식
    버튼을 누르면 input의 값들이 json 형식으로 보내짐
    
# CDN(Content Delivery Network)
    : 지리적 제약 없이 전 세계 사용자들에게 빠르고 안전하게 콘텐츠를 전송할 수 있는 기술 
    ex) 한국과 미국 거리가 너무 멀어서 인터넷 속도가 느려질 수밖에 없음
            => 그래서 CDN이 나오게 됨
        해결) 일본에 특정 회사가 지사를 세우고 한국에서 일본 지사에 접속하면 미국에 접속하는 것보다 빠르게 이용가능
    (인스타그램, 페이스북 등 글로벌로 진출하고자 하는 회사는 무조건 사용해야하는 기술)

# 블록체인
    insert만 존재하고 update나 delete는 불가능하여 데이터 조작이 불가능
    은행에서도 블록체인으로 관리함
    데이터가 많아지면 많아질수록 체인의 길이가 늘어나고 안전해진다.
    
# NFT(Non Fungible Token)
    : 대체 불가능한 토큰
    token은 DB(블록체인)의 기록
    토큰은 모두 public 블록체인에 저장
    NFT 덕분에 디지털 자산의 소유권을 입증하는 것이 가능
    
# 컴파일과 인터프리터
    컴파일 (C, C++, JAVA, ...)
        1. 전체 소스코드를 보고 실행
        2. 인터프리터와 비교했을 때 실행속도가 빠름 (인공위성 같은건 C/C++로 만듦)
        3. 코드를 수정하고 실행하려면 처음부터 다시해야 함
    인터프리터 (Python, JavaScript, ...)
        1. 한줄씩 실행
        2. 컴파일과 비교했을 때 실행속도 느림
        3. 코드를 수정하고 즉시 실행

# API (Application Programming Interface)
    서버와 데이터베이스의 출입구 역할 (허용된 사람에게만 접근성을 부여)
    json을 받을 목적지
    html과 server 간에 상호작용이 일어난다

# AJAX (Asynchronous Javascript And XML)
    자바스크립트를 이용한 "비동기적" 통신 
    데이터 전송해놓고 다른 function 수행 가능. 
        ex) 카톡으로 사진을 보내면서 텍스트도 보낼 수 있다.
    서버와 클라이언트 간의 XML 데이터를 주고 받는 데 사용함
```javascript
    문법
        $.ajax(
            { 
            url : API주소 // 목적지
            type : HTTP Method //위에 적은 HTTP 메소드 중에 하나 적음
            dataType : json // 서버응답 데이터(서버에서 온 데이터를 json으로 받겠다. 주로 쓰는 2가지 = json, text)
            success : function(response){
                HTML에서 요청이 success(성공)하면 익명함수 파라미터에 값을 대입한다는 의미
            },
            error : function(request, status, error){
                성공하지 못하면 error 실행
            }
            }
            // value에 올 수 있는 것 : 문자, 숫자, boolean, json, 배열, function
    )
```
```javascript
    <body>
        <input id="friday" type="text" value="오늘은 금요일">
    </body>
    <script>
        var value = $('#friday').val();
        console.log(value); // 오늘은 금요일
            $.ajax({
                url: 'http://localhost:8080/api/v1/board?pageNum=1&pageSize=10',
                type : 'GET',
                dataType: 'json',
                success: function (response) { // success를 node.js는 then으로 씀
                var html = '<input id="monday" type="text" value="오늘은 월요일">';
                $('body').append(html);
                }
            });
        var value2 = $('#monday').val();
        console.log(value2); // undefined 
    </script>
```
    ajax가 비동기이기 때문에 코드를 위에서부터 차례대로 읽는 과정에서 ajax를 실행시키고서 결과가 나오기도 전에 ajax 아래에 있는 코드를 실행한다. 그래서 ajax 안에서 append한 html은 밖에서 인식하지 못하기 때문에 undefined로 나오게 된다.
        => ajax로 만든 html은 console.log()로 확인하기 어렵기 때문에 컨트롤이 힘들다.

    만약 ajax가 스프링과 같이 동기적 통신이었다면 val를 불러올 수 있다.

# 쿠키와 세션
    HTTP 통신은 Connectionless, Stateless 때문에 정보를 저장 및 유지할 수 없다. 그래서 쿠키와 세션을 이용해서 간단한 정보를 임시로 서버에 저장한다.

    HTTP 통신 특징
        1.Connectionless (비연결지향)
            더 이상 연결을 지속적으로 하지 않음
        2. Stateless (상태정보유지 안함)
            요청을 응답하고 접속을 바로 끊어서 정보를 저장하지 않는다.

    쿠키 : '웹브라우저'에 데이터를 임시 저장 (프론트)
        (개발자도구 - Application - Cookies 에서 저장된 것 확인 가능)
        세션이랑 비교해서 보안 취약
        ex) 아이디 자동완성

    세션 : 특별한 정보를 '서버'에 임시 저장 (백엔드)
        로그인부터 로그아웃할 때까지(세션)에 저장되어 있음
        서버에 있기 때문에 쿠키와 비교해서 보안이 좋음
        사용 이유 : http가 정보를 유지하는 기능이 없기 때문

# 트랜잭션(Transaction)
    - DML(INSERT, DELETE, UPDATE, SELECT)을 이용한 쿼리로 데이터가 변하는 것을 트랜잭션이라고 부른다.
    - 쿼리가 실행되면 트랜잭션이 실행됐다고 말하고, 쿼리를 실행하면서 생기는 오류를 방지하는 것을 "트랜잭션 처리"라고 한다. 트랜잭션 처리는 다음 특징을 고려해야 한다.
    - 특징
        1. 원자성
            쿼리가 모두 실행되거나 모두 실행되지 않아야 한다.(트랜잭션이 모두 반영되거나 아니면 전혀 반영되지 않아야 한다.)
        2. 일관성
            트랜잭션의 결과가 항상 일관성 있어야 한다
        3. 독립성
            동시에 실행되는 두개의 트랜잭션에 대해서 하나의 트랜잭션은 다른 트랜잭션에 끼어들 수 없다.
        4. 지속성
            트랜잭션이 완료되면, 결과는 영구적으로 반영되어야 한다.

# 컴파일과 빌드
    컴파일
        - 개발자가 작성한 소스코드를 기계가 읽을 수 있는 바이너리 코드로 변환하는 과정
        - JAVA에서 컴파일한 바이트코드는 JVM(Java Virtual Machine)가 읽고 실행한다.

    빌드
        - 소스 코드를 실행 가능한 독립적인 소프트웨어 산출물로 만드는 과정
        - 빌드를 함으로써 하나의 프로그램(압축파일)을 만들 수 있고 하나의 소프트웨어가 된다.
        - 빌드 과정
            1. 컴파일
                소스코드 -> 바이너리 코드
            2. 링크
                여러개로 분리된 소스코드를 컴파일한 결과물에서 최종 실행 가능한 파일을 만들기 위해 필요한 부분을 찾아서 연결해 줌
            3. 패키징 : 연결된 클래스 및 리소스 파일 묶어주기
            4. 테스트 : 기능 테스트
        - 산출물
            JAR(Java Archive)
                자바에서 사용되는 압축 양식으로, 클래스 파일과 관련 리소스파일로 구성
            WAR(Web Archive)
                웹 어플리케이션을 압축하고 배포하는데 사용되는 파일 형태
                JAR에 비해 서블릿, XML 파일, 정적 파일등 필요한 자원이 더 많다.
        - 빌드툴
            Ant, Maven, Gradle

# 서블릿
    자바를 이용하여 웹페이지를 동적으로 생성하는 서버측 프로그램
    서블릿 컨테이너를 통해서 서버와 통신을 하고, View 페이지에 알맞은 콘텐츠를 보내줌으로써 정적 페이지인 HTML에서 사용자에 맞는 정보를 전해줄 수 있다(동적 콘텐츠 생성)
    서블릿은 JAVA 코드 안에 HTML을 포함하고 있다 (JSP가 HTML 문서 안에 JAVA 코드를 포함하고 있는 것과 반대)

    동작 방식
        1. 사용자가 URL을 입력하면 HTTP Request가 Servlet Container로 전송
        2. 요청을 전송받은 Servlet Container는 HttpServletRequest, HttpServletResoponse 객체를 생성
        3. web.xml을 기반으로 사용자가 요청한 URL이 어느 서블릿에 대한 요청인지 찾음
        4. 해당 서블릿에서 service 메소드를 호출한 후 클라이언트의 GET, POST 여부에 따라 doGet(), doPost()를 호출
        5. doGet(), doPost()는 동적페이지를 생성한 후 HttpServletResponse 객체에 응답을 보냄
        6. 응답이 끝나면 HttpServletRequest, HttpServletResoponse 객체를 소멸시킴

    서블릿 컨테이너
        서블릿과 웹서버가 쉽게 통신할 수 있게 해줌
        서버에 만들어진 서블릿을 관리
            서블릿 생명주기(서블릿 객체 생성, 초기화, 호출 종료) 관리
        스프링 부트에 내장되어 있는 톰캣이 서블릿 컨테이너이다.
            톰캣은 웹 서버와 통신하여 JSP와 Servlet이 작동하는 환경을 제공해준다
        기능을 서블릿컨테이너에 넣어야 실행이 된다.
            (만든 java 어플리케이션을 컨테이너에 담음)
    
    디스패처 서블릿(Dispatcher-Servlet)
        HTTP 프로토콜로 들어오는 모든 요청을 가장 먼저 받아 적합한 컨트롤러에 위임해주는 프론트 컨트롤러
        예를들어, 클라이언트로부터 요청이 들어오면 톰캣과 같은 서블릿컨테이너가 요청을 받고 다음으로 이런 요청을 프론트 컨트롤러인 디스패처 서블릿이 가장 먼저 받게 된다. 디스패처 서블릿은 공통적인 작업을 먼저 처리한 후 해당 요청을 처리해야 하는 컨트롤러를 찾아서 작업을 위임한다.

# web.xml
    서블릿이 매핑되는 방법, 인증이 필요한 URL 등의 정보가 있다
    모든 Web application은 반드시 하나의 web.xml 파일을 가져야 하고 위치는 WEB-INF 폴더 아래에 있다.
    web.xml파일의 설정은 Web application 시작시 메모리에 로딩된다.

# Bean 생명주기
    스프링의 컨테이너는 빈의 초기화부터 종료까지의 빈생명주기를 관리한다.
    과정
        1. 스프링 컨테이너 생성
        2. 각각의 요청에 맞는 빈 생성
        3. 의존 관계 주입 (Dependenct Injection, DI)
        4. 생성된 빈들의 초기화 콜백 메소드 호출
        5. 어플리케이션에서 빈 사용됨
        6. 빈들의 소멸 콜백 메소드 호출
        7. 스프링 종료