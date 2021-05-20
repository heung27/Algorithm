import java.util.*;

public class programmers_다단계_칫솔_판매 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] result = new int[enroll.length];
		
		Map<String, String> map = new HashMap<>();
		Map<String, Integer> sum = new HashMap<>();
		
		for (int i=0; i<enroll.length; i++) {
			map.put(enroll[i], referral[i]);
		}
		
		for (int i=0; i<seller.length; i++) {
			String temp = seller[i];
			int cost = amount[i] * 100;
			
			while (!temp.equals("-")) {
				int m = cost / 10;
				
				sum.put(temp, sum.getOrDefault(temp, 0)+cost-m);
				if (m < 1) break;
				
				temp = map.get(temp);
				cost = m;
			}
		}
		
		for (int i=0; i<enroll.length; i++) {
			result[i] = sum.getOrDefault(enroll[i], 0);
		}
		
		return result;
	}
}