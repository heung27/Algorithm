# 1987. 알파벳

### classification
* Graph theory
* Graph search
* DFS
* Backtracking

### solution
* 입력되는 알파벳을 배열에 저장
* 배열의 (0,0)에서 DFS 진행
* 지나온 알파벳들을 기억하기위해 26 크기의 1차원 배열 생성
* 알파벳을 지나왔으면 알파벳-'A' 인덱스에 true로 설정
* 지나오지 않은 알파벳으로 이동하면서 지나온 알파벳의 최대 개수를 저장

### remind
* DFS
* Backtracking

### link
https://www.acmicpc.net/problem/1987