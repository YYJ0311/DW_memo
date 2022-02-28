// 자바 print
// System.out.println("Hello World");
// 자바스크립트 print
console.log('Hello World')
// 자바스크립트는 '와 " 구분 안 함. 세미콜론도 필수 아님 but 권장
var x = 10;
var y = '안녕하세요';
console.log('x의 값은? ' + x);
console.log('y의 값은? ' + y);

var num = 10;
var num2 = 20;
var result = num+num2;
console.log(result);

if(result == 30){
    console.log('30 입니다')
}

var x2 = '글자';
var result2 = num+x2;
console.log(result2)

for(var i=0; i<10; i++){
    console.log(i)
}

for(var i=0; i<=10; i++){
    if(i%2 == 0){
        console.log(i)
    }
}

for(var i=0; i<6; i++){
    console.log('*'.repeat(i+1))
}