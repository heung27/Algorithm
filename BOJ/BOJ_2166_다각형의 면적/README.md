# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="30"> 2166. 다각형의 면적

## Classification
* 기하학
* 다각형의 넓이

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2166_다각형의_면적 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static class Point {
		long x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static Point[] list;
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		list = new Point[N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[i] = new Point(x, y);
		}
		
		long sum = 0;
		for (int i=2; i<N; i++) {
			sum += CCW(list[0], list[i-1], list[i]);
		}
		
		String answer = String.format("%.1f", Math.abs(sum)/2.0);
		System.out.println(answer);
	}
	
	static long CCW(Point p1, Point p2, Point p3) {
		return (p1.x*p2.y - p2.x*p1.y) + (p2.x*p3.y - p3.x*p2.y) + (p3.x*p1.y - p1.x*p3.y); 
	}
}
```

## Link
> https://www.acmicpc.net/problem/2166
