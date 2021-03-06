# 1446. 지름길

### classification
* Graph theory
* Dijkstra

### solution
* DP를 사용해 해결
* 출발지부터 도착지까지의 모든 거리에 대해 최솟값을 저장
* 현재 위치가 지름길이 시작하는 위치라면 지름길의 끝나는 위치의 값을 갱신
* 이전 위치의 +1한 값과 이전에 계산된 값(지름길)과 비교하여 작은 값 저장

### remind
* DP

### link
https://www.acmicpc.net/problem/1446