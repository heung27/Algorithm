import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725_트리의_부모_찾기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static ArrayList<Integer>[] list;
	static boolean[] check;
	static int[] result;
	static int N;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		check = new boolean[N+1];
		result = new int[N+1];
		
		list = new ArrayList[N+1];
		for (int i=0; i<N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i=1; i<N; i++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			list[x].add(y);
			list[y].add(x);
		}
		
		BFS(1);
		for (int i=2; i<N+1; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.print(sb);
	}
	
	static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		check[v] = true;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			int size = list[node].size();
			
			for (int i=0; i<size; i++) {
				int x = list[node].get(i);
				if (!check[x]) {
					check[x] = true;
					result[x] = node;
					queue.offer(x);
				}
			}
		}
	}
}
