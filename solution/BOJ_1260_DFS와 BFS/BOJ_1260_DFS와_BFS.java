import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와_BFS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static ArrayList<Integer>[] list;
	static boolean[] check;
	static int N, M, V;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		V = Integer.parseInt(str[2]);
		
		check = new boolean[N+1];
		list = new ArrayList[N+1];
		for (int i=0; i<N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i=0; i<M; i++) {
			str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			list[x].add(y);
			list[y].add(x);
		}
		
		for (int i=1; i<N+1; i++) {
			Collections.sort(list[i]);
		}
		DFS(V);
		sb.append("\n");
		
		Arrays.fill(check, false);
		
		BFS(V);
		System.out.println(sb);
	}
	
	static void DFS(int start) {
		sb.append(start).append(" ");
		check[start] = true;
		int size = list[start].size();
		for (int i=0; i<size; i++) {
			int x = list[start].get(i);
			if (!check[x]) DFS(x);
		}
	}
	
	static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		check[start] = true;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			sb.append(node).append(" ");
			int size = list[node].size();
			
			for (int i=0; i<size; i++) {
				int x = list[node].get(i);
				if (!check[x]) {
					check[x] = true;
					queue.offer(x);
				}
			}
		}
	}
}
