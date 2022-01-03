import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_8980_택배 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] mat;
	static int N, M, C;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(br.readLine());
		
		mat = new int[C][3];
		
		for (int i=0; i<C; i++) {
			st = new StringTokenizer(br.readLine());

			mat[i][0] = Integer.parseInt(st.nextToken());
			mat[i][1] = Integer.parseInt(st.nextToken());
			mat[i][2] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(mat, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int diff =  o1[1] - o2[1];
				if (diff == 0) {
					diff = o1[0] - o2[0];
				}
				return diff;
			}
		});
		
		int[] weight = new int[N+1];
		
		Arrays.fill(weight, M);
		
		for (int i=0; i<C; i++) {
			int max_weight = Integer.MAX_VALUE;
			
			for (int j=mat[i][0]; j<mat[i][1]; j++) {
				max_weight = Math.min(max_weight, weight[j]);
			}
			
			if (max_weight >= mat[i][2]) {
				for (int j=mat[i][0]; j<mat[i][1]; j++) {
					weight[j] -= mat[i][2];
				}
				answer += mat[i][2];
			} else {
				for (int j=mat[i][0]; j<mat[i][1]; j++) {
					weight[j] -= max_weight;
				}
				answer += max_weight;
			}
		}
		
		System.out.println(answer);
	}
}
