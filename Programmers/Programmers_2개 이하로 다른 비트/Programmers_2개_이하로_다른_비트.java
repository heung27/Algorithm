
public class Programmers_2개_이하로_다른_비트 {
	class Solution {
	    public long[] solution(long[] numbers) {
	        int len = numbers.length;
	        long[] answer = new long[len];
	        
	        for (int i=0; i<len; i++) {
	            long temp = (numbers[i] ^ (numbers[i] + 1)) >> 2;
	            
	            answer[i] = numbers[i] + temp + 1;
	        }
	        
	        return answer;
	    }
	}
}
