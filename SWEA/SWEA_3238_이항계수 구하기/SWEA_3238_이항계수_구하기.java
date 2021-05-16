import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_3238_이항계수_구하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=test; t++) {
			st = new StringTokenizer(br.readLine());
			long N = Long.parseLong(st.nextToken());
			long K = Long.parseLong(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			long[] fac = new long[P];
			long answer = 1;
			
			fac[0] = 1;
			for (int i=1; i<P; i++) {
				fac[i] = (fac[i-1] * i) % P;
			}
			
			while (N != 0 || K != 0) {
				int n = (int)(N % P);
				int k = (int)(K % P);
				
				if (n < k) {
					answer = 0;
					break;
				}
				
				long a = (answer * fac[n]) % P;
				long b = pow((fac[n-k] * fac[k]) % P, P-2, P) % P;
				
				answer = (a * b) % P;
				
				N /= P;
				K /= P;
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static long pow(long x, long y, int P) {
		if (y == 0) return 1;
		
		long temp = pow(x, y/2, P);
		
		long pow = temp * temp % P;
		
		if (y % 2 == 0) return pow;
		else return (pow * x) % P;
	}
}
