# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/13.svg" width="30"> 1300. K번째 수

## Classification
* 이분 탐색

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1300_K번째_수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		System.out.println(BinarySearch(1, (long)N*N));
	}
	
	static long BinarySearch(long left, long right) {
		long answer = -1;
		
		while (left <= right) {
			long mid = (left + right) / 2;
			
			if (check(mid) < K) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
				answer = mid;
			}
		}
		
		return answer;
	}
	
	static long check(long k) {
		long sum = 0;
		for (int i=1; i<=N; i++) {
			sum += Math.min(N, k/i);
		}
		return sum;
	}
}
```

## Link
> https://www.acmicpc.net/problem/1300
