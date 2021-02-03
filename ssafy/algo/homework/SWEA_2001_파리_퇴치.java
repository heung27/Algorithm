import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2001_파리_퇴치 {
	public static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			map = new int[N][N];
			for (int i=0; i<N; i++) {
				str = br.readLine().split(" ");
				for (int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			int max = 0;
			for (int i=0; i<=N-M; i++) {
				for (int j=0; j<=N-M; j++) {
					int sum = 0;
					for (int x=0; x<M; x++) {
						for (int y=0; y<M; y++) {
							sum += map[i+x][j+y];
						}
					}
					if (max < sum) max = sum;
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}
}
