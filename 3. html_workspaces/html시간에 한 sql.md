디폴트인 ASC도 가급적 표현해주자!       
SELECT, FROM, WHERE 등은 전부 대문자로 꼭 써주자!       
컬럼이름은 소문자로 쓰자!       
구글에 sql formatter 검색하면 어떻게 표현하는지 나옴!       

SELECT 다음에 tab 눌러서 앞에 띄운다음 작성하기!        
ex) SELECT      
        NAME        

WHERE 절 뒤에 오는 것들은 줄 바꿈 & tab으로 앞에 띄워서 적기!       
ex) WHERE   
        EMPNO = 1000        

LIMIT의 사용 기억하기!      
ex) LIMIT 0,1 또는 LIMIT 1      



- SQL 작성법        
https://codebeautify.org/sqlformatter

    DML : 데이터 조작 언어      
        SELECT      
        DELETE      
        UPDATE(= DELETE 후 INSERT)      
        INSERT    

```sql    
SELECT
    컬럼이름
FROM 테이블
WHERE 조건식
GROUP BY 컬럼이름
HAVING 집계함수, 그룹핑된 컬럼들 조건
ORDER BY 컬럼이름 ASC
LIMIT

순서 : FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY -> LIMIT
```

** 중복제거        
GROUP BY 말고 단순히 중복 제거를 하려면 DISTINCT(컬럼명) 사용

- Order by 뒤에 숫자가 올 수 있는 이유     
select 다음으로 order by를 읽기 때문에

- sql의 if
조건식, true 실행, false 실행
ex) 

- sql in 연산자     
WHERE 절 내에서 특정값 여러개를 선택하는 연산자 
괄호 내의 값 중 일치하는 것이 있으면 TRUE    
WHERE 컬럼명 IN (값1, 값2, 값3 ...)
ex) WHERE COL = 1 
OR COL = 5
OR COL = 7
과
WHERE COL IN (1, 5, 7) 
은 같다!

하지만 WHERE COL = 1 
OR COL = 2
OR NAME LIKE '3%'
와 같은 경우엔 IN은 오지 못함 



JOIN : 교집합 데이터를 연결!        
       2개 이상 테이블 데이터를 조회할 때       
```sql
교집합 조인(내부조인)
SELECT
    e.ename
FROM emp AS e
INNER JOIN dept AS d
ON e.deptno = d.deptno
```
```sql
아우터조인
-- emp에 없는 deptno까지 조회하시오.
SELECT
    *
FROM emp as e
RIGHT JOIN dept as d
ON e.deptno = d.deptono
```
- 서브쿼리        
    : 하나의 쿼리에 또 쿼리가 옴        
    1. SELECT 절에 오는 서브쿼리 (스칼라 서브쿼리)
    2. WHERE 절에 오는 서브쿼리 (중첩 서브쿼리)
    3. FROM 절에 오는 서브쿼리 (인라인 뷰)

- 서브쿼리가 가능한 곳      
    1. ***SELECT
    ```sql
        A 테이블(감기 관련),
        B 테이블(코로나 확진자 관련),
        C 테이블(오미크론 확진자 관련)

        조건. 교집합 데이터(컬럼)이 없음.
        실행. 서브쿼리가 먼저 실행된 후 외부쿼리가 실행된다.
        SELECT
            COUNT(*) AS 감기확진,
            (SELECT COUNT(*) FROM 코로나) AS 코로나확진, // 서브쿼리 먼저 실행됨
            (SELECT COUNT(*) FROM 오미크론) AS 오미크론확진 // 서브쿼리 먼저 실행됨
        FROM 감기

        ===> 이런 경우 테이블이 교집합이 존재하지 않은 상태(엉망인 상태)인 경우이므로 쓸일이 많진 않다.
    ```
    2. ***FROM (제일 많이 씀!!)
    ```sql
        언제. 데이터를 먼저 필터링 해야할 때
        ex) emp 테이블에 급여가 3천 미만인 사람 데이터로 뭔가를 활용할 때
        select
            e.ename,
            e.job
        from (
            select
            ename,
            job
            from emp
            where sal < 3000
        ) as e
        group by e.job
    ```
    3. ***WHERE
    ----------
    4. HAVING 
    5. ORDER BY
    6. INSERT
    7. UPDATE set

- 서브쿼리를 쓰기 전에 한번 생각하기! (정말 필요한가?)

