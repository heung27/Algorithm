# 3234. 준환이의 양팔저울

### solution
* 추의 무게들에 대한 모든 순열을 탐색
* 각 순열에 대해 맨 앞의 추부터 해당 추를 저울의 오른쪽에 놓는 경우, 왼쪽에 놓는 경우를 나누어 탐색
* 오른쪽의 무게가 더 커지면 추를 놓을 수 없기 때문에 그 뒤로는 보지 않음
* 추를 전부 올려놓을 수 있으면 count+1 

### remind
* Permutation
* SubSet

### link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWAe7XSKfUUDFAUw