# [Level2] 삼각 달팽이

## Classification
* 시뮬레이션

## Code
```java
class Solution {
    public int[] solution(int n) {
        int[] movex = {1, 0, -1};
        int[] movey = {0, 1, -1};
        
        int[][] mat = new int[n][n];
        int x = -1, y = 0, cnt = n, num = 1, d = 0;
        while (cnt != 0) {
            for (int i=0; i<cnt; i++) {
                x += movex[d];
                y += movey[d];
                mat[x][y] = num++;
            }
            cnt--;
            d = (d + 1) % 3;
        }
        
        int size = 0;
        for (int i=1; i<=n; i++) {
            size += i;
        }
        int[] answer = new int[size];
        int index = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<=i; j++) {
                answer[index++] = mat[i][j];
            }
        }
        
        return answer;
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/68645
