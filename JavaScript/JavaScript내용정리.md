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

