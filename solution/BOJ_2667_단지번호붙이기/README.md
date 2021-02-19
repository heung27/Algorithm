# 2667. 단지번호붙이기

### classification
* Graph theory
* Graph search
* BFS
* DFS

### solution
* 입력되는 지도의 정보를 2차원 배열에 저장
* 배열 전체를 탐색하면서 1을 만나면 BFS 진행
* BFS를 진행하면서 거쳐가는 좌표 체크하고 count
* 다시 배열 전체를 탐색 (이미 거쳐갔던 좌표는 건너뜀)
* 탐색이 종료되면 저장했던 count 출력

### remind
* BFS

### link
https://www.acmicpc.net/problem/2667