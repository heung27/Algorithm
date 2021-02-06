# 1218. 괄호 짝짓기

### solution
* 입력 데이터를 한 문자씩 읽으면서 '(' or '[' or '{' or '<'일 때 stack에 add
*  ')'일 때 스택의 top이 '('이면 pop, 아니면 0 출력
*  ']'일 때 스택의 top이 '['이면 pop, 아니면 0 출력
*  '}'일 때 스택의 top이 '{'이면 pop, 아니면 0 출력
*  '>'일 때 스택의 top이 '<'이면 pop, 아니면 0 출력
* 입력 데이터를 전부 읽어 들이고 break되지 않았으면 1 출력

### remind
* Stack
* Casework

### link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD