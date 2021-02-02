import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_1954_달팽이_숫자 {
	public static int[] moveX = {1, 0, -1, 0}; // 아래, 왼쪽, 위, 오른쪽 순서
	public static int[] moveY = {0, -1, 0, 1};
	public static int[][] mat = new int[10][10];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			int size = Integer.parseInt(br.readLine());
			
			int start = 1, dir = 0;
			for (int i=0; i<size; i++, start++) {
				mat[0][i] = start; // 맨 윗 줄 미리 초기화
			}
			
			int range = size-1;
			int x = 0, y = size-1;
			for (int i=0; i<size-1; i++) {
				for (int j=0; j<2; j++) {
					for (int k=0; k<range-i; k++, start++) {
						x += moveX[dir]; // next X
						y += moveY[dir]; // next Y
						mat[x][y] = start;
					}
					dir = (dir + 1) % 4; // 방향 회전
				}
			}
			
			sb.append("#"+t+"\n");
			for (int i=0; i<size; i++) {
				for (int j=0; j<size; j++) {
					sb.append(mat[i][j]+" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
