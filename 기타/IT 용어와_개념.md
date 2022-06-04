IT 용어

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