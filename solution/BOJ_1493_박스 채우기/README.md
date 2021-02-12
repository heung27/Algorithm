# 1493. 박스 채우기

### classification
* Math
* Greedy algorithm
* Divide and conquer

### solution
* 먼저 입력된 큐브 데이터들을 큰 순서로 정렬해줌
* 큰 큐브부터 탐색을 진행
* pre_div 변수에 전에 들어갔던 큐브 부피를 저장 (초기 0)
* 전체 상자의 부피에서 현재 큐브가 얼만큼 들어갈 수 있는지 계산을 하고 전에 들어갔던 큐브의 부피를 빼주어야 함
* 전체 상자의 크기 len, width, height에 쉬프트 연산자(>>)를 사용해서 2^x을 나누어 주고 이 값들을 곱하면 몇 개의 큐브가 들어갈 수 있는지 계산 됨
* 계산된 값에 pre_div를 빼줌
* 현재 큐브의 개수와 상자에 들어갈 수 있는 큐브의 개수 중 작은 값을 count에 더함
* 전에 들어갔던 큐브 부피(pre_div)에 지금 들어가는 큐브 부피를 더해줌
* 1x1 큐브의 까지 반복
* 반복문이 종료되고 나면 pre_div는 가능한 모든 큐브가 들어간 부피가 됨
* 만약 pre_div가 전체 상자의 부피와 같다면 count를 출력
* 다르면 가지고 있는 큐브로 상자를 채울 수 없는 것으로 판단하여 -1 출력

### remind
* Divide and conquer
* Greedy algorithm
* Sort

### link
https://www.acmicpc.net/problem/1493