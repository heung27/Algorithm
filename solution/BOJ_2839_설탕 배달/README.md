# 2839. 설탕 배달

### classification
* Math
* Dynamic programming
* Greedy algorithm

### solution
* 그리디로도 풀 수 있지만 DP로 해결
* 1차원 배열 선언 (DP) N이 3이상이기 때문에 배열의 사이즈는 N+3으로 선언
* 3번째, 5번째 인덱스는 1로 초기화 (3킬로그램 1개, 5킬로그램 1개)
* 인덱스 6부터 N+1까지 반복하면서 i-3이 0이 아닐때 dp[i] = dp[i-3]+1,  i-5이 0이 아닐때 dp[i] = dp[i-5]+1
* DP[N]이 0이면 -1, 0이 아니면 그 값 출력 

### remind
* DP

### link
https://www.acmicpc.net/problem/2839