- where 서브쿼리        
    1. 단일행
        : 서브쿼리의 결과가 하나의 행으로 나옴
    ```sql
    SELECT 
        *
    FROM emp
    WHERE ename = (
        SELECT
            ename
        FROM emp
        WHERE
            empno = 3000)
    ```

    2. 다중행
        : 서브쿼리의 결과가 여러 행으로 나옴
    ```sql
    IN : 실제로 존재하는 데이터의 값을 비교
    (IN을 사용하게 되면 비교뿐만 아니라 그 데이터가 테이블에 존재하는지도 체크해야 함.)
    => 데이터가 많아질수록 속도가 느려짐

    웬만하면 IN 서브쿼리(WHERE 서브쿼리)를 쓰지 않는 게 손실이 적다!(속도가 빠르다!)
    => 따라서 from에 서브쿼리를 많이 씀

    SELECT
        *
    FROM emp
    WHERE
       ename IN (
            SELECT
                ename
            FROM emp
            WHERE
                sal<3000)
    ```

- IN 대신 EXISTS를 사용 (괄호안이 true면 실행O, false면 실행X) : 자바의 플래그와 비슷
    ```sql
    SELECT
        ename,
        job
    FROM emp
    WHERE exists (
        SELECT
            *
        FROM emp
        WHERE
            deptno = 40
        )
    ===> deptno = 40이 false이므로 결과값 없음
    ```

- 프로그래머스 서브쿼리 문제
테이블 PLACES는 공간 임대 서비스에 등록된 공간의 정보를 담은 테이블이다.        
그리고 ID는 공간의 아이디, NAME은 공간의 이름, HOST_ID는 공간을 소유한 유저의 아이디를 나타내는 컬럼들이다.     
Q. 공간을 둘 이상 등록한 사람을 헤비유저라고 할 때, 헤비유저가 등록한 공간의 정보를 아이디 순으로 조회하는 방법은?
정답)
```sql
SELECT
    p.ID,
    p.NAME,
    r.HOST_ID
FROM (
    SELECT
        HOST_ID,
        COUNT(*) AS cnt
    FROM PLACES
    GROUP BY HOST_ID
    HAVING COUNT(*) >= 2
    ) AS r
INNER JOIN PLACES as p
on r.HOST_ID = p.HOST_ID 
ORDER BY p.ID ASC
```
주석처리
```sql
SELECT
    p.ID,
    p.NAME,
    r.HOST_ID -- r로 묶었던 것들의 HOST_ID 표시
FROM(
    SELECT
        HOST_ID,
        COUNT(*) AS cnt -- HOST_ID로 그룹핑한 각각의 개수를 cnt라고 지정
    FROM PLACES
    GROUP BY HOST_ID
    HAVING COUNT(*) >= 2 -- 그룹핑한 것의 개수가 2개 이상이어야 함
    ) AS r -- HOST_ID가 2개 이상인 것들을 r로 지정
-- 그리고 이 상태로는 ID와 NAME을 조회할 수 없기 때문에 자기 자신과 inner join을 해 준다.
INNER JOIN PLACES as p
on r.HOST_ID = p.HOST_ID
ORDER BY p.ID ASC
```



```sql
DML
- insert : 데이터를 저장
작성방법
INSERT INTO emp(ename, sal, job)
VALUES('홍길동', 3000, 'manager')

    조건
        1) 테이블에 job 컬럼이 not null이면, insert 할 때 무조건 데이터를 넣어야 함.(null 상태로 남을 수 없다!)
        2) 테이블에 기본키 설정이 auto increment가 아니라면, 기본키 데이터를 넣어야 함.
        3) commit; 을 해야 최종 insert가 됨
            디비버가 auto commit이라서 commit 안 해도 입력 됨
            auto commit을 지원하는 프로그램들은 무조건 끄고 사용하기!!

작성법 2
    1)해당 테이블에 데이터를 모두 넣으면, 테이블 뒤 괄호 생략 가능!
    INSERT INTO emp
    VALUES('홍길동' 3000, 'manager', ...)
```
```sql
insert into dept (deptno)
values(50)

insert into dept (deptno, dname, LOC)
values(60, '쏘리쏘리', '대전')

insert into dept 
-- 컬럼에 모두 데이터를 집어넣기 때문에 컬럼명은 생략했다.
values(70, '햄버거부서', '버거킹지역')
```

