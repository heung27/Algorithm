import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_20437_문자열_게임_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		
		for (int t=0; t<test; t++) {
			char[] str = br.readLine().toCharArray();
			int K = Integer.parseInt(br.readLine());
			
			int max = -1, min = 10001;
			
			list = new ArrayList[26];
			for (int i=0; i<26; i++) list[i] = new ArrayList<>();
			
			for (int i=0; i<str.length; i++) {
				list[str[i]-'a'].add(i);
			}
			
			for (int i=0; i<26; i++) {
				if (list[i].size() < K) continue;
				
				for (int j=0; j<=list[i].size()-K; j++) {
					int diff = list[i].get(j+K-1) - list[i].get(j) + 1;
					max = Math.max(max, diff);
					min = Math.min(min, diff);
				}
			}
			
			if (max == -1) sb.append(-1);
			else sb.append(min).append(" ").append(max);
			
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
