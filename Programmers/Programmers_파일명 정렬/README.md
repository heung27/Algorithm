# [Level2] 파일명 정렬

## Classification
* 문자열
* 정렬

## Code
```java
import java.util.*;

class Solution {
    class Node implements Comparable<Node> {
        int idx;
        String head;
        int number;
        String tail;
        
        public Node(int idx, String head, int number, String tail) {
            this.idx = idx;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
        @Override
        public int compareTo(Node o) {
            String a = this.head.toLowerCase();
            String b = o.head.toLowerCase();
            
            int diff = 0;
            if (!a.equals(b)) {
                diff = a.compareTo(b);
            } else {
                if (this.number != o.number) {
                    diff = this.number - o.number;
                }
            }
            return diff;
        }
    }
    
    public String[] solution(String[] files) {
        int len = files.length;
        Node[] list = new Node[len];
        
        for (int i=0; i<len; i++) {
            int head_end = 0;
            int number_end = files[i].length();
            
            for (int j=0; j<files[i].length(); j++) {
                char c = files[i].charAt(j);
                if (head_end == 0) {
                    if (c >= '0' && c <= '9') {
                        head_end = j;
                    }
                } else {
                    if (number_end == files[i].length() && !(c >= '0' && c <= '9')) {
                        number_end = j;
                    }
                }
            }
            list[i] = new Node(
                i, 
                files[i].substring(0, head_end), 
                Integer.parseInt(files[i].substring(head_end, number_end)), 
                files[i].substring(number_end, files[i].length())
            );
        }
        
        Arrays.sort(list);
        
        String[] answer = new String[len];
        for (int i=0; i<len; i++) {
            answer[i] = files[list[i].idx];
        }
        
        return answer;
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/17686