```sql
- delete : 데이터 삭제
DELETE FROM dept
WHERE deptno = 70

    주의 
    1. 해당 컬럼이 ON DELETE CASCADE로 설정되어 있으면, 연관된 컬럼 모두 삭제됨.
    2. commit; 해야 최종 delete가 됨.
```

회사에서 실제로 데이터를 delete(삭제)하는 일은 없음. column을 하나 더 추가해서 그 컬럼에 보관함.(예를들어 회원탈퇴 컬럼을 만들어 관리)

ex)
    컬럼이름 : 회원탈퇴여부
    데이터 : 'y' or 'n'으로 저장



- DDL (프로그램과 상관없이 자체가 auto commit됨)       
    1. CREATE
    2. DROP
    3. ALTER
```sql
- CREATE        
    테이블 생성!        
    문법)       
        CREATE TABLE student(
            id INT(11) NOT NULL,
            name VARCHAR(20) NOT NULL,
            height INT(5),
            age INT(5) default 0,
            create_at DATETIME DEFAULT CURRENT_TIMESTAMP
        );

        insert into student 
        (id, name, height , age, create_at)
        values(1,'홍길동',190,30,now())

-- 스키마라고 부름(ddl로 작성된 create 테이블 전체)
        CREATE TABLE student(
            id INT(11) NOT null auto_increment,
            -- auto_increment : 하나씩 증가한 키값을 넣어줌
            name VARCHAR(20) NOT NULL,
            height INT(5),
            age INT(5) default 0,
            create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
            constraint student_id_pk primary key(id)
            -- 마지막 줄 지우고 첫 줄 뒤에 primary key을 입력해줘도 된다.
            -- ex. id INT(11) NOT null auto_increment primary key
            -- 하지만 그렇게 하게 되면 나중에 관리하기가 힘들다.            
        );            

        insert into student
        (name,height)
        values('홍길동',190)
```



```
DDL(Data Definition Language)
	: 테이블 관리 명령어 
	CREATE, DROP, ALTER

DML(Data Manipulation Language)
	: 테이블 안에 있는 데이터를 관리 
	SELECT, DELETE, INSERT, UPDATE
	개발자들이 많이 사용

DCL(Data Control Language)
	: 데이터베이스 관리
	GRANT(특정 사용자에게 권한 부여)
	REVOKE(특정 사용자 권한 회수)
	팀장급이 사용

TCL
    COMMIT
    ROLLBACK
```


