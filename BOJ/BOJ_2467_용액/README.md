# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="30"> 2467. 용액

## Classification
* 이분 탐색
* 투 포인터

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = 0, y = N-1, min = Integer.MAX_VALUE;
		int temp_x = x, temp_y = y;
		
		while (x < y) {
			int sum = arr[x] + arr[y];
			
			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				temp_x = x;
				temp_y = y;
			}
			
			if (sum < 0) {
				x++;
			} else if (sum > 0) {
				y--;
			} else break;
		}
		
		System.out.println(arr[temp_x] + " " + arr[temp_y]);
	}
}
```

## Link
> https://www.acmicpc.net/problem/2467
