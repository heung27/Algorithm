import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1289_원재의_메모리_복구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			int answer = 0;
			String str = br.readLine();
			char start = '0';
			for (int i=0; i<str.length(); i++) {
				if (start != str.charAt(i)) {
					answer++;
					start = str.charAt(i);
				}
			}
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb);
	}
}
