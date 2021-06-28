import java.util.*;

public class Programmers_오픈채팅방 {
	
	class Solution {
	    
	    public String[] solution(String[] record) {
	        Map<String, String> map = new HashMap<>();
	        
	        String[][] temp = new String[record.length][];
	        int cnt = 0;
	        
	        for (int i=0; i<record.length; i++) {
	            temp[i] = record[i].split(" ");
	            if (!temp[i][0].equals("Change")) {
	                cnt++;
	            }
	        }
	        
	        String[] answer = new String[cnt];
	        
	        for (int i=0; i<record.length; i++) {
	            if (!temp[i][0].equals("Leave")) {
	                map.put(temp[i][1], temp[i][2]);
	            }
	        }
	        
	        cnt = 0;
	        for (int i=0; i<record.length; i++) {
	            if (temp[i][0].equals("Enter")) {
	                answer[cnt++] = map.get(temp[i][1]) + "님이 들어왔습니다.";
	            }
	            else if (temp[i][0].equals("Leave")) {
	                answer[cnt++] = map.get(temp[i][1]) + "님이 나갔습니다.";
	            }
	        }
	        
	        return answer;
	    }
	}
}
