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

