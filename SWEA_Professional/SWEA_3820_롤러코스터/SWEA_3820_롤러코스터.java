import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3820_롤러코스터 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int M = 1000000007;
	
	static class Node implements Comparable<Node> {
		int a, b;

		public Node(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Node o) {
			double x = (double)(this.a-1)/this.b;
			double y = (double)(o.a-1)/o.b;
			return Double.compare(y, x);
		}
	}
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			int N = Integer.parseInt(br.readLine());
			
			Node[] list = new Node[N];
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list[i] = new Node(a, b);
			}
			
			Arrays.sort(list);
			
			long answer = 1;
			for (int i=0; i<N; i++) {
				answer = (answer * list[i].a)%M + list[i].b;
				answer %= M;
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
