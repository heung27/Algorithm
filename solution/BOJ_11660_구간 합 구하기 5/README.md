# 11660. 구간 합 구하기 5

### classification
* Dynamic programming
* Prefix sum

### solution
* 직사각형의 정보를 입력받으면서 0,0부터 i,j까지의 누적합을 계산
* dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + 현재 칸(i, j)의 값
* (x1, y1)부터 (x2, y2)까지의 합을 구해야 함
* dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1]
* 직사각형의 성질을 이용해 계산

### remind
* DP
* Prefix sum

### link
https://www.acmicpc.net/problem/11660