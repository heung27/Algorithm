import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_4386_별자리_만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static class Node implements Comparable<Node> {
		int a, b;
		double dist;
		
		public Node(int a, int b, double dist) {
			super();
			this.a = a;
			this.b = b;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return Double.compare(this.dist, o.dist);
		}
	}
	
	static ArrayList<Node> arr = new ArrayList<>();
	static int[] parents;
	
	static double[][] list;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		list = new double[N][2];
		parents = new int[N];
		
		for (int i=0; i<N; i++) {
			parents[i] = i;
		}
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Double.parseDouble(st.nextToken());
			list[i][1] = Double.parseDouble(st.nextToken());
		}
		
		for (int i=0; i<N; i++) {
			for (int j=i+1; j<N; j++) {
				arr.add(new Node(i, j, dist(list[i], list[j])));
			}
		}
		
		Collections.sort(arr);
		
		double answer = 0.0;
		for (Node temp : arr) {
			if (union(temp.a, temp.b)) {
				answer += temp.dist;
			}
		}
		
		System.out.println(String.format("%.2f", answer));
	}
	
	static double dist(double[] a, double[] b) {
		double x = a[0] - b[0];
		double y = a[1] - b[1];
		
		return Math.sqrt(x * x + y * y);
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b) return false;
		
		if (a < b) parents[b] = a;
		else parents[a] = b;
		return true;
	}
	
	static int find(int n) {
		if (parents[n] == n) return n;
		return parents[n] = find(parents[n]);
	}
}
