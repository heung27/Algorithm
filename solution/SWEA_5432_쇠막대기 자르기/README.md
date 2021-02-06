# 5432. 쇠막대기 자르기

### solution
* 스택을 이용할 수도 있지만 그냥 배열로도 가능
* 인덱스 0부터 시작하여 탐색
* '('를 만나면 막대기 중첩 수(cnt) 증가
* ')'를 만나면 막대기 중첩 수(cnt)가 감소하고
* 바로 앞의 데이터가 '('이라면 result에 cnt를 더해줌 (막대기의 중첩 수를 더해줌)
* 바로 앞의 데이터가 ')'이라면 result에 1을 더해줌 (막대기의 끝 부분 계산)

### remind
* Stack

### link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWVl47b6DGMDFAXm