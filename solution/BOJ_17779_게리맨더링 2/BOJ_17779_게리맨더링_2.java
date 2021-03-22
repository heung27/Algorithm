import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_17779_게리맨더링_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] area = new int[5];
	static int answer = Integer.MAX_VALUE;
	
	static int[][] map;
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for (int i=0; i<N-2; i++) {
			for (int j=1; j<N-1; j++) {
				for (int d1=1; d1<=j && d1<N-i; d1++) {
					for (int d2=1; d2<N-j && d2<N-i; d2++) {
						sum(i, j, d1, d2);
					}
				}
			}
		}
		
		System.out.println(answer);
	}
	
	static void sum(int x, int y, int d1, int d2) {
		Arrays.fill(area, 0);
		
		int min = Integer.MAX_VALUE, max = 0;
		int y1 = y+1, y2 = y-1;
		int x1 = x, x2 = x+d1+d2+1;
		
		for (int i=0; i<N; i++) {
			if (i >= x1 && i <= x2) {
				if (i <= x+d1) y1--;
				else y1++;
				
				if (i <= x+d2) y2++;
				else y2--;
			}
			
			for (int j=0; j<N; j++) {
				if (j >= y1 && j <= y2) {
					area[4] += map[i][j];
				}
				else if (i < x+d1 && j <= y) {
					area[0] += map[i][j];
				}
				else if (i <= x+d2 && y < j) {
					area[1] += map[i][j];
				}
				else if (x+d1 <= i && j < y-d1+d2) {
					area[2] += map[i][j];
				}
				else if (x+d2 < i && y-d1+d2 <= j) {
					area[3] += map[i][j];
				}
			}
		}
		
		for (int i=0; i<5; i++) {
			min = Math.min(min, area[i]);
			max = Math.max(max, area[i]);
		}
		
		answer = Math.min(answer, max-min);
	}
}
