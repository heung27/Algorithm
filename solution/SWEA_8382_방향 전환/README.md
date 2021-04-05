# 8382. 방향 전환

### classification
* Math
* Simulation

### solution
* 점화식을 세워서 해결함
* x1와 x2, y1와 y2의 차이 x, y를 구함
* x와 y가 같으면 answer = x(또는 y) * 2
* x와 y의 차이가 짝수면 answer = x와 y중 큰 값 * 2
* x와 y의 차이가 홀수면 answer = x와 y중 큰 값 * 2 - 1

### link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWyNQrCahHcDFAVP