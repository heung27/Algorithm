# [Level2] 튜플

## Classification
* 문자열

## Code
```java
import java.util.*;

public class programmers_튜플 {
	class Solution {
	    public int[] solution(String s) {
	        String[] str = s.split("[}]+[,]+[{]|[{]{2}|[}]{2}");

	        String[][] temp = new String[str.length][];
	        for (int i=0; i<str.length; i++) {
	            temp[i] = str[i].split(",");
	        }

	        Arrays.sort(temp, (arr1, arr2) -> arr1.length - arr2.length);

	        int[] answer = new int[temp.length-1];
	        Set<String> set = new HashSet<>();
	        
	        for (int i=1; i<temp.length; i++) {
	            for (int j=0; j<temp[i].length; j++) {
	                if (!set.contains(temp[i][j])) {
	                    answer[i-1] = Integer.parseInt(temp[i][j]);
	                    set.add(temp[i][j]);
	                    break;
	                }
	            }
	        }
	        
	        return answer;
	    }
	}
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/64065
