import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7453_합이_0인_네_정수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] ABCD;
	static int[] AB, CD;
	static int N;
	static long answer;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		ABCD = new int[N][4];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<4; j++) {
				ABCD[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		AB = new int[N*N];
		CD = new int[N*N];
		
		int size = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				AB[size] = ABCD[i][0] + ABCD[j][1];
				CD[size++] = ABCD[i][2] + ABCD[j][3];
			}
		}
		
		Arrays.sort(AB);
		Arrays.sort(CD);
		
		int idx1 = 0, idx2 = size-1;
		while (idx1 < size && idx2 >= 0) {
			int temp1 = AB[idx1], temp2 = CD[idx2];
			int sum = temp1 + temp2;
			int cnt1 = 0, cnt2 = 0;
			
			if (sum == 0) {
				while (idx1 < size && temp1 == AB[idx1]) {
					cnt1++; idx1++;
				}
				while (idx2 >= 0 && temp2 == CD[idx2]) {
					cnt2++; idx2--;
				}
				answer += (long)cnt1 * (long)cnt2;
			}
			else if (sum > 0) idx2--;
			else idx1++;
		}
		
		System.out.println(answer);
	}
}
