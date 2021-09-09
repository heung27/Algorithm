import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1013_Contact {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String str = br.readLine();
			if (str.matches("(100+1+|01)+")) {
				sb.append("YES");
			} else {
				sb.append("NO");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
