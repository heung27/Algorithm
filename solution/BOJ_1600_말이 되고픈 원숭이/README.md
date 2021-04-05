# 1600. 말이 되고픈 원숭이

### classification
* Graph theory
* Graph search
* BFS

### solution
* 원숭이의 좌표에서 부터 4방향, 8방향으로 BFS 진행
* BFS의 각 노드에 K값을 저장
* 8방향으로 이동할 때는 K값을 감소시킴
* map에 도착하는 노드의 K값을 저장
* K값이 map의 값보다 큰 경우에만 재방문 허용

### remind
* BFS

### link
https://www.acmicpc.net/problem/1600