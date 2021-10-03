# [Level2] 점프와 순간 이동

## Classification
* 브루트포스

## Code
```java
public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        while (n != 0) {
            if (n % 2 == 1) ans++;
            n >>= 1;
        }

        return ans;
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/12980