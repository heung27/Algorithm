# [Level1] 직업군 추천하기

## Classification
* 브루트포스

## Code
```java
class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int max = 0;
        for (String str : table) {
            String[] arr = str.split(" ");
            int score = 0;
            for (int i=0; i<languages.length; i++) {
                for (int j=1; j<arr.length; j++) {
                    if (arr[j].equals(languages[i])) {
                        score += (6-j) * preference[i];
                        break;
                    }
                }
            }
            if (max < score) {
                max = score;
                answer = arr[0];
            } else if (max == score && answer.compareTo(arr[0]) > 0) {
                answer = arr[0];
            }
        }
        return answer;
    }
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/84325
