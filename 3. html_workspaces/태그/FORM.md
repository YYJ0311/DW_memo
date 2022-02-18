```html
    웹 서버에 데이터를 전송할 때 사용하는 태그  
    (HTML, 안드로이드를 바로 DB랑 연결 불가능. 웹서버로 연결)  
    작성 양식
    <!--
    <form> 
        <input type = "text">
        <input type = "submit"> 이게 form 태그에서 버튼임!
    </form>
    -->
    <form action=""> 
    <!-- 큰 따옴표 안에 웹서버 주소가 옴! -->
        아이디 : <input type="text" /><br>
        비밀번호 : <input type="password" /><br>
        회원 이메일 : <input type="email" /><br>
        <input type="submit" value="표시되는내용">
    <!-- 페이지에서 제출버튼을 누르면 서버 주소에 input 데이터들이 보내짐 -->
    </form>
```
```
- ### form 태그와 웹서버 전송
    form 태그에 웹서버 주소를 입력하고 전송하는 방법은 2가지이다.
    ```
    1. get (public 전송)  
        http header에 전송
        <form action="" method="get"></form>>

    2. post (private 전송)
        http body에 전송
        <form action="" method="post"></form>
    ```
    form 태그 안에 submit 태그가 아닌, button 태그를 사용하면 UI적으로는 버튼이 생기지만 서버에 전송이 안 되므로 의미가 없다!
```