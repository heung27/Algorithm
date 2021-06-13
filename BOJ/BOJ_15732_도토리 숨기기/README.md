# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/14.svg" width="30"> 15732. 도토리 숨기기

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

public class BOJ_15732_도토리_숨기기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st; 
	
	static int[][] rules;
	static int N, K, D;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		D = Integer.parseInt(str[2]);
		
		rules = new int[K][3];
		
		for (int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				rules[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(BinarySearch(1, N));
	}
	
	static int BinarySearch(int left, int right) {
		int answer = -1;
		while (left <= right) {
			int mid = (left + right) >> 1;
		
			if (check(mid) < D) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
				answer = mid;
			}
		}
		return answer;
	}
	
	static long check(int num) {
		long sum = 0;
		for (int[] rule : rules) {
			if (rule[0] <= num) {
				int max = rule[1];
				if (rule[1] > num) max = num;
				sum += (max - rule[0]) / rule[2] + 1;
			}
		}
		return sum;
	}
}
```

## Link
> https://www.acmicpc.net/problem/15732
