# 13460. 구슬 탈출 2

### classification
* Implementation
* Graph theory
* Graph search
* BFS

### solution
* 빨간 구슬과 파란 구슬, 구멍의 좌표를 저장
* 빨간 구슬과 파란 구슬의 좌표를 Queue에 저장하여 4 방향에 대한 BFS 진행
* 각 구슬은 '#' 또는 'O'가 나올 때까지 이동
* 빨간 구슬과 파란 구슬이 둘 다 'O'에 도착하면 건너뜀
* 빨간 구슬과 파란 구슬의 좌표가 같으면 이동 횟수가 많은 구슬이 반대 방향으로 1칸 이동
* 빨간 구슬과 파란 구슬의 좌표가 같지 않을 때 빨간 구슬이 구멍에 도착하면 true, 파란 구슬이 구멍이 도착하면 continue

### remind
* 

### link
https://www.acmicpc.net/problem/13460