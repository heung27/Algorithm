import java.util.*;

public class Programmers_모두_0으로_만들기 {
	class Solution {
	    class Node {
	        int n;
	        Node next;
	        
	        public Node(int n, Node next) {
	            this.n = n;
	            this.next = next;
	        }
	    }
	    
	    public long solution(int[] a, int[][] edges) {
	        long answer = 0;
	        
	        int len = a.length;
	        Node[] list = new Node[len];
	        int[] count = new int[len];
	        
	        for (int i=0; i<len-1; i++) {
	            int from = edges[i][0];
	            int to = edges[i][1];
	            
	            list[from] = new Node(to, list[from]);
	            list[to] = new Node(from, list[to]);
	            count[from]++;
	            count[to]++;
	        }
	        
	        long[] val = new long[len];
	        for (int i=0; i<len; i++) {
	            val[i] = a[i];
	        }
	        
	        Queue<Integer> queue = new LinkedList<>();
	        long sum = 0;
	        for (int i=0; i<len; i++) {
	            sum += val[i];
	            if (count[i] == 1) {
	                count[i] = 0;
	                queue.offer(i);
	            }
	        }
	        
	        if (sum != 0) return -1;
	        
	        while (!queue.isEmpty()) {
	            int node = queue.poll();
	            
	            answer += Math.abs(val[node]);
	            
	            for (Node next=list[node]; next != null; next = next.next) {
	                val[next.n] += val[node];
	                if (--count[next.n] == 1) {
	                    queue.offer(next.n);
	                }
	            }
	        }
	        
	        return answer;
	    }
	}
}
