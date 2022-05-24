```javascript
1. 자바스크립트에서 문자열 -> 날짜 변환 그리고 계산
    1-1. new Date() 
        new Date("2021-05-23");
        new Date("2020/2/29");
        그냥 new Date() 하면 현재 날짜 가져옴
        // =>  new Date()한 값에 .getTime() 을 쓰면 밀리세컨드로 환산할 수 있다.
        //     = Date.now()와 같음

        // =>  또는 뒤에 .getFullYear()/.getMonth()/.getDate()/.getDay() (요일)/
        //     .getHours()/.getMinutes()/.getSecondes() 를 붙여서 사용가능
        //     각각 함수 뒤에 () 안 쓰면 값 정상출력 안 됨
    1-2. Date.parse()
        Date.parse("2020-11-21")
        Date.parse("2019-01-01T12:30:00.000Z")
        Date.parse("11-20-2021")
        // =>  밀리 세컨드로 변환해줘서 날짜 계산 가능함
        //     1시간 = 3,600,000 밀리세컨드 => 하루 = 86,400,000 밀리세컨드
        //     따라서 Date.parse()로 구한 밀리세컨드에 원하는 날짜만큼 가감하면 된다.

    둘 다 "" 안에 적은 데이터 포맷이 아니면 인식 못 함
```
```javascript
2. 날짜의 월과 일을 1대신 01로 표시하기
    var today = new Date();
    var year = today.getFullYear();
    var month = today.getMonth()+1;
    var day = today.getDate();

    var format = year+"-"+(("00"+month.toString()).slice(-2))+"-"+(("00"+day.toString()).slice(-2));

    // => getMonth는 월을 0부터 11까지로 생각하기 때문에 우리가 원하는 월을 찾으려면 1을 더해줘야 한다
    // => slice(1) 하면 앞에서부터 첫번째를 가져오지만 slice(-2)를 하면 뒤에서부터 2번째 까지를 가져온다. 따라서 00+1 = 001 에서 뒤 두자리 01을 가져옴. 또는 0011에서 11을 가져옴.
```
```javascript
3. new option()
    select 태그 아래에 option을 추가할 때 사용
    기본형 : new Option(text, value, defaultSelected, selected);

    for(var m = 1; m <= 12; m++){ // 월(달) option 태그 추가
        if(m == (today.getMonth()+1)){
            document.getElementById('month').options[m-1] = new Option(m, ("00"+m).slice(-2), true, true); 
            // m이 오늘 날짜에 해당하는 달이라면 true => selected 속성을 준다.
        }else{
            document.getElementById('month').options[m-1] = new Option(m, ("00"+m).slice(-2));
        }
    }
```
```javascript
4. Date 포맷으로 년과 월을 이용하여 마지막 날짜 구하고 추가하기
    function lastday(){
        $('#day').children().remove(); // 오늘 날짜가 기본으로 들어있는 경우, 만들어진 day를 지우고 새로 만듦
        var Year = document.getElementById('year').value; // id가 year인 태그의 요소에서 value를 가져옴
        var Month = document.getElementById('month').value; 
        var day = new Date(new Date(Year,Month,0)).getDate(); 
        // new Date(Year,Month,0) = 해당 Year 해당 Month의 마지막 날.
        // new Date(2022,1,0) = 22/01/31, new Date(2022,1,1) = 22/02/01
        // month는 0부터 시작한다. 따라서 new Date(2022,0,1) = 22/01/01

        // 아래는 day를 id로 가지는 select 태그 아래에 option을 추가하는 과정임
        var dayindex_len = document.getElementById('day').length; 
        if(day > dayindex_len){ 
            for(var i = 1; i <= day; i++){ // 1부터 day까지 option 추가
            if(i == today.getDate()){
                document.getElementById('day').options[i-1] = new Option(i, ("00"+i).slice(-2), true, true); 
            }else{
                document.getElementById('day').options[i-1] = new Option(i, ("00"+i).slice(-2));
            }
            } 
        }
    }
    // else if(day < dayindex_len){
    //         for(var i = dayindex_len; i >= day; i--){
    //             document.getElementById('day').options[i]=null;
    //         }
    //     }

    그리고 함수를 year와 month에 붙인다.

    <select id="year" onchange="javascript:lastday();">
        <!-- 변경이 될 때마다 lastday() 함수 실행 -->
        <!-- 아래 스크립트로 아래와 같은 태그 생성될 것임 -->
        <!-- <option value="2020">2020</option> -->
    </select>              
    <select id="month" onchange="javascript:lastday();"></select>
```