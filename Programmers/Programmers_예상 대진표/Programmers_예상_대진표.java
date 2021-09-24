
public class Programmers_예상_대진표 {
	class Solution {
	    public int solution(int n, int a, int b) {
	        int cnt = 0;
	        while (a != b) {
	            a = a/2 + a%2;
	            b = b/2 + b%2;
	            cnt++;
	        }
	        return cnt;
	    }
	}
}
