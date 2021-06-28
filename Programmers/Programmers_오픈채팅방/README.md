# [Level2] 오픈채팅방

## Classification
* 문자열
* 자료 구조

## Code
```java
import java.util.*;

class Solution {
    
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        
        String[][] temp = new String[record.length][];
        int cnt = 0;
        
        for (int i=0; i<record.length; i++) {
            temp[i] = record[i].split(" ");
            if (!temp[i][0].equals("Change")) {
                cnt++;
            }
        }
        
        String[] answer = new String[cnt];
        
        for (int i=0; i<record.length; i++) {
            if (!temp[i][0].equals("Leave")) {
                map.put(temp[i][1], temp[i][2]);
            }
        }
        
        cnt = 0;
        for (int i=0; i<record.length; i++) {
            if (temp[i][0].equals("Enter")) {
                answer[cnt++] = map.get(temp[i][1]) + "님이 들어왔습니다.";
            }
            else if (temp[i][0].equals("Leave")) {
                answer[cnt++] = map.get(temp[i][1]) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/42888
