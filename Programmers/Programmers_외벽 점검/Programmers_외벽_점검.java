	
public class Programmers_외벽_점검 {
	public static void main(String[] args) {
		int[] weak = {1, 5, 6, 10};
		int[] dist = {1, 2, 3, 4};
		int result = solution(12, weak, dist);
		System.out.println(result);
	}

	static int len;
	static int answer;
	    
	static public int solution(int n, int[] weak, int[] dist) {
	        answer = Integer.MAX_VALUE;
	        
	        len = weak.length;
	        
	        boolean[] visit = new boolean[len];
	        
	        dfs(0, n, weak, dist, visit, 0);
	        
	        return answer;
	    }
	    
	static void dfs(int cnt, int n, int[] weak, int[] dist, boolean[] visit, int flag) {
	        if (answer <= cnt) return;
	        if (len == flag) {
	            answer = cnt;
	            return;
	        }
	        
	        for (int i=0; i<len; i++) {
	            if (visit[i]) continue;
	            
	            boolean[] temp = visit.clone();
	            
	            int num = dist[dist.length-cnt-1], temp_flag = flag;
	            int j = i;
	            while (true) {
	                temp[j] = true;
	                temp_flag++;
	                
	                if (temp[(j+1)%len]) break;
	                int diff = weak[(j+1)%len] - weak[j]; //
	                if (diff < 0) diff += n;
	                if (num < diff) break;
	                num -= diff;
	                j = (j+1)%len;
	            }
	            
	            dfs(cnt+1, n, weak, dist, temp, temp_flag);
	        }
	    }
}
