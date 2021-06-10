# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/12.svg" width="30"> 2096. 내려가기

## Classification
* 다이나믹 프로그래밍
* 슬라이딩 윈도우

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2096_내려가기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] max = new int[3];
		int[] min = new int[3];
		int[] temp = new int[3];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			temp[0] = Math.max(max[0], max[1]) + a;
			temp[1] = Math.max(max[0], Math.max(max[1], max[2])) + b;
			temp[2] = Math.max(max[1], max[2]) + c;
			
			max[0] = temp[0];
			max[1] = temp[1];
			max[2] = temp[2];
			
			temp[0] = Math.min(min[0], min[1]) + a;
			temp[1] = Math.min(min[0], Math.min(min[1], min[2])) + b;
			temp[2] = Math.min(min[1], min[2]) + c;
			
			min[0] = temp[0];
			min[1] = temp[1];
			min[2] = temp[2];
		}
		
		System.out.println(Math.max(max[0], Math.max(max[1], max[2])) + " " + Math.min(min[0], Math.min(min[1], min[2])));
	}
}
```

## Link
> https://www.acmicpc.net/problem/2096
