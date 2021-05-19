# [D4] 4039. 두 번 이상 등장하는 문자열

## Classification
* 문자열
* 해싱

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class SWEA_4039_두_번_이상_등장하는_문자열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static char[] str;
	static int len, D = 31;
	
	static long[] patternHash;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			len = Integer.parseInt(br.readLine());
			str = br.readLine().toCharArray();
			
			patternHash = new long[len];
			
			sb.append("#").append(t).append(" ").append(Search(0, len-1)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static int Search(int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (mid == 0) return 0;
			
			if (check(mid)) {
				left = mid+1;
			}
			else {
				right = mid-1;
			}
		}
		
		return right;
	}
	
	static boolean check(int k) {
		long value = 0, pow = 1;
		
		for (int i=k-1; i>=0; i--) {
			value += (str[i]-96) * pow;
			if (i != 0) pow *= D;
		}
		patternHash[0] = value;
		
		for (int i=1; i<=len-k; i++) {
			patternHash[i] = D * (patternHash[i-1] - (str[i-1]-96) * pow) + (str[i+k-1]-96);
		}
		
		Arrays.sort(patternHash, 0, len-k+1);
		
		for (int i=1; i<=len-k; i++) {
			if (patternHash[i-1] == patternHash[i]) return true;
		}
		return false;
	}
}
```

## Link
> https://swexpertacademy.com/main/learn/course/subjectDetail.do?courseId=AVuPDj5qAAfw5UW6&subjectId=AWWxy8bKAikDFAW4#
