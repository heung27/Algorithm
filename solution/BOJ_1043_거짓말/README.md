# 1043. 거짓말

### classification
* Graph theory
* Data structure
* Graph search
* Disjoint set

### solution
* 유니온 파인드 알고리즘을 사용해 모든 사람들을 부분 집합으로 나눔
* 그 집합 안에 진실을 아는 사람이 있으면 다른 사람들도 진실을 안다고 처리
* 모든 파티를 탐색하면서 파티의 참가자 중 진실을 아는 사람이 없으면 +1

### remind
* Union-Find algorithm

### link
https://www.acmicpc.net/problem/1043