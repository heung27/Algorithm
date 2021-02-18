import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1041_주사위 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] dice = new int[3][2];
	static int[] res = new int[3];
	static long N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		
		long sum = 0, max = 0;
		for (int k=0; k<3; k++) {
			dice[k][0] = Integer.parseInt(str[k]);
			dice[k][1] = Integer.parseInt(str[5-k]);
			
			if (dice[k][0] < dice[k][1]) {
				res[k] = dice[k][0];
				max = Math.max(max, dice[k][1]);
			}
			else {
				res[k] = dice[k][1];
				max = Math.max(max, dice[k][0]);
			}
			sum += dice[k][0] + dice[k][1];
		}
		Arrays.sort(res);
		
		if (N == 1) {
			sum -= max;
		}
		else {
			sum = 0;
			
			long cnt = (N-1) * (N-2) * 4 + (N-2) * (N-2);
			sum += res[0] * cnt;
			
			cnt = (N-1) * 4 + (N-2) * 4;
			sum += (res[0]+res[1]) * cnt;
			
			cnt = 4;
			sum += (res[0]+res[1]+res[2]) * cnt;
		}
		
		System.out.println(sum);
	}
}
