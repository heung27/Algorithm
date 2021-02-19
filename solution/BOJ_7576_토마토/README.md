# 7576. 토마토

### classification
* Graph theory
* Graph search
* BFS

### solution
* 토마토가 담겨있는 상자의 정보를 입력받으면서 2차원 배열에 저장
* 익은 토마토의 위치를 큐에 삽입해 놓고 덜 익은 토마토의 개수를 count
* 앞에서 익은 토마토의 위치를 저장해 놨던 큐를 통해 BFS 진행
* BFS를 진행하면서 레벨을 계산하고 토마토가 익으면 덜 익은 토마토의 개수-1
* 덜 익은 토마토의 개수가 0이 되거나 큐가 비게 되면 종료
* 덜 익은 토마토의 개수가 0이 아니면 -1 출력
* 덜 익은 토마토의 개수가 0이면 계산한 레벨(시간) 출력

### remind
* BFS

### link
https://www.acmicpc.net/problem/7576