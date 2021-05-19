# [Level2] 순위 검색

## Classification
* 문자열
* 부분집합
* 이분탐색

## Code
```java
import java.util.*;

public class programmers_순위_검색 {
	class Solution {
	    HashMap<String, ArrayList<Integer>> map = new HashMap<>();

	    public int[] solution(String[] info, String[] query) {
	        int[] answer = new int[query.length];

	        String[][] str1 = new String[info.length][];
	        String[][] str2 = new String[query.length][];

	        for (int i=0; i<info.length; i++) {
	            str1[i] = info[i].split(" ");

	            int score = Integer.parseInt(str1[i][4]);

	            subset(str1[i], str1[i][0]+str1[i][1]+str1[i][2]+str1[i][3], 0, score);
	        }

	        Collection<ArrayList<Integer>> values = map.values();
	        for (ArrayList<Integer> list : values) {
	            Collections.sort(list, (o1, o2) -> o2 - o1);
	        }

	        for (int i=0; i<query.length; i++) {
	            str2[i] = query[i].replace(" and", "").split(" ");

	            int score = Integer.parseInt(str2[i][4]);

	            answer[i] = binarySearch(map.get(str2[i][0]+str2[i][1]+str2[i][2]+str2[i][3]), score);
	        }

	        return answer;
	    }

	    public void subset(String[] str, String key, int cnt, int score) {
	        if (cnt == 4) {
	            ArrayList<Integer> temp = map.getOrDefault(key, new ArrayList<Integer>());
	            temp.add(score);
	            map.put(key, temp);
	            return;
	        }

	        subset(str, key, cnt+1, score);

	        String temp = key.replace(str[cnt], "-");
	        subset(str, temp, cnt+1, score);
	    }

	    public int binarySearch(ArrayList<Integer> list, int score) {
	        if (list == null) return 0;
	        
	        int left = 0, right = list.size()-1, index = -1;

	        while (left <= right) {
	            int mid = (left + right) / 2;
	            int num = list.get(mid);

	            if (num >= score) {
	                left = mid + 1;
	                index = mid;
	            }
	            else {
	                right = mid - 1;
	            }
	        }

	        return index+1;
	    }
	}
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/72412
