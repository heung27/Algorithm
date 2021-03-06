import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_7236_저수지의_물의_총_깊이_구하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] movex = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] movey = {0, 0, -1, 1, -1, 1, -1, 1};
	
	static char[][] map;
	static int[][] cnt;
	static int N, answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N+2][N+2];
			cnt = new int[N+2][N+2];
			
			for (int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=1; j<=N; j++) {
					map[i][j] = st.nextToken().charAt(0);
					if (map[i][j] == 'W') {
						for (int k=0; k<8; k++) {
							cnt[i+movex[k]][j+movey[k]]++;
						}
					}
				}
			}
			answer = 1;
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					if (map[i][j] == 'W' && cnt[i][j] > answer) answer = cnt[i][j];
				}
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
