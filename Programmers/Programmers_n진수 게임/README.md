# [Level2] n진수 게임

## Classification
* 문자열
* 수학
* 구현

## Code
```java
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        
        p %= m;
        
        int index = 1;
        int cnt = 0;
        
        int[] list = new int[100000];
        int len = 1;
        
        loop: while (true) {
            for (int i=len-1; i>=0; i--, index++) {
                if (index % m == p) {
                    if (list[i] >= 10) {
                        answer.append((char)('A'+list[i]-10));
                    } else {
                        answer.append(list[i]);
                    }
                    if (++cnt == t) break loop;
                }
            }
            for (int i=0; i<100000; i++) {
                if (++list[i] != n) break;
                else {
                    if (i == len-1) len++;
                    list[i] = 0;
                }
            }
        }
        
        return answer.toString();
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/17687
