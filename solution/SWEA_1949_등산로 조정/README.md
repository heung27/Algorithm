# 1949. 등산로 조정

### solution
* 최고 높이를 기억하고 가장 높은 봉우리들을 탐색
* 해당 좌표에서 부터 DFS
* 공사는 단 한번 할 수 있기 때문에 check 변수를 사용해 공사 여부 판단
* 현재 위치보다 낮은 위치가 있으면 그 곳으로 이동
* 공사가 시행된 적이 없으면 위, 아래, 오른쪽, 왼쪽의 높이에서 k를 뺀 값이 현재 높이보다 작으면 이동
* 공사는 1부터 k깊이만큼 깎을 수 있기 때문에 모든 경우의 수 탐색 

### remind
* DFS

### link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PoOKKAPIDFAUq