# 2565. 전깃줄

### classification
* Dynamic programming

### solution
* 각 전깃줄의 연결 정보를 배열에 저장하고 오른쪽 숫자 기준으로 오름차순을 정렬
* 왼쪽 숫자들에서 최장 증가 부분 수열을 구함
* 최장 증가 부분 수열을 구하는 알고리즘으로 이분탐색을 사용
* N - 최장 증가 부분 수열의 길이 + 1을 구하면 답이 됨

### link
https://www.acmicpc.net/problem/2565