# [D4] 4065. LCS

## Classification
* 다이나믹 프로그래밍
* 문자열

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_4065_LCS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			char[] a = br.readLine().toCharArray();
			char[] b = br.readLine().toCharArray();
			
			dp = new int[a.length+1][b.length+1];
			
			for (int i=1; i<=a.length; i++) {
				for (int j=1; j<=b.length; j++) {
					if (a[i-1] == b[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
					else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
			
			sb.append("#").append(t).append(" ").append(dp[a.length][b.length]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
```

## Link
> https://swexpertacademy.com/main/learn/course/subjectDetail.do?courseId=AVuPDj5qAAfw5UW6&subjectId=AWWx2zqqAmoDFAW4
