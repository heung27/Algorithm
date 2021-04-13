# 12026. BOJ거리

### classification
* Dynamic programming

### solution
* DP 배열에 각 인덱스까지의 최솟값을 저장
* i가 'J'일 때, 이전에 나왔던 ('O'까지의 값 + i까지의 점프하는 데 필요한 양)의 최솟값을 구함
* 위와 마찬가지로 'B'일 때는 'J'를 찾고 'O'일 때는 'J'를 찾아 계산함
* DP의 마지막 인덱스 값 출력

### link
https://www.acmicpc.net/problem/12026