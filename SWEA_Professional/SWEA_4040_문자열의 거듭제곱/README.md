# [D4] 4040. 문자열의 거듭제곱 

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
import java.util.StringTokenizer;

public class SWEA_4040_문자열의_거듭제곱 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static char[] str;
	static int size;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			sb.append("#").append(t).append(" ");
			
			str = br.readLine().toCharArray();
			size = str.length;
			
			for (int i=size; i>=1; i--) {
				if (size%i == 0) {
					if (check(size/i)) {
						sb.append(i);
						break;
					}
				}
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static boolean check(int len) {
		long parentHash = 0, patternHash = 0, pow = 1;
		long D = 257;
		
		for (int j=0; j<len; j++) {
			patternHash += str[len-j-1] * pow;
			pow *= D;
		}
		
		for (int i=len; i<=size-len; i+=len) {
			parentHash = 0;
			pow = 1;
			
			for (int j=0; j<len; j++) {
				parentHash += str[i+len-j-1] * pow;
				pow *= D;
			}
			
			if (parentHash != patternHash) return false;
		}
		return true;
	}
}
```

## Link
> https://swexpertacademy.com/main/learn/course/subjectDetail.do?courseId=AVuPDj5qAAfw5UW6&subjectId=AWWxy8bKAikDFAW4#
