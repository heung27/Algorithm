# 16918. 봄버맨

### classification
* Implementation
* Graph theory
* Graph search
* BFS

### solution
* 2차원 배열을 두 개 선언해서 맵 정보를 저장
* N초가 짝수일 때는 폭탄을 전부 채웠을 때이기 때문에 폭탄을 전부 채워 출력
* map1의 폭탄들을 보고 map2에서 터트려주고 map1은 폭탄을 전부 채워줌
* map2의 폭탄들을 보고 map1에서 터트려주고 map2은 폭탄을 전부 채워줌
* 반복
* (N/2)가 짝수이면 map1 출력, 홀수이면 map2 출력

### remind
* Implementation
* BFS

### link
https://www.acmicpc.net/problem/16918