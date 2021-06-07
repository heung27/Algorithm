import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1967_트리의_지름 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static class Node {
		int n, weight;
		Node next;
		
		public Node(int n, int weight, Node next) {
			this.n = n;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static Node[] list;
	static int N, start, max;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		list = new Node[N+1];
		
		while (N-- > 1) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from] = new Node(to, weight, list[from]);
			list[to] = new Node(from, weight, list[to]);
		}
		
		DFS(1, 0, 0);
		DFS(start, 0, 0);
		
		System.out.println(max);
	}
	
	static void DFS(int n, int pre, int weight) {
		if (max < weight) {
			start = n;
			max = weight;
		}
		
		for (Node node = list[n]; node != null; node = node.next) {
			if (node.n == pre) continue;
			DFS(node.n, n, weight + node.weight);
		}
	}
}
