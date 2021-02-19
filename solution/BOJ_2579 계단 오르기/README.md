# 2579. 계단 오르기

### classification
* Dynamic programming

### solution
* 입력되는 계단의 정보를 배열에 저장
* 현재 계단까지 올라오면서 얻을 수 있는 총 점수의 최댓값을 저장하는 dp 배열 선언
* 현재 계단까지 올라오는 경우는 두 가지 (1칸 또는 2칸 뛰어 올라오는 것)
* 따라서 dp[i]는 dp[i-3]+한 계단 아래의 값과 dp[i-2 중 큰 값에 현재 계단의 값을 더한 것

### remind
* DP

### link
https://www.acmicpc.net/problem/2579