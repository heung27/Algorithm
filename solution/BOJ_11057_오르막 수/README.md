# 11057. 오르막 수

### classification
* Dynamic Programming

### solution
* [N+1][10] 크기의 배열 선언
* sum을 1로 초기화
* 1행 부터 수를 채워나감
* dp[i][0] = sum (i-1행의 모든 수를 합친 수)
* dp[i][1] ~ dp[i][9] = dp[i][j-1] - dp[i-1][j-1]
* 행의 값들을 채워나가면서 sum에 합산
* N 행까지 반복하고 나면 sum을 출력

### remind
* DP

### link
https://www.acmicpc.net/problem/11057