# [Level2] 방금그곡

## Classification
* 문자열
* 정렬

## Code
```java
import java.util.*;

class Solution {
    class Node implements Comparable<Node> {
        int idx;
        int time;
        String title;
        
        public Node(int idx, int time, String title) {
            this.idx = idx;
            this.time = time;
            this.title = title;
        }
        
        @Override
        public int compareTo(Node o) {
            int diff = o.time - this.time;
            if (diff == 0) {
                diff = this.idx = o.idx;
            }
            return diff;
        }
    }
    public String solution(String m, String[] musicinfos) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        
        StringBuilder temp_m = new StringBuilder();
        for (int i=0; i<m.length(); i++) {
            if (i+1 < m.length() && m.charAt(i+1) == '#') {
                temp_m.append((char)(m.charAt(i)+32));
                i++;
            }
            else temp_m.append(m.charAt(i));
        }
        
        int len = musicinfos.length;
        for (int i=0; i<len; i++) {
            String[] input = musicinfos[i].split(",");
            
            String[] start = input[0].split(":");
            String[] end = input[1].split(":");
            
            int s = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int e = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
            
            int runTime = e - s;
            
            StringBuilder temp = new StringBuilder();
            int index = 0, size = input[3].length();
            for (int j=0; j<runTime; j++) {
                if (index+1 < size && input[3].charAt(index+1) == '#') {
                    temp.append((char)(input[3].charAt(index)+32));
                    index = (index + 1) % size;
                }
                else temp.append(input[3].charAt(index));
                
                index = (index + 1) % size;
            }
            
            if (temp.toString().contains(temp_m)) {
                queue.offer(new Node(i, runTime, input[2]));
            }
        }
        
        if (queue.isEmpty()) {
            return "(None)";
        }
        Node answer = queue.poll();
        return answer.title;
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/17683
