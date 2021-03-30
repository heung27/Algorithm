import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1149_RGB거리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[][] cost;
	static int N, answer;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		
		for (int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j=0; j<3; j++) {
				cost[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for (int i=1; i<N; i++) {
			cost[i][0] = Math.min(cost[i-1][1], cost[i-1][2]) + cost[i][0];
			cost[i][1] = Math.min(cost[i-1][0], cost[i-1][2]) + cost[i][1];
			cost[i][2] = Math.min(cost[i-1][0], cost[i-1][1]) + cost[i][2];
		}
		
		answer = Math.min(cost[N-1][0], Math.min(cost[N-1][1], cost[N-1][2]));
		System.out.println(answer);
	}
}
