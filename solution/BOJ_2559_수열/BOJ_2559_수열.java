import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2559_수열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		
		int[] num = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for (int i=0; i<k; i++) {
			sum += num[i];
		}
		
		int answer = sum;
		for (int i=k; i<n; i++) {
			sum -= num[i-k];
			sum += num[i];
			
			answer = Math.max(answer, sum);
		}
		
		System.out.println(answer);
	}
}
