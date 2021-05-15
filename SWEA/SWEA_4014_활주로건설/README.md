# [모의 SW 역량테스트] 4014. 활주로 건설

## Classification
* 시뮬레이션
* 구현

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_4014_활주로_건설 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] map;
	static boolean[][] check;
	static int N, X, answer;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			answer = 0;
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			check_row();
			check_col();
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void check_row() {
		check = new boolean[N][N];
		
		for (int i=0; i<N; i++) {
			for (int j=1; j<N; j++) {
				if (map[i][j-1] == map[i][j]+1) {
					int cnt = 0;
					int temp = map[i][j];
					
					for ( ; j<N; j++) {
						if (temp != map[i][j] || ++cnt == X) break;
					}
					
					if (cnt != X) break;
					else while (--cnt >= 0) check[i][j-cnt] = true;
				}
				else if (map[i][j-1]+1 == map[i][j]) {
					int cnt = 0;
					int temp = map[i][j-1];
					
					for (int k=j-1; k>=0; k--) {
						if (temp != map[i][k] || check[i][k] || ++cnt == X) break;
					}
					if (cnt != X) break;
				}
				else if (map[i][j-1] != map[i][j]) break;
				
				if (j == N-1) answer++;
			}
		}
	}
	
	static void check_col() {
		check = new boolean[N][N];
		
		for (int j=0; j<N; j++) {
			for (int i=1; i<N; i++) {
				if (map[i-1][j] == map[i][j]+1) {
					int cnt = 0;
					int temp = map[i][j];
					
					for ( ; i<N; i++) {
						if (temp != map[i][j] || ++cnt == X) break;
					}
					
					if (cnt != X) break;
					else while (--cnt >= 0) check[i-cnt][j] = true;
				}
				else if (map[i-1][j]+1 == map[i][j]) {
					int cnt = 0;
					int temp = map[i-1][j];
					
					for (int k=i-1; k>=0; k--) {
						if (temp != map[k][j] || check[k][j] || ++cnt == X) break;
					}
					
					if (cnt != X) break;
				}
				else if (map[i-1][j] != map[i][j]) break;
				
				if (i == N-1) answer++;
			}
		}
	}
}
```

## Link
> https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeW7FakkUDFAVH
