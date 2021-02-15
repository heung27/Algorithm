import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10163_색종이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] map = new int[101][101];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int x1, x2, y1, y2;
		for (int k=1; k<=n; k++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = x1+Integer.parseInt(st.nextToken());
			y2 = y1+Integer.parseInt(st.nextToken());
			
			for (int i=x1; i<x2; i++) {
				for (int j=y1; j<y2; j++) {
					map[i][j] = k;
				}
			}
		}
		int[] answer = new int[n+1];
		for (int i=0; i<101; i++) {
			for (int j=0; j<101; j++) {
				answer[map[i][j]]++;
			}
		}
		
		for (int i=1; i<=n; i++) {
			System.out.println(answer[i]);
		}
	}
}
