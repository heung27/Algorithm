# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/13.svg" width="30"> 2146. 다리 만들기

## Classification

* 그래프 이론
* 그래프 탐색
* 너비 우선 탐색

## Code

```java
import java.io.*;
import java.util.*;

public class BOJ_2146_다리_만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static Queue<int[]> queue = new LinkedList<>();

    static int[] movex = {-1, 0, 1, 0};
    static int[] movey = {0, 1, 0, -1};

    static int[][] map;
    static int N, num, answer;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        num = 2;
        answer = N * 2;

        map = new int[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == 1) {
                    BFS(i, j);
                    num++;
                }
            }
        }

        move();
        System.out.println(answer);
    }

    static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        map[x][y] = num;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int d=0; d<4; d++) {
                int nx = pos[0] + movex[d];
                int ny = pos[1] + movey[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != 1) continue;

                map[nx][ny] = num;
                queue.offer(new int[] {nx, ny});
            }
        }
    }

    static void move() {
        int[][] dist = new int[N][N];

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int d=0; d<4; d++) {
                int nx = pos[0] + movex[d];
                int ny = pos[1] + movey[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (map[nx][ny] == 0) {
                    map[nx][ny] = map[pos[0]][pos[1]];
                    dist[nx][ny] = dist[pos[0]][pos[1]] + 1;
                    queue.offer(new int[] {nx, ny});
                } else if (map[nx][ny] != map[pos[0]][pos[1]]) {
                    answer = Math.min(answer, dist[nx][ny] + dist[pos[0]][pos[1]]);
                }
            }
        }
    }
}
```

## Link

> https://www.acmicpc.net/problem/2146