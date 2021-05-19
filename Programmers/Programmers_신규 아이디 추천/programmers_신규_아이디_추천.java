
public class programmers_신규_아이디_추천 {
	class Solution {
	    public String solution(String new_id) {
	        new_id = new_id.toLowerCase();
	        
	       char[] c = {'~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '=', '+', '[', '{', ']', '}', ':', '?', ',', '<', '>', '/'};
			for (int i=0; i<c.length; i++) {
				new_id = new_id.replace(c[i]+"", "");
			}
			
			while (true) {
				String temp = new_id.replace("..", ".");
				if (new_id == temp) break;
				new_id = temp;
			}
			
			if (!new_id.equals("")) {
				if (new_id.charAt(0) == '.') {
					new_id = new_id.substring(1, new_id.length());
				}
				
	            if (!new_id.equals("")) {
	                if (new_id.charAt(new_id.length()-1) == '.') {
					new_id = new_id.substring(0, new_id.length()-1);
				    }
	            }
			}
			
			if (new_id.equals("")) {
				new_id += "a";
			}
			
			if (new_id.length() >= 16) {
				new_id = new_id.substring(0, 15);
				
				if (new_id.charAt(new_id.length()-1) == '.') {
					new_id = new_id.substring(0, new_id.length()-1);
				}
			}
			
			if (new_id.length() <= 2) {
				while (new_id.length() != 3) {
					new_id += new_id.charAt(new_id.length()-1);
				}
			}
	        
	        return new_id;
	    }
	}
}
