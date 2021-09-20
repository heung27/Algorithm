# [Level3] 네트워크

## Classification
* 그래프
* DFS
* 유니온 파인드

## Code
```java
class Solution {
    boolean[] visit;
        
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        
        visit = new boolean[n];
        for (int i=0; i<n; i++) {
            if (visit[i]) continue;
            answer++;
            DFS(computers, i);
        }
        
        return answer;
    }
    
    public void DFS(int[][] computers, int num) {
        visit[num] = true;
        for (int i=0; i<computers.length; i++) {
            if (visit[i]) continue;
            if (computers[num][i] == 1) {
                DFS(computers, i);
            }
        }
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/43162
