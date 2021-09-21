import java.util.*;

public class Programmers_캐시 {
	class Solution {
	    public int solution(int cacheSize, String[] cities) {
	        int answer = 0;
	        int len = cities.length;
	        
	        if (cacheSize == 0) return 5 * len;
	        
	        Map<String, Integer> map = new HashMap<>();
	        int index = 0;
	        while (map.size() < cacheSize && index < len) {
	            String low = cities[index].toLowerCase();
	            if (map.containsKey(low)) {
	                answer += 1;
	            } else {
	                answer += 5;
	            }
	            map.put(low, index);
	            index++;
	        }
	        for (int i=index; i<len; i++) {
	            String low = cities[i].toLowerCase();
	            if (map.containsKey(low)) {
	                map.put(low, i);
	                answer += 1;
	            } else {
	                String str = null;
	                int min = Integer.MAX_VALUE;
	                for (String key : map.keySet()) {
	                    if (min > map.get(key)) {
	                        str = key;
	                        min = map.get(key);
	                    }
	                }
	                map.remove(str);
	                map.put(low, i);
	                answer += 5;
	            }
	        }
	        
	        return answer;
	    }
	}
}
