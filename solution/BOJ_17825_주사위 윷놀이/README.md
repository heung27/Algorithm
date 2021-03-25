# 17825. 주사위 윷놀이

### classification
* Implementation
* Brute force
* Backtracking

### solution
* 게임판의 (시작 ~ 40), (10 ~ 40), (20 ~ 40), (30 ~ 40) 각각을 따로 배열에 저장
* 방문체크를 위해 테두리 boolean 배열과 안쪽 boolean 배열을 따로 선언 (숫자가 겹치기 때문)
* 도착한 말을 체크하는 배열, 말들의 위치를 저장하는 배열 선언
* 말들을 테두리부터(시작 위치) 움직임
* 이동하려는 말이 테두리의 5, 10, 15번 째 칸에 위치해 있으면 방향을 바꿔주고 움직임 (다른 배열로 넘어감)
* 움직이지 않았을 때도 계산해야 하기 때문에 다시 말의 정보를 원래대로 되돌려줌
* 말이 배열의 끝을 넘어가면 도착으로 처리
* 말이 총 10번 움직였을 경우의 최대값을 저장

### remind
* Implementation
* Simulation
* DFS

### link
https://www.acmicpc.net/problem/17825