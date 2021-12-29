# [Level3] 합승 택시 요금

## Classification
* 브루트포스
* 플로이드 와샬
* 다익스트라

## Code
```java
class Solution {
    int INF = Integer.MAX_VALUE / 3;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        
        int[][] mat = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
        	for (int j=1; j<=n; j++) {
        		mat[i][j] = INF;
        	}
        	mat[i][i] = 0;
        }
        
        int len = fares.length;
        for (int i=0; i<len; i++) {
        	int c = fares[i][0];
        	int d = fares[i][1];
        	int f = fares[i][2];
        	
        	mat[c][d] = mat[d][c] = f;
        }
        
        floyd(mat, n);
        
        for (int i=1; i<=n; i++) {
        	answer = Math.min(answer, mat[s][i] + mat[i][a] + mat[i][b]);
        }
        
        return answer;
    }
	
	public void floyd(int[][] mat, int n) {
		for (int k=1; k<=n; k++) {
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=n; j++) {
					mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
				}
			}
		}
	}
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/72413
