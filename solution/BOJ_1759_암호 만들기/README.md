# 1759. 암호 만들기

### classification
* Math
* Brute force algorithm
* Combinatorics
* Backtracking

### solution
* 입력받은 알파벳 문자들을 배열에 저장
* 배열을 오름차순으로 정렬
* 암호에는 순서가 있기 때문에 순열을 사용해야 할 것 같음
* 하지만 알파벳이 증가하는 순서로 배열되어 있다는 조건이 있기 때문에 조합으로 해결
* 알파벳을 L개 선택하는 조합을 탐색
* 모든 경우의 수에서 모음과 자음의 수 count
* 모음이 1개 이상, 자음이 2개 이상일 때 해당 조합 출력

### remind
* Permutation
* Combination
* Sort

### link
https://www.acmicpc.net/problem/1759