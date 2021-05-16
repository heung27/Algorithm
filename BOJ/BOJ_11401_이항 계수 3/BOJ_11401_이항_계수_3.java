import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11401_이항_계수_3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static long DIV = 1000000007;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		long N = Long.parseLong(str[0]);
		long K = Long.parseLong(str[1]);
		
		long a = 1, b1 = 1, b2 = 1;
		
		for (int i=2; i<=N; i++) {
			a = (a * i) % DIV;
			
			if (i == K) b1 = a;
			if (i == N-K) b2 = a;
		}
		
		long b = (b1 * b2) % DIV;
		
		b = mul2(b, DIV-2); 
		
		long result = (a * b) % DIV;
		
		System.out.println(result);
	}
	
	static long mul(long x, long y) {
		long num = 1;
		
		while (y > 0) {
			if (y % 2 != 0) {
				num = (num * x) % DIV;
			}
			x = (x * x) % DIV;
			y >>= 1;
		}
		
		return num;
	}
	
	static long mul2(long x, long y) { // 분할 정복을 이용한 거듭제곱
		if (y == 0) return 1;
		
		long temp = mul2(x, y/2);
		
		long pow = temp * temp % DIV;
		
		if (y % 2 == 0) return pow;
		else return (pow * x) % DIV;
	}
}
