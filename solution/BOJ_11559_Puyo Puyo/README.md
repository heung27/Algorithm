# 11559. Puyo Puyo

### classification
* Implementation
* Graph theory
* Graph search
* BFS

### solution
* 입력되는 필드의 정보를 2차원 배열에 저장
* 맨 아래(마지막 행)부터 탐색을 진행하면서 '.'가 아닌 색깔이 나왔을 때 BFS 연산
* BFS가 진행되면서 몇 개의 뿌요들이 근접해 있는지 count하면서 좌표를 리스트에 저장하고 해당 좌표를 '.'로 만들어 줌
* count가 4개 이상이면 true를 리턴
* 4개 미만이면 리스트에 저장했던 뿌요 좌표들을 get하여 '.'를 처음 색깔로 돌려놓음
* 2차원 배열 전체를 탐색하고 나서 BFS가 true(터짐이 한번이라도 있으면)이었으면 연쇄 수를 1 증가시키고 공중에 떠있는 뿌요들을 아래로 내려줌
* 한번도 터지지않을 때까지 다시 처음부터 탐색 반복

### remind
* Implementation
* BFS

### link
https://www.acmicpc.net/problem/11559