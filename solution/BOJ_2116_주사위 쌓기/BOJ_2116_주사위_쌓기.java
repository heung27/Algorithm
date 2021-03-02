import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2116_주사위_쌓기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] dice;
	static int N, answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		dice = new int[N][7];
		
		for (int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j=0; j<3; j++) {
				int k = -1;
				switch (j) {
				case 0: k = 5; break;
				case 1: k = 3; break;
				case 2: k = 4;
				}
				int x = Integer.parseInt(str[j]);
				int y = Integer.parseInt(str[k]);
				dice[i][x] = y;
				dice[i][y] = x;
			}
		}
		
		for (int j=1; j<=6; j++) {
			int sum = 0, temp = j;
			for (int i=0; i<N; i++) {
				if (temp < dice[i][temp]) {
					if (dice[i][temp] == 6) {
						if (temp == 5) sum += 4;
						else sum += 5;
					}
					else sum += 6;
				}
				else {
					if (temp == 6) {
						if (dice[i][temp] == 5) sum += 4;
						else sum += 5;
					}
					else sum += 6;
				}
				temp = dice[i][temp];
			}
			answer = Math.max(answer, sum);
		}
		
		System.out.println(answer);
	}
}
