```
페이징은 고객의 요구에 따라 수정할 수 있게끔 알고리즘을 잘 짜야 한다.
페이징에 필요한 쿼리
    1. 해당 테이블의 전체를 카운트하는 쿼리
    2. 페이지에 보여질 게시글을 나누는 쿼리
        select *
        from emp
        limit 0,5   ==> limit(startPage, pageSize)
```
```java
우선 아래와 같이 페이징 기능을 STEP 별로 나눠서 구현했다.

package 페이징;

public class PageHandler {
	public static void main(String[] args) {
//		STEP 1. 페이지 수 알아내기(총 카운트와 한 페이지에 몇 개를 보여줄지가 중요함)
		// 웹툰 여신강림을 예시로 페이징 함
		// 야옹이 작가는 210화까지 연재함. 1페이지에 10화를 보여줄 수 있다.
		int total = 211; // sql에서 count 필요
		int pages = 0;
		int pageSize = 10; // 1페이지에 보여줄 수 있는 게시물 수
		pages = total / pageSize; // 페이지 수
		if(total % pageSize >= 1) ++pages; // 나머지가 있으면 페이지수 1개 추가
		System.out.println("총 "+pages+"개 페이지"); // 22
		System.out.println("한 페이지에 보여줄 게시물 : "+pageSize+"개");
		
//		STEP 2. 블럭 알아내기(한 블럭은 사용자한테 보여주는 페이지 뭉치 ex. 1~10페이지 까지가 한 블럭)
		int navigatePages = 10; // 한 블럭에 보여줄 페이지 수
		int blocks = 0;
		blocks = pages / navigatePages; // 22/10 = 2
		if(pages % navigatePages >= 1) ++blocks; // 2+1
		System.out.println("총 "+blocks+"개 블럭"); // 3
		
//		STEP 3. 현재 있는 블럭 알아내기
		int pageNum = 21; // 지금 위치한 페이지
		int nowBlock = 0;	
		// 내 풀이
//		nowBlock = 1 + (pageNum / navigatePages);
//		if(pageNum % navigatePages == 0) {
//			--nowBlock;
//		}
		// 선생님 풀이
		nowBlock = pageNum / navigatePages;
		if(pageNum % navigatePages > 0) {
			++nowBlock;
		}
		System.out.println("현재 블럭 : "+nowBlock+"블럭");
		
//		STEP 4. 마지막 블럭 알아내기
		int lastBlock = 0;
//		total(총 게시물 수), navigatePages(한 블럭에 보여지는 페이지), pageSize(한 페이지에 보여지는 게시물 수) 이용
		lastBlock = total / (navigatePages * pageSize);
		if(total % (navigatePages * pageSize) > 0) {
			++lastBlock;
		}
		System.out.println("마지막 블럭 : "+lastBlock+"블럭");
		
//		STEP 5. 현재 내가 위치한 블럭의 처음 페이지와 마지막 페이지 구하기
//		ex) 1블럭에 있으면 1~10, 3블럭에 있으면 21~22(여신강림 기준)
//		startpage를 먼저 구함
		int startPage = 0;
		int endPage = 0;

//		startPage = (nowBlock-1) * navigatePages + 1; 또는
		startPage = (nowBlock * navigatePages) - (navigatePages -1);
		endPage = nowBlock * navigatePages;
		if(nowBlock == lastBlock) { // 마지막 블럭이라면 마지막 페이지로 총 페이지 수 대입
			endPage = pages;
		}
		System.out.println("처음 페이지 : "+startPage+", 마지막 페이지 : "+endPage);
		
//		STEP 6. 이전버튼, 다음버튼 유무 판단
		boolean hasPreviousPage = true;
		boolean hasNextPage = true;
		
		if(lastBlock == 1) { // 블럭이 하나이므로 이전, 다음 버튼 존재 X
			hasPreviousPage = false;
			hasNextPage = false;
		}
		if(lastBlock > 1 && lastBlock == nowBlock) { // 마지막 블럭이라면 이전 버튼만 존재
			hasPreviousPage = true;
			hasNextPage = false;
		}
		if(lastBlock > 1 && pageNum <= navigatePages) { // 첫번째 블럭인데 블럭이 1 이상일 경우 다음 버튼 존재
			// pageNum이 navigatePages 보다 작은 경우는 1블럭만 해당됨
			hasPreviousPage = false;
			hasNextPage = true; 
		}
		System.out.println("이전 버튼이 있습니까? "+hasPreviousPage);
		System.out.println("다음 버튼이 있습니까? "+hasNextPage);
	}
}
```
```
위의 각 STEP별로 나누어 메소드를 만들고, utils 패키지에서 관리한다.
ex) com.dw.board.utils 패키지 아래의 PageHandler.java 클래스 파일에 아래와 같이 적음.
```
```java
package com.dw.board.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageHandler {
	private int total; // 전체 게시물 수
	private int pageNum; // 현재 페이지
	private int pageSize; // 한 페이지에 있는 게시물
	private int startPage; // 현재 블럭의 첫 페이지
	private int endPage; // 현재 블럭의 마지막 페이지
	private boolean hasPreviousPage; // 이전 버튼 유무
	private boolean hasNextPage; // 다음 버튼 유무
	private int nowBlock; // 현재 블럭
	private int lastBlock; // 마지막 블럭
	private int navigatePages; // 한 블럭에 있는 페이지 수
	
	/**
	 * @return
	 * @author : YoungJoon Yoo
	 * @date : 2022. 5. 31.
	 * comment : 총 페이지 수
	 */
	public int calcPage(int total, int pageSize) {
		int pages = total / pageSize;
		if(total % pageSize > 0) ++pages;
		return pages;
	}
	
	/**
	 * 
	 * @author : YoungJoon Yoo
	 * @date : 2022. 5. 31.
	 * comment : 현재 페이지 블록 알아내기
	 */
	public void setNowBlock(int pageNum, int navigatePages) {
		this.nowBlock = pageNum / navigatePages;
		if(pageNum % navigatePages > 0) this.nowBlock++;
	}
	
	/**
	 * @param total
	 * @author : YoungJoon Yoo
	 * @date : 2022. 5. 31.
	 * comment : 마지막 블록 알아내기
	 */
	public void setLastBlock(int total) {
		this.lastBlock = total / (this.navigatePages * this.pageSize);
		if(total % (this.navigatePages * this.pageSize) > 0) this.lastBlock++;
	}
	// 현재 블럭의 처음 페이지
	public void setStartPage(int nowBlock) {
		this.startPage = (nowBlock * this.navigatePages) - (this.navigatePages -1);
	}
	// 현재 블럭의 마지막 페이지
	public void setEndPage(int nowBlock, int total) {
		this.endPage = nowBlock * this.navigatePages;
		if(nowBlock == this.lastBlock) { // 마지막 블록이라면 마지막 페이지로 총 페이지 수 대입
			this.endPage = total;
		}
	}
	
	public void setPreNext(int pageNum) {
		if(this.lastBlock == 1) { 
			setHasNextPage(false);
			setHasPreviousPage(false);
		}
		if(this.lastBlock > 1 && this.lastBlock == this.nowBlock) { 
			setHasPreviousPage(true);
			setHasNextPage(false);
		}
		if(this.lastBlock > 1 && pageNum <= this.navigatePages) { 
			setHasPreviousPage(false);
			setHasNextPage(true);
		}
	}
}
```

