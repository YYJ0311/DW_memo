- ### DB
    ```
    데이터베이스 => 오라클, (MYSQL, Mariadb)  
    종류는 여러개이나 문법은 동일

    오라클은 국가기관, 연구소 / MYSQL 스타트업, 중소기업에서 많이 사용  
    하지만 요새는 국가기관에서도 오라클 대신 티맥스에서 만든 국내 프로그램을 많이 씀

    데이터베이스를 잘 배우면 웹, 앱, IOT, 데이터분석, 보안, AI 어느 분야를 가던 도움이 된다(데이터를 어떻게 불러오냐의 차이일 뿐)  
    데이터베이스는 모든 어플리케이션의 시작점!

    MYSQL안에 DB가 있고 그 안에 table이 있고 그 안에 data가 있다. 데이터는 테이블에 있는 것이고 데이터베이스는 그 테이블들을 관리하는 것

    ***대부분의 테이블들은 서로 "관계"가 있음 ===> MySQL을 관계형 데이터베이스라고 부른다 = RDB  
    데이터베이스는 관계형(RDB), 비관계(NORDB)형 두가지가 있다.

    비관계형DB 에는 몽고db, 다이나모 db가 있다.
    관계형DB(RDB)는 IOT, AI에서 쓴다. <---수업때 배울 것
    ex) A테이블에 데이터를 지울 때, B테이블에 같은 데이터를 지우거나 지우지 않는 설정이 가능

    블록체인은 비관계형 DB이다.(모두가 독립된 테이블)

    DB에도 commit이 존재!
    데이터 10개를 인서트하면 그 다음에 커밋을 해야 함.
    디비버는 디폴트값이 오토커밋이기때문에 인서트 하면 자동으로 커밋된다.
    다른 프로그램을 사용하면 커밋 추가로 입력해야 한다. (ex 마지막에 COMMIT; 입력)

    DB
    데이터베이스 -> 테이블 -> 데이터

    JAVA
    프로젝트 -> 패키지 -> 클래스(코드파일)
    ```

- ### 데이터
    ```
    컴퓨터는 문자, 숫자 구분을 못 하므로 데이터 타입을 입력해야 한다. 데이터베이스에서 숫자는 int, 문자는 VARCHAR

    데이터의 최소단위가 비트
    1 byte = 8 bit => 2^8=256 : 컴퓨터는 0, 1밖에 모르기 때문
    서브넷 마스크가 255인 이유(0부터 255까지 256개)

    int는 4 바이트 = 256^4 = 숫자가 올 수 있는 갯수
    ```

- ### 데이터 언어
    ```
    *** DDL(Data Definition Language) 데이터 정의 언어
        : 테이블을 관리하는 명령어
    CREATE TABLE 테이블이름 : 테이블 생성
    DROP TABLE 테이블이름 : 테이블 삭제
    ALTER TABLE 테이블이름 : 테이블 수정(이름 변경할 때 많이 씀)

    *** DML(Data Manipulation Language) 데이터 조작 언어 <==== 개발자들이 많이 사용
        : 테이블 안에 있는 데이터를 관리하는 명령어
    SELECT : 데이터 조회
    DELET : 데이터 삭제
    UPDATE : 데이터 수정
    INSERT : 데이터 삽입(생성)

    DCL(Data Control Language) 데이터 제어 언어 <==== 팀장급이 사용
        : 데이터베이스 관리
    GRANT : 특정 사용자에게 권한 부여
    REVOKE : 특정 사용자 권한 회수

    이거는 오라클, MYSQL, MariaDB 다 같다
    ```

- ### 번역하는 방법 2가지 (차이점 알기!)
    ```
    1. 컴파일 (C, C++, JAVA, ...)
        1-1. 전체 소스코드를 보고 실행
        1-2. 인터프리터와 비교했을 때 실행속도가 빠름 (인공위성 같은건 C/C++로 만듦)
        1-3. 코드를 수정하고 실행하려면 처음부터 다시해야 함

    2. 인터프리터 (Python, JavaScript, ...)
        2-1. 한줄씩 실행
        2-2. 컴파일과 비교했을 때 실행속도 느림
        2-3. 코드를 수정하고 즉시 실행
    ```
