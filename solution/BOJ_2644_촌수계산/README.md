# 2644. 촌수계산

### classification
* Graph theory
* Graph search
* BFS
* DFS

### solution
* 부모 배열을 선언하여 각 노드의 부모를 저장
* A와 B의 촌수는 각각 부모를 따라올라가면 만나는 노드에서 A와 B 노드까지의 높이를 더해주면 됨
* 부모 배열을 활용해 A 부모로 따라가올라면서 체크해줌
* 똑같이 B 부모로 따라올라가면서 A가 체크한 노드를 만나면 둘의 높이를 더함

### link
https://www.acmicpc.net/problem/2644