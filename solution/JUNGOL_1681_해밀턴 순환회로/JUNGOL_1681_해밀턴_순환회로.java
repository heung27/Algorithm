import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class JUNGOL_1681_해밀턴_순환회로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[][] map;
	static boolean[] check;
	static int N, answer;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N];
		answer = Integer.MAX_VALUE;
		
		for (int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		check[0] = true;
		DFS(1, 0, 0);
		
		System.out.println(answer);
	}
	
	static void DFS(int cnt, int start, int dist) {
		if (answer <= dist) return;
		else if (cnt == N && map[start][0] != 0) {
			dist += map[start][0];
			if (answer > dist) answer = dist;
			return;
		}
		for (int i=0; i<N; i++) {
			if (!check[i] && map[start][i] != 0) {
				check[i] = true;
				DFS(cnt+1, i, dist+map[start][i]);
				check[i] = false;
			}
		}
	}
}
