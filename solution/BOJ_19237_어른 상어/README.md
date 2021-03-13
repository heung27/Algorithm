# 19237. 어른 상어

### classification
* Implementation
* Simulation

### solution
* 상어의 번호와 방향, 우선순위를 저장
* 번호순으로 상어 이동 (해당 번호의 우선순위를 이용)
* 이동하려는 곳에 냄새가 없으면 이동
* 냄새가 없어 이동하려는데 상어가 이미 있으면 이동하려는 상어 삭제 (번호 순으로 이동했기 때문)
* 냄새가 없는 곳이 없으면 현재 상어의 냄새가 있는 곳들 중 우선순위가 높은 곳으로 이동
* 상어가 이동하고 나서 배열의 모든 냄새들 지속시간 감소

### remind
* Implementation
* Simulation

### link
https://www.acmicpc.net/problem/19237