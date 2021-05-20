# [Level2] 행렬 테두리 회전하기

## Classification
* 시뮬레이션
* 구현

## Code
```java
public class programmers_행렬_테두리_회전하기 {
	class Solution {
	    int[][] map;
	    int R, C;
	    
	    public int[] solution(int rows, int columns, int[][] queries) {
	        int[] answer = new int[queries.length];
	        
	        R = rows; C = columns;
	        map = new int[R+1][C+1];
	        
	        int num = 1;
	        for (int i=1; i<=R; i++) {
	            for (int j=1; j<=C; j++) {
	                map[i][j] = num++;
	            }
	        }
	        
	        for (int i=0; i<queries.length; i++) {
	            answer[i] = rotate(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
	        }
	        
	        return answer;
	    }
	    
	    int[] movex = {1, 0, -1, 0};
	    int[] movey = {0, 1, 0, -1};
	    
	    public int rotate(int x1, int y1, int x2, int y2) {
	        int temp = map[x1][y1];
	        int d = 0, min = temp;
	        
	        int nx = x1 + movex[d], ny = y1 + movey[d];
	        int x = x1, y = y1;
	        
	        while (nx != x1 || ny != y1) {
	            map[x][y] = map[nx][ny];
	            
	             x = nx; y = ny;
	            
	            if (x == x1 && y == y2 || (x == x2 && (y == y1 || y == y2))) d++;
	           
	            min = Math.min(min, map[nx][ny]);
	            
	            nx = nx + movex[d];
	            ny = ny + movey[d];
	        }
	        
	        map[x][y] = temp;
	        return min;
	    }
	}
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/77485
