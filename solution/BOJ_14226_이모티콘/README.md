# 14226. 이모티콘

### classification
* Dynamic programming
* Graph theory
* Graph search
* BFS

### solution
* BFS를 통해 각 연산에 대한 결과를 구함
* 클립보드에 복사하는 연산은 시간이 1 증가하고 클립 변수를 업데이트하여 Queue 저장
* 이모티콘을 삭제하는 연산은 이모티콘의 개수를 1 줄이고 시간 증가
* 이모티콘을 붙여넣기하는 연산은 이모티콘의 개수에 클립 변수를 더하고 시간 증가
* 이모티콘의 개수가 S가 되면 그때가 가장 빠른 시간이기 때문에 return

### remind
* BFS

### link
https://www.acmicpc.net/problem/14226