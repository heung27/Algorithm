# [Level1] 로

## Classification
* 문자열
* 시뮬레이션
* 구현

## Code
```java
import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int len = timetable.length;
        int[] times = new int[len];
        
        for (int i=0; i<len; i++) {
            String[] input = timetable[i].split(":");
            times[i] = Integer.parseInt(input[0]) * 60 + Integer.parseInt(input[1]);
        }
        Arrays.sort(times);
        
        int index = 0, cur_cnt = 0, pre_cnt = 0, count = 0, cur = 9 * 60;
        
        while (index < len && count < n) {
            if (times[index] > cur) {
                cur += t;
                count++;
                pre_cnt = cur_cnt;
                cur_cnt = 0;
            } else {
                if (++cur_cnt == m) {
                    cur += t;
                    count++;
                    pre_cnt = cur_cnt;
                    cur_cnt = 0;
                }
                index++;
            }
        }
        
        int answer = 0;
        
        if (count == n && pre_cnt == m) {
            answer = times[--index] - 1;
        } else {
            answer = 9 * 60 + (n - 1) * t;
        }
        
        return String.format("%02d", answer/60) + ":" + String.format("%02d", answer%60);
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/17678
