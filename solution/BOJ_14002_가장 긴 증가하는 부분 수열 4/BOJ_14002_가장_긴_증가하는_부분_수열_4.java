import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_14002_가장_긴_증가하는_부분_수열_4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] parent;
	static int[] num;
	static int[] dp;
	static int N, answer, index;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		parent = new int[N];
		num = new int[N];
		dp = new int[N];
		Arrays.fill(parent, -1);
		answer = 1;
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 1;
		for (int i=1; i<N; i++) {
			int max = 0;
			for (int j=i-1; j>=0; j--) {
				if (num[i] > num[j]) {
					if (max < dp[j]) {
						max = dp[j];
						parent[i] = j;
					}
				}
			}
			dp[i] = max+1;
			if (answer < dp[i]) {
				answer = dp[i];
				index = i;
			}
		}
		
		sb.append(answer).append("\n");
		
		Stack<Integer> stack = new Stack<>();
		int temp = parent[index];
		stack.add(num[index]);
		while (temp != -1) {
			stack.add(num[temp]);
			temp = parent[temp];
		}
		
		while (!stack.isEmpty()) sb.append(stack.pop()).append(" ");
		
		bw.write(sb.toString());
		bw.flush();
	}
}
