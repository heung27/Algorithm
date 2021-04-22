# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="30"> 14719. 빗물

## Classification
* 구현
* 시뮬레이션

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] arr;
	static int R, C, answer;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[C];
	
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<C; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, sum = 0;
		for (int i=1; i<C; i++) {
			if (arr[start] <= arr[i]) {
				
				answer += arr[start] * (i - start - 1) - sum;
				start = i;
				sum = 0;
			}
			else sum += arr[i];
		}
		
		start = C-1; sum = 0;
		for (int i=C-2; i>=0; i--) {
			if (arr[start] < arr[i]) {
				
				answer += arr[start] * (start - i - 1) - sum;
				start = i;
				sum = 0;
			}
			else sum += arr[i];
		}
		
		System.out.println(answer);
	}
}
```

## Link
> https://www.acmicpc.net/problem/14719
