# 14503. 로봇 청소기

### classification
* Implementation
* Simulation

### solution
* 단순하게 문제에 나온 조건을 구현하는 문제
* 방향 인덱스를 두고 -1을 하면서 왼쪽 방향으로 회전
* 해당 공간을 청소하면 map에 -1을 찍어두고 청소한 칸 수 카운트
* 네 방향이 모두 -1이거나 1이면 뒤로 후퇴
* 뒤로 후퇴하려는데 뒤가 1이면 종료

### remind
* Implementation
* Simulation

### link
https://www.acmicpc.net/problem/14503