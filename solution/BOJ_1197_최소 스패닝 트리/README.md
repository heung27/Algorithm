# 1197. 최소 스패닝 트리

### classification
* Graph theory
* MST

### solution
* 크루스칼 알고리즘을 사용하여 해결한다.
* 우선순위 큐에 모든 간선을 삽입한다. 이때 우선순위 큐는 최소 가중치의 간선이 루트이다.
* 유니온 파인드 알고리즘을 사용하여 사이클이 생기는지 검사하면서 V-1개의 간선을 뽑는다.

### link
https://www.acmicpc.net/problem/1197