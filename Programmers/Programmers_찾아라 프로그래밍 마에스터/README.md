# [Level2] 게임 맵 최단거리

## Classification
* BFS

## Code
```java
import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        return BFS(maps);
    }
    
    public int BFS(int[][] maps) {
        int[] movex = {-1, 0, 1, 0};
        int[] movey = {0, 1, 0, -1};
        int n = maps.length;
        int m = maps[0].length;
        int cnt = 1;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        queue.offer(new int[] {0, 0});
        visit[0][0] = true;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] pos = queue.poll();
                
                if (pos[0] == n-1 && pos[1] == m-1) return cnt;

                for (int d=0; d<4; d++) {
                    int nx = pos[0] + movex[d];
                    int ny = pos[1] + movey[d];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || maps[nx][ny] == 0) continue;

                    if (!visit[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        visit[nx][ny] = true;
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/1844
