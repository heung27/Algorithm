import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15591_MooTube_Silver {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static class Node implements Comparable<Node> {
		int v1, v2, weight;

		public Node(int v1, int v2, int weight) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return o.weight - this.weight;
		}
	}
	
	static class Query implements Comparable<Query> {
		int idx, v, k;

		public Query(int idx, int v, int k) {
			this.idx = idx;
			this.v = v;
			this.k = k;
		}

		@Override
		public int compareTo(Query o) {
			return o.k - this.k;
		}
	}
	
	static Node[] list;
	static Query[] queries;
	static int[] parents, count;
	static int N, Q;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		Q = Integer.parseInt(str[1]);
		
		list = new Node[N-1];
		queries = new Query[Q];
		parents = new int[N+1];
		count = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			parents[i] = i;
			count[i] = 1;
		}
		
		for (int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[i] = new Node(v1, v2, weight);
		}
		
		for (int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			queries[i] = new Query(i, v, k);
		}
		
		Arrays.sort(list);
		Arrays.sort(queries);
		
		int[] result = new int[Q];
		
		int index = 0;
		for (Query query : queries) {
			
			while (index < list.length && list[index].weight >= query.k) {
				union(list[index].v1, list[index].v2);
				index++;
			}
			result[query.idx] = count[find(query.v)] - 1;
		}
		
		for (int num : result) sb.append(num).append("\n");
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void union(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);
		count[v1] += count[v2];
		parents[v2] = v1;
	}
	
	static int find(int v) {
		if (parents[v] == v) return v;
		else return parents[v] = find(parents[v]);
	}
}
