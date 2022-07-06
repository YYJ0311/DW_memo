```javascript
var javaList = '${javaList}'; // jstl 데이터
var test1 = fn_javaListToJson(javaList);

console.log("fn_javaListToJson : ", test1 ); // jstl에서 변환된 json 출력

function fn_javaListToJson(obj){
	var resultJson = [];
	var str = obj.split('[{').join('').split('}]').join(''); //양끝 문자열 제거
	var rows = str.split('}, {'); //str는 배열
	for(var i = 0; rows.length > i; i++){ // rows 배열만큼 for돌림
		var cols = rows[i].split(', ');
		var rowData = {};	
		for(var j = 0; cols.length > j; j++){
			var colData = cols[j].trim();
			
			var key = colData.substring(0, colData.indexOf("="));
			var val = colData.substring(colData.indexOf("=") +1);
			rowData[key] = val;
		}
		resultJson.push(rowData);
	}
	return resultJson;
}
출처: https://toyuq.tistory.com/310 [Goni:티스토리]
```