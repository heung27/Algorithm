# 1238. 파티

### classification
* Graph theory
* Dijkstra

### solution
* 다익스트라 알고리즘을 사용하여 해결
* A노드에서 B노드까지 가는 가중치를 인접 리스트로 저장
* X노드에서 모든 노드까지 가는 최단거리를 구함 (dist1)
* B노드에서 A노드까지 가는 가중치를 인접 리스트로 저장
* 여기서 실제로 B노드에서 A노드까지 가는 것이 아니라 B노드가 A노드로부터 X의 가중치로 들어온다는 것을 의미
* 마찬가지로 다익스트라를 통해 최단거리를 구함 (dist2)
* dist1[i] + dist2[i]의 최솟값을 구함

### link
https://www.acmicpc.net/problem/1238