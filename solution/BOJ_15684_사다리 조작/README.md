# 15684. 사다리 조작

### classification
* Implementation
* Brute force
* Backtracking

### solution
* 사다리의 정보를 저장하는 배열 선언
* 입력받은 가로선의 정보를 통해 사다리 배열에 체크
* [a][b] (가로선의 왼쪽)은 1, [a][b+1] (가로선의 오른쪽)은 -1로 기억
* 가로선이 놓일 수 있는 모든 자리(왼쪽과 오른쪽이 0인 자리) list에 저장
* list를 활용해 가로선이 0개, 1개, 2개, 3개 놓이는 경우에 대한 모든 조합을 찾음
* 모든 조합에 대해 사다리를 내려가보며 i번 세로선의 결과가 i번이 나오는지 확인하여 가능하면 true 리턴
* true가 나왔으면 조합 탐색을 종료하고 결과 출력
* 3개 놓이는 경우에도 불가능하면 -1 출력

### remind
* Implementation
* Combination

### link
https://www.acmicpc.net/problem/15684