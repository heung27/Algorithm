# 20056. 마법사 상어와 파이어볼

### classification
* Implementation
* Simulation

### solution
* 모든 파이어볼의 좌표를 Queue1에 저장
* 파이어볼의 이동 좌표를 계산하여 Queue2에 저장
* 모든 파이어볼의 이동 좌표를 저장하면 Queue2를 poll하면서 map에 파이어볼 좌표 저장
* map에 파이어볼의 정보와 개수를 저장하고 Queue1에 파이어볼 좌표 저장
* 다시 모든 파이어볼의 이동 좌표를 계산, 이때 파이어볼의 개수가 2개 이상이면 4 방향으로 이동
* 반복

### remind
* Implementation
* Simulation

### link
https://www.acmicpc.net/problem/20056