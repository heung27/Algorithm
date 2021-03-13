import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1707_이분_그래프 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static ArrayList<Integer>[] map;
	static int[] check;
	static int N, E, K;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		K = Integer.parseInt(br.readLine());
		for (int t=0; t<K; t++) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			E = Integer.parseInt(str[1]);
			
			map = new ArrayList[N+1];
			check = new int[N+1];
			
			while (E-- > 0) {
				str = br.readLine().split(" ");
				int x = Integer.parseInt(str[0]);
				int y = Integer.parseInt(str[1]);
				
				if (map[x] == null) map[x] = new ArrayList<>();
				if (map[y] == null) map[y] = new ArrayList<>();
				
				map[x].add(y);
				map[y].add(x);
			}
			
			int i = 1;
			for ( ; i<=N; i++) {
				if (map[i] != null && check[i] == 0 && DFS(i, -1, 0)) {
					sb.append("NO");
					break;
				}
			}
			if (i == N+1) sb.append("YES");
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static boolean DFS(int node, int color, int pre) {
		if (check[node] != 0) {
			if (check[node] != color) {
				return true;
			}
			else return false;
		}
		
		check[node] = color;
		
		int size = map[node].size();
		for (int i=0; i<size; i++) {
			int next = map[node].get(i);
			
			if (next == pre) continue;
			
			if (DFS(next, -color, node)) return true;
		}
		return false;
	}
}
