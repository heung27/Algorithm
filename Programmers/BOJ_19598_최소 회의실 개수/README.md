# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="30"> 19598. 최소 회의실 개수

## Classification
* 자료 구조
* 그리디 알고리즘
* 정렬
* 스위핑
* 우선순위 큐

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_19598_최소_회의실_개수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static class Time implements Comparable<Time> {
		long time;
		int flag;
		
		public Time(long time, int flag) {
			this.time = time;
			this.flag = flag;
		}

		@Override
		public int compareTo(Time o) {
			int diff = Long.compare(this.time, o.time);
			if (diff == 0) diff = o.flag - this.flag;
			return diff;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Time> queue = new PriorityQueue<>();
		
		for (int i=0; i<N; i++) {
			st = new  StringTokenizer(br.readLine());
			long start = Long.parseLong(st.nextToken());
			long end = Long.parseLong(st.nextToken());
			
			queue.offer(new Time(start, 0));
			queue.offer(new Time(end, 1));
		}
		
		int cnt = 0, answer = 0;
		while (!queue.isEmpty()) {
			Time time = queue.poll();
			if (time.flag == 0) {
				answer = Math.max(answer, ++cnt);
			}
			else cnt--;
		}
		
		System.out.println(answer);
	}
}
```

## Link
> https://www.acmicpc.net/problem/19598
