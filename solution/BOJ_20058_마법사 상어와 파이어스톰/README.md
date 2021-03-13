# 20058. 마법사 상어와 파이어스톰

### classification
* Implementation
* Simulation

### solution
* 분할정복. 각 큰 사각형을 4개로 나누어 배열 돌리기
* 모든 배열을 탐색하면서 인접한 4개의 칸 중 얼음이 없는 칸이 2개 이상 있으면 현재 칸의 얼음 수 감소
* Q만큼 반복하고 배열의 얼음이 있는 칸에서 BFS를 진행하여 얼음 덩어리의 최대 크기를 구함

### remind
* Implementation
* Simulation
* Divide and Conquer

### link
https://www.acmicpc.net/problem/20058