import java.util.*;

public class Programmers_표_편집 {
	class Solution {
	    int[] tree;
		int len, temp_n;
	    
	    public String solution(int n, int k, String[] cmd) {
	        len = 1;
	        temp_n = n;
	        
	        while (len < n) {
	        	len <<= 1;
	        }
	        
	        tree = new int[len*2];
	        for (int i=len; i<n+len; i++) {
	        	tree[i] = 1;
	        }
	        
	        for (int i=len; i<n+len; i++) {
	        	int temp = i >> 1;
	        	while (temp != 0) {
	        		tree[temp] = tree[temp] + tree[i];
	        		temp >>= 1;
	        	}
	        }
	        
	        Stack<Integer> stack = new Stack<>();
	        
	        int current = k;
	        for (int i=0; i<cmd.length; i++) {
	        	char c = cmd[i].charAt(0);
	        	if (c == 'D') {
	                int num = Integer.valueOf(cmd[i].substring(2));
	        		int move = binarySearch1(num, n-current-1, current, num);
	        		current += move;
	        	}
	        	else if (c == 'U') {
	                int num = Integer.valueOf(cmd[i].substring(2));
	        		int move = binarySearch2(num, current, current, num);
	        		current -= move;
	        	}
	        	else if (c == 'C') {
	        		update(len+current, 0);
	        		stack.add(current);
	        		int move = binarySearch1(1, n-current-1, current, 1);
	        		if (move == 0) {
	        			move = binarySearch2(1, current, current, 1);
	        			current -= move;
	        		}
	        		else current += move;
	        	}
	        	else {
	        		int temp = stack.pop();
	        		update(len+temp, 1);
	        	}
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        for (int i=len; i<n+len; i++) {
	        	if (tree[i] == 1) sb.append("O");
	        	else sb.append("X");
	        }
	        
	        return sb.toString();
	    }
		
		void update(int index, int num) {
			int diff = num - tree[index];
			
			while (index != 0) {
				tree[index] += diff;
				index >>= 1;
			}
		}
		
		boolean check(int start, int end, int k) {
			int sum = 0;
			
			while (start < end) {
				if ((start & 1) == 1) {
					sum += tree[start++];
				}
				if ((end & 1) == 0) {
					sum += tree[end--];
				}
				start >>= 1;
				end >>= 1;
			}
			
			if (start == end) sum += tree[start];
			
			if (sum < k) return false;
			else return true;
		}
		
		int binarySearch1(int left, int right, int start, int k) {
	        int temp = 0;
			while (left <= right) {
				int mid = (left + right) / 2;
				
				if (check(len+start+1, len+start+mid, k)) {
					right = mid - 1;
	                temp = mid;
				}
				else {
					left = mid + 1;
				}
			}
			return temp;
		}
		
		int binarySearch2(int left, int right, int start, int k) {
	        int temp = 0;
			while (left <= right) {
				int mid = (left + right) / 2;
				
				if (check(len+start-mid, len+start-1, k)) {
					right = mid - 1;
	                temp = mid;
				}
				else {
					left = mid + 1;
				}
			}
			return temp;
		}
	}
}
