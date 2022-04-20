// 자바스크립트 or 자바 선택해서 풀 것!
// 버블정렬을 이용하여 오름차순으로 정렬하고 총 몇회전 했는지 알아내시오.
let array = [1, 10, 4, 3, 5];
let count = 0; //총 몇회전 했는지 알아내는 변수
// let temp = [];
// for (var i = 0; i < array.length; i++) {
//   for (var j = 0; j < array.length - 1; j++) {
//     if (array[i] < array[j]) {
//       temp = array[i];
//       array[i] = array[j];
//       array[j] = temp;
//     }
//     count++;
//   }
// }
// console.log(array);
// console.log(count);

// Solution
// isSwap = null;

// let, var 차이점
// var는 중복이 허용되지만 let은 허용 안 됨
// var name = "youngjoon";
// var name = "youngjoon";
// 중복 가능
// let name = "youngjoon";
// let name = "youngjoon";
// 중복 X

let len = array.length;
let isSwap = null;
// let isSwap = false;
for (let i = len; i >0 ; i--) {
    // i는 len부터 체크해서 하나씩 줄여간다
    for (let j = 0; j < (i-1); j++) {
      let temp = 0;
      if(array[j]>array[j+1]){
        temp = array[j];
        array[j] = array[j+1];
        array[j+i] = temp;
        ++count
        isSwap = true;
      }
    }
    if(!isSwap) break;
}
console.log(array);
console.log(count);

// function bubbleResult(array){
//   let len = array.length;
//   let isSwap = null;
//   for(let i = len; i > 0; i--){
//       isSwap = false;
//       for(let j=0; j < (i-1); j++){
//           let tmp=0;
//           if(array[j]>array[j+1]){
//               tmp = array[j];
//               array[j]=array[j+1];
//               array[j+1]=tmp;
//               count++;
//               isSwap = true;
//           }    
//       }
//       if(!isSwap) break; // for문 닫기
//   }
//   return array;
// }
// var array2 = bubbleResult(array);
// console.log(array2);
// console.log(count);