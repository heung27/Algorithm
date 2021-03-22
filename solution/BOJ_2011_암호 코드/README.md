# 2011. 암호 코드

### classification
* Dynamic programming

### solution
* 문자열의 맨 뒤부터 DP 진행
* 한 개의 숫자를 가지고 문자를 만들 경우와 두 개의 숫자를 가지고 문자를 만들 경우를 나누어 계산
* 0 처리가 중요한 포인트
* i의 숫자 하나를 가지고 문자를 만드려고할 경우 i+1이 0이면 불가능
* i와 i+1 두 개의 숫자를 가지고 문자를 만드려고 할 경우 i가 0이면 불가능
* 두 개의 숫자가 26이 넘으면 불가능


### remind
* Dynamic programming

### link
https://www.acmicpc.net/problem/2011