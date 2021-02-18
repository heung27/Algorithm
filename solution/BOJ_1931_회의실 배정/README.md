# 1931. 회의실 배정

### classification
* Greedy algorithm
* Sort

### solution
* 입력되는 회의실의 시작 시간, 종료 시간을 배열에 저장
* 가장 빨리 종료되는 순서로 정렬
* 종료되는 시간이 같을 경우 빨리 시작하는 순서로 정렬
* 배열의 처음부터 끝까지 탐색을 진행
* (현재 회의실의 종료시간 <= 다음 회의실 시작) 이면 cnt + 1하고 다음 회의실은 현재 회의실이 됨

### remind
* Greedy algorithm
* Sort

### link
https://www.acmicpc.net/problem/1931