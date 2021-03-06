# 자바스크립트 var, let, const
    1. var 
        변수 이름을 중복선언이 가능하다
        => 테스트에는 편리하지만, 코드가 많아지면 관리하기 힘들다.

    2. let과 const
        변수 이름 중복 불가능
        차이점
            let은 변수에 재입력이 가능하지만 const는 불가능하다.

            let name = "i'm let"
            let name = "i'm not let" => 콘솔로 확인하면 name이 이미 선언됐다고 오류 나옴
            name = "i'm not let" => 이 때 비로소 name에 새로운 값이 입력된다(재할당됨)

            const name = "i'm const"
            const name = "i'm not const" => 콘솔로 확인하면 name이 이미 선언됐다고 오류 나옴
            name = "i'm not const" => constant 변수 입력에러 출력

# print의 차이
	자바의 print : System.out.println("Hello World");
	자바스크립트의 print : console.log('Hello World')

	자바스크립트는 '와 " 구분 안 함. 세미콜론도 필수 아님 but 권장

	- 문자와 숫자의 합출력도 가능
		var x2 = '글자';
		var result2 = num+x2;
		console.log(result2)

	- 별찍기
		for(var i=0; i<6; i++){
			console.log('*'.repeat(i+1))
		}

# html에서 script 실행 확인
		live 서버로 띄워지는 페이지에서 f12로 개발자도구 들어가고 consol에서 상태 확인하면 됨

# javascript 연습
	const PI = 3.14;
	var array = [1,3,4,5,10];

	- 짝수 출력하기 1번
	var len = array.length;
	for(i=0; i<len; i++){
		if(array[i]%2==0){
			console.log(array[i]+" 는 짝수입니다.")
		}
	}

	- 짝수 출력하기 2번
	const EVEN = 2;
	for(var i=0; i<len; i++){
		var value = array[i];
		if((value%EVEN)==0){
        	console.log(value+" 는 짝수입니다.");
    	}
	}
	짝수를 판별하기 위한 EVEN이라는 변수와 for문 아래에 value 변수를 만들어서 value와 EVEN을 비교했음

	- 최대값 구하기
	var temp = 0;
	for(var i=0; i<len; i++){
		if(temp < array[i]){
			temp = array[i]
		}
	}
	console.log("array의 최대값은 " + temp);

# JSON
	데이터를 전송할 때 많이 사용되는 경량의 DATA 교환형식
	대부분의 프로그램에서 공통언어
	데이터를 단순히 표시하는 표현 방법이다.

	장점 : 1. 문서화를 할 수 있다
		   2. 재사용 가능
	단점 : 없음!

	형식
		1. 중괄호 {}
		2. key(중복 X), value(중복 O)
		3. value(문자형, 정수형, 논리형, 배열, json, null 등)

		emp :
		{
			empno : 7369,
			enmae : "SMITH",
			mgr : [7902, 7370]
		}

		var information = {
			"name" : "YOO YOUNGJOON",
			"age" : 30,
			"address" : "대전 대전로542번길",
			"isMarri" : false
			// 데이터타입이 boolean형일 때 변수이름을 is + ~로 적는다!
		}; 

		왼쪽은 key(중복 불가능), 오른쪽은 value(중복 가능)
		value에는 데이터타입이 온다
		information이라는 변수를 서버에 전송함
	출력
		console.log(information);
		console.log(information.address);

	- JSON의 데이터를 jQuery를 이용해서 백엔드로 보낸다.
		프론트(Client) -> jQuery -> 백엔드(Server) <-> 데이터베이스
		HTML <--JSON/jQuery--> JAVA <--> DB
	- 백엔드에서 온 JSON을 HTML에서 append, innerHTML, innerTEXT로 출력한다.
	- Mybatis : 백엔드에서 JSON을 데이터베이스로 보내 줌.
		(프론트에서 백엔드로 보내는 수단은 jQuery)
	- 드론, 애플워치 같은 IOT도 JSON으로 데이터를 보낸다.
	- 소프트웨어, 하드웨어 모두에서 사용함

