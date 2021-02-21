import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] map;
	static boolean[] numbers;
	static int[] temp1, temp2;
	static int N, size, answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			numbers = new boolean[N];
			temp1 = new int[N/2];
			temp2 = new int[N/2];
			size = N/2;
			answer = Integer.MAX_VALUE;
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			combination(0, 0);
			sb.append("#"+t+" ");
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void combination(int cnt, int start) {
		if (cnt == size) {
			int cnt1=0, cnt2=0;
			for (int i=0; i<N; i++) {
				if (numbers[i]) temp1[cnt1++] = i;
				else temp2[cnt2++] = i;
			}
			int sum1 = 0, sum2 = 0;
			for (int i=0; i<size; i++) {
				for (int j=i+1; j<size; j++) {
					sum1 += map[temp1[i]][temp1[j]];
					sum1 += map[temp1[j]][temp1[i]];
					
					sum2 += map[temp2[i]][temp2[j]];
					sum2 += map[temp2[j]][temp2[i]];
				}
			}
			answer = Math.min(answer, Math.abs(sum1-sum2));
		}
		for (int i=start; i<N; i++) {
			numbers[i] = true;
			combination(cnt+1, i+1);
			numbers[i] = false;
		}
	}
}
