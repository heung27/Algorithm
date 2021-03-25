# 17822. 원판 돌리기

### classification
* Implementation
* Simulation

### solution
* 각각의 원판의 top을 0으로 주고 k만큼 회전시키면 top은 +k가 됨
* 다시 각각의 top부터 모든 방향을 배열에 복사하면 회전시킨 모양이 됨
* 아래와 옆의 숫자를 비교하여 같은 수면 둘 다 0으로 만들어 줌
* 같은 수가 하나도 없으면 전체 배열을 돌며 증감연산
* 반복

### remind
* Implementation
* Simulation

### link
https://www.acmicpc.net/problem/17822