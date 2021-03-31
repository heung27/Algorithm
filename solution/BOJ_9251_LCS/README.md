# 9251. LCS

### classification
* Dynamic programming

### solution
* LCS 알고리즘 사용
* 두 문자열의 문자들을 각각 비교
* 두 문자가 같으면 dp[i-1][j-1] + 1
* 두 문자가 다르면 dp[i-1][j]와 dp[i][j-1] 중 큰 값 선택

### remind
* Dynamic programming

### link
https://www.acmicpc.net/problem/9251