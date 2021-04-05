# 1726. 로봇

### classification
* Graph theory
* Graph search
* BFS

### solution
* 출발지점에서 도착지점까지 4방위 BFS 진행
* BFS의 각 노드에 로봇의 방향과 연산 횟수를 저장
* 방향이 바뀌거나 같은 방향으로 3번 움직였으면 연산횟수+1
* 도착점에 도착하는 모든 경우에서 최소 연산횟수를 구함
* map에 연산 횟수를 저장하여 재방문 처리를 해줌
* 재방문 처리가 포인트인 문제

### remind
* BFS

### link
https://www.acmicpc.net/problem/1726