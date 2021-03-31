# 1932. 정수 삼각형

### classification
* Dynamic programming

### solution
* DP로 해결
* 삼각형의 각 부분까지의 최댓값을 구함
* dp[i][j] = dp[i-1][j-1]와 dp[i-1][j] 중 큰 값 + 현재 숫자
* 맨 아래 줄에서 가장 큰 값이 결과값이 됨

### remind
* Dynamic programming

### link
https://www.acmicpc.net/problem/1932