import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_2644_촌수계산 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] parents, check;
	static int N, X, Y, M;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		check = new int[N+1];
		answer = -1;
		
		String[] str = br.readLine().split(" ");
		X = Integer.parseInt(str[0]);
		Y = Integer.parseInt(str[1]);
		
		M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			str = br.readLine().split(" ");
			int parent = Integer.parseInt(str[0]);
			int child = Integer.parseInt(str[1]);
			
			parents[child] = parent;
		}
		
		Arrays.fill(check, -1);
		
		int cnt = 0;
		while (true) {
			check[X] = cnt;
			X = parents[X];
			if (X == 0) break;
			cnt++;
		}
		
		cnt = 0;
		while (true) {
			if (check[Y] != -1) {
				answer = check[Y] + cnt;
				break;
			}
			check[Y] = cnt;
			Y = parents[Y];
			if (Y == 0) break;
			cnt++;
		}
		
		System.out.println(answer);
	}
}
