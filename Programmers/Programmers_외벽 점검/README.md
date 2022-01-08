# [Level3] 외벽 점검

## Classification
* 순열

## Code
```java
class Solution {
    int len;
    int answer;
    
    public int solution(int n, int[] weak, int[] dist) {
        answer = Integer.MAX_VALUE;
        len = weak.length;
        
        boolean[] visit = new boolean[len];
        
        dfs(0, n, weak, dist, visit, 0);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    void dfs(int cnt, int n, int[] weak, int[] dist, boolean[] visit, int flag) {
        if (answer <= cnt) return;
        if (flag == len) {
            answer = cnt;
            return;
        }
        if (cnt == dist.length) return;
        
        for (int i=0; i<len; i++) {
            if (visit[i]) continue;
            
            boolean[] temp = visit.clone();
            
            int num = dist[dist.length-cnt-1], temp_flag = flag;
            int j = i;
            while (true) {
                temp[j] = true;
                temp_flag++;
                
                if (temp[(j+1)%len]) break;
                int diff = weak[(j+1)%len] - weak[j];
                if (diff < 0) diff += n;
                if (num < diff) break;
                num -= diff;
                j = (j+1)%len;
            }
            
            dfs(cnt+1, n, weak, dist, temp, temp_flag);
        }
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/60062
