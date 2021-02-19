import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247_최적_경로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] node;
	static int[] numbers;
	static boolean[] check;
	static int N;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int test = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=test; t++) {
			N = Integer.parseInt(br.readLine());
			node = new int[N+2][2];
			numbers = new int[N];
			check = new boolean[N+2];
			answer = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N+2; i++) {
				node[i][0] = Integer.parseInt(st.nextToken());
				node[i][1] = Integer.parseInt(st.nextToken());
			}
			
			permutation(0);
			sb.append("#"+t+" ");
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static void permutation(int cnt) {
		if (cnt == N) {
			int sum = 0;
			int[] temp = node[0];
			for (int i=0; i<N; i++) {
				sum += Math.abs(temp[0] - node[numbers[i]][0]) + Math.abs(temp[1] - node[numbers[i]][1]);
				temp = node[numbers[i]];
			}
			sum += Math.abs(temp[0] - node[1][0]) + Math.abs(temp[1] - node[1][1]);
			answer = Math.min(answer, sum);
			return;
		}
		for (int i=2; i<N+2; i++) {
			if (!check[i]) {
				numbers[cnt] = i;
				check[i] = true;
				permutation(cnt+1);
				check[i] = false;
			}
		}
	}
}
