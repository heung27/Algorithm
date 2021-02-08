import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_5215_햄버거_다이어트 {
	static int[][] map;
	static int N, L, answer, depth;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			map = new int[N][2];
			L = Integer.parseInt(str[1]);
			for (int i=0; i<N; i++) {
				str = br.readLine().split(" ");
				map[i][0] = Integer.parseInt(str[0]);
				map[i][1] = Integer.parseInt(str[1]);
			}
			answer = 0;
			for (depth=1; depth<=N; depth++) {
				sol(0, 0, 0, 0);
			}
			System.out.println("#"+t+" "+answer);
		}
	}
	static void sol(int cnt, int start, int score, int cal) {
		if (cal > L) return;
		if (cnt == depth) {
			if (score > answer) answer = score;
			return;
		}
		for (int i=start; i<N; i++) {
			sol(cnt+1, i+1, score+map[i][0], cal+map[i][1]);
		}
	}
}