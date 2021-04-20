# 16197. 두 동전

### classification
* Graph theory
* Graph search
* BFS
* Backtracking

### solution
* 두 동전의 위치를 기억
* 4방위 BFS를 진행하면서 한 칸씩 전진
* 4차원 boolean 배열[x1][y1][x2][y2]을 활용하여 좌표의 재방문 체크
* 다음 칸이 '#'일 경우 움직이지 않음
* 두 동전 중 한 개만 범위 밖으로 나갈 때까지 반복

### link
https://www.acmicpc.net/problem/16197