# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/12.svg" width="30"> 5549. 행성 탐사

## Classification
* 누적합

## Code
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5549_행성_탐사 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, K;
    static int[][][] sum;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sum = new int[N+1][M+1][3];

        K = Integer.parseInt(br.readLine());

        for (int i=1; i<=N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j=1; j<=M; j++) {

                if (arr[j-1] == 'J') {
                    sum[i][j][0]++;
                } else if (arr[j-1] == 'O') {
                    sum[i][j][1]++;
                } else {
                    sum[i][j][2]++;
                }

                for (int k=0; k<3; k++) {
                    sum[i][j][k] += sum[i-1][j][k] + sum[i][j-1][k] - sum[i-1][j-1][k];
                }
            }
        }

        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int[] result = new int[3];
            for (int k=0; k<3; k++) {
               result[k] = sum[x2][y2][k] - sum[x1-1][y2][k] - sum[x2][y1-1][k] + sum[x1-1][y1-1][k];
            }

            sb.append(result[0]).append(" ").append(result[1]).append(" ").append(result[2]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
```

## Link
> https://www.acmicpc.net/problem/5549
