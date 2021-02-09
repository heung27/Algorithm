# 17471. 게리맨더링

### classification
* Graph theory
* Graph search
* Brute force algorithm

### solution
* A 선거구가 1 ~ N/2 구역을 차지할 수 있는 모든 조합을 탐색
* 이때 A 선거구가 아닌 구역은 B 선거구가 됨
* 각 선거구에 BFS를 적용하여 구역의 수와 sum을 계산함
* BFS가 종료되었는데 구역의 수가 모자라면 그 구역은 모두 연결되어 있지 않은 것
* 어느 한 쪽의 선거구가 모두 연결되어 있지 않으면 두 선거구의 차를 계산하지 않음
* 두 선거구가 모두 연결되어 있으면 sum의 차를 계산하고 answer에 가장 작은 수 저장

### remind
* BFS
* DFS
* Combination

### link
https://www.acmicpc.net/problem/17471