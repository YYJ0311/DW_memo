# SQL  

- 급여가 1000달러 이상인 사람의 이름과 직업 조회  
```sql
select  
ename,  
job  
from emp  
where sal >= 1000 ; <====== having 쓰면 오류남
```

- 정렬하기 (order by)  
내림차순 : desc  
오름차순 : asc  

- null
```sql
where COMM is null
where COMM  is not null  
```

- like
```sql
where ENAME = 'smith'
where ename like 'smith'

where ename like 'A%' <====== 위와 다르게 where ename = 'A%' 는 제대로 조회되지 않음
```

- 테이블에 데이터 추가(insert into, value)
```sql
insert into emp  
(empno,ename,job,mgr,hiredate,sal,comm,deptno)  
values  
(8000,'유영준','salesman',7369,'2022-01-06',5000,1000,30) 
```

- AND와 OR 같이 사용  
where 절에서 AND와 OR을 같이 사용할 경우 and를 먼저 읽는다. and를 먼저 읽게되면 원하는 값을 조회하지 못할 수도 있기 때문에 괄호를 사용하여 순서를 명확히 해 준다.  
```sql
where 
 (
 deptno = 10
 or
 deptno = 30
 )
 and
 sal > 1500
 ```

 - AND와 OR 순서 정하는 괄호 사용법
```sql
1) 괄호를 맞게 쓴 경우
select
*
from emp
where 
 (
 deptno = 10
 or
 deptno = 30
 )
 and
 sal > 1500

이 상태로 컴퓨터가 읽는 방법은 deptno = 10 인 것과 deptno = 30 인 것을 조회하고 거기서 sal > 1500 인 것을 불러온다.
만약 괄호가 없다면 and 앞에 있는 deptno = 30 이면서 sal > 1500 인 것을 먼저 조회하고 추가로 다른 조건이 붙지 않은 deptno = 10 인 것을 불러오기 때문에 원하는 결과값과 달라진다.
```
```sql
2) 괄호를 안 썼는데 맞는 결과가 나온 경우
select 
*
from emp
where
JOB = 'clerk'
or 
JOB = 'analyst'
and SAL != 1000
and SAL != 3000
and SAL != 5000

이 상태에서 컴퓨터는 JOB = 'analyst'이고, SAL이 1000, 3000, 5000 이 아닌 것들을 조회한 후 JOB = 'clerk' 인 것을 불러온다. 따라서 우리가 원하는 값을 불러오기 위해선 or 앞뒤를 괄호로 묶어주는 것이 맞는 방법이다. 하지만 이 경우엔, clerk를 직업으로 하고 sal이 1000, 3000, 5000 인 사원이 DB에 없었기에 운이 좋아서 맞는 결과가 나왔다. 따라서 앞으로 or 에는 무조건 괄호를 붙여주는게 맞는 것 같다. 
```

- limit : 출력 결과 행의 수를 제한
```sql
select 
*
from emp
limit 0,10
```

- count(*) 는 having 뒤에 온다
```sql
다음과 같이 쓰면 오류 나옴
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
```
```sql
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

