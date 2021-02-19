# 16236. 아기상어

### classification
* Graph theory
* Graph search
* BFS
* Simulation

### solution
* 입력되는 공간의 정보를 2차원 배열에 저장하고 아기상어의 좌표를 기억
* 아기상어의 좌표부터 BFS 진행
* BFS를 진행하면서 지나온 거리를 트리의 레벨로 계산
* 같은 거리 내의 물고기들을 전부 탐색하여 가장 위, 가장 왼쪽에 있는 물고기의 위치가 상어의 위치가 됨
* 물고기를 먹은 수를 count하고 상어의 크기에 변화를 줌
* 더이상 먹을 물고기가 없을 때까지 상어의 좌표에서 BFS 반복
* BFS를 진행하면서 총 움직인 거리 계산

### remind
* BFS
* Simulation

### link
https://www.acmicpc.net/problem/16236