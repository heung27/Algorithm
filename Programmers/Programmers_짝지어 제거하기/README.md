# [Level2] 짝지어 제거하기

## Classification
* 문자열
* 스택

## Code
```java
import java.util.*;

class Solution {
    public int solution(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < len) {
            if (!stack.isEmpty() && stack.peek() == arr[index]) {
                stack.pop();
            }
            else stack.add(arr[index]);
            index++;
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/12973
