# [D6] 4070. 타일링

## Classification
* 다이나믹 프로그래밍

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class SWEA_4070_타일링 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static BigInteger[] dp = new BigInteger[250];
	
	public static void main(String[] args) throws IOException {
		dp[0] = BigInteger.ONE; dp[1] = BigInteger.valueOf(3);
		
		for (int i=2; i<250; i++) {
			dp[i] = dp[i-1].add(dp[i-2].shiftLeft(1));
		}
		
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			int n = Integer.parseInt(br.readLine());
			
			sb.append("#").append(t).append(" ").append(dp[n-1]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
```

## Link
> https://swexpertacademy.com/main/learn/course/subjectDetail.do?courseId=AVuPDj5qAAfw5UW6&subjectId=AWWx2zqqAmoDFAW4#
