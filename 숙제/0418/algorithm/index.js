// 자바스크립트 or 자바 선택해서 풀 것!
// 선택정렬을 이용해서 오름차순으로 정렬해보자.
// 선택정렬 관련해서 서치는 좋지만 코드는 직접 풀어봐요! 과정을 중요시 생각합니다 :)
let array = [9, 6, 7, 3, 5]; 


자바
int[] array = {9, 6, 7, 3, 5};
boolean isChange = false; // 교환할지 안 할지 판단

for(int i=0; i<array.length-1; i++) { // 4회전
    int min = array[i];
    int index = 0; // 최솟값 위치
    for(int j=i+1; j<array.length; j++) {
        int jIndex = array[j];
        if(min > jIndex) {
//				디버깅을 위해서 만들었던 변수를 나중에 통합시켜줌
//				if(min > array[j]) {
            min = jIndex;
//					min = array[j];
            index = j;
            isChange = true; // 최솟값이 있음
        }
    }
    if(isChange) {
        int temp = array[i];
        array[i] = min;
        array[index] = temp;
    }
    if(!isChange) break; // 최솟값이 없다고 판단 정렬되어 있음. break로 for문 중단
}
System.out.println(array[0]);