# json에 데이터 저장
```javascript
다음과 같이 클릭하면 jsonParam에 데이터를 저장하려고 한다. 이 때 .과 []를 사용해서 데이터를 저장한다.
$('#join').on('click',function(){
	var jsonParam = {};

	jsonParam.phone = '010'; 
	// key = phone, value = '010'
	var elementID = 'iphone';
	var money = 1000;
	jsonParam.elementID = '010' 
	// key = elementID, value = '010' 임. 위에 elementID를 변수로 지정했다고 해서 ket가 iphone이 되지 않음
	jsonParam[elementID] = '010' 
	// 위와 마찬가지. jsonParam.iphone = '010';을 의미하지 않는다
	// jsonParam.money 역시 jsonParam.1000을 의미 하지 않음

	// 결과) jsonParam = {phone : '010', elementID : '010'};
}
```

# json을 쓰는 이유
	var 영화 = {
		name : ['라라랜드', '인터스텔라', '스파이더맨'],
		actor : ['라이언고슬링', '엠마스톤','톰홀랜드','젠데이어']
	}
	이렇게 만들면 어떤 영화에 어떤 배우가 오는지 모른다!

	var 영화 = {
		// 배급사가 같고, 이름이 다른 여러개의 영화에 대하여
		배급사 : 'CJ',
		영화이름 : [{
			name : '스파이더맨 노 웨이 홈',
			actor : ['톰홀랜드', '젠데이어'],
			time : 148
		},
		{
			name : '인터스텔라',
			actor : ['앤 헤서웨이', '매슈 매커너히'],
			time : 169
		}]
		영화마다 이름과 배우 시간이 각각 다르기 때문에 영화 json 안에 영화이름 json을 만든다.
	}
	서버에 전송하기 위해서 영화 이름, 배급사 등등을 각각 변수를 만들어서 보내기엔 너무 많다.
	따라서 json으로 묶어서 보낸다.
	* 이유 1. 변수를 만들어서 보내기에 변수의 양이 너무 많아져서

	json 출현 전에는 백엔드개발자가 모든 걸 수행하다가, json 출현으로 프론트와 백엔드 개발자가 나뉘게 됨.
	* 이유 2. 프론트와 백엔드 간에 소통을 하기 위해서 사용하는 면도 존재

