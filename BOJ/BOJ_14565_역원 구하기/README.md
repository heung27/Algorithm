# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/12.svg" width="30"> 14565. 역원 구하기

## Classification
* 수학
* 정수론
* 확장 유클리드 호제법

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_14565_역원_구하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static long answer = -1;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		long N = Long.parseLong(str[0]);
		long A = Long.parseLong(str[1]);
		
		long gcd = gcd(A, N);
		
		if (gcd == 1) {
			answer = gap(N, A);
			while (answer < 0) {
				answer += N;
			}
		}
		
		System.out.println(N-A+" "+answer);
	}
	
	static long gcd(long a, long b) {
		if (b == 0) return a;
		else return gcd(b, a%b);
	}
	
	static long gap(long a, long b) {
		long[] st1 = new long[]{1, 0};
		long[] st2 = new long[]{0, 1};
		
		while (true) {
			long q = a / b;
			long r = a % b;
			
			if (r == 0) return st2[1];
			
			long s = st1[0] - (st2[0] * q);
			long t = st1[1] - (st2[1] * q);
			
			st1[0] = st2[0]; st1[1] = st2[1];
			
			st2[0] = s; st2[1] = t;
			
			a = b;
			b = r;
		}
	}
} 

//	다른 방법
//	static long exEuclid(long a, long b) {
//	if (b == 0) return a;
//	
//	long gcd = exEuclid(b, a%b);
//	
//	long temp = t;
//	t = s - (a / b) * t;
//	s = temp;
//	
//	while (s <= 0) {
//		s += b;
//		t -= a;
//	}
//	
//	return gcd;
//}
```

## Link
> https://www.acmicpc.net/problem/14565
