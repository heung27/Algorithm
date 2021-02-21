# 2615. 오목

### classification
* Implementation
* Brute force algorithm

### solution
* 전에 풀어봤던 문제지만 더 깔끔하게 다시 품
* 입력되는 오목판의 정보를 2차원 배열에 저장
* 방향 배열을 선언하여 오른쪽 위 대각선, 오른쪽, 오른쪽 아래 대각선, 아래 4방향을 탐색
* 배열의 모든 좌표에서 4방향 탐색을 진행하는데 진행 방향의 반대 방향으로 한 칸 뒤에 현재 오목알과 동일한 오목알이 있으면 continue  
* 탐색을 진행하며 동일한 색깔의 오목알을 세어 5개가 나오면 종료하고 출력
* 끝까지 나오지 않으면 0 출력

### remind
* Implementation

### link
https://www.acmicpc.net/problem/2615