
public class Programmers_광고_삽입 {
	
	class Solution {
		
	    public String solution(String play_time, String adv_time, String[] logs) {
	        int size = getSecond(play_time);
	        int len = getSecond(adv_time);
	        
	        long[] play = new long[size+1];
	        for (String log : logs) {
	            String[] temp = log.split("-");
	            int start = getSecond(temp[0]);
	            int end = getSecond(temp[1]);
	            
	            play[start]++; play[end]--;
	        }
	        
	        for (int i=1; i<=size; i++) play[i] += play[i-1];
	        for (int i=1; i<=size; i++) play[i] += play[i-1];
	        
	        long max = play[len-1]; int index = 0;
	        for (int i=0; i+len<=size; i++) {
	            long temp = play[i+len] - play[i];
	            if (temp > max) {
	                max = temp;
	                index = i+1;
	            }
	        }
	        
	        int h = (int)(index / 3600);
	        index %= 3600;
	        int m = (int)(index / 60);
	        index %= 60;
	        int s = (int)index;
	        
	        return String.format("%02d:%02d:%02d", h, m, s);
	    }
	    
	    private int getSecond(String time) {
	        String[] str = time.split(":");
	        
	        int temp = 0;
	        temp += Integer.parseInt(str[0]) * 3600;
	        temp += Integer.parseInt(str[1]) * 60;
	        temp += Integer.parseInt(str[2]);
	        
	        return temp;
	    }
	}
}