- ## 연산자, 정렬, 연산순서
    ```
    연산자는 where절에 온다.

    1. 관계 연산자
        >, <, <=, >=, =, !=(다르다를 의미), is, is not

    2. 논리 연산자
        and, or  
        두 개가 모두 참일 때 and 사용
        ex) 로그인할 때 ID와 비밀번호 모두 맞아야 로그인되게 만듦
        두 개중에 하나만 맞아도 되면 or 사용

    3. 문자 연산자
        like

    4. 정렬하기
        order by + desc/asc
        내림차순 : desc
        오름차순(디폴트) : asc
        정렬은 맨 뒤(where 뒤)에 온다.

    5. 연산순서
    from -> where -> group by -> having -> select -> order by
    order by는 맨 마지막에 이뤄지는 작업이기 때문에 가급적 피한다.
    ```

- ### 기본 문제
    ```sql
    <NAME이 KING인 사람의 JOB을 조회>  
    select
        job
    from dw.emp
    where empno = 7839;
    ctrl + 엔터

    <직업번호가 7900인 사람의 이름과 직업을 조회>  
    select   
        ename,  
        job  
    from dw.emp  
    where empno = 7900;  

    <사원번호가 7369인 사람의 이름과 직업과 월급(SAL) 조회>  
    select   
        ename, job, sal <====이렇게 한다고 에러나진 않지만 세로로 길게 늘여쓰는게 규칙임  
    from dw.emp  
    where empno = 7369;

    <EMPNO가 7934인 사람의 직업과 고용날짜를 조회>
    select  
        JOB,  
        HIREDATE  
    from emp  
    where empno = 7934;  

    <JOB이 CLERK인 사람의 이름과 고용날짜를 모두 조회>
    hint) 문자 조회할 땐 "", '' 사용  
    select  
        ENAME,  
        hiredate  
    from emp  
    where job="CLERK"  

    <JOB이 MANAGER인 사람의 이름과 급여 조회>
    select  
        ename,  
        sal  
    from emp  
    where job="manager"

    <급여가 1000달러 이상인 사람의 이름과 직업 조회>
    select  
        ename,  
        job  
    from emp  
    where sal >= 1000 ;  
    <!-- 여기에서 "=>"로 표시하면 에러 -->

    <아래 결과창에 별칭을 붙이고 싶을 때,  as 사용>
    select  
        count(*) as '총합'  
    from emp  
    where sal >= 1000 ;  

    <87-06-28 이후에 입사한 사원을 조회>
    select  
        ENAME as '사원이름'   
    from emp  
    where HIREDATE >= '1987-06-28' ;  

    <입사한 날짜가 1982-01-23 이전에 입사한 사람의 이름과 직업, 부서번호를 조회>
    select   
        ename,  
        job,  
        DEPTNO   
    from emp  
    where HIREDATE <= '1982-01-23';  

    <입사날짜가 1981-02-20부터 1981-12-03까지인 사람의 이름과 직업, 부서번호 조회>
    select   
        ename as '사원',  
        job as '직업',  
        DEPTNO as '부서'   
    from emp  
    where HIREDATE >= '1981-02-20' 
    and 
    HIREDATE <= '1981-12-03'; 

    <커미션이 null인 사람 조회>
    select   
        ename,  
        sal  
    from emp  
    where COMM is null  
    order by sal ;
    <!-- ***실무에서 DB상에 수많은 데이터가 있기 때문에 null은 조회하지 않는다. -->

    <커미션이 null이 아닌 사람 조회>
    select   
        ename,  
        sal,  
        COMM   
    from emp  
    where COMM is not null

    <COMM이 null이 아닌 사원의 이름과 부서번호, 입사날짜를 오름차순으로 조회>
    select   
        ename,  
        DEPTNO,  
        HIREDATE   
    from emp  
    where COMM  is not null   
    order by HIREDATE ;

    <이름을 조회할 때>
    select
        job  
    from emp  
    where ENAME = 'smith' ;  
    하지만 관계연산자는 잘 사용 안 한다. 따라서 다음과 같이 써 줌!
    select   
        job  
    from emp  
    where ename like 'smith' ;

    **중복된 코드는 좋지않다!!
    ex) ename 반복
    select   
        job  
    from emp  
    where ename = 'smith' 
    or ename = 'allen';  

    <이름이 A로 시작하는 사람 조회>
    <!-- like 'A%'를 사용한다. -->
    select   
        ename,  
        job  
    from emp  
    where ename like 'A%';

    만약 where ename = 'A%'; 로 쓸 경우 제대로 조회 안 됨!

    <이름에 L이 2번 들어간 사람 조회>
    <!-- '%L%L%' 사용 -->

    <급여가 1500 ~ 2850 사이의 범위에 속하지 않는 모든 사원의 이름 및 급여를 표시>
    select   
        ename,  
        sal  
    from emp  
    where SAL < 1500  
    or   
    SAL > 2850

    <1981년 2월 20일 ~ 1981년 5월 1일에 입사한 사원의 이름, 직위 및 입사일을 표시하라. (입사을 기준으로 오름차순 정렬할 것!)>
    select   
        ENAME,  
        JOB,  
        HIREDATE   
    from emp  
    where   
    HIREDATE >= "1981-02-20"  
    and   
    HIREDATE <= "1981-05-01"  
    order by HIREDATE   
    <!-- order by 3 라고 써도 됨. select한 것 중 3번째 있는 hiredate를 의미 -->

    <부서가 10, 30에 속하는 사원 중 급여가 1500을 넘는 사원의 이름 및 급여를 표시하라>
    select   
        ENAME,  
        SAL   
    from emp  
    where   
    DEPTNO = 10  
    or   
    DEPTNO = 30  
    having   
    SAL > 1500  

    <1982년에 입사한 모든 사원의 이름과 입사일을 표시>
    select  
        ENAME,  
        HIREDATE   
    from emp  
    where   
    HIREDATE > "1981-12-31"  
    and   
    HIREDATE < "1983-01-01"  
    
    선생님 답
    where   
    hiredate >= DATE_FORMAT(820101,'%Y-%m-%d')   
    and   
    hiredate < DATE_FORMAT(830101,'%Y-%m-%d')  

    <직위가 CLREK, ANALYST 이면서 급여가 1000, 3000, 5000가 아닌 모든 사원의 이름, 직위 및 급여를 표시>
    select  
        ENAME,  
        JOB,  
        SAL
    from emp
    where
    JOB = 'clerk'
    or
    JOB = 'analyst'
    and
    SAL != 1000
    and
    SAL != 3000
    and
    SAL != 5000

    <커미션이 null인 사람을 조회>
    select
        ENAME 
    from emp 
    where comm is null





    ```

