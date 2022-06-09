```java
JSP에서 화면 출력하기
    1. 컨트롤러 아래에 메소드 파라미터로 ModelMap 받기
    public String loadHomePage(ModelMap map)
    이제 이 컨트롤러로 표현하고자 하는 건 map에 추가할 것임.
    2. for each 테스트용 list 만들기
        2-1. list를 선언하고 데이터 추가
            List<String> list = new ArrayList<String>();
            list.add("씨야");
            list.add("쏠");
            list.add("윤은혜");
        2-2. map에 list추가
            map.addAttribute("wsgList", list);
    3. 리턴해준 jsp 파일에서 for each 사용
        <c:forEach items="${wsgList}" var="str">  
            // for(String str : wsgList) 와 같음
            <h4>${str}</h4> 
            // println(str)과 같음
        </c:forEach>
    4. 결과
        씨야
        쏠
        윤은혜
```
```java
ModelMap에 값 넣는 방법
    1. 위에서 한 것처럼 list 만들고 add하고 map에 addAttribute
        => 구조) ModelMap 안에 list 존재.

    2. list 만들고 VO클래스 인스턴스화하고 VO에 있는 변수를 재정의하고 list에 add하고 map에 addAttribute
        => 구조) ModelMap 안에 list 존재. list는 vo 정보를 갖고 있음.
		List<ActorVO> actorList = new ArrayList<ActorVO>();
		ActorVO a1 = new ActorVO();
		a1.name = "이병헌";
		a1.age = 51;
		ActorVO a2 = new ActorVO();
		a2.name = "차승원";
		a2.age = 52;
		actorList.add(a1);
		actorList.add(a2);
        map.addAttribute("actorList", actorList);

        jsp 파일
        <c:forEach items="${actorList}" var="a">
            <h4>${a.name}, ${a.age}</h4> 
            // a에 들어있는 vo를 갖고 오기 위해서 vo클래스에 get 함수가 필요하다.
        </c:forEach>

        결과
            이병헌, 51
            차승원, 52

    3. map으로 된 list 만들고 다시 map을 인스턴스화해서 값을 put함. 그리고 처음에 만든 mapList에 add하고 ModelMap 의 map에 addAttribute
        => 구조) ModelMap 안에 list 안에 map 존재.
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("no", 300);
        Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("no", 100);
		mapList.add(map1);
        mapList.add(map2);
		map.addAttribute("mapList", mapList);

        jsp 파일
        <c:forEach items="${mapList}" var="item">
            <h4>${item.no}</h4> 
        </c:forEach>

        결과
            300
            100

    4. map으로 된 list 만들고 다시 map을 인스턴스화 해서 값을 put함. 그리고 mapList에 add한 뒤, 또 map을 하나 더 만들어서(수업에선 맨 처음에 만듦) 거기에 list를 put 하고 ModelMap 에 addAttribute
        => 구조) ModelMap 안에 Map 안에 list 안에 map 존재.
        Map<String, Object> data = new HashMap<String, Object>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("Company", "Alfreds Futterkiste");
		map1.put("Contact", "Maria Anders");
		map1.put("Country", "Germany");
        Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("Company", "Centro comercial Moctezuma");
		map2.put("Contact", "Francisco Chang");
		map2.put("Country", "Mexico");
		list.add(map1);
        list.add(map2);
		data.put("list", list);
		map.addAttribute("data", data);

        jsp 파일
        <c:forEach items="${data.list}" var="d">
            <tr>
                <td>${d.Company}</td>
                <td>${d.Contact}</td>
                <td>${d.Country}</td>
            </tr>
        </c:forEach>

        결과
            Alfreds Futterkiste / Maria Anders / Germany
            Centro comercial Moctezuma / Francisco Chang / Mexico
        
        주의점) for each를 사용할 때 데이터를 갖고오는 item이 3번과 다름.
            4번은 우리가 찾는 데이터(Company 등의 value값)가 ModelMap 안에 map 안에 list 안에 map에 있기 때문에 items에 경로를 data(map 이름).list(list 이름) 로 한다.
            반면, 3번은 ModelMap 안에 list 안에 map에 있기 때문에 items를 mapList(list 이름) 으로 한다.
```