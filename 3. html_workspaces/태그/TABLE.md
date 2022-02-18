```html
    1) 기본구성
    <table> 
        <thead>
        <!--테이블제목(컬럼)-->
            <tr>
            <!-- tr = table row / 테이블 줄 구분-->
                <th>제목1</th>
                <!-- th = table head -->
                <th>제목2</th>
            </tr>
        </thead>
        <tbody>
        <!--제목(컬럼)에 해당하는 데이터-->
            <tr>
                <td>데이터1</td>
                <!-- td = table data -->
                <td>데이터2</td>
            </tr>
        </tbody>
    </table>
```
```html
    2) 응용
    <table>
        <thead> 
            <tr>
                <th>제목1</th>
                <th>제목2</th>
                <th>제목3</th>
                <th>제목4</th>
                <th>제목5</th>
            </tr>
        </thead>
        <tbody> 
            <tr>
                <td>데이터1</td>
                <td colspan="2">옆으로 확장</td> 
                <!--열 범위(옆으로 확장)-->
                <td rowspan="2">아래로 확장</td> 
                <!--행 범위(밑으로 확장)-->
                <td>데이터2</td>
            </tr>
            <tr>
                <td>확인용 추가 row</td>
            </tr>
        </tbody>
    </table>
```