- ### UPDATE
    ```sql
    update emp  
    set ename = '정우성' 
    --------->여기서 엔터 누르면 이름이 전부 정우성으로 바뀌게 돼버림!!! 주의!!!!  
    where empno = 8001; <----------- 조건을 꼭!! 붙여줘야 한다!!  

    update는 사실 mysql에서 해당 데이터를 delete 하고 insert 해 주는 것.

    update emp
    set ename = 'BRIAN'
    where EMPNO = 7369;

    <우성이가 직업하고 월급 변경요청>
    update emp  
    set 
    job = 'MANAGER',  
    sal = 8000  
    where empno = 8001;
    ```

- ### INSERT
    ```sql
    insert into emp  
    (empno,ename,job,mgr,hiredate,sal,comm,deptno)  
    values  
    (8000,'유영준','salesman',7369,'2022-01-06',5000,1000,30) 
    
    insert into emp
    values(8001,'정우성','MANAGER',7369,'2022-01-06',8000,null,30)

    insert into emp
    values(8002,'손흥민','DEVELOPER',null,'2022-01-10',300,100,null)
    ```

- ### 통계(count, sum, avg, max, min)
    ```sql
    select   
        sum(comm) as '보너스 총 합'  
    from emp  

    select   
        avg(comm) as '보너스 평균'  
    from emp   

    select   
        max(sal) as '고액연봉액'  
    from emp   

    select   
        min(sal) as '저액연봉액'  
    from emp   

    <직업이 manager인 사람들의 급여 평균 조회>
    select  
        avg(sal) as'급여평균'  
    from emp  
    where job = "manager"  

    <입사날짜가 1987-06-25이상인 사람들의 수와 급여평균 조회>
    select   
        count(*),  
        avg(sal)  
    from emp  
    where HIREDATE >= 1987-06-25  

    <직업이 CLERK인 사원 중 최소급여를 받고있는 사원의 이름과 입사날짜 조회>
    select   
        min(sal),  
        ename,  
        hiredate  
    from emp  
    where   
    job = "CLERK"

    <comm이 null이 아니고, 직업이 salesman 그리고 입사날짜가 1981-02-22이후에 들어온 사원의 comm 총합 조회>
    select   
        sum(comm)  
    from emp  
    where   
    job = 'salesman'  
    and   
    HIREDATE >= 1981-02-22  
    and   
    COMM is not null

    sum, avg, min, max는 where절이 아니라 having과 같이 위치해야 한다. where 뒤에 오면 오류남
    1. 이렇게 하면 오류 나옴
        select 
        sum(sal)
        from emp
        where DEPTNO != 10
        and DEPTNO != 30
        and sum(SAL) >= 5000 
        group by DEPTNO
    
    2. 다음과 같이 sum(sal)은 having 뒤에 와야된다.
        select 
        sum(sal)
        from emp
        where DEPTNO != 10
        and DEPTNO != 30
        group by DEPTNO
        having sum(SAL) >= 5000 
    ```
    
