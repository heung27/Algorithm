import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15791_세진이의_미팅 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static long MOD = 1000000007L;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long R = Long.parseLong(st.nextToken());
		
		long a = 1, b1 = 1, b2 = 1;
		
		for (long i=2; i<=N; i++) {
			a *= i;
			a %= MOD;
			
			if (i == R) b1 = a;
			if (i == N-R) b2 = a;
		}
		
		long b = (b1 * b2) % MOD;
		
		b = mul(b, MOD-2);
		
		System.out.println((a * b) % MOD);
	}
	
	static long mul(long x, long y) {
		if (y == 0) return 1;
		
		long temp = mul(x, y/2);
		long pow = (temp * temp) % MOD;
		
		if (y % 2 == 0) return pow;
		else return (pow * x) % MOD;
	}
}
