# [Level2] 멀쩡한 사각형

## Classification
* 최대공약수

## Code
```java
class Solution {
    public long solution(int w, int h) {
        long answer = (long)w * h;
        long r = gcd(w, h);
        answer -= w + h - r;
        return answer;
    }
    
    public int gcd(int a, int b) {
        int r = a % b;
        if (r == 0) return b;
        else return gcd(b, r);
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/62048
