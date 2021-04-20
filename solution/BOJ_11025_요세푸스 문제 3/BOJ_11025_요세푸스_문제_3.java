import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11025_요세푸스_문제_3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		
		int answer = 0;
		for (int i=1; i<=N; i++) {
			answer = (answer + K) % i;
		}
		
		System.out.println(answer+1);
	}
}
