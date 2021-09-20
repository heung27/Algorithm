# [Level2] 프린터

## Classification
* 큐

## Code
```java
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        for (int num : priorities) {
            queue.offer(num);
        }
        
        Arrays.sort(priorities);
        
        int index = priorities.length-1;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            location--;
            if (priorities[index] == num) {
                index--;
                if (location < 0) break;
            }
            else {
                if (location < 0) location = queue.size();
                queue.offer(num);
            }
        }
        
        return priorities.length - index - 1;
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/42587
