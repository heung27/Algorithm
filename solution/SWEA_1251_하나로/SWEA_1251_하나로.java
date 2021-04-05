import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1251_하나로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static class Node implements Comparable<Node> {
		int n;
		double weight;

		public Node(int n, double weight) {
			this.n = n;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	
	static double[][] map;
	static int[][] node;
	static boolean[] check;
	static double[] dist;
	static int N;
	static double E, answer;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			N = Integer.parseInt(br.readLine());
			node = new int[N][2];
			map = new double[N][N];
			check = new boolean[N];
			dist =  new double[N];
			answer = 0;
			
			Arrays.fill(dist, Double.MAX_VALUE);
			
			for (int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					node[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			E = Double.parseDouble(br.readLine());
			
			for (int i=0; i<N-1; i++) {
				for (int j=i+1; j<N; j++) {
					map[i][j] += Math.pow(Math.abs(node[i][0] - node[j][0]), 2) * E;
					map[i][j] += Math.pow(Math.abs(node[i][1] - node[j][1]), 2) * E;
					map[j][i] = map[i][j];
				}
			}
			
			Prim(0);
			
			sb.append("#").append(t).append(" ").append(Math.round(answer)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void Prim(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		dist[start] = 0;
		queue.offer(new Node(start, 0.0));
		
		while (!queue.isEmpty()) {
			Node min = queue.poll();
			
			if (check[min.n]) continue;
			
			answer += min.weight;
			
			check[min.n] = true;
			for (int i=0; i<N; i++) {
				if (!check[i] && dist[i] > map[min.n][i]) {
					dist[i] = map[min.n][i];
					queue.offer(new Node(i, dist[i]));
				}
			}
		}
	}
}
