# 19238. 스타트 택시

### classification
* Implementation
* Graph theory
* Graph search
* BFS
* Simulation

### solution
* map의 출발지의 좌표에 승객의 번호를 저장해 놓고, 도착지의 좌표들을 따로 배열에 저장해 놓음
* BFS를 진행하면서 출발지를 만나면 오는데 걸린 이동거리와 연료량을 비교
* 이동거리가 같은 승객이 여러 명이면 왼쪽 위의 승객을 선택해야 하기 때문에 BFS 트리의 같은 레벨을 전부 봐야 함
* 비교하여 연료량이 0이상이면 그 좌표부터 다시 BFS를 진행하면서 도착지까지 탐색
* 도착지에 도착하면 다시 연료량 비교하여 0이상이면 이동거리 만큼 더해줌
* 반복

### remind
* Implementation
* Simulation
* BFS

### link
https://www.acmicpc.net/problem/19238