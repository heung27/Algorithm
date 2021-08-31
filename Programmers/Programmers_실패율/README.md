# [Level1] 실패율

## Classification
* 우선순위 큐
* 정렬

## Code
```java
import java.util.*;

class Solution {
    
    public int[] solution(int N, int[] stages) {
        int[] count = new int[N+2];
        for (int i=0; i<stages.length; i++) {
            count[stages[i]]++;
        }
        
        PriorityQueue<Node> queue = new PriorityQueue<>();
        
        for (int i=N; i>0; i--) {
            int cur = count[i];
            count[i] += count[i+1];
            
            double rate = 0.0;
            if (cur != 0) {
                rate = (double)cur/count[i];
            }
            queue.offer(new Node(i, rate));
        }
        
        int[] answer = new int[N];
        int index = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            answer[index++] = temp.num;
        }
        return answer;
    }
    
    class Node implements Comparable<Node> {
        int num;
        double rate;

        public Node(int num, double rate) {
            super();
            this.num = num;
            this.rate = rate;
        }

        @Override
        public int compareTo(Node o) {
            int diff = Double.compare(o.rate, this.rate);
            if (diff == 0) {
                return Integer.compare(this.num, o.num);
            }
            return diff;
        }
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/42889
