# 14500. 테트로미노

### classification
* Implementation
* Brute force

### solution
* 입력되는 정보를 배열에 저장
* 배열의 처음 인덱스부터 끝까지 해당 좌표에서 DFS 진행 (상하좌우 방향 인덱스 사용)
* DFS의 depth가 4가 됐을 때(4개의 칸이 되면) max값을 저장
* ㅗ, ㅜ, ㅏ, ㅓ 모양은 DFS로 볼 수 있기 때문에 따로 함수 구현
* 상하좌우 4가지 방향 중 가장 작은 값을 제외한 값들의 합과 가운데의 합을 구하여 max값 저장

### remind
* DFS
* Brute force

### link
https://www.acmicpc.net/problem/14500