import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047_동전_0 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] coin;
	static int N, K, cnt;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		coin = new int[N];
		
		for (int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i=N-1; i>=0; i--) {
			cnt += K / coin[i];
			K %= coin[i];
			if (K == 0) break;
		}
		
		System.out.println(cnt);
	}
}
