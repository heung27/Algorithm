# 15683. 감시

### classification
* Implementation
* Brute force
* Simulation

### solution
* 입력되는 사무실의 정보를 배열에 저장하고 카메라의 좌표를 리스트에 add하고 벽이 아닌 칸의 개수를 셈
* 1번 ~ 5번 카메라의 감시하는 동작을 구현
* 해당 카메라의 좌표부터 감시하는 방향으로 벽이 나오거나 범위를 벗어날 때까지 이동하며 체크하고 개수를 셈
* 이동이 끝났으면 cnt를 1증가 시키고 sum에 이동 횟수(감시되는 칸 수)를 더하고 DFS
* cnt 가  카메라의 개수와 같아지면 sum(감시되는 칸 수)가 max보다 크면 max에 대입
* max는 최대로 많이 감시할 수 있는 칸 수이기 때문에 세두었던 빈공간의 수에 이를 빼준 결과를 출력

### remind
* Implementation
* Brute force
* DFS

### link
https://www.acmicpc.net/problem/15683