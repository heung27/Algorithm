# [Level1] 부족한 금액 계산하기

## Classification
* 브루트포스

## Code
```java
class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        for (int cnt=1; cnt<=count; cnt++) {
            answer += price * cnt;
        }
        answer = Math.max(0, answer - money);
        return answer;
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/82612
