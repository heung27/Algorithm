import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2671_잠수함식별 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		if (str.matches("(100+1+|01)+")) {
			System.out.println("SUBMARINE");
		} else {
			System.out.println("NOISE");
		}
	}
}
