
public class Programmers_부족한_금액_계산하기 {
	class Solution {
	    public long solution(int price, int money, int count) {
	        long answer = 0;
	        for (int cnt=1; cnt<=count; cnt++) {
	            answer += price * cnt;
	        }
	        answer = Math.max(0, answer - money);
	        return answer;
	    }
	}
}
