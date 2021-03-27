import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_18352_특정_거리의_도시_찾기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static class Node implements Comparable<Node> {
		int n, w;
		Node next;
		
		public Node(int n, int w, Node next) {
			this.n = n;
			this.w = w;
			this.next = next;
		}

		public Node(int n, int w) {
			this.n = n;
			this.w = w;
		}

		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	static Node[] map;
	static int[] dist;
	static boolean[] check;
	static int N, M, K, X;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		K = Integer.parseInt(str[2]);
		X = Integer.parseInt(str[3]);
		
		map = new Node[N+1];
		dist = new int[N+1];
		check = new boolean[N+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		 
		for (int i=0; i<M; i++) {
			str = br.readLine().split(" ");
			int from = Integer.parseInt(str[0]);
			int to = Integer.parseInt(str[1]);
			
			map[from] = new Node(to, 1, map[from]);
		}
		
		dijksta(X);
		
		for (int i=1; i<=N; i++) {
			if (dist[i] == K) {
				sb.append(i).append("\n");
				answer++;
			}
		}
		
		if (answer == 0) sb.append(-1).append("\n");
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void dijksta(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		dist[start] = 0;
		queue.offer(new Node(start, 0));
		
		while (!queue.isEmpty()) {
			Node min = queue.poll();
			
			if (check[min.n]) continue;

			check[min.n] = true;
			for (Node temp = map[min.n]; temp != null; temp = temp.next) {
				if (dist[temp.n] > min.w + temp.w) {
					dist[temp.n] =  min.w + temp.w;
					queue.offer(new Node(temp.n, dist[temp.n]));
				}
			}
		}
	}
}
