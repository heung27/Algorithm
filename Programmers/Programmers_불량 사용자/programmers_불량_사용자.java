import java.util.*;

public class programmers_불량_사용자 {
	class Solution {
	    Set<Integer> visit = new HashSet<>();
	    
	    Set<String>[] list;
		String[] ban;
	    
	    boolean[] check;
		int size, answer;
	    
	    public int solution(String[] user_id, String[] banned_id) {
	        list = new HashSet[user_id.length];
	        size = banned_id.length;
	        ban = banned_id;
	        
	        check = new boolean[user_id.length];

	        for (int i=0; i<user_id.length; i++) {
	            list[i] = new HashSet<>();
	            subset(list[i], user_id[i].toCharArray(), 0);
	        }

	        perm(0, 0);

	        return answer;
	    }
	    
	   void subset(Set<String> set, char[] str, int cnt) {
			if (cnt == str.length) {
				set.add(String.valueOf(str));
				return;
			}
			subset(set, str, cnt+1);
			
			char[] str2 = str.clone();
			str2[cnt] = '*';
			subset(set, str2, cnt+1);
		}
		
		void perm(int cnt, int flag) {
			if (cnt == size) {
				if (visit.add(flag)) answer++;
				return;
			}
			for (int i=0; i<list.length; i++) {
				if (check[i] || !list[i].contains(ban[cnt])) continue;
				
				check[i] = true;
				perm(cnt+1, flag|(1 << i));
				check[i] = false;
			}
		}
	}
}