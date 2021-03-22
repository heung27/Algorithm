import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_13458_시험_감독 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] area;
	static int N, B, C;
	static long answer;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		area = new int[N];
		answer = N;
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			area[i] = Integer.parseInt(st.nextToken());
		}
		
		String[] str = br.readLine().split(" ");
		B = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		
		for (int i=0; i<N; i++) {
			area[i] -= B;
			if (area[i] <= 0) continue;
			answer += (long)Math.ceil((double)area[i]/C);
		}
		
		System.out.println(answer);
	}
}