```java
위와 같은 기능들은 PageHelper 하나만 추가하면 간편하게 사용할 수 있다.
참고 
    https://github.com/abel533/MyBatis-Spring-Boot 
    https://deonggi.tistory.com/96

    1. 기능 다운로드
        gradle
            dependencies {
                implementation group: 'com.github.pagehelper', name: 'pagehelper-spring-boot-starter', version: '1.4.2'
            }
        maven
            <dependency>
                <groupId>com.github.pagehelper</groupId>
                <artifactId>pagehelper-spring-boot-starter</artifactId>
                <version>1.4.2</version>
            </dependency>

    2. applicantion.yaml 또는 .properties 설정
        yaml
            pagehelper:
                helperDialect: mysql
                reasonable: true
                supportMethodsArguments: true
                params: count=countSql
        properties
            #pagehelper
            pagehelper.helperDialect=mysql
            pagehelper.reasonable=true
            pagehelper.supportMethodsArguments=true
            pagehelper.params=count=countSql

    3. Controller 예시
        //	게시판 조회(R)
        //	리턴 타입을 list에서 PageHelper 안에 있는 PageInfo로 변경
        @GetMapping("/board")
        public PageInfo<Map<String, Object>> callBoardList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
            List<Map<String, Object>> list = boardService.getAllBoardList(pageNum, pageSize);
            return new PageInfo<Map<String, Object>>(list);
        }

    4. Service 예시
        //	pageNum : 현재 페이지, pageSize : 한 페이지에 게시물 몇개 보여줄지
        public List<Map<String, Object>> getAllBoardList(int pageNum, int pageSize){
            PageHelper.startPage(pageNum, pageSize);
            return boardMapper.selectAllBoardList();
        }
```

```
ajax 안에서의 페이징
	장점 : 페이지의 깜빡임이 없다.
	단점 : 페이지가 바뀔 때 주소가 바뀌지 않는다.
		(뒤로가기 하면 첫 페이지로 넘어간다. 뒤로가기 기능 없음)

페이지에서 뒤로가기를 쓰고 싶으면 jsp, 리액트, 뷰를 사용해야 한다.
```