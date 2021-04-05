import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class BOJ_1793_타일링 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static BigInteger[] dp = new BigInteger[251+2];
	
	public static void main(String[] args) throws IOException {
		
		dp[0] = new BigInteger("1");
		dp[1] = new BigInteger("1");
		dp[2] = new BigInteger("3");
		
		for (int i=3; i<=250; i++) {
			dp[i] = dp[i-1].add(dp[i-2].shiftLeft(1));
		}
		
		String str = "";
		while ((str = br.readLine()) != null) {
			sb.append(dp[Integer.parseInt(str)]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}
