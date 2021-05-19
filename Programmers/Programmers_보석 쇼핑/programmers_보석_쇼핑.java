import java.util.*;

public class programmers_보석_쇼핑 {
	class Solution {
	    String[] gems;
	    
		Map<String, Integer> map = new HashMap<>();
		int[] answer = new int[2];
		int cnt;
	    
	    public int[] solution(String[] gems_temp) {
	        gems = gems_temp;
	        
	        for (int i = 0; i < gems.length; i++) {
				if (map.get(gems[i]) == null) {
					map.put(gems[i], 1);
					cnt++;
				}
			}
			BinarySearch(1, gems.length);
	        
	        answer[0]++; answer[1]++;
	        return answer;
	    }
	    
	    public void BinarySearch(int left, int right) {
			while (left <= right) {
				int mid = (left + right) / 2;

				if (check(mid)) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}

		public boolean check(int k) {
			map.clear();
			int i = 0, x = 0;
			for ( ; i < k; i++) {
				if (map.get(gems[i]) == null) {
					map.put(gems[i], 1);
					x++;
				} else
					map.put(gems[i], map.get(gems[i]) + 1);
			}
			if (x == cnt) {
				answer[0] = 0; answer[1] = i-1;
				return true;
			}
			
			for ( ; i<gems.length; i++) {
				int temp = map.get(gems[i-k]);
				map.put(gems[i-k], temp-1);
				if (temp == 1) x--;
				
				if (map.get(gems[i]) == null || map.get(gems[i]) == 0) {
					map.put(gems[i], 1);
					x++;
				} else
					map.put(gems[i], map.get(gems[i]) + 1);
				if (x == cnt) {
					answer[0] = i-k+1; answer[1] = i;
					return true;
				}
			}
			return false;
		}
	}
}
