# 11725. 트리의 부모 찾기

### classification
* Graph theory
* Graph search
* Tree
* DFS
* BFS

### solution
* ArrayList 배열을 생성
* x노드와 y노드의 연결 정보 저장
* x번째 ArrayList에 y add
* y번째 ArrayList에 x add
* ArrayList 배열을 활용하여 BFS 진행
* 1번 노드(루트)에서 부터 탐색을 진행하면서, 다음 노드의 부모는 이전 노드가 되고 이를 저장
* BFS가 종료되면 저장한 부모 노드 정보 출력

### remind
* Tree
* BFS

### link
https://www.acmicpc.net/problem/11725