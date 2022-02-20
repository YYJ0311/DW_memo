```
<input></input> 또는 <input type="text" /> 중 하나로 표현한다.
두번째 방법을 많이 사용
```
```
1. text
    <input type="text" placeholder="텍스트 설명"/>
    아이디 : <input type="text" placeholder="아이디 입력!"/>

2. password
    비밀번호 : <input type="password" placeholder="최대 2글자" maxlength="2"/>

3. button
    1)  <input type="button" value="버튼내용"/>
    2)  <button>버튼 내용</button>
    3) form 태그 안에서 버튼태그는 <input type = "submit"> 사용

4. checkbox
    체크박스 : <input type="checkbox" />
    체그된박스 : <input type="checkbox" id="멜론" checked/>
    <label for="멜론">멜론</label>
    <!-- 체크박스에 라벨 붙이기 -->

5. 날짜관련
    <input type="date" />
    <input type="month" />
    <input type="week" />
    <input type="time" />

6. 그 외
    - 숫자 : <input type="number" placeholder="숫자만"/>
    - 파일 : <input type="file" />
- 

```
```
    인풋 타입은 한 가지 종류만 올 수 있다.
    placeholder, id, name, readonly, maxlength 와 같은 속성들은 중복 가능하다!

    <input type="text" id="userId" name="userId" value="안녕" readonly/>
    에서 id, name, value, readonly는 input의 속성이다.
    - id는 중복 불가능, name은 중복 가능
      중복 가능한 name은 나중에 수정을 한번에 할 수 있다.

    - value는 서버에 전송할 실제 데이터 혹은 디폴트값을 의미

    - placeholder와 value의 구분
        placeholder는 입력 전까지 표시, value는 디폴트로 입력돼 있음.
        
    - required     
    인풋 속성 중 required를 쓰면 제출하기 전 입력하지 않은 항목을 알려준다.
```
    