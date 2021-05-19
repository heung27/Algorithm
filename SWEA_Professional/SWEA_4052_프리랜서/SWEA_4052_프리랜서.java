import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4052_프리랜서 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static class Node implements Comparable<Node> {
		int start, end;
		int cost;
		
		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.end - o.end;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			sb.append("#").append(t).append(" ");
			
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			
			int[] dp = new int[M+1];
			Node[] list = new Node[N];
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				list[i] = new Node(start, end, cost);
			}
			
			Arrays.sort(list);
			
			int index = 0;
			for (int i=1; i<=M; i++) {
				dp[i] = Math.max(dp[i], dp[i-1]);
				
				if (list[index].end == i) {
					dp[i] = Math.max(dp[i], dp[list[index].start-1] + list[index].cost);
					i--; index++;
					
					if (index == N) {
						sb.append(dp[i+1]);
						break;
					}
				}
			}
			
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
