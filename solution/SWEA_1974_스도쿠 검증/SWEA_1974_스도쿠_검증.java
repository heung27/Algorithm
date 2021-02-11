import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1974_스도쿠_검증 {
	static int[][] map = new int[9][9];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			for (int i=0; i<9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("#").append(t).append(" ");
			
			if (!check2()) {
				sb.append(0);
				sb.append("\n");
				continue;
			}
			
			int i;
			a: for (i=0; i<9; i+=3) {
				for (int j=0; j<9; j+=3) {
					if (!check1(i, j)) break a;
				}
			}
			if (i == 9) sb.append(1);
			else sb.append(0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static boolean check1(int x, int y) {
		int sum = 0;
		for (int i=x; i<x+3; i++) {
			for (int j=y; j<y+3; j++) {
				sum += map[i][j];
			}
		}
		return sum == 45? true : false;
	}
	
	static boolean check2() {
		for (int k=0; k<9; k++) {
			int sum = 0;
			for (int i=0; i<9; i++) {
				sum += map[i][k];
			}
			if (sum != 45) return false;
			
			sum = 0;
			for (int j=0; j<9; j++) {
				sum += map[k][j];
			}
			if (sum != 45) return false;
		}
		return true;
	}
}
