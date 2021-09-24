
public class Programmers_등굣길 {
	class Solution {
	    public int solution(int m, int n, int[][] puddles) {
	        int MOD = 1000000007;
	        
	        long[][] mat = new long[n+1][m+1];
	        for (int i=0; i<puddles.length; i++) {
	            mat[puddles[i][1]][puddles[i][0]] = -1;
	        }
	        for (int i=1; i<=n; i++) {
	            if (mat[i][1] == -1) break;
	            mat[i][1] = 1;
	        }
	        for (int i=1; i<=m; i++) {
	            if (mat[1][i] == -1) break;
	            mat[1][i] = 1;
	        }
	        
	        for (int i=2; i<=n; i++) {
	            for (int j=2; j<=m; j++) {
	                if (mat[i][j] == -1) continue;
	                if (mat[i-1][j] > 0) mat[i][j] += mat[i-1][j];
	                if (mat[i][j-1] > 0) mat[i][j] += mat[i][j-1];
	                mat[i][j] %= MOD;
	            }
	        }
	        
	        return (int)mat[n][m];
	    }
	}
}
