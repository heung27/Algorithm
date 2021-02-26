# 15685. 드래곤 커브

### classification
* Implementation
* Simulation

### solution
* 101 x 101 크기의 2차원 boolean map 배열 선언 (좌포 1,1부터 시작)
* 입력받은 드래곤 커브의 시작 좌표와 한 칸 전진한 좌표를 stack에 add, map에 해당 좌표 true
* temp 스택에 복사하고 temp의 top 좌표를 중심으로해서 temp의 모든 데이터에 대한 회전 구현
* 회전하면서 얻은 좌표를 stack에 add, map에 해당 좌표 true
* 드래곤 커브의 세대만큼 반복
* 모든 드래곤 커브를 구현하고 나서 map의 전체 행과 열을 탐색하면서 2 x 2크기가 전부 true이면 answer+1

### remind
* Implementation
* Simulation
* Stack

### link
https://www.acmicpc.net/problem/15685