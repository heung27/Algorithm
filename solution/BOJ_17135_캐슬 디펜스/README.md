# 17135. 캐슬 디펜스

### classification
* Implementation
* Graph theory
* Graph search
* Brute force algorithm
* BFS
* Simulation

### solution
* 격자판의 정보를 2차원 배열에 저장하고 적의 수 count
* 3명의 궁수가 위치할 수 있는 모든 조합을 탐색
* 모든 조합에서 각 궁수의 위치에서부터 BFS를 진행하며 가장 가까운 적을 찾아 제거 (map에서 -1로 표시)
* 3명의 궁수가 같은 적을 표적할 수 있기 때문에 -1을 만나면 count를 감소시키지 않고 return
* 한 조합을 다 보고나면 맵의 정보들을 한칸 아래로 이동
* 이동하면서 제거되는 적의 수 계산
* 적의 수가 0이 되면 종료

### remind
* Combination
* BFS
* Simulation

### link
https://www.acmicpc.net/problem/17135