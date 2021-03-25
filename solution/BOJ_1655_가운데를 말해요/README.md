# 1655. 가운데를 말해요

### classification
* Data Structure
* Priority queue

### solution
* 최소힙과 최대힙을 활용
* 중간값보다 작으면 최대힙으로, 같거나 크면 최소힙으로 삽입
* 두 힙의 높이 균형을 위해 큰 쪽에서 poll하고 작은 쪽으로 offer
* 사이즈가 큰 쪽의 루트가 이제 중간값이 되고 다음 연산에 활용

### remind
* Priority queue

### link
https://www.acmicpc.net/problem/1655