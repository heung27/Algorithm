import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_12025_장난꾸러기_영훈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		char[] str = br.readLine().toCharArray();
		long K = Long.parseLong(br.readLine())-1;
		
		for (int i=str.length-1; i>=0; i--) {
			if (str[i] == '1' || str[i] == '6') {
				if ((K & 1) == 0) str[i] = '1';
				else str[i] ='6';
				K >>= 1;
			}
			else if (str[i] == '2' || str[i] == '7') {
				if ((K & 1) == 0) str[i] = '2';
				else str[i] ='7';
				K >>= 1;
			}
		}
		
		if (K != 0) System.out.println(-1);
		else System.out.println(String.valueOf(str));
	}
}
