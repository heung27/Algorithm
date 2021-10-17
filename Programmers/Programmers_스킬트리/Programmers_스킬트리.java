
public class Programmers_스킬트리 {
	class Solution {
	    public int solution(String skill, String[] skill_trees) {
	        int answer = 0;
	        
	        char[] arr = skill.toCharArray();
	        
	        for (int i=0; i<skill_trees.length; i++) {
	            int[] pos = new int[26];
	            char[] temp = skill_trees[i].toCharArray();
	            boolean check = true;
	            
	            for (int j=0; j<temp.length; j++) {
	                pos[temp[j]-'A'] = j+1;
	            }
	            
	            for (int j=1; j<arr.length; j++) {
	                
	                if (pos[arr[j]-'A'] != 0 && (pos[arr[j-1]-'A'] == 0 || pos[arr[j-1]-'A'] > pos[arr[j]-'A'])) {
	                    check = false;
	                    break;
	                }
	            }
	            
	            if (check) answer++;
	        }
	        
	        return answer;
	    }
	}
}
