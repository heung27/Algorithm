# 11726. 2xN 타일링

### classification
* Dynamic programming

### solution
* DP로 해결
* 2xi 크기의 직사각형을 2x1, 1x2 타일로 채우는 방법은
* 2x(i-2) 직사각형을 채우는 방법의 수 + 2x(i-1) 직사각형을 채우는 방법의 수
* dp[i] = dp[i-2] + dp[i-1]

### remind
* Dynamic programming

### link
https://www.acmicpc.net/problem/11726