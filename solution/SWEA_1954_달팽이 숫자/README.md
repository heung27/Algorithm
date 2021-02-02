# 1954. 달팽이 숫자

### solution
* 먼저 매트릭스의 맨 윗 줄은 순서대로 초기화 시켜줌
* 매트릭스의 오른쪽 모서리부터 차례대로 탐색하며 숫자를 대입
* range(초기: N-1) 만큼 순서대로 대입하고 회전하여 다시 반복
* 두 모서리가 채워졌으면 range를 1 감소시키고 다시 회전하며 두 모서리를 채워 넣음
* 회전은 방향 배열을 만들어주어 인덱스를 증가시키며 연산
* 모서리를 따라 아래, 왼쪽, 위, 오른쪽 순서대로 회전

### remind
* DFS
* Rotation

### link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq#none