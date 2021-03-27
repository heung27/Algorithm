# 12865. 평범한 배낭

### classification
* Dynamic programming
* Knapsack

### solution
* 배낭에 수용할 수 있는 모든 무게에 대해
* n번 째 물건을 배낭에 넣는 경우와 넣지않는 경우를 비교
* 물건을 넣는 경우는 dp[현재 넣으려고 하는 배낭의 무게 - 물건의 무게] + 물건의 가치
* 물건을 넣지 않는 경우는 dp[현재 넣으려고 하는 배낭의 무게] (이전까지의 결과)
* 이 둘을 비교하여 큰 값을 저장

### remind
* Dynamic programming
* Knapsack

### link
https://www.acmicpc.net/problem/12865