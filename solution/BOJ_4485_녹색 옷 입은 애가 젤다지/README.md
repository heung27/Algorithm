# 4485. 녹색 옷 입은 애가 젤다지?

### classification
* Graph theory
* Dijkstra

### solution
* 우선순위 큐를 활용하여 다익스트라를 구현
* 상하좌우를 보면서 현재 까지의 비용과 이동할 위치의 비용을 더하여 우선순위 큐에 삽입
* 비용이 작은 것부터 큐에서 poll하여 다시 진행
* 동굴의 끝에 도착하면 현재까지의 비용 출력

### link
https://www.acmicpc.net/problem/4485