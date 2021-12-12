# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/11.svg" width="30"> 2866. 문자열 잘라내기

## Classification
* 문자열
* 정렬
* 이분탐색

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2866_문자열_잘라내기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static char[][] str;
	static int R, C;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		str = new char[R][C];
		
		for (int i=0; i<R; i++) {
			str[i] = br.readLine().toCharArray();
		}
		
		System.out.println(search(0, R-1));
	}
	
	public static int search(int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (check(mid)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}
	
	public static boolean check(int k) {
		Set<String> set = new HashSet<>();
		
		for (int j=0; j<C; j++) {
			StringBuilder temp = new StringBuilder();
			for (int i=k+1; i<R; i++) {
				temp.append(str[i][j]);
			}
			if (!set.add(temp.toString())) return false;
		}
		return true;
	}
}
```

## Link
> https://www.acmicpc.net/problem/2866
