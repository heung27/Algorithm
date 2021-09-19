import java.util.*;

public class Programmers_짝지어_제거하기 {
	class Solution {
	    public int solution(String s) {
	        char[] arr = s.toCharArray();
	        int len = arr.length;
	        
	        Stack<Character> stack = new Stack<>();
	        int index = 0;
	        while (index < len) {
	            if (!stack.isEmpty() && stack.peek() == arr[index]) {
	                stack.pop();
	            }
	            else stack.add(arr[index]);
	            index++;
	        }

	        return stack.isEmpty() ? 1 : 0;
	    }
	}
}
