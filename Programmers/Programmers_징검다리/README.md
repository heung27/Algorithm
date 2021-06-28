# [Level4] 징검다리

## Classification
* 이분 탐색
* 투 포인터

## Code
```java
import java.util.Arrays;

class Solution {
    int[] arr;
	int N, len;
    
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        N = n;
        len = rocks.length + 2;
        arr = new int[len];
        arr[len-1] = distance;
        
        for (int i=0; i<rocks.length; i++) {
            arr[i+1] = rocks[i];
        }

        return binarySearch(1, distance);
    }
    
    public int binarySearch(int left, int right) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (check(mid)) {
            	left = mid + 1;
            }
            else {
            	right = mid - 1;
            }
        }
        return left - 1;
    }
    
    public boolean check(int k) {
    	int cnt = 0, pre = 0, post = 1;
        while (post < len) {
            if (arr[post] - arr[pre] < k) {
            	cnt++;
            }
            else {
            	pre = post;
            }
            post++;
        }
        return cnt <= N;
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/43236
