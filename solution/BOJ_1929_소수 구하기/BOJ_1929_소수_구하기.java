import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1929_소수_구하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		for (int i=N; i<=M; i++) {
			if (prime(i)) sb.append(i).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static boolean prime(int n) {
		if (n < 2)  return false;
		for (int i=2; i*i <= n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
}
