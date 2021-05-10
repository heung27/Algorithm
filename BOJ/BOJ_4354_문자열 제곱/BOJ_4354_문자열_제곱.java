import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_4354_문자열_제곱 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] fail;
	static char[] str;
	static int size;
	
	public static void main(String[] args) throws IOException {
		while (true) {
			str = br.readLine().toCharArray();
			size = str.length;
			
			if (size == 1 && str[0] == '.') break;
			
			KMP();
			
			int num = fail[size-1];
			
			if (size % (size - num) == 0) {
				sb.append(size / (size - num));
			}
			else sb.append("1");
			
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void KMP() {
		fail = new int[size];
		
		int i=1, j=0;
		while (i<size) {
			if (str[i] == str[j]) {
				fail[i++] = ++j;
			}
			else {
				if (j==0) i++;
				else j = fail[j-1];
			}
		}
	}
}