- ### COUNT
    ```sql
    select  
        count(*)  
    from emp  
    where sal >= 1000 ;  

    <count(*) 는 having 뒤에 온다>  
    select 
    *
    from emp
    where DEPTNO != 10
    and count(*) < 3
    group by 
    DEPTNO, 
    JOB 
    order by 
    count(*)
    이렇게 쓰면 오류

    따라서 count(*)은 where 절이 아니라, having 절로 내려서 쓰면 된다.
    select 
    *
    from emp
    where DEPTNO != 10
    group by 
    DEPTNO, 
    JOB 
    having count(*) < 3
    order by 
    count(*)
    ```

- ### 그룹핑
    ```sql
    having은 그룹핑한 것들에 대한 필터링! where 과는 다르다.
    group by는 where 다음에 나온다.  
    group by를 할 때는 그룹이 나눠지는 것만 가능하다. (그룹화되지 않는 것도 결과가 나오지만 여러 데이터중 상단에 있는 데이터 하나만 가져오게 되므로 정상적인 결과가 아니다.)
    group by를 쓰면 select에는 그룹화되지 않는 컬럼을 쓰지 않는다.

    <각 부서별(deptno) 그룹화하여 최고로 급여가 높은 사람의 이름과 직업을 조회>
    select   
        max(SAL),  
        ename,  
        job  
    from emp  
    group by DEPTNO   

    <직업이 세일즈맨인 사람을 제외하고 월급이 5000이 넘는 사람 조회>
    select   
        max(SAL),  
        ename,  
        job  
    from emp  
    where JOB != 'salesman'  
    group by DEPTNO   
    having max(SAL) >= 5000

    <각 부서번호별 평균급여, 총 인원, 최고 급여, 최소 급여 조회>
    select   
        DEPTNO as 부서번호,   
        count(*) as '총인원',  
        avg(SAL) as '평균',  
        max(SAL) as '최고급여',  
        min(SAL) as '최소급여'  
    from emp  
    group by DEPTNO   

    <부서별 직책별 최대급여와 인원수, 최소급여를 추출. 
    단, 10번 부서와 사원은 제외하고, 인원수는 3명 이하인 것으로 인원수가 적은 순서대로 추출>
    select   
        DEPTNO,  
        job,  
        count(*),  
        max(sal),  
        min(sal)  
    from emp  
    where DEPTNO != 10  
    group by   
    DEPTNO,   
    JOB   
    having count(*) <= 3  
    order by   
    count(*)  

    <부서별로 급여합계
    단, 10, 30번 부서에서 급여합계가 5000이상인 부서만 추출>
    select  
        DEPTNO,   
        sum(SAL)  
    from emp  
    where   
    DEPTNO = 10  
    or   
    DEPTNO = 30  
    group by DEPTNO   
    having sum(SAL) >= 5000  

    <직책별로 급여합계와 평균급여를 추출
    단, MANAGER는 제외하고 평균 SAL이 1000이상인 것만 추출>
    select   
        JOB ,  
        sum(SAL),  
        avg(SAL)  
    from emp  
    where  
    job != 'manager'  
    group by JOB  
    having avg(SAL) >= 1000  
    ````

- ### ifnull
    ```sql
    데이터가 null인 행에 임의 데이터를 넣는다
    데이터를 업데이트하는 게 아님!

    ifnull은 mysql에서만 사용한다. 데이터베이스마다 다르니, 오라클이나 다른 것들은 추가로 찾아보기

    select
        ifnull(comm, 100)
    from emp
    ```

- ### date_format <===== 정말 많이 씀!!!!!!
    ```sql
    데이터베이스마다 다름!

    다음과 같이 표현한다
    1)
    select
        date_format(hiredate, '%y-%m')
    2)
    where e.HIREDATE >= date_format(830101,'%y-%m-%d') 
    where e.HIREDATE >= date_format(HIREDATE ,'1983-01-01')

    e.HIREDATE >= date_format(820101,'%y-%m-%d') 
    and 
    e.HIREDATE <= date_format(821231,'%y-%m-%d') 
    는 아래와 같이 한 줄로 표현할 수 있다.
    date_format(e.HIREDATE, '%Y') = '1982'
    
    <연도별로 입사한 사람 수를 구하시오!>
    select
        date_format(HIREDATE, '%y'), 
        count(*) 
    from emp
    group by date_format(HIREDATE, '%y')
    order by 1 ;
    ```

- ### AND, OR
    ```sql
    실행순서 : AND 먼저! 그 다음 OR

    select
        ename,
        sal
        from emp
    where 
    deptno = 10
    or
    deptno = 30
    and
    sal > 1500

    이렇게 하면 and 앞에 있는 deptno = 30 이면서 sal > 1500 인 것을 먼저 조회하고 추가로 다른 조건이 붙지 않은 deptno = 10 인 것을 불러오기 때문에 deptno가 20인 사람도 조회될 수 있다. 따라서 순서를 바꾸려면 다음과 같이 괄호를 추가해준다.  

    select
        ename,
        sal
    from emp
    where 
    (
    deptno = 10
    or
    deptno = 30
    )
    and
    sal > 1500
    ```

- ### JOIN
    ```sql
    <join 방법 1>
    select
        ENAME 
    from emp e, dept d 
    where e.DEPTNO = d.DEPTNO 
    emp테이블에 있는 deptno와 dept 테이블에 있는 deptno중 같은 값인 것들의 사원명을 불러옴

    <join 방법 2>
    select 
        ename
    from emp e
    join dept d
    on e.deptno = d.deptno
    
    <join 방법 3>
    select 
        ename
    from emp e
    inner join dept d <====== inner가 디폴트 값이라서 안 써도 됨
    on e.deptno = d.deptno
    
    방법 1을 권장하지 않음. 그 이유는 추가 조건이 있을 때 where절이 계속 길어지고, 방법 2에서는 where을 따로 빼서 적을 수 있기 때문. 기능이 다른 것은 구분해서 적어주자!  

    여러개의 테이블을 조회할 때는 앞에 테이블의 이름이 들어가야 한다.
    ```
    ```sql
    <join의 종류>
    1. INNER JOIN(내부 조인, 조인)  
    2. OUTER JOIN(외부 조인)  
        : 1개 테이블에만 데이터가 있어도 조회  
    3. SELF JOIN(자체 조인)  
        : 자신이 자신과 조인, 1개 테이블을 사용 (관리자 아래에 있는 사람들을 조회할 때 사용)

    <OUTER JOIN의 종류>
    1. LEFT OUTER JOIN  
        : 왼쪽 테이블의 모든 값을 출력
    2. RIGHT OUTER JOIN  
        : 오른쪽 테이블의 모든 값을 출력
    3. FULL OUTER JOIN  
        : 왼쪽 또는 오른쪽 테이블의 모든 값을 출력 (MySQL에서 지원하지 않음)
    ```
    ```sql
    <사원명, 부서번호, 부서이름, 부서 근무지를 조회>
    select 
        e.ename,
        e.DEPTNO,
        d.dname,
        d.loc
    from emp as e 
    inner join dept as d 
    on e.DEPTNO = d.DEPTNO

    <부서별 급여합계와 부서이름을 조회>
    select 
        sum(e.SAL),
        d.dname
    from emp as e 
    inner join dept as d 
    on e.DEPTNO = d.DEPTNO 
    group by dname
    
    <부서 근무지가 NEW YORK이고, 직책이 MANAGER인 사원의 이름과 급여를 조회>
    select 
        e.ename,
        e.SAL
    from emp as e 
    inner join dept as d 
    on e.DEPTNO = d.DEPTNO 
    where d.loc = 'new york'
    and e.job = 'manager'

    <1983년 이후 입사한 사원의 보너스가 null이면 100 주고, 사원의 이름과 부서이름, 직업을 조회>
    select 
        ifnull(COMM,100),
        e.ename,
        d.dname,
        e.job
    from emp as e 
    inner join dept as d 
    on e.DEPTNO = d.DEPTNO 
    where e.HIREDATE >= date_format(830101,'%y-%m-%d') 

    ======> 각 컬럼들 앞에 별칭을 꼭 써주자!!! (ex d.loc)  
    ======> join 앞에도 inner같은 별칭을 꼭 붙이자!!  
    ======> 디폴트 값은 되도록 표시해주는게 좋다.  
    ======> 나중에 컬럼이 많아졌을 때 컬럼이름이 겹치면 에러가 나옴!!

    <사원 테이블에서 40번 부서 OPERATIONS 도 조회>
    select
        *
    from emp as e 
    right join dept as d 
    on e.DEPTNO = d.DEPTNO 
 
    <부서번호가 없는 사원 출력>
    select
        *
    from emp as e
    left outer join dept as d 
    on e.DEPTNO = d.DEPTNO 
    where e.DEPTNO is null 

    <사원들의 사수 이름과 번호를 조회>
    select
        sawon.EMPNO as "사원 번호",
        sawon.ENAME as "사원 이름",
        boss.EMPNO as "사수 번호",
        boss.ENAME as "사수 이름"
    from emp as sawon
    inner join emp as boss
    on sawon.mgr = boss.EMPNO 
    
    <사원들의 후임 이름과 번호를 조회>
    select 
        boss.EMPNO as "사수 번호",
        boss.ENAME as "사수 이름",
        sawon.EMPNO as '사원 번호',
        sawon.ENAME as '사원 이름'
    from emp as boss
    inner join emp as sawon 
    on boss.EMPNO = sawon.MGR
    =====> 위와 반대로 조회하면 됨

    <다중 조인>
    JOIN과 ON을 여러개 사용. 위에 있는 조인부터 차례대로 실행됨.
    select
        *
    from emp as e
    inner join dept as d
    on e.DEPTNO = d.DEPTNO 
    inner join emp as boss 
    on e.MGR = boss.EMPNO 
    ```

- ### limit
    ```sql
    출력되는 결과 행의 수를 제한
    mysql에서 limit은 oder by 뒤에 온다(맨 뒤)

    select 
        *
    from emp
    limit 0,10
    ```

- ### 서브쿼리
    ```sql
    하나의 쿼리 문장 내에 포함된 또 하나의 쿼리 (마지막 수단으로 사용)

    - 서브쿼리가 가능한 곳
        select 절(스칼라 서브쿼리)  
        **from 절 (인라인 뷰)  
        where 절 (중첩 서브쿼리)  
        having  
        order by  
        insert values  
        update set (MYSQL에서 실행X) 
    
    <부서번호가 10번이고 평균 급여보다 많은 사원 모두 조회>
    select 
        *
    from emp
    where DEPTNO = 10
    and SAL > (select avg(SAL) from emp);
    
    <사원번호가 7876인 사원과 job이 같은 사람 모두 조회>
    select 
        *
    from emp
    where job = (
    select job from emp where empno = 7876
    )
    
    서브쿼리 결과값이 하나만 나오는 것이 단일 서브쿼리, 결과값이 여러개 나오는 것이 다중행 서브쿼리  
    서브쿼리를 어떻게 작성할까 먼저 생각한 후 나머지 코딩하는게 쉽다  
    ```

- ### EXISTS, NOT EXISTS
    ```
    - where절에 온다
    - 괄호 안이 참이면 메인쿼리가 실행이 되고, 거짓이면 실행되지 않는다.

    ** EXISTS는 단지 서브쿼리 데이터가 있는지 없는지만 판단하며, 결과값은 메인쿼리에서 나온다. (EXISTS 서브쿼리의 SELECT는 중요하지 않다.)

    BUT!!, exists 서브쿼리 안에 join이 존재하면 해당 서브쿼리를 갖는 where절을 조건으로 하는 메인쿼리를 실행한다.

        select
            *
        FROM emp
        WHERE EXISTS (
            SELECT * 
            FROM emp WHERE 
            job = 'manager'
        )
        ====> 서브쿼리의 데이터가 존재하기 때문에 메인쿼리가 실행됨.
    
    - NOT EXISTS는 EXISTS와 반대. FALSE(거짓)이면 메인쿼리가 실행됨

    - EXISTS 의 사용
        UPDATE 할 때 사용
        
        ex) 카카오뱅크에서 입출금내역이 없는 경우 업데이트 안 함. 입충금내역이 있는 경우 백업실행 컬럼의 백업날짜 220222로 업데이트
            update 백업실행
            set 백업날짜 = '220222'
            where exists
            (
                select *
                from 입출금내역
            )
    ```