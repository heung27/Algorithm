# 12851. 숨바꼭질 2

### classification
* Graph theory
* Graph search
* BFS

### solution 
* 세 위치(-1, +1, *2) BFS
* BFS 트리의 레벨을 계산하여 시간 계산
* poll 하면서 넣어둔 시간을 체크하여 다음 레벨에서 다시 탐색하지 않게 함
* 처음 동생을 찾았을 때 현재 레벨의 노드만 탐색하여 동생을 찾는 방법의 수 계산

### remind
* BFS using the queue
* Height of the tree

### link
https://www.acmicpc.net/problem/12851