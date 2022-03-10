# print 방법
	자바의 print : System.out.println("Hello World");
	자바스크립트의 print : console.log('Hello World')

	자바스크립트는 '와 " 구분 안 함. 세미콜론도 필수 아님 but 권장

	- 문자와 숫자의 합출력도 가능
		var x2 = '글자';
		var result2 = num+x2;
		console.log(result2)

	- 짝수출력
		for(var i=0; i<=10; i++){
			if(i%2 == 0){
				console.log(i)
			}
		}

	- 별찍기
		for(var i=0; i<6; i++){
			console.log('*'.repeat(i+1))
		}

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

	json 출현 전에는 백엔드개발자가 모든 걸 수행하다가, json 출현으로 프론트와 백엔드 개발자가 나뉘게 됨.
	=> 프론트와 백엔드 간에 소통을 하기 위해서 사용하는 면도 있음

	의사소통의 방식이라고 생각하면 될듯


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
```

