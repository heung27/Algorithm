import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1976_여행_가자 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[][] map;
	static int[] parents, arr;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		parents = new int[N];
		arr = new int[M];
		
		for (int i=0; i<N; i++) {
			parents[i] = i;
		}
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) union(i, j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<M; i++) {
			arr[i] = find(Integer.parseInt(st.nextToken())-1);
		}
		
		boolean t = true;
		for (int i=1; i<M; i++) {
			if (arr[i-1] != arr[i]) {
				t = false;
				break;
			}
		}
		
		if (t) System.out.println("YES");
		else System.out.println("NO");
	}
	
	static boolean union(int a, int b) {
		int r1 = find(a);
		int r2 = find(b);
		
		if (r1 == r2) return false;
		else if (r1 < r2) parents[r2] = r1;
		else parents[parents[r1]] = r2;
		return true;
	}
	
	static int find(int n) {
		if (parents[n] == n) return n;
		else return parents[n] = find(parents[n]);
	}
}