```
DML : INSERT, DELETE, UPDATE, SELECT
DDL : CREATE, DROP, ALTER
DCL : REVOKE, GRANT
TCL : COMMIT, ROLLBACK
      COMMIT : DML은 커밋 미포함, DDL은 커밋이 포함돼 있음
              (디비버는 DML이지만 프로그램 상에서 커밋이 자동으로 되게 돼있음)
      ROLLBACK : 이전 커밋으로 되돌아가는 것
                 홍길동이 DB접속 INSERT 5번 날리고 COMMIT 함. 길동이가 실수로 DELETE하고서 ROLLBACK을 이용해서 최신 COMMIT 상태로 돌아간다.(DELETE 한 것이 무시되고 INSERT 5번 하고 COMMIT한 상태로 되돌아 간다.)
```
```
- 관계형 데이터베이스(RDBMS)
Relational DataBase Management System
데이터를 더욱 안전하게 저장(서로 관계가 맺어져 있어서 마음대로 수정 불가능)
    : 그 중 MySQL을 배우고 있음
JOIN이 있다.
부모테이블과 자식테이블이 존재(관계)
ex) emp테이블에 deptno 컬럼이 있음
    deptno컬럼은 dept테이블에서 온 것
    : emp(자식) 테이블은 deptno(부모) 테이블을 참조하고 있음.(참조하고 있는 쪽이 자식, 참조를 주는 쪽이 부모가 됨)
참조를 하지 않는(참조를 주기만 하는) 테이블을 원시테이블이라고 함

CREATE TABLE emp
(
    empno int(11),
    ename varchar(20),
    deptno int(5),
    foreign key (deptno) references dept(deptno) 
);
    
    emp테이블의 deptno와 dept 테이블의 deptno와 관계를 맺을 것을 나타냄
    emp테이블에서 컬럼 이름이 deptno가 아닌 다른 것이어도 가능함
        ex) JOON int(5),
            foreign key (JOON) references dept(deptno)
        으로 적는 것도 가능함. 대신 조건은 JOON 컬럼의 데이터타입 int(5)와 dept테이블의 deptno 컬럼의 데이터타입이 같은 경우에 가능하다. 즉, 컬럼 이름은 상관없고 *데이터타입이 중요*하다.
        하지만 이렇게 다르게 하면 헷갈리기 때문에 보통 이름도 통일시켜 적는다.
        (참조키(외래키)는 컬럼이름이 중요한게 아니라 데이터 타입이 같아야 하며, 고유한 데이터를 가진 컬럼을 참조해야 한다.)

    ***참조한 것 뒤에 조건으로 오는 것
    on delete 
    : dept테이블(부모)의 데이터에 삭제 이벤트가 발생하면 자식 데이터도 이벤트 발생 
    on update
    : 부모 데이터에 수정 이벤트가 발생하면 자식 데이터도 이벤트 발생
    ex) foreign key (deptno) references dept(deptno) on delete

    ***이벤트 종류 : 아래 중 하나 선택
    1. cascade : 자식데이터 삭제 or 수정
    2. set null : 자식데이터 null로 업데이트
                  데이터를 보호하기 위해 사용함(부모데이터를 지우지 않고 자식 데이터만 null로 바꿈)
    3. set default : 자식데이터 default 값으로 업데이트
    4. restrict : 데이터 삭제 or 수정 불가능
                  지우고자 하는 데이터를 자식테이블에서 쓰고 있으면 삭제/수정 불가능, 안 쓰고 있으면 가능
    5. NO ACTION : 부모테이블의 데이터를 삭제하거나 수정해도 자식 테이블의 데이터는 남아있음

    ex) foreign key (ename) references dept(deptno) on delete cascade
        : dept 테이블에서 deptno 데이터 하나가 삭제되면 자식 테이블(emp)에서도 같은 deptno에 해당하는 데이터가 삭제됨 (update cascade는 부모가 수정되면 자식도 수정됨)
```
```
- 비관계형 데이터베이스(NoSQL)
대표적 프로그램 : **Dynamodb, MongoDB
JOIN이 없다.
데이터를 분석하는게 목적.
```
```
- 모델링
    데이터들을 나열하고 어떤게 고유한 특성(수정하지 않는 것)을 갖는지 찾고 그걸 기본키로 한다.
    다른 테이블과 중복되는 건 기존 테이블

(학생테이블)                    (교수테이블)                 (담당교수테이블)
학생이름                        교수이름                     ~
학생나이                        교수번호(기본키)              ~
교수이름(중복으로 지워짐)         담당과목                    ~
교수번호(외래키, 참조키, FK)     연차                           
학점
학번
학년

학생테이블과 교수테이블만 있으면 하나의 교수번호에 하나의 학생밖에 오지 못 함.
따라서 담당교수테이블을 따로 만들어서 하나의 교수에 여러 학생이 올 수 있게 만들어 줌
```



```
- 테이블을 설계했는데 null이 많이 들어가면 잘못된 테이블임.   
    ====> 테이블을 나눠야 한다.     

- 테이블에서 자주 조회할 것을 위에 둔다.  
```



```
CREATE emp
    ename varchar(50)
문자 50byte 제한됨(영어는 1byte, 한글은 2byte 할당)

INSERT emp values(1)
    ===> 1이 varchar형 컬럼인 emp에 인서트 될 수 있음. 하지만 정수형으로 저장되는 게 아니라 문자형으로 저장된다.
    sum, avg 사용하려면 문자를 숫자로 바꿔주는 함수를 입력해줘야 함.

*** CHECK 사용해서 아예 숫자가 입력되지 않게 제약을 걸 수 있다.
CHECK('예','아니오','커피') 
    => 괄호 안에 있는 데이터만 받을 수 있다. 
    따라서 예와 아니오 커피만 데이터를 받을 수 있음.
```



```
테이블 정규화(모델링)
1. PK not null, 중복 X
    PK는 null이 되면 안 되고 중복이 되면 안 되는 조건을 갖는다.
2. 부서관련(dname, loc) 수정 & 삭제 제약이 커짐
    같은 dname을 갖는 여러 사람의 loc가 나눠질 때 수정&삭제가 어렵다
3. 논리적으로 테이블에 해당돼야 한다.
    예를 들어 사원 테이블에 dname이 단일로 올 수는 있지만, dname을 포함하면서 loc와 deptno등을 같이 가져오고 싶을 경우 새로운 테이블을 만들고 참조해야 한다.
```



