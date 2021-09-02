# [Level2] 후보키

## Classification
* 문자열
* 비트마스킹
* 부분집합
* 자료구조

## Code
```java
import java.util.*;

class Solution {
    String[][] temp;
    int len;
    
    public int solution(String[][] relation) {
        temp = relation;
        len = relation[0].length;
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int flag=1; flag < (1 << len); flag++) {
            if (!isMinimal(flag, list)) continue;
            
            if (isUnique(flag)) {
                list.add(flag);
            }
        }
        return list.size();
    }
    
    boolean isMinimal(int flag, ArrayList<Integer> list) {
        for (int key : list) {
            if ((key & flag) == key) return false;
        }
        return true;
    }
    
    boolean isUnique(int flag) {
        Set<String> set = new HashSet<>();
        for (int i=0; i<temp.length; i++) {
            String str = "";
            for (int j=0; j<len; j++) {
                if ((flag & 1 << j) != 0) {
                    str += temp[i][j];
                }
            }
            if (set.contains(str)) return false;
            set.add(str);
        }
        return true;
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/42890
