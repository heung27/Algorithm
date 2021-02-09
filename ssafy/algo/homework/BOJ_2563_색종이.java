import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2563_색종이 {
	static boolean[][] map = new boolean[100][100];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		while (N-- > 0) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			for (int i=0; i<10; i++) {
				for (int j=0; j<10; j++) {
					if (!map[x+i][y+j]) {
						map[x+i][y+j] = true;
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
