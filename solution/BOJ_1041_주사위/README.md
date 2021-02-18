# 1041. 주사위

### classification
* Greedy algorithm

### solution
* 주사위를 N x N x N 크기로 쌓았을 때 5개의 면이 어떻게 구성될 것인지 생각
* 주사위를 1-6, 2-5, 3-4 세 개의 조합으로 나눔
* 세 개의 조합에서 각각 작은 수를 res 배열에 저장
* res 배열을 오름차순으로 정렬
* 주사위를 정사각형 모양으로 쌓았을 때, 작은 주사위는 0~3개의 면이 노출될 수 있음
* 각각의 주사위의 개수를 구하는 점화식을 세움
* 정렬된 res 배열에서 가장 작은 값이 1개의 면, 그 다음 값이 2개의 면, 마지막 제일 큰 값이 3개의 면이 노출되는것이 5면의 최솟값
* 점화식에 res 값들을 대입하여 계산

### remind
* Greedy algorithm
* Math

### link
https://www.acmicpc.net/problem/1041