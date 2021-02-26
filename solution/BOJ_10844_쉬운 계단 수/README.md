# 10844. 쉬운 계단 수

### classification
* Dynamic programming

### solution
* DP[i][j]는 길이가 i인 수에서 맨 앞의 자리 수가 j일 때 계단 수의 개수
* DP[i][j] = dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]
* 맨 앞자리의 수가 0일 때는 i-1길이의 맨 앞자리수가 1일 때와 같음
* 맨 앞자리의 수가 9일 때는 i-1길이의 맨 앞자리수가 8일 때와 같음
* N번째 행의 모든 수를 합을 출력

### remind
* Dynamic programming

### link
https://www.acmicpc.net/problem/10844