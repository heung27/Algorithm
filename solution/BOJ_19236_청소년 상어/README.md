# 19236. 청소년 상어

### classification
* Implementation
* Simulation
* Backtracking

### solution
* 물고기들의 좌표와 방향을 배열에 저장해 놓고 map에 물고기 번호 저장
* 물고기 배열을 활용해 모든 물고기 이동 (8 방향 배열 사용)
* 상어의 좌표에서 보고 있는 방향으로 갈 수 있는 모든 칸에 대해 DFS 진행 (모든 경우의 수를 탐색)
* 상어가 이동했으면 다시 물고기 이동
* 상어가 더 이상 이동할 수 없을 때까지 반복하며 최댓값을 구함

### remind
* Implementation
* Simulation
* Backtracking

### link
https://www.acmicpc.net/problem/19236