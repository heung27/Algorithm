import java.util.*;

public class Programmers_괄호_회전하기 {
	class Solution {
	    public int solution(String s) {
	        int answer = 0;
	        char[] arr = s.toCharArray();
	        int len = arr.length;
	        
	        for (int j=0; j<len; j++){
	            Stack<Character> stack = new Stack<>();
	            for (int i=0; i<len; i++) {
	                boolean check = true;
	                switch (arr[(i+j)%len]) {
	                    case ']':
	                        if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
	                        else check = false;
	                        break;
	                    case ')':
	                        if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
	                        else check = false;
	                        break;
	                    case '}':
	                        if (!stack.isEmpty() && stack.peek() == '{') stack.pop();
	                        else check = false;
	                        break;
	                    default:
	                        stack.add(arr[(i+j)%len]);
	                        break;
	                }
	                if (!check || (i == len-1 && !stack.isEmpty())) {
	                    answer++;
	                    break;
	                }
	            }
	        }
	        return len - answer;
	    }
	}
}
