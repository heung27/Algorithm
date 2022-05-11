# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/13.svg" width="30"> 11085. 군사 이동

## Classification

* 그래프 이론
* 자료 구조
* 그래프 탐색
* 분리 집합

## Code

```java
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11085_군사_이동 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int P, W, C, V;

    static int[] parents;
    static int answer;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        parents = new int[P];

        for (int i = 0; i < P; i++) {
            parents[i] = i;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);

        for (int i=0; i<W; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            queue.offer(new int[] {from, to, weight});
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            if (union(node[0], node[1])) {
                if (find(parents[C]) == find(parents[V])) {
                    answer = node[2];
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;
        else parents[b] = a;
        return true;
    }

    static int find(int n) {
        if (parents[n] == n) return n;
        return parents[n] =  find(parents[n]);
    }
}
```

## Link

> https://www.acmicpc.net/problem/11085