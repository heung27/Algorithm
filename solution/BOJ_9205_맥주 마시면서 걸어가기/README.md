# 9205. 맥주 마시면서 걸어가기

### classification
* Graph theory
* Graph search
* BFS
* Floyd–Warshall

### solution
* 상근이네 집(출발점), 편의점, 락 페스티벌(도착점)의 좌표를 저장
* N x N 크기의 2차원 배열을 만들어 각 노드에서 다른 노드와의 거리를 저장
* 거리가 1000이 초과하면 맥주 20병으로 갈 수 없는 거리에 있는 것이기 때문에 MAX.VALUE를 넣어둠
* 플로이드 알고리즘을 적용하여 모든 정점에서 모든 정점으로 갈 수 있는 거리를 계산
* 0행(출발점) N-1열(도착점)의 값이 MAX_VALUE이면 페스티벌까지 갈 수 없는 것이기 때문에 sad 출력
* MAX_VALUE가 아니면 페스티벌까지 갈 수 있는 경로가 있는 것이기 때문에 happy 출력

### remind
* Floyd–Warshall

### link
https://www.acmicpc.net/problem/9205