# [Level2] 카펫

## Classification
* 브루트포스

## Code
```java
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer;
        
        int x = 3, y = 3;
        while (true) {
            int sum = (x-1) * 2 + (y-1) * 2;
            if (sum == brown && x*y - brown == yellow) {
                answer = new int[]{x, y};
                break;
            }
            if (x > y) {
                y++;
            }
            else {
                x++;
                y = 3;
            }
        }
        
        return answer;
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/42842
