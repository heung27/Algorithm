# 1493. 수의 새로운 연산

### solution
* 입력받은 두 개의 숫자를 좌표로 변환
* temp를 1로 초기화하고 +2, +3, +4.. 1씩 증가되는 값(add)을 더해주면서 숫자가 temp보다 작거나 같을 때까지 반복
* 숫자가 temp 보다 작으면 그 차이를 구함 (diff)
* 숫자의 x좌표는 add-diff, y좌표는 diff+1
* 두 숫자의 자표를 더하고 이 좌표를 숫자로 변환

### remind
* Math
* Greedy algorithm

### link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV2b-QGqADMBBASw