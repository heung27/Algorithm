import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2941_크로아티아_알파벳 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		
		int cnt = 0;
		for (int i=str.length()-1; i>=0; i--) {
			char c = str.charAt(i);
			if (c == '=' || c == '-') {
				i--;
				if (i-1 >= 0 && str.charAt(i) == 'z' && str.charAt(i-1) == 'd') {
					i--;
				}
			}
			else if (c == 'j') {
				if (i-1 >= 0 && (str.charAt(i-1) == 'l' || str.charAt(i-1) == 'n')) i--;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
