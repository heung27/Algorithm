import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_5607_조합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int MAX = 1000000;
	
	static long MOD = 1234567891;
	
	static long[] arr = new long[MAX+1];
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		
		arr[1] = 1;
		for (int i=2; i<=MAX; i++) {
			arr[i] = (arr[i-1] * i) % MOD;
		}
		
		for (int t=1; t<=test; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			long a = arr[N];
			long b = (arr[R] * arr[N-R]) % MOD;
			
			b = mul(b, MOD-2);
			
			sb.append("#").append(t).append(" ").append(a * b % MOD).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static long mul(long x, long y) {
		if (y == 0) return 1;
		else if (y == 1) return x;
		
		long temp = mul(x, y/2);
		long pow = (temp * temp) % MOD;
		
		if (y % 2 == 0) return pow;
		else return (pow * x) % MOD;
	}
}
