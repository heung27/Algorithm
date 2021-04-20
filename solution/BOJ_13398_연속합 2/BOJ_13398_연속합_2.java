import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_13398_연속합_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] numbers, left, right;
	static int N, answer;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		answer = Integer.MIN_VALUE;
		
		numbers = new int[N];
		left = new int[N];
		right = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		left[0] = numbers[0];
		right[N-1] = numbers[N-1];
		for (int i=1,j=N-2; i<N; i++,j--) {
			left[i] = Math.max(numbers[i], left[i-1] + numbers[i]);
			right[j] = Math.max(numbers[j], right[j+1] + numbers[j]);
		}
		
		for (int i=0; i<N; i++) {
			answer = Math.max(answer, left[i]);
		}
		
		for (int i=1; i<N-1; i++) {
			answer = Math.max(answer, left[i-1] + right[i+1]);
		}
		
		System.out.println(answer);
	}
}
