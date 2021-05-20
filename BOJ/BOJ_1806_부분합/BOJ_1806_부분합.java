import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] numbers = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, sum = 0, result = Integer.MAX_VALUE;
		for (int i=0; i<N; i++) {
			sum += numbers[i];
			if (sum >= S) {
				result = Math.min(result, i-start);
				while (sum >= S) sum -= numbers[start++];
				result = Math.min(result, i-start+1);
			}
		}
		
		if (result == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(result+1);
	}
}
