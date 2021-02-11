import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1220_Magnetic {
	static int[][] map = new int[100][100];
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int t=1; t<=10; t++) {
			N = Integer.parseInt(br.readLine());
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for (int j=0; j<N; j++) {
				boolean check = false;
				int init = 1;
				for (int i=0; i<N; i++) {
					if (map[i][j] == 0) continue;
					if (map[i][j] != init) {
						if (check) {
							cnt++;
							check = false;
						}
					}
					else check = true;
				}
			}
			
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
