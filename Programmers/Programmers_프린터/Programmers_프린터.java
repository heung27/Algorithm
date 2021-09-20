
import java.util.*;

public class Programmers_프린터 {
	class Solution {
	    public int solution(int[] priorities, int location) {
	        Queue<Integer> queue = new LinkedList<>();
	        for (int num : priorities) {
	            queue.offer(num);
	        }
	        
	        Arrays.sort(priorities);
	        
	        int index = priorities.length-1;
	        while (!queue.isEmpty()) {
	            int num = queue.poll();
	            location--;
	            if (priorities[index] == num) {
	                index--;
	                if (location < 0) break;
	            }
	            else {
	                if (location < 0) location = queue.size();
	                queue.offer(num);
	            }
	        }
	        
	        return priorities.length - index - 1;
	    }
	}
}
