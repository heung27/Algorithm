import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_3499_퍼펙트_셔플 {
	static String[] str;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			int N = Integer.parseInt(br.readLine());
			str = br.readLine().split(" ");
			sb.append("#").append(t);
			sol(N);
		}
		System.out.println(sb);
	}
	static void sol(int n) {
		int index = (int) Math.ceil((double)n/2);
		int x = 0;
		for ( ; x<n/2; x++, index++) {
			sb.append(" ").append(str[x]);
			sb.append(" ").append(str[index]);
		}
		if (n%2 == 1) sb.append(" ").append(str[x]);
		sb.append("\n");
	}
}
