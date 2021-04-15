# 9935. 문자열 폭발

### classification
* Data Structure
* String
* Stack

### solution
* 문자열과 폭발 문자열을 비교할 위치를 저장하는 변수(index)를 선언한다.
* 문자열의 부분 문자열 중 폭발 문자열과 같은 문자열이 나오면 index에 그 길이만큼 빼준다.
* 다시 그 index부터 폭발 문자열과 비교한다. (폭발 문자열의 끝에서 부터 비교해야 함)

### link
https://www.acmicpc.net/problem/9935