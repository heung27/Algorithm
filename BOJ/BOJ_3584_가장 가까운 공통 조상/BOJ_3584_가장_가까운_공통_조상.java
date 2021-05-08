import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_3584_가장_가까운_공통_조상 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static class Node {
		int n;
		Node next;
		
		public Node(int n, Node next) {
			this.n = n;
			this.next = next;
		}
	}
	
	static Node[] list;
	
	static int[][] ancestor;
	static int[] depth;
	static int N, maxLevel;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			
			maxLevel = getMaxLevel();
			list = new Node[N+1];
			
			ancestor = new int[N+1][maxLevel+1];
			depth = new int[N+1];
			depth[0] = -1;
			
			boolean[] check = new boolean[N+1];
			for (int i=1; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				
				list[parent] = new Node(child, list[parent]);
				check[child] = true;
			}
			
			for (int i=1; i<=N; i++) {
				if (!check[i]) {
					getTree(i, 0);
					break;
				}
			}
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (depth[a] > depth[b]) sb.append(LCA(b, a));
			else sb.append(LCA(a, b));
			
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static int getMaxLevel() {
		double log = Math.log(N) / Math.log(2);
		return (int)Math.floor(log);
	}
	
	static void getTree(int current, int parent) {
		depth[current] = depth[parent] + 1;
		
		ancestor[current][0] = parent;
		
		for (int i=1; i<=maxLevel; i++) {
			int temp = ancestor[current][i-1];
			ancestor[current][i] = ancestor[temp][i-1];
		}
		
		for (Node node = list[current]; node != null; node = node.next) {
			getTree(node.n, current);
		}
	}
	
	static int LCA(int a, int b) {
		for (int i=maxLevel; i>=0; i--) {
			if (depth[a] <= depth[ancestor[b][i]]) {
				b = ancestor[b][i];
			}
		}
		if (a == b) return a;
		
		for (int i=maxLevel; i>=0; i--) {
			if (ancestor[a][i] != ancestor[b][i]) {
				a = ancestor[a][i];
				b = ancestor[b][i];
			}
		}
		return ancestor[a][0];
	}
}
