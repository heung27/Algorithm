# 1629. 곱셈

### classification
* Math
* Power using division and conquest

### solution
* 거듭제곱을 단순하게 * 연산으로 계산하면 시간 초과 또는 메모리 초과가 날 수 있음
* 분할 정복을 적용해 해결
* B가 짝수 일 때 : A^B = A^(B/2) * A^(B/2) 
* B가 홀수 일 때 : A^B = A^(B/2) * A^(B/2) * A
* 재귀를 통해 구하고자 하는 수를 위의 방정식과 같이 계속 분할하여 계산
* 분할하여 계산된 결과를 상위 문제에 다시 적용하여 최종적으로 구하고자 하는 A^B 계산
* 문제는 C로 나눈 나머지를 구하는 것이기 때문에 계산을 할 때 마다 % C를 해줘야 함

### remind
* Divide and conquer

### link
https://www.acmicpc.net/problem/1629