# 1707. 이분 그래프

### classification
* Graph theory
* Graph search
* BFS

### solution
* 노드들의 연결 정보를 저장
* 그래프의 한 노드부터 DFS를 진행하면서 1, -1을 번갈아 가면서 저장
* 다음 노드가 이미 방문한 적 있으면 (싸이클이 생기면) 다음 노드의 색(1 or -1)을 확인
* 현재 저장하려는 색과 다음 노드의 색이 다르면 이분 그래프가 아님
* 그래프는 연결그래프가 아닐 수 있기 때문에 모든 연결그래프를 검사

### remind
* DFS
* BFS

### link
https://www.acmicpc.net/problem/1707