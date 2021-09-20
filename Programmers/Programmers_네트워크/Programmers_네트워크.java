
public class Programmers_네트워크 {
	class Solution {
	    boolean[] visit;
	        
	    public int solution(int n, int[][] computers) {
	        int answer = 0;
	        
	        
	        visit = new boolean[n];
	        for (int i=0; i<n; i++) {
	            if (visit[i]) continue;
	            answer++;
	            DFS(computers, i);
	        }
	        
	        return answer;
	    }
	    
	    public void DFS(int[][] computers, int num) {
	        visit[num] = true;
	        for (int i=0; i<computers.length; i++) {
	            if (visit[i]) continue;
	            if (computers[num][i] == 1) {
	                DFS(computers, i);
	            }
	        }
	    }
	}
}
