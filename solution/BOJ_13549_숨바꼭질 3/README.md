# 13549. 숨바꼭질 3

### classification
* Graph theory
* Graph search
* BFS
* Dijkstra algorithm
* 0-1 BFS

### solution
* A의 위치에서 B위치로 가는 연산 (*2, +1, -1)에 대해 BFS (트리의 레벨: 시간)
* 곱하기 2 연산은 시간이 지나지않기 때문에 기본 Queue로는 해결할 수 없음
* 우선순위 큐를 사용해 시간이 짧은 노드부터 탐색하여 해결

### remind
* PriorityQueue
* BFS

### link
https://www.acmicpc.net/problem/13549