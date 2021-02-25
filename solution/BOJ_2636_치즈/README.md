# 2636. 치즈

### classification
* Implementation
* Graph theory
* Graph search
* BFS
* Simulation

### solution
* 입력되는 치즈의 위치 정보를 배열에 저장하고 치즈가 차지하고있는 칸의 수를 셈
* (0,0) 좌표(공기가 있는 공간)부터 BFS 진행하면서 치즈를 만나면 해당 좌표는 0으로 만들어주고 치즈의 수 감소
* 치즈의 수가 0이 될 때까지 BFS 반복하고 0이 되면 반복한 횟수를 출력

### remind
* BFS
* Simulation

### link
https://www.acmicpc.net/problem/2636