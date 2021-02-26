# 14501. 퇴사

### classification
* Dynamic programming
* Brute force

### solution
* 입력되는 상담의 정보를 배열에 저장
* 1차원의 dp배열 선언 (해당 날짜에서 받을 수 있는 최대 금액 저장)
* dp[k]는 해당 날짜에서부터 전 날짜를 모두 보면서 그 날짜에 상담을 하고,
* 현재 날짜에 상담을 할 수 있는 날짜 중 가장 금액이 큰 값 + 현재 날짜의 금액
* 이전 날짜에서 상담을 완료하는 날이 N+1보다 크면 그 날짜는 보지않음

### remind
* Dynamic programming

### link
https://www.acmicpc.net/problem/14501