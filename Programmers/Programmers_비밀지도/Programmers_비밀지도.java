
public class Programmers_비밀지도 {
	class Solution {
	    public String[] solution(int n, int[] arr1, int[] arr2) {
	        String[] answer = new String[n];
	        
	        for (int i=0; i<n; i++) {
	            int[] temp = new int[n];
	            int num1 = arr1[i];
	            int num2 = arr2[i];
	            
	            for (int j=n-1; j>=0; j--) {
	                temp[j] = num1 % 2;
	                num1 /= 2;
	                if (temp[j] == 0) {
	                    temp[j] = num2 % 2;
	                }
	                num2 /= 2;
	            }
	            
	            StringBuilder sb = new StringBuilder();
	            for (int j=0; j<n; j++) {
	                sb.append(temp[j] == 0 ? " " : "#");
	            }
	            answer[i] = sb.toString();
	        }
	        
	        return answer;
	    }
	}
}
