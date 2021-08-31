
public class Programmers_단체사진_찍기 {
	class Solution {
	    char[] arr = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	    boolean[] visit = new boolean[26];
	    int[] index = new int[26];
	    int answer = 0;
	    
	    public int solution(int n, String[] data) {
	        func(0, data);
	        return answer;
	    }
	    
	    void func(int cnt, String[] data) {
	        if (cnt == 8) {
	            if (check(data)) answer++;
	            return;
	        }
	        for (int i=0; i<8; i++) {
	            if (visit[arr[i]-'A']) continue;
	            visit[arr[i]-'A'] = true;
	            index[arr[i]-'A'] = cnt;
	            func(cnt+1, data);
	            visit[arr[i]-'A'] = false;
	        }
	    }
	    
	    boolean check(String[] data) {
	        for (int i=0; i<data.length; i++) {
	            char a = data[i].charAt(0);
	            char b = data[i].charAt(2);
	            char op = data[i].charAt(3);
	            int dist = data[i].charAt(4)-'0';
	            
	            int diff = Math.abs(index[a-'A'] - index[b-'A'])-1;
	            switch (op) {
	                case '=':
	                    if (diff != dist) return false;
	                    break;
	                case '<':
	                    if (diff >= dist) return false;
	                    break;
	                case '>':
	                    if (diff <= dist) return false;
	            }
	        }
	        return true;
	    }
	}
}
