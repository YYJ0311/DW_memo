# 바닐라 js와 j쿼리
	- 바닐라 js 속도가 더 빠르다
	- 바닐라 js 문법
		document.getElementBy~("")
    	~ 자리에 id, class, name 오는데 보통 고유한 id로 많이 사용.
	- 왜 바닐라.js에서 제이쿼리로 넘어갔을까?
		기능적인 한계(통신 등)
		2008년 ~ 2017 or 2018년까지는 제이쿼리의 시대!(압도적)
		2018년 이후에는 React, vue, 앵귤러
		지금은 제이쿼리 or React를 사용한다.

# 바닐라js와 j쿼리 문법
    기존 바닐라.js (순수 자바스크립트)
    document.getElementBy~
                        (id, className, name)
        : 태그를 불러 옴

    Jquery
    $('.className').css('display','block')
    $('.name').show() : 제이쿼리 show 함수를 클래스 name에서 호출

    document.getElementByClass('name').style = $('.name').css()

# 자주 사용하는 jquery
    1. show, hide
    2. append
    3. children
    *****4. val, text, focus
    5. attr

# this와 super
    this는 본인, super는 부모

# on
    on('이벤트','함수(){}')
    : 이벤트가 발생하면 함수를 실행하겠다(바인딩)

    $('#children').on('click',function(){ }
        - fuction(함수) 에서 함수이름을 쓰지 않고 사용 <= 익명함수
            (익명함수를 쓰는 이유 : 함수가 많아지면 함수 이름 짓기가 너무 힘들어서)
        - on이 jquery 메소드이고 click과 function. 2개의 파라미터를 받고 있다.
        
# $('#children').on('click',function(){ } 에서
    - 자바스크립트는 매개변수에 함수를 넣을 수 있다 
        (자바는 안 됨! js의 특징)
    - js는 리턴타입이 없어서 function(함수)으로도 리턴이 가능하다(클로저) 
        ex. function name(){ return function name x(){} }

# append & appendto
    : 추가 또는 이동기능
    "부모태그"에 append하면 "자식태그"로 추가된다.
    기존에 존재하는 태그는 이동되었음

# children & find
    : 부모태그를 기준으로 자식태그의 정보를 알고싶을 때 사용
    * 배열 형태로 가져왔다!
    자식태그 안에 자식태그(손자?태그)를 찾을 땐 사용 못 함 
        ==> 1. 자식태그를 부모태그로 해서 그 자식(손자)태그 찾음
        2. find 사용

# 내장함수
    var userId = $('#userId').val().trim();
        1. val()은 제이쿼리에 있는 함수이고, 문자를 리턴함
        2. trim()은 문자 자체에 내장돼 있는 함수
    $('#userId').val()에서 return한 문자에 .trim() 함수 적용
    => 메소드 체이닝

    trim(), substring() 등은 문자열 함수이고 자바스크립트의 내장함수이다 (j쿼리는 다운받아서 썼지만 내장함수는 다운받지 않고 사용 가능함)

# 메소드체이닝
    메소드 체이닝은 리턴값이 있는 함수만 가능하다
    리턴을 받아서 다음 메소드로 넘어감
        ex) string(n).split('').sort().reverse().join('');
        
    보기 편해서 많이 쓴다!

# 정규표현식(Reguler Expression)
    : 문자열을 처리하는 방법
    한글, 영어, 이메일 등의 정규표현식은 검색해서 사용

    test() 를 이용해서 정규표현식을 return한다
    ex) return regex.test(변수이름);

# 데이터 전송
    HTML <--json(jquery 이용)--> server(JAVA or node.js)
    HTML <--HTTP이용(json을 담음)--> server

    HTML (Hyper Text Markup Language)
    HTTP ( Hyper Text Transfer Protocol)
        : hyper text를 전송하기 위한 약속 (html을 전송하는 약속)
        HTTP를 지휘하는 것 = jQuery

# HTTP / HTTPs
    HTTP 메소드(기능)
        주요 메소드
        GET : DB의 select 개념 (데이터 조회)
        POST : DB의 insert 개념 (데이터 생성)
        PATCH : DB의 update 개념 (데이터 일부분 수정)
        DELETE (데이터 삭제)
        PUT : 리소스를 대체, 해당 리소스가 없으면 생성
        
        기타메소드
        HEAD, OPTION, CONNECT, TRACE

    HTTPs : http가 보안이 취약해서 security 보완한 것
    (json 데이터를 다른 사람이 탈취하게되면 제대로 주고받지 못하게 되기 때문에 보안을 강화시킴)

# 제이쿼리 css 여러개 사용하는 방법
    1. 하나의 css 적용
        $(".className").css("속성","값");
    2. 여러개의 css 적용
        $(".className").css({"속성","값", "속성","값"});