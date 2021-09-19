
public class Programmers_124_나라의_숫자 {
	class Solution {
	    public String solution(int n) {
	        StringBuilder sb = new StringBuilder();
	        
	        while (n != 0) {
	            int r = n % 3;
	            
	            if (r == 0) sb.append("4");
	            else if (r == 1) sb.append("1");
	            else sb.append("2");
	            
	            n = (n - 1) / 3;
	        }
	        
	        
	        return sb.reverse().toString();
	    }
	}
}
