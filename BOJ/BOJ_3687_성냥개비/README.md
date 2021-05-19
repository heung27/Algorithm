# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/14.svg" width="30"> 3687. 성냥개비

## Classification
* 다이나믹 프로그래밍
* 그리디 알고리즘

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_3687_성냥개비 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static int[] num = {0, 0, 1, 7, 4, 2, 0, 8, 10};
	
	static long[] min = new long[101];
	
	public static void main(String[] args) throws IOException {
		for (int i=1; i<9; i++) {
			min[i] = num[i];
		}
		min[6] = 6;
		
		for (int i=9; i<101; i++) {
			min[i] = min[i-2]*10 + num[2];
			
			for (int j=3; j<8; j++) {
				min[i] = Math.min(min[i], min[i-j]*10 + num[j]);
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			sb.append(min[n]).append(" ");
			
			while (n != 0) {
				if (n % 2 != 0) {
					sb.append(7);
					n -= 3;
				}
				else {
					sb.append(1);
					n -= 2;
				}
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}
```

## Link
> https://www.acmicpc.net/problem/3687
