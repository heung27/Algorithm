# 1865. 웜홀

### classification
* Graph theory
* Bellman–Ford

### solution
* 음수 가중치가 있기 때문에 다익스트라로는 풀 수 없음
* 벨만 포드 알고리즘으로 해결
* 1번 정점을 시작으로 다른 모든 정점까지의 최단 거리를 구함
* 모든 간선들을 탐색하여 distance를 갱신함
* 위의 작업을 N-1번 반복한다면 distance는 무조건 최단거리가 완성이 되어야 함
* 마지막으로 한번 더 모든 간선을 탐색하면서 distance가 갱신되는지 체크
* 만약 갱신되는 거리가 생긴다면 음수 사이클이 발생한 것임
* 이렇게 음수 사이클이 발생한다면 시간이 줄어들면서 출발 위치로 돌아오는 것이 가능함

### link
https://www.acmicpc.net/problem/1865