import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11437_LCA {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static class Node {
		int to;
		Node next;
		
		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}
	
	static Node[] graph;
	
	static int[][] ancestor;
	static int[] depth;
	static int N, M, maxLevel;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		graph = new Node[N+1];
		
		maxLevel = getMaxLevel();
		ancestor = new int[N+1][maxLevel+1];
		depth = new int[N+1];
		
		for (int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a] = new Node(b, graph[a]);
			graph[b] = new Node(a, graph[b]);
		}
		
		depth[0] = -1;
		getTree(1, 0);
		
		M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
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
	
	static int getMaxLevel() { // 트리의 최대 높이 계산
		double log2 = Math.log(N) / Math.log(2);
		return (int)Math.floor(log2);
	}
	
	static void getTree(int current, int parent) { // 노드의 높이와 조상을 구함
		depth[current] = depth[parent] + 1;
		
		ancestor[current][0] = parent;
		
		for (int i=1; i<=maxLevel; i++) {
			int temp = ancestor[current][i-1];
			ancestor[current][i] = ancestor[temp][i-1];
		}
		
		for (Node node = graph[current]; node != null; node = node.next) {
			if (node.to != parent) { // 양방향 그래프를 트리로 만들어주는 조건
				getTree(node.to, current);
			}
		}
	}
	
	static int LCA(int a, int b) {
		for (int i=maxLevel; i>= 0; i--) {
			if (depth[a] <= depth[ancestor[b][i]]) { 
				b = ancestor[b][i]; // b를 끌어 올림
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
