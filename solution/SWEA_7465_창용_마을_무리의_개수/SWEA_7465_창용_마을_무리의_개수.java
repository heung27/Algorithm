import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_7465_창용_마을_무리의_개수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static int[] parents;
	static boolean[] check;
	static int N, M, answer;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);
			
			parents = new int[N+1];
			check = new boolean[N+1];
			answer = 0;
			
			for (int i=1; i<=N; i++) {
				parents[i] = i;
			}
			
			while (M-- > 0) {
				str = br.readLine().split(" ");
				int a = Integer.parseInt(str[0]);
				int b = Integer.parseInt(str[1]);
				union(a, b);
			}
			
			for (int i=1; i<=N; i++) {
				check[find(i)] = true;
			}
			
			for (int i=1; i<=N; i++) {
				if (check[i]) answer++;
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static boolean union(int a, int b) {
		int r1 = find(a);
		int r2 = find(b);
		
		if (r1 == r2) return false;
		else if (r1 < r2) parents[r1] = r2;
		else parents[r2] = r1;
		return true;
	}
	
	static int find(int node) {
		if (parents[node] == node) return node;
		return parents[node] = find(parents[node]);
	}
}
