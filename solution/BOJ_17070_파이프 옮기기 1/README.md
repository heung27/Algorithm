# 17070. 파이프 옮기기 1

### classification
* Dynamic programming
* Graph theory
* Graph search

### solution
* 입력되는 집의 상태를 2차원 배열에 저장
* 현재 파이프의 상태를 저장하는 변수를 선언 (0: 가로, 1: 세로, 2: 대각선)
* (1,2) 부터 DFS를 진행
* 파이프가 오른쪽으로 이동했을 때는 0으로, 아래로 이동했을 때는 1로, 대각선으로 이동했을 때는 2로 파이프의 상태 변경
* 파이프의 상태에 따라 이동할 수 있는 모든 방향 탐색
* 파이프의 끝이 (N, N)에 도착하는 횟수 카운트

### remind
* Implementation
* DFS

### link
https://www.acmicpc.net/problem/17070