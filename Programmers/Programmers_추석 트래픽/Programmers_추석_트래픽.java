import java.util.*;

public class Programmers_추석_트래픽 {
	class Solution {
	    class Node implements Comparable<Node> {
	        int time;
	        int type;
	        
	        public Node(int time, int type) {
	            this.time = time;
	            this.type = type;
	        }
	        
	        public int compareTo(Node o) {
	            int diff = Integer.compare(this.time, o.time);
	            if (diff == 0) {
	                return Integer.compare(this.type, o.type);
	            }
	            else return diff;
	        }
	    }
	    public int solution(String[] lines) {
	        int len = lines.length;
	        
	        PriorityQueue<Node> queue = new PriorityQueue<>();
	        for (int i=0; i<len; i++) {
	            String[] temp = lines[i].split(" ");
	            int time = getTime(temp[1]);
	            String runTemp = String.format("%-4s", temp[2].replaceAll("[.s]", "")).replace(' ', '0');
	            int run = Integer.parseInt(runTemp);
	            
	            queue.offer(new Node(time - run + 1, 0));
	            queue.offer(new Node(time + 999, 1));
	        }
	        
	        int answer = 0, cnt = 0;
	        while (!queue.isEmpty()) {
	            Node node = queue.poll();
	            if (node.type == 0) cnt++;
	            else cnt--;
	            answer = Math.max(answer, cnt);
	        }
	        
	        return answer;
	    }
	    
	    public int getTime(String end) {
	        String[] time = end.split(":");
	        int xh = Integer.parseInt(time[0]) * 3600 * 1000;
	        int xm = Integer.parseInt(time[1]) * 60 * 1000;
	        int xs = Integer.parseInt(time[2].replace(".", ""));
	        
	        return xh + xm + xs;
	    }
	}
}
