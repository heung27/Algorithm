# 16637. 괄호 추가하기

### classification
* Brute force

### solution
* 첫 번째 연산자에 괄호를 치는 경우 두 번째 연산자는 괄호를 칠 수 없음
* 첫 번째 연산자에 괄호를 치지 않는 경우는 두 번째 연산자에 괄호를 칠 수 있기 때문에
* 연산자에 괄호를 치는 경우는 i+2, 치지 않는 경우는 i+1 해주면서 부분집합을 구하고
* 모든 부분집합에 대해 계산하여 최댓값을 구함

### remind
* Subset

### link
https://www.acmicpc.net/problem/16637