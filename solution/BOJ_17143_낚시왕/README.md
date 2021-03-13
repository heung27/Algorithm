# 17143. 낚시왕

### classification
* Implementation
* Simulation

### solution
* 먼저 상어들의 속력을 각 ((이동방향의 크기-1) * 2)로 나누어 나머지를 저장
* (이동방향의 크기-1) * 2 만큼 이동하면 이동하기 전의 위치와 같아지기 때문
* 각 상어의 진행 방향으로 1칸씩 속력만큼 이동
* 이동하면서 배열 끝에 닿으면 방향을 반대로 바꿔줌
* 사람이 이동하며 배열의 가장 위에 있는 상어를 제거함

### remind
* Implementation
* Simulation

### link
https://www.acmicpc.net/problem/17143