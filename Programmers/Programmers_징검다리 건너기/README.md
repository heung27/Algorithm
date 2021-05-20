# [Level3] 징검다리 건너기

## Classification
* 이분탐색
* 슬라이딩 윈도우

## Code
```java
public class programmers_징검다리_건너기 {
	class Solution {
	    int[] arr;
	    int max;
	    
	    public int solution(int[] stones, int k) {
	        arr = stones;
	        max = k;
	        
	        return binarySearch(0, Integer.MAX_VALUE);
	    }
	    
	    int binarySearch(int left, int right) {
	        while (left <= right) {
	            int mid = (left + right) / 2;
	            
	            if (check(mid)) {
	                left = mid + 1;
	            }
	            else {
	                right = mid - 1;
	            }
	        }
	        return left;
	    }
	    
	    boolean check(int mid) {
	        int cnt = 0;
	        for (int i=0; i<arr.length; i++) {
	            if (arr[i] - mid > 0) {
	                cnt = 0;
	            }
	            else if (++cnt == max) return false;
	        }
	        return true;
	    }
	}
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/64062
