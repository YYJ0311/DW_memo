-- Mysql DDL
CREATE TABLE food(
    foodNo INTEGER(4) AUTO_INCREMENT PRIMARY KEY COMMENT '음식 번호',
    foodName VARCHAR(20) NOT NULL COMMENT '음식 이름',
    foodPrice INTEGER(4) NOT NULL COMMENT '음식 가격',
);
    
CREATE TABLE restaurant(
    restaurantNo INTEGER(4) AUTO_INCREMENT PRIMARY KEY COMMENT '레스토랑 번호',
    restaurantName VARCHAR(20) NOT NULL COMMENT '레스토랑 이름',
    foodNo INTEGER(4) NOT NULL COMMENT '음식 번호',
    FOREIGN KEY(foodNo) REFERENCES food(foodNo)
);
-- 레스토랑 테이블에서 음식 테이블의 음식번호를 참조중임

SELECT * FROM restaurant WHERE foodNo = 30 AND restaurantName= '빠스타스';
/* 문제 1.
레스토랑 테이블에 데이터가 일일 1000만건 저장된다. 
레스토랑 테이블에서 위에 작성한 select쿼리 호출 시간이 오래 걸리기 시작했다.
가장 먼저해야하는 바람직한 행동은?
답안 작성 =>
    1. * 으로 전체 호출하지 말고 필요한 컬럼만 골라서 호출한다
    2. 자주 사용하는 컬럼에 INDEX를 생성한다
*/

DELETE FROM food
WHERE foodNo = 30;
/* 문제 2.
음식 테이블에 30번 음식 데이터를 지우려고 한다.
하지만 레스토랑 테이블에 30번 데이터가 있어서 지울 수가 없다. 
음식 테이블에 30번 데이터를 지울 방법은 무엇일까?
답안 작성 =>
    ON DELETE CASCADE 를 사용해서 부모테이블과 자식테이블 데이터를 같이 지운다
    ON DELETE CASCADE는 테이블을 생성할 때 적용하므로 이미 존재하는 자식테이블(레스토랑 테이블)에 적용하기 위해서는,
    ALTER 명령어를 이용해서 기존의 FK를 지웠다가 ON DELETE CASCADE를 추가한 FK를 다시 생성하면 된다.
*/