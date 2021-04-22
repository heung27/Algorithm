# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/9.svg" width="30"> 15664. N과 M (10)

## Classification
* 백트래킹

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_15664_N과_M_10 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static ArrayList<Integer> list = new ArrayList<>();
	static int[] mount = new int[10001];
	
	static int[] numbers;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		numbers = new int[M];
		
		str = br.readLine().split(" ");
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(str[i]);
			if (mount[num]++ == 0) list.add(num);
		}
		
		Collections.sort(list);
		
		DFS(0, 0);
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void DFS(int cnt, int start) {
		if (cnt == M) {
			for (int i=0; i<cnt; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i=start; i<list.size(); i++) {
			int num = list.get(i);
			if (mount[num] <= 0) continue;
			
			numbers[cnt] = list.get(i);
			
			mount[num]--;
			DFS(cnt + 1, i);
			mount[num]++;
		}
	}
}
```

## Link
> https://www.acmicpc.net/problem/15664
