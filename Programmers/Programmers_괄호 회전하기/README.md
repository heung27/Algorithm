# [Level2] 괄호 회전하기

## Classification
* 문자열
* 스택

## Code
```java
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        int len = arr.length;
        
        for (int j=0; j<len; j++){
            Stack<Character> stack = new Stack<>();
            for (int i=0; i<len; i++) {
                boolean check = true;
                switch (arr[(i+j)%len]) {
                    case ']':
                        if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                        else check = false;
                        break;
                    case ')':
                        if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                        else check = false;
                        break;
                    case '}':
                        if (!stack.isEmpty() && stack.peek() == '{') stack.pop();
                        else check = false;
                        break;
                    default:
                        stack.add(arr[(i+j)%len]);
                        break;
                }
                if (!check || (i == len-1 && !stack.isEmpty())) {
                    answer++;
                    break;
                }
            }
        }
        return len - answer;
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/76502
