# 1261_알고스팟

### classification
* Graph theory
* Dijkstra
* 0-1 BFS

### solution
* Queue 두 개를 사용
* (0,0)부터 인접한 0의 그룹을 찾는 BFS 진행 (Queue1 사용)
* BFS가 진행되면서 1을 만나면 1의 좌표를 Queue2에 저장
* BFS가 끝나면 Queue2에 저장되어 있던 1의 좌표를 꺼내어 인접한 0을 찾아 Queue1에 저장 (벽을 깸)
* 다시 Queue1을 이용해 BFS 진행
* 도착지점까지 반복

### remind
* BFS

### link
https://www.acmicpc.net/problem/1261