public class Programmers_가장_긴_팰린드롬 {
	class Solution {
	    public int solution(String s) {
	        int len = s.length();
	        int left = 0, right = 0;
	        int result = 1;

	        if(len != 1) {
	            for (int center = 1; center < len - 1; center++) {
	                left = center - 1;
	                right = center + 1;
	                while (left >= 0 && right <= len - 1) {
	                    if (s.charAt(left) != s.charAt(right)) break;

	                    result = Math.max(result, right - left + 1);
	                    left--;
	                    right++;
	                }
	            }

	            for (int center = 0; center <= len - 2; center++) {
	                left = center;
	                right = center + 1;
	                while (left >= 0 && right <= len - 1) {
	                    if (s.charAt(left) != s.charAt(right)) break;
	                    
	                    result = Math.max(result, right - left + 1);
	                    left--;
	                    right++;
	                }
	            }
	        }

	        return result;
	    }
	}
}