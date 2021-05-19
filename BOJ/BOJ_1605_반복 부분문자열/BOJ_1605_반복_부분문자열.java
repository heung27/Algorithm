import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_1605_반복_부분문자열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static char[] str;
	static int len, D = 37;
	static int M = 100003;
	
	public static void main(String[] args) throws IOException {
		len = Integer.parseInt(br.readLine());
		str = br.readLine().toCharArray();
		
		System.out.println(Search(1, len-1));
	}
	
	static int Search(int left, int right) {
		int result = 0;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (check(mid)) {
				result = mid;
				left = mid+1;
			}
			else {
				right = mid-1;
			}
		}
		
		return result;
	}
	
	static boolean check(int k) {
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] list = new ArrayList[M];
		int value = 0, pow = 1;
		
		for (int i=k-1; i>=0; i--) {
			value = (value + (str[i]-96) * pow) % M ;
		
			if (i != 0) pow = (pow * D) % M;
		}
		value = (value + M) % M;
		
		list[value] = new ArrayList<>();
		list[value].add(0);
		
		for (int i=1; i<=len-k; i++) {
			value = ((D * (value - (str[i-1]-96) * pow)) + str[i+k-1]-96) % M;
			value = (value + M) % M;
			
			if (list[value] == null) {
				list[value] = new ArrayList<>();
				list[value].add(i);
			}
			else {
				for (int x : list[value]) {
					boolean eq = true;
					for (int j=0; j<k; j++) {
						if (str[i+j] != str[x+j]) {
							eq = false;
							break;
						}
					}
					
					if (eq) return true;
				}
				list[value].add(i);
			}
		}
		return false;
	}
}
