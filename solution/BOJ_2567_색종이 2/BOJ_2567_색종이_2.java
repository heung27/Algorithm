import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2567_색종이_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static boolean[][] map = new boolean[101][101];
	static int N;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			for (int i=x; i<x+10; i++) {
				for (int j=y; j<y+10; j++) {
					map[i][j] = true;
				}
			}
		}
		
		for (int i=0; i<101; i++) {
			boolean temp1 = false, temp2 = false;
			for (int j=0; j<101; j++) {
				if (map[i][j] != temp1) {
					temp1 = map[i][j];
					answer++;
				}
				if (map[j][i] != temp2) {
					temp2 = map[j][i];
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}
}
