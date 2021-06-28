import java.util.*;

public class Programmers_정수_삼각형 {

	class Solution {
	    int[] parents;
	    
	    public int solution(int n, int[][] costs) {
	        int answer = 0;
	        
	        parents = new int[n];
	        for (int i=0; i<n; i++) {
	            parents[i] = i;
	        }
	        
	        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
	        
	        for (int[] cost : costs) {
	            if (union(cost[0], cost[1])) {
	                answer += cost[2];
	            }
	        }
	        
	        return answer;
	    }
	    
	    public boolean union(int a, int b) {
	        a = find(a);
	        b = find(b);
	        
	        if (a == b) return false;
	        else if (a < b) parents[b] = a;
	        else parents[a] = b;
	        return true;
	    }
	    
	    public int find(int n) {
	        if (parents[n] == n) return n;
	        else return parents[n] = find(parents[n]);
	    }
	}
}
