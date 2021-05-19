# [Level3] 경주로 건설

## Classification
* 구현
* 시뮬레이션
* BFS

## Code
```java
import java.util.*;

public class programmers_경주로_건설 {
	class Solution {
	    class Node implements Comparable<Node> {
			int x, y, d;
			int weight;
			
			public Node(int x, int y, int d, int weight) {
				this.x = x;
				this.y = y;
	            this.d = d;
				this.weight = weight;
			}

			@Override
			public int compareTo(Node o) {
				return this.weight - o.weight;
			}
		}
	    
	    int[] movex = {-1, 0, 1, 0};
	    int[] movey = {0, 1, 0, -1};
	    int N;
	    
	    public int solution(int[][] board) {
	        N = board.length;
	        int[][][] check =  new int[N][N][4];
	        
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					Arrays.fill(check[i][j], Integer.MAX_VALUE);
				}
			}
			bfs(board, check);
			
			int min = Integer.MAX_VALUE;
			for (int d=0; d<4; d++) {
				min = Math.min(min, check[N-1][N-1][d]);
			}
	        
	        return min;
	    }
	    
	    public void bfs(int[][] map, int[][][] check) {
	        Queue<Node> queue = new LinkedList<>();
	        queue.offer(new Node(0, 0, 1, 0));
	        queue.offer(new Node(0, 0, 2, 0));
	        
	        check[0][0][0] = check[0][0][1] = check[0][0][2] = check[0][0][3] = 0;
	        
	        while (!queue.isEmpty()) {
	            Node node = queue.poll();
	            
	            if (node.x == N-1 && node.y == N-1) continue;
	            
	            for (int d=0; d<4; d++) {
	                int nx = node.x + movex[d];
	                int ny = node.y + movey[d];
	                
	                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
	                
	                if (map[nx][ny] == 0) {
	                	int temp = node.weight+100;
	                    if (node.d != d) temp += 500;
	                    
	                    if (check[nx][ny][d] > temp) {
	                    	queue.offer(new Node(nx, ny, d, temp));
	                    	check[nx][ny][d] = temp;
	                    }
	                }
	            }
	        }
	    }
	}
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/67259
