import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_16472_고냥이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		char[] arr = br.readLine().toCharArray();
		
		int[] visit = new int[26];
		int pre = 0, cur = 0, cnt = 0;
		int answer = 0;
		
		while (cur < arr.length) {
			if (visit[arr[cur]-'a']++ == 0) {
				cnt++;
				
				if (cnt > N) {
					answer = Math.max(answer, cur-pre);
					while (pre <= cur) {
						if (--visit[arr[pre++]-'a'] == 0) {
							if (--cnt == N) break;
						}
					}
					
				}
			}
			cur++;
		}
		answer = Math.max(answer, cur-pre);
		
		System.out.println(answer);
	}
}
