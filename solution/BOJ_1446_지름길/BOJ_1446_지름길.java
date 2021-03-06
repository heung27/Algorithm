import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1446_지름길 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] road;
	static int[] dp;
	static int N, D;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		D = Integer.parseInt(str[1]);
		road = new int[N][3];
		dp = new int[D+1];
		
		for (int i=0; i<N; i++) {
			str = br.readLine().split(" ");
			road[i][0] = Integer.parseInt(str[0]);
			road[i][1] = Integer.parseInt(str[1]);
			road[i][2] = Integer.parseInt(str[2]);
		}
		
		Arrays.sort(road, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int index = 0, cur = 0;
		
		while (cur < D) {
			if (index < N && road[index][0] == cur) {
				if (road[index][1] <= D) {
					if (dp[road[index][1]] == 0) dp[road[index][1]] = dp[cur] + road[index][2];
					else dp[road[index][1]] = Math.min(dp[road[index][1]], dp[cur] + road[index][2]);
				}
				index++;
			}
			else {
				int next = cur + 1;
				if (dp[next] == 0) dp[next] = dp[cur] + 1;
				else dp[next] = Integer.min(dp[next], dp[cur] + 1);
				cur++;
			}
		}
		
		System.out.println(dp[D]);
	}
	
}
