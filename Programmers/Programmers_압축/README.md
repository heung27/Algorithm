# [Level2] 압축

## Classification
* 문자열
* 구현

## Code
```java
import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<26; i++) {
            map.put((char)('A'+i)+"", i+1);
        }
        
        char[] list = msg.toCharArray();
        int len = list.length;
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        int cur = 1, pre = 0, num = 27;
        while (cur <= len) {
            String str = msg.substring(pre, cur);
            
            if (!map.containsKey(str)) {
                map.put(str, num++);
                String temp = msg.substring(pre, cur-1);
                arr.add(map.get(temp));
                pre = cur-1;
            } else {
                cur++;
            }
        }
        
        String temp = msg.substring(pre, cur-1);
        arr.add(map.get(temp));
        
        int[] answer = new int[arr.size()];
        int index = 0;
        for (int n : arr) {
            answer[index++] = n;
        }
        
        return answer;
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/17684
