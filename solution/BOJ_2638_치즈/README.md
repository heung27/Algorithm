# 2638. 치즈

### classification
* Implementation
* Graph theory
* Graph search
* BFS
* DFS
* Simulation

### solution
* 0,0은 항상 치즈가 없는 자리이기 때문에 0,0부터 BFS 진행 (모든 외부 공기의 위치 탐색)
* BFS를 진행하면서 치즈를 만나면 그 치즈가 공기에 닿는 횟수 카운트
* BFS가 종료되면 공기에 2면 이상 닿았던 치즈를 제거해 줌
* 반복

### remind
* Simulation
* BFS

### link
https://www.acmicpc.net/problem/2638