// JSON : 데이터 형식(단순히 데이터를 표시하는 표현방법)

var information = {
    "name" : "YOO YOUNGJOON",
    "age" : 30,
    "address" : "대전 대전로542번길",
    "isMarri" : false
    // 데이터타입이 boolean형일 때 변수이름을 is + ~로 적는다!
}; 
// information이라는 변수를 서버에 전송함. 
// 괄호 안의 데이터에서 왼쪽에 있는 name, age, address, isMerri 같은 것들을 Key
// 오른쪽에 오는 것들을 Value라고 한다.

// 주의점!
//  1. Key는 중복 불가능, Value는 중복 가능
//  2. Value에 정수형(int, double), 문자형(string), boolean형, 배열형(array), null이 온다.
//  3. 중괄호로 감싼다.

// console.log(information);
//json 전체 출력

// console.log(information.address);
// 특정 value를 출력

// var age = information.age
// // 아래의 식을 출력하려면 변수 age를 지정해줘야 한다!
// if(age >= 30){
//     console.log('30 이상입니다')
// }else{
//     console.log('30 미만입니다.')
// }

const PI = 3.14;
var array = [1,3,4,5,10];
// console.log(array[0]);

// 짝수 출력하기 1번
var len = array.length;
for(i=0; i<len; i++){
    if(array[i]%2==0){
        console.log(array[i]+" 는 짝수입니다.")
    }
}
// 짝구 출력하기 2번
const EVEN = 2;
for(var i=0; i<len; i++){
    var value = array[i];
    if((value%EVEN)==0){
        console.log(value+" 는 짝수입니다.");
    }
}

// 최대값 구하기
var temp = 0;
for(var i=0; i<len; i++){
    if(temp < array[i]){
        temp = array[i]
    }
}
console.log("array의 최대값은 " + temp);
