# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/13.svg" width="30"> 7512. 연속하는 소수의 합

## Classification
* 수학
* 브루트포스 알고리즘
* 정수론
* 소수 판정
* 에라토스테네스의 체
* 슬라이딩 윈도우

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7512_연속하는_소수의_합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static boolean[] prime;
	
	static int[][] indexs;
	static int[] list, numbers;
	static int N, len;
	static int MAX = 10000000;
	
	static ArrayList<Integer> arr = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		prime = new boolean[MAX];
		prime();
		
		for (int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			list = new int[N];
			numbers = new int[N];
			indexs = new int[N][2];
			
			for (int i=0; i<N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(list);
			
			for (int i=0; i<N; i++) {
				indexs[i][1] = list[i];
			}
			
			int index = 0, sum = 0;
			for (int i=0; i<len; i++) {
				if (list[index] == i) {
					numbers[index++] = sum;
					if (index == N) break;
				}
				sum += arr.get(i);
			}
			
			while (prime[numbers[N-1]]) {
				numbers[N-1] += arr.get(indexs[N-1][1]++) - arr.get(indexs[N-1][0]++);
			}
			
			index = N-2;
			while (index >= 0) {
				if (numbers[index] < numbers[index+1]) {
					numbers[index] += arr.get(indexs[index][1]++) - arr.get(indexs[index][0]++);
				} else if (numbers[index] > numbers[index+1]) {
					index++;
					numbers[index] += arr.get(indexs[index][1]++) - arr.get(indexs[index][0]++);
					if (index == N-1) {
						while (prime[numbers[index]]) {
							numbers[index] += arr.get(indexs[index][1]++) - arr.get(indexs[index][0]++);
						}
						index--;
					}
				} else index--;
			}
			
			sb.append("Scenario ").append(t).append(":\n");
			sb.append(numbers[0]).append("\n\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static void prime() {
		for (int i=2; i<MAX; i++) {
			if (prime[i]) continue;
			arr.add(i);
			
			for (int j=i+i; j<MAX; j+=i) {
				prime[j] = true;
			}
		}
		len = arr.size();
	}
}
```

## Link
> https://www.acmicpc.net/problem/7512
