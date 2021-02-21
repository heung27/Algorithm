# 1107. 리모컨

### classification
* Brute force algorithm

### solution
* 목표로 하는 채널을 저장하고 문자열의 길이를 저장
* 10크기의 1차원 배열을 선언하여 고장난 버튼을 기억
* DFS를 이용하여 고장나지 않은 버튼에 대한 중복 순열을 생성
* 순열의 길이가 size-1 이상이면 목표 채널과의 차이를 계산하고 최솟값 저장
* 순열의 길이가 0일 때는 계산하지 않음
* 순열의 길이가 size+1이 되면 return

### remind
* Brute force algorithm
* Redundant permutation

### link
https://www.acmicpc.net/problem/1107