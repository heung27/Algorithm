import java.util.*;

public class Programmers_리틀_프렌즈_사천성 {
	class Solution {
	    int M, N;
	    
	    public String solution(int m, int n, String[] board) {
	        M = m;
	        N = n;
	        
	        char[][] mat = new char[m][n];
	        for (int i=0; i<m; i++) {
	            mat[i] = board[i].toCharArray();
	        }
	        
	        TreeMap<Character, int[]> map = new TreeMap<>();
	        for (int i=0; i<m; i++) {
	            for (int j=0; j<n; j++) {
	                if (mat[i][j] != '.' && mat[i][j] != '*') {
	                    map.put(mat[i][j], new int[]{i, j});
	                }
	            }
	        }
	        int total = map.size();
	        ArrayList<Character> list = new ArrayList<>();
	        
	        boolean check = true;
	        while (check) {
	            check = false;
	            for (char c : map.keySet()) {
	                int[] pos = map.get(c);
	                if (BFS(mat, pos[0], pos[1])) {
	                    check = true;
	                    map.remove(c);
	                    list.add(c);
	                    break;
	                }
	            }   
	        }
	        
	        int size = list.size();
	        if (size != total) return "IMPOSSIBLE";
	        
	        StringBuilder sb = new StringBuilder();
	        for (char c : list) {
	            sb.append(c);
	        }
	        
	        return sb.toString();
	    }
	    
	    int[] movex = {-1, 0, 1, 0};
	    int[] movey = {0, 1, 0, -1};
	    
	    public boolean BFS(char[][] mat, int x, int y) {
	        int[][] visit = new int[M][N];
	        Queue<int[]> queue = new LinkedList<>();
	        queue.offer(new int[]{x, y, -1, 0});
	        visit[x][y] = -1;
	        
	        while (!queue.isEmpty()) {
	            int[] pos = queue.poll();
	            
	            if (mat[pos[0]][pos[1]] == mat[x][y] && (x != pos[0] || y != pos[1])) {
	                mat[pos[0]][pos[1]] = '.';
	                mat[x][y] = '.';
	                return true;
	            }
	            
	            for (int d=0; d<4; d++) {
	                int nx = pos[0] + movex[d];
	                int ny = pos[1] + movey[d];
	                int cnt = pos[3];
	                if (d != pos[2]) cnt += 1;
	                    
	                if (nx < 0 || nx >= M || ny < 0 || ny >= N || cnt > 2) continue;
	                
	                if ((visit[nx][ny] == 0 || visit[nx][ny] >= cnt) && (mat[nx][ny] == '.' || mat[nx][ny] == mat[x][y])) {
	                    queue.offer(new int[]{nx, ny, d, cnt});
	                    visit[nx][ny] = cnt;
	                }
	            }
	        }
	        return false;
	    }
	}
}
