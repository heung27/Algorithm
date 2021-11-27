import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17136_색종이_붙이기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] number = {5, 5, 5, 5, 5};
	
	static int[][] mat;
	
	static int answer = Integer.MAX_VALUE;
	static int N = 10;
	
	public static void main(String[] args) throws IOException {
		mat = new int[N][N];
		
		int one = 0;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				if (mat[i][j] == 1) one++;
			}
		}
		
		DFS(0, one, 0);
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	public static void DFS(int cnt, int num, int flag) {
		if (answer <= cnt) return;
		else if (num == 0) {
			answer = cnt;
			return;
		}
		
		int i = flag / N;
		int j = flag % N;
		
		if (mat[i][j] == 0) {
			DFS(cnt, num, flag+1);
			return;
		}
		
		for(int k=5; k>0; k--) {
			if (i+k-1 >= N || j+k-1 >= N || number[k-1] == 0) continue;
			
			if (isTrue(i, j, k)) {
				change(i, j, k);
				DFS(cnt+1, num - (k * k), flag+1);
				reChange(i, j, k);
			}
		}
	}
	
	public static boolean isTrue(int i, int j, int k) {
		boolean check = true;
		loop: for (int x=0; x<k; x++) {
			for (int y=0; y<k; y++) {
				if (mat[i+x][j+y] == 0) {
					check = false;
					break loop;
				}
			}
		}
		return check;
	}
	
	public static void change(int i, int j, int k) {
		for (int x=0; x<k; x++) {
			for (int y=0; y<k; y++) {
				mat[i+x][j+y] = 0;
			}
		}
		number[k-1]--;
	}
	
	public static void reChange(int i, int j, int k) {
		for (int x=0; x<k; x++) {
			for (int y=0; y<k; y++) {
				mat[i+x][j+y] = 1;
			}
		}
		number[k-1]++;
	}
}
