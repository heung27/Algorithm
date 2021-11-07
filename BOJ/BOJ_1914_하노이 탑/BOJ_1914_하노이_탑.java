import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class BOJ_1914_하노이_탑 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	    int n = Integer.parseInt(br.readLine());
	    
	    bw.write(getLeastMoveCount(n).toString()+"\n");
	    
	    if (n <= 20) {
	    	move(n, 1, 2, 3);
	    	bw.write(sb.toString());
	    }
	    bw.flush();
	  }

	  static BigInteger getLeastMoveCount(int n) {
	    return new BigInteger("2").pow(n).subtract(BigInteger.ONE);
	  }

	  static void move(int n, int from, int tmp, int to) {
	    if (n == 1) {
	    	sb.append(from).append(" ").append(to).append("\n");
	    	return;
	    } 

	    move(n - 1, from, to, tmp);
	    sb.append(from).append(" ").append(to).append("\n");
	    move(n - 1, tmp, from, to);
	  }
}
