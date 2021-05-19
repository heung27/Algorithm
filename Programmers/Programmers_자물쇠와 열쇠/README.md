# [Level3] 자물쇠와 열쇠

## Classification
* 브루트포스
* 구현
* 시뮬레이션

## Code
```java
public class programmers_자물쇠와_열쇠 {
	class Solution {
	    int M, N;
	    int[][] temp;
	    
	    public boolean solution(int[][] key, int[][] lock) {
	            M = key.length; N = lock.length;

				int len = N + (M - 1) * 2;
				int[][] map = new int[len][len];

	            temp = new int[M][M];
	        
				copy(map, lock);
	            if (check(map)) return true;
	        
				int cnt = 4;
				while (true) {
					for (int i = 0; i < M+N-1; i++) {
						for (int j = 0; j < M+N-1; j++) {
							for (int x=0; x<M; x++) {
								for (int y=0; y<M; y++) {
									map[i+x][j+y] += key[x][y];
								}
							}
							if (check(map)) return true;
							copy(map, lock);
						}
					}
					if (--cnt == 0) break;
					key = rotate(key);
				}
				
				return false;
			}
			
			public void copy(int[][] map, int[][] lock) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						map[M-1 + i][M-1 + j] = lock[i][j];
					}
				}
			}

			public int[][] rotate(int[][] key) {
				
				for (int i = 0; i < M; i++) {
					for (int j = 0; j < M; j++) {
						temp[i][j] = key[j][M - i - 1];
					}
				}
				return temp;
			}

			public boolean check(int[][] map) {
				for (int i = M-1; i < M-1 + N; i++) {
					for (int j = M-1; j < M-1 + N; j++) {
						if (map[i][j] != 1) return false;
					}
				}
				return true;
			}
	}
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/60059
