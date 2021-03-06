# 1744. 수 묶기

### classification
* Greedy algorithm
* Sort

### solution
* 가장 큰 수가 되기 위해서는 절대값이 가장 큰 것들끼리 곱셈을 해야함
* 음수는 음수끼리 곱하여 양수로 만들어줌 (0은 음수 쪽으로 삽입)
* 수열을 음수 집합과 양수 집합으로 나누고 각각 절대값이 큰 순서로 정렬
* 1은 곱하면 손해기 때문에 1은 숫자만 세줌
* 두 개씩 곱하고 홀수면 나머지 하나를 더해줌

### remind
* Greedy algorithm
* Sort

### link
https://www.acmicpc.net/problem/1744