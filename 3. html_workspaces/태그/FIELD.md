```
폼 태그 안에 관련있는 요소들을 그룹화할 때 사용함

field 태그 하위에 legend 태그를 사용하여 그룹화한 요소들을 목적에 맞게 이름을 지정한다.
  
    <form action = "#" accept-charset="ut f-8" name = "person_info" method = "get">
        <fieldset style = "width:150">
            <legend>개인 정보 입력</legend>
                이름 : <input type = "text" name = "name"/><br><br>
                나이 : <input type = "text" name = "age"/><br><br>
        </fieldset>
        <br>
        <fieldset seyle = "width:180; height:180">
            <legend>여가 활동</legend>
                취미 : <input type = "text" name = "hobby"/><br><br>
                특기 : <input type = "text" name = "specialty"/><br><br>
        </fieldset>
    </form>
```