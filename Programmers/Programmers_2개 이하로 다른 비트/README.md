# [Level2] 2개 이하로 다른 비트

## Classification
* 수학
* 비트마스킹

## Code
```java
class Solution {
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] answer = new long[len];
        
        for (int i=0; i<len; i++) {
            long temp = (numbers[i] ^ (numbers[i] + 1)) >> 2;
            
            answer[i] = numbers[i] + temp + 1;
        }
        
        return answer;
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/77885
