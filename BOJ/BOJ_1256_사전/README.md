# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/13.svg" width="30"> 1256. 사전

## Classification
* 수학
* 다이나믹 프로그래밍
* 조합론

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1256_사전 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N, M, K;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][M+1];
		
		get(N, M, K);
		
		if (check(N, M) < K) {
			System.out.println(-1);
		} else {
			System.out.println(sb.toString());
		}
	}
	
	public static int check(int a,int z){
        if(a == 0 || z == 0) return 1;
        if(dp[a][z] != 0) return dp[a][z];
        return dp[a][z] = Math.min(check(a-1,z) + check(a,z-1), 1000000001);
    }

	public static void get(int a, int z, int k){
        if(a == 0){
            for(int i=0; i<z; i++) {
            	sb.append("z");
            }
            return;
        }
        if(z == 0){
            for(int i=0; i<a; i++) {
            	sb.append("a");
            }
            return;
        }

        int check = check(a-1, z);

        if(k > check){
            sb.append("z");
            get(a, z-1, k-check);
        }
        else{
            sb.append("a");
            get(a-1, z, k);
        }
    }
}
```

## Link
> https://www.acmicpc.net/problem/1256
