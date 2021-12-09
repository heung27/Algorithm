# [Level1] 다트 게임

## Classification
* 문자열

## Code
```java
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        int pre = 0, cur = 0;
        char[] str = dartResult.toCharArray();
        for (int i=0; i<str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') {
                answer += pre;
                pre = cur;
                if (str[i] == '1' && i+1 < str.length && str[i+1] == '0') {
                    cur = 10;
                    i++;
                }
                else cur = str[i] - '0';
            } else if (str[i] == 'D') {
                cur = cur * cur;
            } else if (str[i] == 'T') {
                cur = cur * cur * cur;
            } else if (str[i] == '*') {
                pre *= 2;
                cur *= 2;
            } else if (str[i] == '#') {
                cur = -cur;
            }
        }
        
        answer += pre;
        answer += cur;
        
        return answer;
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/17682
