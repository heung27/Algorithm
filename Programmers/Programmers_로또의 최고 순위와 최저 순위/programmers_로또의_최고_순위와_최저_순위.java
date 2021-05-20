
public class programmers_로또의_최고_순위와_최저_순위 {
	class Solution {
	    public int[] solution(int[] lottos, int[] win_nums) {
	        int[] check = new int[46];
	        
	        for (int i=0; i<lottos.length; i++) {
	            check[lottos[i]]++;
	        }
	        
	        int cnt = 0;
	        for (int i=0; i<win_nums.length; i++) {
	            if (check[win_nums[i]] != 0) {
	                cnt++;
	            }
	        }
	        
	        int high = 7 - (cnt+check[0]);
	        int low = 7 - cnt;
	        
	        if (high == 7) high--;
	        if (low == 7) low--;
	        
	        return new int[]{high, low};
	    }
	}
}
