- ### HTML 
    ```
    - HTML이란?
    (Hyper Text Markup Language)  
    언어 종류 중 하나

    - 수업때 사용한 HTML은 5버전!
    
    - HTML을 알아야 하는 직군
        웹디자이너, 프로그래머(프론트/백엔드), 웹기획자, 블로거, 쇼핑몰 운영자  

    - HTML 특징
    1. 논리적이고 연산적인 요소가 필요없다.  
    2. 컴파일(자바 이클립스에서 ctrl+f10) 작업이 필요없다.  
       컴파일 = 컴퓨터는 0101밖에 모르기때문에 우리가 짠 소스를 0101로 바꾸는 작업
    3. ***브라우저마다 보이는게 조금씩 다르다.  
       크롬, 익스플로러 등 브라우저마다 만든 회사가 다르기 때문 
    
    - 정적 웹
        = HTML + CSS + JavaScript

    - SCSS
        = 기존 CSS의 버전 업

    - 지금 쓰는 HTML/css은 5버전, html과 css는 업데이트가 매우 드물다
      javascript는 버전 업이 매우 빠르다(1, 2년에 한번씩 됨)
    ```

- ### prettier 사용
    회사에서 자바보다 자바스크립트로 개발을 많이 할 경우, 개인마다 코드 스타일이 다름(세미콜론 유무, 글자 수 제한 등) ===> prettier를 사용해서 스타일을 하나로 맞춰준다!!

- ### 주석달기
    ctrl + /

- ### 태그 여러개 만들기
    태그*개수
    ex) div*3

- ### 띄어쓰기
    &nbsp;

- ### HTML에서 <과 > 표시
    ```html
    < = &lt;
    > = &gt;

    ex) 
    <h4> h4로 작성 </h4>
    &lt;h4&gt; h4로 작성 &lt;/h4&gt;
    ```

- ### 휴대폰 화면 확인
    크롬페이지에서 f12를 누르고 휴대폰모양(togle device toolbar) 버튼을 눌러서 휴대폰 모델별로 보여지는 화면을 확인할 수 있다.

- ### INDEX
    사이트들마다 메인화면을 index라고 부르기로 약속함!
    연습할 때 html파일을 index로 적자

