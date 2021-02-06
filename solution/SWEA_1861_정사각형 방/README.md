# 1861. 정사각형 방

### solution
* 방들의 정보를 2차원 배열에 저장함
* 모든 방에서부터 깊이 우선 탐색을 하며 이동횟수를 카운트
* answer에 가장 높은 이동횟수를 저장하고 answer가 업로드 될 때마다 value에 시작점(방 번호)을 저장
* 이동횟수가 같을 경우 방 번호가 낮은 쪽을 value에 저장

### remind
* DFS

### link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc