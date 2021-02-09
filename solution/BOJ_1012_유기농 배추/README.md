# 1012. 유기농 배추

### classification
* Graph theory
* Graph search
* DFS
* BFS

### solution
* 2차원 boolean배열을 선언
* 입력받으면서 배추의 위치에 true로 표시
* 배추가 위치한 곳부터 4방위 BFS 실행
* BFS를 진행하면서 이동된 위치는 false로 만들어줌
* 전체 배열을 탐색하면서 true를 만나면 count++

### remind
* BFS

### link
https://www.acmicpc.net/problem/1012