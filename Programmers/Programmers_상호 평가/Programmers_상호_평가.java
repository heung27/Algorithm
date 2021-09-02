
public class Programmers_상호_평가 {
	class Solution {
	    public String solution(int[][] scores) {
	        String answer = "";
	        for (int j=0; j<scores[0].length; j++) {
	            int sum = 0, max = 0, min = 100;
	            int max_index = 0, min_index = 0;
	            for (int i=0; i<scores.length; i++) {
	                sum += scores[i][j];
	                
	                if (max < scores[i][j]) {
	                    max = scores[i][j];
	                    max_index = i;
	                } else if (max == scores[i][j]) {
	                    max_index = -1;
	                }
	                
	                if (min > scores[i][j]) {
	                    min = scores[i][j];
	                    min_index = i;
	                } else if (min == scores[i][j]) {
	                    min_index = -1;
	                }
	            }
	            int cnt = scores.length;
	            if (max_index == j) {
	                sum -= max;
	                cnt--;
	            } else if (min_index == j) {
	                sum -= min;
	                cnt--;
	            }
	            double avg = (double)sum / cnt;
	            if (avg >= 90) {
	                answer += "A";
	            } else if (avg >= 80) {
	                answer += "B";
	            } else if (avg >= 70) {
	                answer += "C";
	            } else if (avg >= 50) {
	                answer += "D";
	            } else {
	                answer += "F";
	            }
	        }
	        return answer;
	    }
	}
}
