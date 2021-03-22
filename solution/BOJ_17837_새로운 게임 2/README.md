# 17837. 새로운 게임 2

### classification
* Implementation
* Simulation

### solution
* 2차원 ArrayList 배열을 만들어주고 색깔을 저장
* 체스판의 말들의 좌표를 저장
* 말들을 순서대로 움직이면서 진행
* 다음 좌표가 파란색이면 방향을 반대로 바꿔주고 이동 시도
* 다음 좌표가 빨간색이면 현재 위치의 ArrayList 맨 뒤에서 부터 탐색
* 이동하는 말의 번호가 나올 때까지 다음 좌표에 add, 현재 좌표는 remove
* 다음 좌표가 흰색이면 ArrayList의 맨 앞에서 부터 탐색
* 이동하는 말의 번호가 나오고 부터 마지막까지 다음 좌표에 add, 현재 좌표에서 remove
* 현재 좌표의 ArrayList 사이즈가 4 이상이면 종료

### remind
* Implementation
* Simulation

### link
https://www.acmicpc.net/problem/17837