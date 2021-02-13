# 9252. LCS 2

### classification
* Dynamic Programming
* String

### solution
* 각 문자열의 길이+1 만큼 2차원 배열(DP)을 선언
* 인덱스 1은 문자열의 첫 번째 문자를 의미함
* (1,1) 부터 탐색을 진행
* 문자열 A의 i 번째 문자와 문자열 B의 j 번째 문자가 같으면 DP[i-1][j-1] <- DP[i-1][j-1] + 1
* 다르면 해당 좌표의 위쪽과 왼쪽의 값 중 큰 값을 저장
* 반복하면 DP의 마지막 인덱스의 값이 최장 공통 부분 수열의 길이가 됨
* 마지막 인덱스부터 거꾸로 위, 왼쪽으로 올라가면서 숫자가 바뀌는 모서리 부분의 인덱스가 최장 공통 부분 수열이 됨

### remind
* LCS algorithm
* DP

### link
https://www.acmicpc.net/problem/9252