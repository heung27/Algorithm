
public class Programmers_멀쩡한_사각형 {
	class Solution {
	    public long solution(int w, int h) {
	        long answer = (long)w * h;
	        long r = gcd(w, h);
	        answer -= w + h - r;
	        return answer;
	    }
	    
	    public int gcd(int a, int b) {
	        int r = a % b;
	        if (r == 0) return b;
	        else return gcd(b, r);
	    }
	}
}