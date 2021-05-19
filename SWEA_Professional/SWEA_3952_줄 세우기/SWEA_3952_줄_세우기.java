import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_3952_줄_세우기 {
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
	static int[] in_degree; // 들어오는 간선의 개수 카운트
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			list = new Node[N+1];
			in_degree = new int[N+1];
			
			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list[a] = new Node(b, list[a]);
				in_degree[b]++;
			}
			
			Topological_Sort();
			
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void Topological_Sort() {
		Queue<Node> queue = new LinkedList<>();
		
		for (int i=1; i<=N; i++) {
			if (in_degree[i] == 0) {
				queue.offer(new Node(i, list[i]));
			}
		}
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			sb.append(node.n).append(" ");
			
			for (Node temp = node.next; temp != null; temp = temp.next) {
				if (--in_degree[temp.n] == 0) {
					queue.offer(new Node(temp.n, list[temp.n]));
				}
			}
		}
	}
}
