# 10451. 순열 사이클

### classification
* Graph theory
* Graph search

### solution
* 1번 사람부터 탐색을 시작, 사이클 count를 1로 초기화
* 탐색을 진행하면서 check 배열에 사이클 count를 대입
* 탐색을 진행하다가 내 다음 차례의 check가 나의 check와 같으면 사이클이 생겼다고 판단하고 count를 증가시킴
* 다음 check가 0인 사람을 찾아서 반복

### remind
* DFS
* Cycle

### link
https://www.acmicpc.net/problem/10451