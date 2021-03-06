# 16235. 나무 재태크

### classification
* Implementation
* Simulation

### solution
* 문제에 나이가 작은 나무부터 계산을 해야 한다는 조건이 있음
* 처음에는 모든 트리의 정보를 ArrayList에 저장하고 정렬하면서 계산을 함
* 매번 정렬을 해줘야 하기때문에 시간초과가 발생
* Deque를 활용하여 앞으로 삽입, 뒤쪽에서 삭제하면서 항상 정렬인 상태를 유지 (시간초과 해결)
* Deque는 인덱스 접근이 불가능하기 때문에 iterator로 순회
* 봄과 여름을 함께 구현
* 여름에 죽은 나무가 있으면 그 나무를 포함 뒤쪽 나무 전부 제거 (정렬되어 있기 때문)
* 나무 번식은 Queue를 활용하여 번식할 좌표를 저장하고 여름 이후에 모두 poll

### remind
* Implementation
* Simulation
* Deque
* ArrayList
* Sort

### link
https://www.acmicpc.net/problem/16235