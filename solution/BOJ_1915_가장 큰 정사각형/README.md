# 1915. 가장 큰 정사각형

### classification
* Dynamic programming

### solution
* 모든 칸에 대해 (i-1, j), (i-1, j-1), (i, j-1)을 확인하여 전부 1이면 정사각형의 넓이 증가(dp)
* (i-1, j), (i-1, j-1), (i, j-1) 세 개의 칸에서 가장 작은 수에 +1 (정사각형이기 때문)
* dp의 최대값을 구함

### remind
* Dynamic programming

### link
https://www.acmicpc.net/problem/1915