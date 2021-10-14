import java.util.*;

public class Programmers_다리를_지나는_트럭 {
	class Solution {
	    public int solution(int bridge_length, int weight, int[] truck_weights) {
	        int cur = 0, cnt = 0, time = 0;
	        Queue<int[]> queue = new LinkedList<>();
	        
	        int len = truck_weights.length;
	        int index = 0;
	        while (index < len) {
	            time++;
	            
	            if (!queue.isEmpty()) {
	                int[] pos = queue.peek();
	                if (time - pos[0] == bridge_length) {
	                    queue.poll();
	                    cur -= pos[1];
	                    cnt -= 1;
	                }
	            }
	            
	            if (cur + truck_weights[index] <= weight && cnt + 1 <= bridge_length) {
	                cur += truck_weights[index];
	                cnt++;
	                queue.offer(new int[]{time, truck_weights[index++]});
	            }
	        }
	        
	        Object[] answer = queue.toArray();
	        int[] temp = (int[])answer[answer.length-1];
	        return temp[0] + bridge_length;
	    }
	}
}
