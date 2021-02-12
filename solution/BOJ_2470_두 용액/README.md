# 2470. 두 용액

### classification
* Binary Search
* Two Pointers

### solution
* 입력받는 용액의 정보들을 배열에 저장
* 용액을 오른차순으로 정렬
* 먼저 맨 앞의 용액과 맨 뒤의 용액을 혼합했을 때 특성값을 구함
* 특성값이 음수면 왼쪽 인덱스 1 증가
* 특성값이 양수면 오른쪽 인덱스 1 감소
* 특성값이 0이거나 왼쪽 인덱스가 오른쪽 인덱스와 같아지면 종료
* 위의 과정을 반복하면서 특성값의 절대값이 가장 낮은 값을 찾고 이때의 두 용액을 저장

### remind
* Binary Search
* Two Pointers

### link
https://www.acmicpc.net/problem/2470