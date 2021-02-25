# 14499. 주사위 굴리기

### classification
* Implementation
* Simulation

### solution
* 입력되는 지도의 정보를 배열에 저장
* 주사위의 각 면을 저장하는 6 크기의 주사위 배열을 선언
* 주사위 배열의 각 인덱스는 윗면, 뒷면, 오른쪽면, 왼쪽면, 앞면, 밑면을 저장하고 있음
* d가 1일 때 동쪽으로 굴러가면 윗면은 왼쪽면, 왼쪽면은 밑면, 밑면은 오른쪽면, 오른쪽면은 윗면이 됨
* top 변수를 두어 주사위 배열의 4개 인덱스 스왑
* 위와 같은 방식으로 d가 2, 3, 4일 때 구현
* 주사위가 이동할 때 마다 주사위 배열의 5 인덱스(밑면)을 확인하고 0 인덱스(윗면) 출력

### remind
* Implementation
* Simulation

### link
https://www.acmicpc.net/problem/14499