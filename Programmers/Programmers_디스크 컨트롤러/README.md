# [Level3] 디스크 컨트롤러

## Classification
* 힙
* 정렬

## Code
```java
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int len = jobs.length;
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int time = 0, sum = 0, index = 0;
        while (true) {
            while (index < len && jobs[index][0] <= time) {
                queue.offer(jobs[index++]);
            }
            if (queue.isEmpty()) {
                if (index >= len) break;
                time = jobs[index][0];
                continue;
            }
            int[] cur = queue.poll();
            sum += time - cur[0] + cur[1];
            time += cur[1];
        }
        
        return sum / len;
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/42627
