# 2629. 양팔저울

### classification
* Dynamic programming
* Knapsack

### solution
* 추를 오른쪽에 올려놓는 경우, 왼쪽에 올려놓는 경우, 올려놓지 않는 경우를 모두 탐색
* 2차원 방문처리를 통해 시간 초과를 방지하는것이 포인트
* 같은 cnt에서 같은 sum이 나오면 중복이기 때문에 보지않아야 함

### link
https://www.acmicpc.net/problem/2629