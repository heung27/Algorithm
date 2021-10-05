import java.util.*;

public class Programmers_배달 {
	class Solution {
	    class Node implements Comparable<Node> {
	        int n, weight;
	        
	        public Node(int n, int weight) {
	            this.n = n;
	            this.weight = weight;
	        }
	        
	        public int compareTo(Node o) {
	            return this.weight - o.weight;
	        }
	    }
	    
	    int[][] mat;
	    boolean[] visit;
	    int[] dist;
	    int len;
	    
	    public int solution(int N, int[][] road, int K) {
	        len = N;
	        mat = new int[N+1][N+1];
	        visit = new boolean[N+1];
	        dist = new int[N+1];
	        Arrays.fill(dist, Integer.MAX_VALUE);
	        
	        for (int i=0; i<road.length; i++) {
	            int from = road[i][0];
	            int to = road[i][1];
	            int weight = road[i][2];
	            
	            if (mat[from][to] == 0 || mat[from][to] > weight) {
	                mat[from][to] = weight;
	                mat[to][from] = weight;
	            }
	        }
	        
	        dijkstra(road);
	        
	        int answer = 0;
	        for (int i=1; i<=N; i++) {
	            if (dist[i] <= K) answer++;
	        }
	        return answer;
	    }
	    
	    public void dijkstra(int[][] road) {
	        PriorityQueue<Node> queue = new PriorityQueue<>();
	        queue.offer(new Node(1, 0));
	        dist[1] = 0;
	        
	        while (!queue.isEmpty()) {
	            Node node = queue.poll();
	            
	            if (visit[node.n]) continue;
	            visit[node.n] = true;
	        
	            for (int i=1; i<=len; i++) {
	                if (mat[node.n][i] != 0 && dist[i] > dist[node.n] + mat[node.n][i]) {
	                    dist[i] = dist[node.n] + mat[node.n][i];
	                    queue.offer(new Node(i, dist[i]));
	                }
	            }
	        }
	    }
	}
}
