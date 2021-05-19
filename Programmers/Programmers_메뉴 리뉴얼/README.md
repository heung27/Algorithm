# [Level2] 메뉴 리뉴얼

## Classification
* 문자열
* 조합

## Code
```java
import java.util.*;

public class programmers_메뉴_리뉴얼 {
	class Solution {
	    ArrayList<String>[] arr;
	    boolean[] list = new boolean[26];

	    boolean[][] check;
	    char[] temp;
	    int[] max;

	    public String[] solution(String[] orders, int[] course) {
	        check = new boolean[orders.length][26];
	        for (int i=0; i<orders.length; i++) {
	            for (int j=0; j<orders[i].length(); j++) {
	                check[i][orders[i].charAt(j)-'A'] = true;
	                list[orders[i].charAt(j)-'A'] = true;
	            }
	        }

	        temp = new char[course[course.length-1]];
	        max = new int[course[course.length-1]];

	        arr = new ArrayList[course[course.length-1]];
	        for (int i=0; i<arr.length; i++) {
	            arr[i] = new ArrayList<>();
	        }

	        DFS(0, 0, 0, course);


	        for (int i=1; i<arr.length; i++) {
	            for (String s : arr[i]) {
	                arr[0].add(s);
	            }
	        }

	        Collections.sort(arr[0]);

	        String[] answer = new String[arr[0].size()];
	        for (int i=0; i<arr[0].size(); i++) {
	            answer[i] = arr[0].get(i);
	        }
	        return answer;
	    }

	    public void DFS(int cnt, int start, int course_idx, int[] course) {
	        if (cnt == course[course_idx]) {
	            int sum = 0;
	            for (int i=0; i<check.length; i++) {
	                boolean t = true;

	                for (int j=0; j<cnt; j++) {
	                    if (!check[i][temp[j]-'A']) {
	                        t = false;
	                        break;
	                    }
	                }

	                if (t) sum++;
	            }
	            
	            if (sum >= 2) {
	                 if (max[course_idx] < sum) {
	                arr[course_idx].clear();
	                arr[course_idx].add(String.valueOf(temp, 0, cnt));
	                max[course_idx] = sum;
	                }
	                else if (max[course_idx] == sum) {
	                    arr[course_idx].add(String.valueOf(temp, 0, cnt));
	                }
	            }

	            if (++course_idx == course.length) return;
	        }
	        for (int i=start; i<26; i++) {
	            if (!list[i]) continue;

	            temp[cnt] = (char)('A'+i);
	            DFS(cnt+1, i+1, course_idx, course);
	        }
	    }
	}
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/72411
