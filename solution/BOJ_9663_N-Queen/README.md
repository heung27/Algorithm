# 9663. N-Queen

### classification
* Brute force algorithm
* Backtracking

### solution
* (0,0)에 퀸을 놓고 다음 퀸을 놓을 수 있는 자리 DFS
* 퀸을 놓을 때 마다  8개의 방향 체크
* N개가 놓였으면 백트래킹
** 2차원 배열을 사용하지 않고 3개의 1차원 배열(세로1, 대각선2)을 사용하여 해결 가능

### remind
* DFS
* Check eight directions

### link
https://www.acmicpc.net/problem/9663