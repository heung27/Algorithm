# [Level3]  이중우선순위큐

## Classification
* 우선순위큐

## Code
```java
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> o1 - o2);
        
        for (int i=0; i<operations.length; i++) {
            String[] op = operations[i].split(" ");
            if (op[0].equals("I")) {
                max.offer(Integer.parseInt(op[1]));
                min.offer(Integer.parseInt(op[1]));
            } else if (op[1].equals("1")) {
                while (!max.isEmpty() && !min.isEmpty() && max.peek() <= min.peek()) {
                     max.poll();
                     min.poll();
                 }
                if (!max.isEmpty()) max.poll();
            } else if (op[1].equals("-1")) {
                 while (!max.isEmpty() && !min.isEmpty() && max.peek() <= min.peek()) {
                     max.poll();
                     min.poll();
                 }
                if (!min.isEmpty()) min.poll();
            }
        }
        
        int[] answer = new int[2];
        if (max.isEmpty() || min.isEmpty() || max.peek() < min.peek()) {
            answer[0] = answer[1] = 0;
        } else {
            answer[0] = max.poll();
            answer[1] = min.poll();
        }
        
        return answer;
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/42628
