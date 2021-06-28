# [Level3] 정수 삼각형

## Classification
* 다이나믹 프로그래밍

## Code
```java
class Solution {
		
    public int solution(int[][] triangle) {
        for (int i=triangle.length-2; i>=0; i--) {
            for (int j=0; j<triangle[i].length; j++) {
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }

        return triangle[0][0];
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/43105
