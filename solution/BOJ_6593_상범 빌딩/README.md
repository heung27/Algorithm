# 6593. 상범 빌딩

### classification
* Graph theory
* Graph search
* BFS

### solution
* 입력되는 빌딩의 정보를 3차원 배열에 저장하고 출발점의 좌표를 기억
* 출발점부터 BFS 진행하고 레벨을 계산 (6방위 탐색)
* E를 만나면 계산한 레벨 출력
* BFS가 종료됐는데 E를 만나지 못했으면 Trapped! 출력

### remind
* BFS

### link
https://www.acmicpc.net/problem/6593