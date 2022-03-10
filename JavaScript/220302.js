
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
