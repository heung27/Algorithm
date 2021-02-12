# 10830. 행렬 제곱

### classification
* Math
* Divide and conquer
* Power using division and conquest
* Linear algebra

### solution
* 2차원 배열에 행렬 값을 저장
* 두 행렬을 곱하는 연산을 구현 temp[i][j] = mat1[i][k] * mat2[k][j]
* 분할 정복을 이용해 거듭제곱 알고리즘 구현
* b가 짝수일 때 mat^b는 mat^(b/2) * mat^(b/2)
* b가 홀수일 때 mat^b는 mat^(b/2) * mat^(b/2) * mat

### remind
* Divide and conquer
* Power using division and conquest
* Matrix product

### link
https://www.acmicpc.net/problem/10830