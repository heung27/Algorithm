# 3499. 퍼펙트 셔플

### solution
* N개의 카드를 반으로 나눠야 하기 때문에 N/2
* N이 홀수일 때 앞쪽 파트가 1개 더 많아야 하기 때문에 N/2에 올림을 함
* 앞쪽 파트는 0 인덱스부터 시작하여 출력
* 뒤쪽 파트는 N/2에 올림을 한 숫자의 인덱스부터 시작하여 출력
* 만약 N이 홀수일 때 앞쪽에서 한 개 더 출력

### remind
* Math.ceil

### link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW