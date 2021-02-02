import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210_Ladder1 {
	public static int[][] mat;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t=1; t<=10; t++) {
			mat = new int[100][100];
			br.readLine();
			int start = 0;
			for (int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<100; j++) {
					mat[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int j=0; j<100; j++) {
				if (mat[99][j] == 2) {
					start = j;
					break;
				}
			}
			for (int i=99; i>=0; i--) {
				if (start-1 >= 0 && mat[i][start-1] == 1) { // Left
					start--;
					while (start-1 >= 0 && mat[i][start-1] != 0) {
						start--;
					}
				}
				else if (start+1 < 100 && mat[i][start+1] == 1) { // Right
					start++;
					while (start+1 < 100 && mat[i][start+1] != 0) {
						start++;
					}
				}
			}
			System.out.println("#"+t+" "+start);
		}
	}
}
