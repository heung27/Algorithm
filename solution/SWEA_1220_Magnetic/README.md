# 1220. Magnetic

### solution
* 입력 데이터를 2차원 배열에 저장
* 각 열마다 위에서부터 탐색을 진행
* 내려오면서 자성체가 존재하지 않는 0은 무시
* 위에는 N극이 있기 때문에 내려가면서 N극을 만나면 check = true
* check가 true일 때(N극을 만났을 때) S극을 만나면 count+1, check는 다시 false
* check가 false일 때(N극을 만나지 않았을 때) S극을 만나면 무시

### remind
* Brute force
* Implementation

### link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14hwZqABsCFAYD