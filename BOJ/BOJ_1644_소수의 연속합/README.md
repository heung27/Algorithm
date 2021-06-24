# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/13.svg" width="30"> 1644. 소수의 연속합

## Classification
* 수학
* 정수론
* 두 포인터
* 소수 판정
* 에라토스테네스의 체

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1644_소수의_연속합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static boolean[] check;
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		check = new boolean[N+1];
		prime();
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=2; i<=N; i++) {
			if (!check[i]) list.add(i);
		}
		
		int answer = 0, sum = 0;
		int pre = 0, index = 0;
		while (pre < list.size()) {
			if (sum < N) {
				if (index == list.size()) break;
				sum += list.get(index++);
			}
			else {
				if (sum == N) answer++;
				sum -= list.get(pre++);
			}
		}
		System.out.println(answer);
	}
	
	static void prime() {
		for (int i=2; i<=Math.sqrt(N); i++) {
			if (check[i]) continue;
			for (int j=i+i; j<=N; j+=i) {
				check[j] = true;
			}
		}
	}
}
```

## Link
> https://www.acmicpc.net/problem/1644
