
public class Programmers_전력망을_둘로_나누기 {
	class Solution {
	    boolean[][] mat;
	    boolean[] visit;
	    int len, answer;
	    
	    public int solution(int n, int[][] wires) {
	        mat = new boolean[n+1][n+1];
	        visit = new boolean[n+1];
	        len = n;
	        answer = n;
	        
	        for (int i=0; i<n-1; i++) {
	            mat[wires[i][0]][wires[i][1]] = true;
	            mat[wires[i][1]][wires[i][0]] = true;
	        }
	        
	        DFS(1);
	        
	        return answer;
	    }
	    
	    public int DFS(int n) {
	        visit[n] = true;
	        int temp = 1;
	        
	        for (int i=1; i<=len; i++) {
	            if (mat[n][i] && !visit[i]) {
	                temp += DFS(i);
	            }
	        }
	        
	        answer = Math.min(answer, Math.abs(temp - (len-temp)));
	        return temp;
	    }
	}
}
