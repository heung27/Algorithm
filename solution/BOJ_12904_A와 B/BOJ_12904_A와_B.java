import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_12904_A와_B {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		String start = br.readLine();
		char[] end = br.readLine().toCharArray();
		
		boolean check = false;
		int left = 0, right = end.length-1;
		
		while (right - left >= start.length()) {
			if (!check) {
				if (end[right] == 'B') {
					check = true;
				}
				right--;
			}
			else {
				if (end[left] == 'B') {
					check = false;
				}
				left++;
			}
		}
		
		for (int i=left; i<=right; i++) {
			sb.append(end[i]);
		}
		if (check) sb.reverse();
		
		if (start.equals(sb.toString())) System.out.println(1);
		else System.out.println(0);
	}
}
	
