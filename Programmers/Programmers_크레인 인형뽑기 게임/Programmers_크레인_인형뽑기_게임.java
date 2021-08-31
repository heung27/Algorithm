import java.util.*;

public class Programmers_크레인_인형뽑기_게임 {
	class Solution {
	    public int solution(int[][] board, int[] moves) {
	        Stack<Integer> stack = new Stack<>();
	        int count = 0;
	        
	        for (int i=0; i<moves.length; i++) {
	            for (int j=0; j<board.length; j++) {
	                int num = board[j][moves[i]-1];
	                if (num != 0) {
	                    if (!stack.isEmpty() && stack.peek() == num) {
	                        stack.pop();
	                        count += 2;
	                    }
	                    else stack.add(num);
	                    board[j][moves[i]-1] = 0;
	                    break;
	                }
	            }
	        }
	        return count;
	    }
	}
}
