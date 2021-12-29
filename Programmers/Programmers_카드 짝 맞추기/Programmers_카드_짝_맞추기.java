import java.util.*;

public class Programmers_카드_짝_맞추기 {
	class Solution {
	    int[] movex = {-1, 0, 1, 0};
		int[] movey = {0, 1, 0, -1};
		int answer;
	    int[] numbers;
		boolean[] visit;
	    
	    public int solution(int[][] board, int r, int c) { 
	        answer = Integer.MAX_VALUE;
			boolean[] check = new boolean[7];
			
	        for (int i=0; i<4; i++) {
	        	for (int j=0; j<4; j++) {
	        		if (board[i][j] != 0) {
	        			check[board[i][j]] = true;
	        		}
	        	}
	        }
	        
	        ArrayList<Integer> list = new ArrayList<>();
	        for (int i=1; i<=6; i++) {
	        	if (check[i]) {
	        		list.add(i);
	        	}
	        }
	        
	        numbers = new int[list.size()];
	        visit = new boolean[list.size()];
			
	        perm(board, list, 0, r, c);
	        
	        return answer;
	    }
	    
	    public void perm(int[][] board, ArrayList<Integer> list, int cnt, int r, int c) {
			if (cnt == list.size()) {
				int[][] temp = new int[4][4];
				for (int i=0; i<4; i++) {
					for (int j=0; j<4; j++) {
						temp[i][j] = board[i][j];
					}
				}
				int[] rc = new int[] {r, c};
				int sum = 0;
				for (int i=0; i<cnt; i++) {
					sum += bfs(temp, rc, numbers[i]);
					sum += bfs(temp, rc, numbers[i]);
				}
				answer = Math.min(answer, sum);
				return;
			}
			
			for (int i=0; i<list.size(); i++) {
				if (visit[i]) continue;
				
				visit[i] = true;
				numbers[cnt] = list.get(i);
				perm(board, list, cnt+1, r, c);
				visit[i] = false;
			}
		}
	    
	    public int bfs(int[][] board, int[] rc, int flag) {
			Queue<int[]> queue = new LinkedList<>();
			boolean[][] visit = new boolean[4][4];
			
			queue.offer(new int[] {rc[0], rc[1]});
			visit[rc[0]][rc[1]] = true;
			
			int cnt = 0;
			
			while (!queue.isEmpty()) {
				int size = queue.size();
				cnt++;
				
				while (size-- > 0) {
					int[] pos = queue.poll();
					
					if (board[pos[0]][pos[1]] == flag) {
						board[pos[0]][pos[1]] = 0;
						rc[0] = pos[0];
						rc[1] = pos[1];
						return cnt;
					}
					
					for (int d=0; d<4; d++) {
						int nx = pos[0] + movex[d];
						int ny = pos[1] + movey[d];
						
						while (true) {
							if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
								nx -= movex[d];
								ny -= movey[d];
								break;
							} else if (board[nx][ny] > 0) break;
							
							nx += movex[d];
							ny += movey[d];
						}
						
						if (visit[nx][ny]) continue;
						
						queue.offer(new int[] {nx, ny});
						visit[nx][ny] = true;
					}
					
					for (int d=0; d<4; d++) {
						int nx = pos[0] + movex[d];
						int ny = pos[1] + movey[d];
						
						if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || visit[nx][ny]) continue;
						
						queue.offer(new int[] {nx, ny});
						visit[nx][ny] = true;
					}
				}
			}
			return 0;
		}
	}
}
