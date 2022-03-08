var name = "홍길동"
var age = 20;
// 위 내용을 json으로 표기하면,
var information ={
    name : "홍길동",
    age : 20
};
// json으로 묶어서 서버에 전송한다.
// console.log(information.age);

// json 형식
var dwacademy ={
    students : ['오승택', '류근환', '김보겸', '이인서', '나정수', '정지유', 
    '김민영', '이규성', '이승섭', '이상협', '홍준호', '유영준'],
    students_count : 15,
    teacher : '현상원',
    today : '2022-03-08',
    subject : ['SQL', 'JAVA', 'HTML']
};
// json을 호출할 때는 key 값을 사용해야 한다.
// console.log(dwacademy.students_count);
// json 값 호출
// console.log(dwacademy.students[10]);
// json 배열 호출

// 문제 1. students_count가 15이하면 학생 수 부족, 15 초과면 학생 수 정상

// var count = dwacademy.students_count;
// if(count <= 15){
//     console.log("학생수 부족 : 학생수가 15 이하입니다.")
// }else{
//     console.log("학생수 초과 : 학생수가 15 초과입니다.")
// }

// 문제 2. 학생 중 이 씨가 몇명인가?
// 오답
var temp = 0;
var length = dwacademy.students.length;
for(i=0; i < length; i++){
        if(dwacademy.students[i] == '%이%'){
                // %로 비교하는건 안 됨
                temp++
        }
}
// 정답
var searchWord = '이';
for(var i=0; i < length; i++){
    var firstName = dwacademy.students[i].substring(0,1);
    if(firstName == searchWord){
        temp++
    }
}
console.log(temp);

var array = [2,5,7,8];

var arrayJson = {
    array : [2,5,7,8]
}
console.log(array[1]);
// 와
console.log(arrayJson.array[1]);
// 는 같다.
