# [Level2] 예상 대진표

## Classification
* 수학

## Code
```java
class Solution {
    public int solution(int n, int a, int b) {
        int cnt = 0;
        while (a != b) {
            a = a/2 + a%2;
            b = b/2 + b%2;
            cnt++;
        }
        return cnt;
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/12985
