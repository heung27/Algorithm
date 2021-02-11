# 17406. 배열 돌리기4

### classification
* Implementation
* Brute force algorithm

### solution
* 입력 데이터를 2차원 배열에 초기화
* 동작한 연산들을 list 배열에 넣어두고 DFS를 통해 모든 순열 탐색
* 탐색된 순열에 따라 넣어둔 연산을 수행하며 각 행에 있는 모든 수의 합을 구함
* answer에 그 중 최솟값 저장
* 회전하는 연산은 회전하는 범위를 구한 후 방향 배열(하우상좌)과 temp변수를 이용해 구현

### remind
* DFS
* Permutation
* Rotation

### link
https://www.acmicpc.net/problem/17406