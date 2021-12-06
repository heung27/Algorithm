# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/14.svg" width="30"> 1202. 보석 도둑

## Classification
* 자료 구조
* 그리디 알고리즘
* 정렬
* 우선순위 큐

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202_보석_도둑 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[][] items;
	static int[] bags;
	static int N, K;
	
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		items = new int[N][2];
		bags = new int[K];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0] = Integer.parseInt(st.nextToken());
			items[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(items, (o1, o2) -> o1[0] - o2[0]);
		Arrays.sort(bags);
		
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
		int index = 0;
		long answer = 0;
		
		for (int i=0; i<K; i++) {
			while (index < N && items[index][0] <= bags[i]) {
				queue.offer(items[index++][1]);
			}
			if (!queue.isEmpty()) answer += (long)queue.poll();
		}
		
		System.out.println(answer);
	}
}
```

## Link
> https://www.acmicpc.net/problem/1202
