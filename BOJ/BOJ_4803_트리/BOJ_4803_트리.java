import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_4803_트리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static boolean[] check;
	static int[] parents;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		int t = 1;
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if (N == 0 && M == 0) break;
			
			check = new boolean[N+1];
			parents = new int[N+1];
			
			for (int i=1; i<=N; i++) {
				parents[i] = i;
			}
			
			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b);
			}
			
			int cnt = 0;
			for (int i=1; i<=N; i++) {
				int root = find(i);
				if (!check[root]) {
					check[root] = true;
					cnt++;
				}
			}
			
			sb.append("Case ").append(t++).append(": ");
			if (cnt == 0) {
				sb.append("No trees.");
			} else if (cnt == 1) {
				sb.append("There is one tree.");
			} else {
				sb.append("A forest of ").append(cnt).append(" trees.");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b) {
			check[a] = true;
			return;
		}
		
		if (check[a]) {
			parents[b] = a;
		} else if (check[b]) {
			parents[a] = b;
		} else {
			if (a < b) {
				parents[b] = a;
			} else {
				parents[a] = b;
			}
		}
	}
	
	static int find(int n) {
		if (parents[n] == n) return n;
		return parents[n] = find(parents[n]);
	}
}
