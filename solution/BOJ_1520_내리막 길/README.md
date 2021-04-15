# 1520. 내리막 길

### classification
* Dynamic programming
* Graph theory

### solution
* BFS와 DP를 사용하여 해결
* DP 배열에 각 지점에서의 경로 수를 저장
* 시작점부터 BFS를 진행하면서 현재 위치에서 갈 수 있는 위치에 현재 위치의 경로수를 더해줌
* BFS에 우선순위 큐를 사용하여 높이가 가장 큰 좌표부터 BFS 진행

### link
https://www.acmicpc.net/problem/1520