- ### POSITION
    ```
    태그마다 position을 가지고 있다.
    1) static(디폴트) : 위치를 지정하지 않을 때
    2) relative : 원래 자리 기준으로 움직임
    3) absolute : 다 같은 초기위치에서 움직임
                  부모태그 포지션이 relative면 부모를 기준으로 움직인다!
                  (레이아웃과 상관없는 배너, 광고, 팝업에서 많이 사용한다)
    4) fixed : 위치가 고정됨
               (스크롤을 움직여도 같이 따라옴)

- ### MARGIN 과 PADDING
    ```
    공통점 : div로 이루어진 박스태그에서 박스 간격을 조절한다.
    작성법 (padding을 예시로)
        1) padding: 10px;
            상하좌우 모두 10px씩 간격 둠
        2) padding: 5px 10px 0;
            상 5px, 좌우 같이 10px, 하 0px 간격
        3) padding: 5px 10px;
            상하 같이 5px, 좌우 같이 10px 간격
        4) padding: 10px 10px 10px 10px;
            차례대로 위,오른쪽,아래,왼쪽 10px 간격
        
        그 외) padding-top, padding-left 등으로 표현

    차이점
        padding : 부모박스 안에 있는 *자식박스* 간격 조절
                  자식 태그와 간격을 만들기 위해 "부모태그"에 작성한다!
        margin : 부모박스와 부모박스 간격 조절
                 부모태그에 작성한다!
    ```

- ### FLEX 
    ```
    <FLEX 사용하는 클래스 표기>

    flex를 쓰는 클래스 이름에 row라고 표시해 준다.
    ex) <div class="section row-col">

    flex의 정렬방법이 column인 경우 row-col 클래스로 표기
    row 또는 row-col로 묶어서 css를 한번에 적용할 수 있게 만들어 준다.
    ```
    ```
    <FLEX 와 inline-block>

    인라인블록을 사용하면 플렉스처럼 보이지만, 플렉스만큼 유연하게 대처는 불가능하다!  
    ```
    ```
    flex: 1;
    아이템들이 동일한 크기를 가지게 됨
    ```
    ```
    flex-grow: 2.5;
        해당 아이템에 크기를 할당해 준다. 만약 다른 아이템의 크기가 할당되지 않았다면 받을 수 있는 공간을 모두 받고, 다른 아이템의 크기가 할당돼 있으면 크기를 키우고 싶은 아이템의 flex-grow를 키워주면 된다.

        보통 2는 두배, 3은 세배정도 된다.
    ```
    ```
    .item:hover .caption{
        display: block;

        item에 커서를 올렸을 때 caption의 표현에 관하여 설정. 
        display: block은 none과 반대로 보여주는 표현
        hover되면 block, 떼면 none */
    ```
    ```
    flex : 컨테이너(선장)와 아이템(선원)으로 구성

    컨테이너는 아이템 배치
    아이템은 각각 아이템 크기, 넓이 설정

    컨테이너(선장) css
        - display : flex
        - justify-content : space-between

    아이템 css
        - flex-basis
        - flex-grow
        - flex
    ```

- ### 클래스 이름이 item인 항목이 여러개 있을 때 각각을 제어하는 방법
    ```
    1. 클래스 이름 변경
    2. :nth-child() 사용
        .item:nth-child(1){
            background-color: aqua;
        }
    item 클래스의 첫번째 항목을 조정한다. 괄호 안에 숫자만 바꾸면 됨.
    ```

- ### 백그라운드 그라데이션 표현
    .background{
        background-image: linear-gradient(rgba(0, 8, 51, 0.5), rgba(255, 0, 0, 0.5)), url(background.jpg);
    }

- ### border 사용
    border: solid #f33; 
        /* solid 대신 dotted 쓰면 선이 점선으로 바뀜. solid는 두꺼운 선. */

- ### 색상 입력 방법
    ```
    1. red      
    2. #ff0000      
    3. rgba(255, 0, 0, 0.5) 
    <!-- rgba 마지막 항목은 투명도 -->
    ```

- ### CSS파일 분리
    ```
    스타일 태그가 길어지면서 보기 불편해짐      
    -> .css파일에 스타일태그를 분리시킨다       
    -> 분리시킨 css파일을 다시 html에 호출함      
        호출방법) 타이틀 위에 link:css를 입력하고, css파일명을 입력한다
        <link rel="stylesheet" href="style.css">
    ```

- ### HEADER
    ```
    - 사이트에서 헤더 아래 설명이나 배경있는 것들은 전부 헤더에 포함돼 있다.  
    header에 메뉴(navigation)도 오고 머리글, 사이트 로고 등도 온다.   
    보통 맨 왼쪽엔 로고가 오고 그 옆에 메뉴가 온다.  <- 하나의 div로 이루어져 있음
    ```

- ### 클래스(변수) 이름
    ```
    변수이름 규칙
    1. 명사
    2. 복합명사
        카멜표기법 ex) int userInformation
    3. 데이터 타입이 boolean형일 때
        변수이름 앞에 is + (명사) 옴
        ex) "isLogin (로그인 여부)" : true or false
            "isMeal (식사 여부)" : true or false
    
    백엔드에서 변수이름 만들 때 많이 쓰는 카멜표기법
    : userName

    프론트(HTML)에서는 변수이름 만들 때 많이 쓰는 방법
    : user-name
    만약 "user name" 로 클래스를 만들면, user와 name 각각의 클래스를 의미하니 주의!

    ==> 페이스북에서 카멜표기법으로 맞추자해서 *리액트 라는 기술이 있음
    ```

- ### 폴더 경로 찾기
    ```
    이미지폴더 경로 찾기
    ./ : 현재 경로
    ../ : 다음 상위 폴더로 가라(뒤로가기)
    ../../ : 다다음 상위

    ex)
    - 인덱스 파일 경로
        html/workspace/day01/index.html

        증명사진이 다음 폴더에 있을 때 어떻게 불러오는가?
        html/img/증명사진.png
        
        정답
        index.html에서 ../../img/증명사진.png

    - 인덱스 파일 경로
        A폴더/B폴더/index.html

        다음 파일은 각각 어떻게 불러오는가?
        1) A폴더/이미지폴더/증명사진.png
        2) C폴더/이미지폴더/피카츄.png
        3) A폴더/B폴더/이미지폴더/A폴더/ 라이츄.png

        정답
        1) ../이미지폴더/증명사진.png
        2) ../../C폴더/이미지폴더/피카츄.png
        3) 이미지폴더/A폴더/라이츄.png 또는 
        ./이미지폴더/A폴더/라이츄.png
    ```

- ### OVERFLOW
    ```
    - overflow : 컨텐츠가 너무 커서 요소내에 모두 보여주기 힘들 때 사용.  
                visible (기본값)  
                hidden (넘치는 부분 자름)  
                scroll (스크롤 바 추가) 
                auto (컨텐츠에 따라 스크롤 추가여부 자동결정)

    사용) overflow: visible;

    가로로만 스크롤을 하고 싶은 경우
    white-space: nowrap; 추가
    ```

- ### JavaScript
    ```
    = 팝업창 구현, 서버 데이터 처리

    - JavaScript 버전 5 (ES 5) 배울 것임
        = 대부분의 it 회사들이 5나 6를 사용중임
        5와 6는 문법이 많이 다르다!
        둘 다 공부하는게 좋음

        **React, Angular, Vue 모두 버전 6 이상으로 구현된 자바스크립트

        페이스북에서 만든 React가 메인!!

    자바스크립트가 원래 프론트언어였지만 업데이트를 거친 지금은 자체적으로 백엔드 작업까지 수행 가능해졌다.

    자바스크립트는 데이터타입도 구분하지 않는다.

    바닐라JS도 공부하기
    ```
- ### item 배치
    ```
    상황) 고객 요구사항으로 item 각각의 위치 변동이 많을 때
    1. item:nth-child(1)
        을 사용하여 아이템마다 margin값을 지정함

    2. 만약 flex와 nth-child로 감당이 안 될 정도로 많은 수정이 필요할 때는
        display : inline-block 사용
    ```

- ### Java와 JavaScript의 상수
    ```
    1) JAVA에서 상수 = final
        ex) final int PI = 3.14;
    2) JavaScript에서 상수 = const
        ex) const PI = 3.14;
    ```
- VSC 터미널에서 폴더 경로 수정
    ```
    리눅스 명령어 (*주니어 개발자가 알아야 하는 필수 명령어)
        ls : 현재 경로 파일 및 폴더 확인
        cd : 폴더 접속 (change directory)
            cd .. : 뒤로가기
        pwd : 현재 경로 확인
        clear : 명령어 내용 삭제

    터미널 실행하고 ../ 나 ./을 이용해서 작업하려는 파일이 있는 폴더로 이동해야 한다.
    ```

- ### flex와 grid
    ```
    flex는 1차원적인 UI(한 방향 레이아웃)
    grid는 2차원적인 UI(두 방향 레이아웃)

    공통점) 둘다 container 안에 item이 있는 구조
    문법) display : flex or grid

    ex) 인스타그램 사진 피드 grid로 구현, 유튜브는 flex로 구현돼 있음
    
    카드레이아웃 만들 때, flex or grid 둘중 하나 선택하기. 또는 inline-block

    ```

- ### 바닐라 JS
    ```
    프레임워크나 라이브러리를 일절 사용하지 않는 순수한 자바스크립트

    ex) getElementByID()
    ```

- ### 주의할 것
    ```
    1. padding은 auto 미적용
    2. a태그는 text-align : center; 미적용. div나 span으로 감싸서 적용시킨다.
    3. a태그는 디폴트가 inline-block
    ```

# css로 드래그 막기
    -ms-user-select: none; 
    -moz-user-select: -moz-none;
    -khtml-user-select: none;
    -webkit-user-select: none;
    user-select: none;

# width/height auto일 때 애니메이션 처리
    width나 height가 auto이면 애니메이션이 적용되지 않는다.
    애니메이션이 특정 길이에서 시작해서 특정 길이에서 끝나야 되는데 auto는 길이가 지정되지 않았기 때문.
    해결법
        1. max-width 또는 max-height 사용
            auto 대신 max를 쓰면 애니메이션 사용 가능
        2. transform: scaleX(1) 또는 scaleY(1) 사용
            scaleX를 0에서 1로 입력하면 컨텐츠 크기만큼 늘어남