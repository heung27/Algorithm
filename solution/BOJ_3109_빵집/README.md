# 3109. 빵집

### classification
* Graph theory
* Greedy algorithm
* Graph search
* DFS

### solution
* 입력되는 빵집 근처의 모습 정보를 2차원 배열에 저장
* 맨 왼쪽의 열에서 맨 오른쪽의 열까지 가야하기 때문에 3방향 탐색 (위, 오른쪽, 아래)
* 맨 왼쪽의 첫 번재 행부터 R-1번째 행까지 각 좌표에서 DFS 수행
* DFS를 진행하면서 지나가는 경로는 다시는 가지 않아야함 (갔던 경로는 아는 결과이기 때문) 
* 모든 행에서 DFS를 통해 맨 오른쪽 열에 도착한 개수를 count

### remind
* Greedy algorithm
* DFS

### link
https://www.acmicpc.net/problem/3109