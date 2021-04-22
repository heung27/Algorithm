# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/12.svg" width="30"> 17281. 야구공

## Classification
* 구현
* 브루트포스 알고리즘

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17281_야구공 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[][] map;
	static int[] numbers;
	static boolean[] check;
	static int N, answer;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][9];
		numbers = new int[9];
		check = new boolean[9];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0);
		System.out.println(answer);
	}
	static void DFS(int cnt) {
		if (cnt == 9) {
			int score = 0, out = 0, row = 0, index = 0;
			boolean[] ru = new boolean[3];
			
			while (true) {
				int x = map[row][numbers[index]];
				
				if (x == 0) {
					if (++out == 3) {
						if (++row == N) break;
						else out = 0;
						ru[0] = ru[1] = ru[2] = false;
					}
				}
				else score += hit(x, ru);
				
				if (++index == 9) index = 0;
			}
			answer = Math.max(score, answer);
			return;
		}
		else if (cnt == 3) {
			cnt++;
		}
		for (int i=1; i<9; i++) {
			if (check[i]) continue;
			
			numbers[cnt]= i;
			check[i] = true;
			DFS(cnt+1);
			check[i] = false;
		}
	}
	
	static int hit(int x, boolean[] ru) {
		int score = 0;
		
		if (x == 4) {
			for (int i=0; i<3; i++) {
				if (ru[i]) {
					score++;
					ru[i] = false;
				}
			}
			score++;
		}
		else {
			int index = 2, cnt = 0;
			
			while (cnt++ < x) {
				if (ru[index]) {
					score++;
					ru[index] = false;
				}
				index--;
			}
			
			while (index >= 0) {
				ru[index+x] = ru[index];
				ru[index--] = false;
			}
			
			ru[x-1] = true;
		}
		
		return score;
	}
}
```

## Link
> https://www.acmicpc.net/problem/17281