# json 연습
```
1. 사원 ID가 3450인 사원 이름은 SMITH고, 급여는 3400을 받는다.
부서는 개발팀과 영업팀, 입사날짜 21-12-31, 상사는 BRIAN과 KING인 데이터를 json으로 만들자.
	var emp ={
		empno : 3450,
		ename : 'SMITH',
		sal : 3400,
		dname :['개발','영업'],
		hiredate : '21-12-31',
		상사이름 : ['BRIAN','KING']	
	}

+ 만약 개발팀의 인원수가 5명이라는 내용을 넣고 싶다면, 개발팀에 대한 상세내용을 dname 안에 json을 만들어서 추가한다.
	var emp ={
		empno : 3450,
		ename : 'SMITH',
		sal : 3400,
		dname :[{
		name : "개발",
		count : 5	
		}, '영업'],
		hiredate : '21-12-31',
		상사이름 : ['BRIAN','KING']	
	}

	var emp ={
		empno : 3450,
		ename : 'SMITH',
		sal : 3400,
		dname :["개발",'영업'],
		hiredate : '21-12-31',
		상사이름 : ['BRIAN','KING'],
		개발팀부서인원수 : 5
	}
	위 처럼 개발팀부서인원수를 따로 만들어줘도 되지만, json으로 보낼 때 *연관있는 것들은 최대한 묶어서 보내야 한다* 
	따라서 아래와같이 개발팀부서인원수를 dname안에 넣는다.

	var emp ={
		empno : 3450,
		ename : 'SMITH',
		sal : 3400,
		dname :[{
			name : "개발",
			count : 5,
			부서장 : "홍길동"	
		}
		,{
			name : '영업',
			count : 13,
			부서장 : '박길동'
		}],
		hiredate : '21-12-31',
		상사이름 : ['BRIAN','KING']	
	}


2. smith의 사수 직업과 급여를 알고 싶다. json으로 표현하라.
	emp : 
	{
		empno : 7369,
		ename : "SMITH",
		mgr :[{
			empno : 1,
			job : "CLERK",
			sal : 300
			},
			{
			empno : 2,
			job : "MANAGER",
			sal : 400
		}]
	}

	*mgr = manager(사수)

3. SMITH의 직업과 급여, 부서이름과 부서위치, 부서인원수를 알고싶다.
	emp :
	{
		(내 풀이. 틀림)
		ename : "SMITH",
		job : "CLERK",
		sal : 1200,
		dname : [{
			loc : "",
			count : 
		}]
	* key 이름이 명확하지 않았다. 부서에 대해서 묶어주려면 dept로 묶어서 그 안에서 dname을 표기해주자.
		
		(정답)
		dname : "SALES",
		loc : "SEOUL",
		count : 5

		(만약 소속된 부서가 2개 라면)
		dept : [{
			dname : "SALES",
			loc : "",
			count : 5
			},
			{
			dname : "MANAGE",
			loc : "",
			count : 6
		}]
	}

4. SMITH의 사원번호와 급여, 사수 3명의 사수의 번호와 직업을 알고싶다.
	emp : 
	{
		ename : "SMITH",
		empno : "2322",
		sal : 1000,
		mgr : [{
			empno : 1,
			job : "CLERK"
		},
		{
			empno : 2,
			job : "CLERK"
		},
		{
			empno : 3,
			job : "CLERK"
		}]
	}

	배열을 사용하면 count 변수를 따로 만들 필요가 없다! 배열 길이로 조회 가능

5. json 호출
	var dwacademy = {
		students : ['오승택', '류근환', '김보겸', '이인서', '나정수', '정지유', '김민영', '이규성', '이승섭', '이상협', '홍준호', '유영준'],
		students_count : 15,
		teacher : '현상원',
		today : '2022-03-08',
		subject : ['SQL', 'JAVA', 'HTML']
	};

	"변수이름.변수내컬럼명" 의 형식으로 호출한다.

	console.log(dwacademy.students_count);
	console.log(dwacademy.students[10]);
	
	var array = [2,5,7,8];
	var arrayJson = {array : [2,5,7,8]	}; 두개의 변수에서 호출하는,
	console.log(array[1]); 와 console.log(arrayJson.array[1]); 의 값은 같다.

6. students_count가 15이하면 학생 수 부족, 15 초과면 학생 수 정상 출력
	var count = dwacademy.students_count;
	if(count <= 15){
		console.log("학생수 부족 : 학생수가 15 이하입니다.")
	}else{
		console.log("학생수 초과 : 학생수가 15 초과입니다.")
	}

7. 학생 중 이씨가 몇명인가?
	sql에서 사용하는 %가 아니라, substring 사용!

	var searchWord = '이';
	for(var i=0; i < length; i++){
		var firstName = dwacademy.students[i].substring(0,1);
		if(firstName == searchWord){
			temp++
		}
	}
	console.log(temp);

	추가) 
	var array = [2,5,7,8];
	var arrayJson = {
		array : [2,5,7,8]
	};
	에서 
	console.log(array[1]); 와
	console.log(arrayJson.array[1]); 는 같다.
```

# script의 function과 body의 태그를 연결시키는 순서
	1. 태그를 먼저 만든다
	2. 태그에 onclick 또는 onkeyup 등 원하는 값을 내보내기 위한 속성을 입력한다.
	3. script 아래에 함수로 function을 만들고, 함수 안에서 사용할 값을 var로 지정해준다.
	3-1. 값은 document.getElementBy~("태그의 속성(id 또는 클래스 등)") 등의 형식으로 입력
	4. 각 지정한 값들로 필요한 조건을 생성한다.
	
# 비동기와 동기
    비동기 : 작업이 끝나기 전에도 다른 작업을 할 수 있음
        ex) 자바스크립트(스트리밍 서비스 또는 카카오톡 같은 채팅, 게임)
    동기 : 작업이 끝날 때까지 기다려서 끝나면 실행
        ex) 결제시스템

