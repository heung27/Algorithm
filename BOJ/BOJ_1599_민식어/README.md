# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/12.svg" width="30"> 1559. 민식어

## Classification
* 문자열
* 정렬
* 파싱

## Code
```java
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1599_민식어 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        PriorityQueue<String> queue = new PriorityQueue<>();

        while (N-- > 0) {
            String input = br.readLine().replace("k", "c").replace("ng", "n~");
            queue.offer(input);
        }

        while (!queue.isEmpty()) {
            sb.append(queue.poll().replace("c", "k").replace("n~", "ng")).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
```

## Link
> https://www.acmicpc.net/problem/1599
