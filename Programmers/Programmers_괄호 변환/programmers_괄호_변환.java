
public class programmers_괄호_변환 {
	class Solution {
	    StringBuilder sb = new StringBuilder();
	    
	    public String solution(String p) {  
	        return divide(p);
	    }
	    
	    public String sol(String u, String v) {
	        boolean check = true;
	        int flag = 0;
	        
	        for (int i=0; i<u.length(); i++) {
	            if (u.charAt(i) == '(') flag++;
	            else flag--;
	            
	            if (flag < 0) {
	                check = false;
	                break;
	            }
	        }
	        if (flag > 0) check = false;
	        
	        if (!check) {
	            String temp = u.substring(1, u.length()-1);
	            temp = temp.replace('(', '[');
	            temp = temp.replace(')', '(');
	            temp = temp.replace('[', ')');
	            return "(" + divide(v) + ")" + temp;
	        }
	        else return u + divide(v);
	    }
	    
	    public String divide(String v) {
	        int flag = 0;
	        
	        for (int i=0; i<v.length(); i++) {
	            if (v.charAt(i) == '(') flag++;
	            else flag--;
	            
	            if (flag == 0) {
	                return sol(v.substring(0, i+1), v.substring(i+1, v.length()));
	            }
	        }
	        return "";
	    }
	}
}