# ==과 ===
	자바스크립트에서
	A==B : A는 B와 같다
	A===B : A와 B는 같고, 자료형도 같다
	(자바스크립트가 타입이 없기때문에 이렇게 표현해 줌)

	var a = "1";
	var a1 = 1;
	a == a1 //true
	a === a1 //false

	<div class="item" onclick="getItem('2')"></div> 에서 다음 함수를 받을 때 
	function getItem(num){
            if (num == 2){ console.log('Hello World!') }
            if (num === 2){ console.log('Wow World!') }
	}
	num == 2 는 true('2' == 2)이고 num === 2는 false('2' !=== 2) 이므로 Hello World! 만 출력됨

# function 규칙
	- 함수(메소드) 만드는 규칙
	1. 작게
	2. 작게
	함수는 항상 작게 만들어야 한다 (함수가 크면 안 됨)

	- **함수는 한 가지를 해야 한다. 
		그 한 가지를 잘 해야 한다. 
		그 한 가지만을 해야 한다.

# 절차지향/객체지향 프로그래밍
	* 절차지향 프로그래밍
		순차적인 처리가 중요시 되며 프로그램 전체가 유기적으로 연결되도록 만드는 프로그래밍 기법
		ex) C, 코볼

	* 객체지향 프로그래밍
		모든 데이터를 object로 취급하여 프로그래밍 하는 방법
		ex) 자바, 파이썬, js, node, 리액트, C++, C#

# forEach
	Array 객체의 메소드
	반복적인 기능을 수행할 때 사용
	범위지정X, 배열의 길이까지 자동으로 돈다

	const arr = [0,1,2,3,4,5];
	arr.forEach(function(element){
		console.log(element);
	})
	
	결과값 : 0 1 2 3 4 5 

# attr
	attr = attribute (속성)

	<div id="red" class="redbox"> 에서

	var idName =$('.redbox').attr('id');
		- 클래스가 redbox인 속성(attr)의 id를 문자 idName으로 지정
	console.log(idName);
		- redbox의 id가 red이기 때문에 red 출력됨
	
	$('.redbox').attr('style','background-color : red');
	$('.redbox').attr('id','black');
		- 속성에 스타일을 주거나 수정하는 것도 가능하다

# 스크립트의 위치
	제이쿼리가 필요한 경우 제이쿼리 스크립트를 가져와서 html 파일에 넣어서 사용한다
	이 떄, 스크립트의 위치가 위에 있을 경우 정상적으로 사용되지 않는다
```html
<head>
	<script
    src="https://code.jquery.com/jquery-3.6.0.min.js"
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
    crossorigin="anonymous"
    ></script>
    <!-- body에 필요한 스크립트를 body 위에 입력하면 body에서 만든 태그가 정상인식되지 않는다(따라서 함수를 이용한 hello world가 출력되지 않음) -->
    <script>
        $('.container').on('click',function(){
            console.log('hello world');
        })
        // 하지만 아래와 같이 $(function(){ })를 사용해서 강제 호출하면 스크립트를 위에 써도 가능은 함(비추)
        $(function(){
            $('.container').on('click',function(){
            console.log('hello world');
            })
        })
    </script>
</head>
<body>
	<button class="container">버튼</button>
</body>
```

# div 사용방법
```html
<body>
	<div class="forms">
        <input type="text">
        <input type="text">
        <input type="text">
        <input type="text">
        <input type="text">
    </div> 
    <div class="email-input-box">
        <input type="text">
    </div>
    <div class="name-input-box">
        <input type="text">
    </div>
</body>
    만약 각각 텍스트 박스가 위처럼 개별 div로 묶여있다면 children으로 각 div의 children value를 일괄적으로 불러오기가 힘들다(for문을 사용한 데이터 호출이 힘들다. 회원가입 문제풀이 참조)
    이런 경우, 회의를 통해 다음과 같이 할 수 있도록 함
    1. div를 없앨 수 있는지 
    2. 힘들다면 다음과 같이 div 이름만이라도 같게 
        <div class="input-box">
            <input id="email" type="text">
        </div>
        <div class="input-box">
            <input id="name" type="text">
        </div>
```