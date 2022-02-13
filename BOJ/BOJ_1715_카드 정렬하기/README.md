# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/12.svg" width="30"> 1715. 카드 정렬하기

## Classification

* 자료 구조
* 그리디 알고리즘
* 우선순위 큐

## Code

```java
import java.io.*;
import java.util.PriorityQueue;

public class BOJ_1715_카드_정렬하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> queue = new PriorityQueue<>();

        while (N-- > 0) {
            long num = Long.parseLong(br.readLine());
            queue.offer(num);
        }

        if (queue.size() == 1) {
            System.out.println(0);
            return;
        }

        long sum = 0;
        while (true) {
            long num = queue.poll() + queue.poll();
            sum += num;

            if (queue.isEmpty()) break;
            queue.offer(num);
        }

        System.out.println(sum);
    }
}
```

## Link

> https://www.acmicpc.net/problem/1715