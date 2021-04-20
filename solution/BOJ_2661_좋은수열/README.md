# 2661. 좋은수열

### classification
* Backtracking

### solution
* 각 문자열 뒤에 1, 2, 3이 붙는 모든 경우에 대해 DFS를 진행
* 현재 문자열이 좋은 수열인지 나쁜 수열인지 판단해야 함
* 비교할 문자열 길이를 1부터 늘려가면서 뒤쪽 문자열을 비교
* 비교할 위치를 기억하는 index, temp 변수를 선언하여 두 위치를 비교함
* 두 문자열이 같은 경우가 있는지 확인

### link
https://www.acmicpc.net/problem/2661