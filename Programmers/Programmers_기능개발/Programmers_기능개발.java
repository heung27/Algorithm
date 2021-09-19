import java.util.*;

public class Programmers_기능개발 {
	class Solution {
	    public int[] solution(int[] progresses, int[] speeds) {
	        ArrayList<Integer> list = new ArrayList<>();
	        
	        int len = progresses.length;
	        int[] arr = new int[len];
	        
	        for (int i=0; i<len; i++) {
	            arr[i] = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
	        }
	        
	        int cnt = 1, temp = arr[0];
	        for (int i=1; i<len; i++) {
	            if (arr[i] > temp) {
	                list.add(cnt);
	                temp = arr[i];
	                cnt = 1;
	            }
	            else cnt++;
	        }
	        list.add(cnt);
	        
	        return list.stream().mapToInt(i -> i).toArray();
	    }
	}
}
