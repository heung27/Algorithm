# 1463. 1로 만들기

### classification
* Dynamic programming

### solution
* /2, /3, -1 세 가지 연산에 대해 DP를 적용
* 2부터 N까지 1로 만드데 필요한 횟수를 저장함
* n이 6으로 나누어 지면 dp[n/2], dp[n/3], dp[i-1] 중 작은 값+1을 저장 (2와 3의 최소공배수)
* n이 3으로 나뉘어 지면 dp[n/3]와 dp[n-1] 중 작은 값+1
* n이 2으로 나뉘어 지면 dp[n/2]와 dp[n-1] 중 작은 값+1
* 나머지 경우는 dp[n-1] + 1

### remind
* Dynamic programming

### link
https://www.acmicpc.net/problem/1463