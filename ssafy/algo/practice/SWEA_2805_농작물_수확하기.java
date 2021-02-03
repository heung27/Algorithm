import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2805_농작물_수확하기 {
	public static int[][] map;
	public static int answer;
	public static int num;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			num = Integer.parseInt(br.readLine());
			map = new int[num][num];
			answer = 0;
			for (int i=0; i<num; i++) {
				String[] str = br.readLine().split("");
				for (int j=0; j<num; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			int x = num/2;
			int y = num/2;
			boolean tx = false;
			for (int i=0; i<num; i++) {
				for (int j=0; j<num; j++) {
					if (x <= j && j <= y) {
						answer += map[i][j];
					}
				}
				if (x == 0 && y == num-1) tx = true;
				if (!tx) {
					x -= 1;
					y += 1;
				}
				else {
					x += 1;
					y -= 1;
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}
}
