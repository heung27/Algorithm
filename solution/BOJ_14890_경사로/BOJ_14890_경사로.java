import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14890_경사로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static boolean[][] check;
	static int[][] map;
	static int N, L;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		L = Integer.parseInt(str[1]);
		map = new int [N][N];
		check = new boolean[N][N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=1; j<N; j++) {
				if (map[i][j-1] == map[i][j]) { 
					// 같은 높이
				}
				else if (map[i][j-1] == map[i][j]+1) { // 왼쪽이 더 작을 때
					int cnt = 0;
					int temp = map[i][j];
					for ( ; j<N; j++) {
						if (temp != map[i][j] || ++cnt == L) break;
					}
					if (cnt != L) break;
					else {
						while (--cnt >= 0) check[i][j-cnt] = true;
					}
				}
				else if (map[i][j-1]+1 == map[i][j]) { // 왼쪽이 더 클 때
					int cnt = 0;
					int temp = map[i][j-1];
					for (int k=j-1; k>=0; k--) {
						if (temp != map[i][k] || check[i][k] || ++cnt == L) break;
					}
					if (cnt != L) break;
				}
				else break;
				
				if (j == N-1) answer++;
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				check[i][j] = false;
			}
		}
		
		for (int j=0; j<N; j++) {
			for (int i=1; i<N; i++) {
				if (map[i-1][j] == map[i][j]) { 
					// 같은 높이
				}
				else if (map[i-1][j] == map[i][j]+1) { // 왼쪽이 더 작을 때
					int cnt = 0;
					int temp = map[i][j];
					for ( ; i<N; i++) {
						if (temp != map[i][j] || ++cnt == L) break;
					}
					if (cnt != L) break;
					else {
						while (--cnt >= 0) check[i-cnt][j] = true;
					}
				}
				else if (map[i-1][j]+1 == map[i][j]) { // 왼쪽이 더 클 때
					int cnt = 0;
					int temp = map[i-1][j];
					for (int k=i-1; k>=0; k--) {
						if (temp != map[k][j] || check[k][j] || ++cnt == L) break;
					}
					if (cnt != L) break;
				}
				else break;
				
				if (i == N-1) answer++;
			}
		}
		
		System.out.println(answer);
	}
}
