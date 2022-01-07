# [Level3] 기둥과 보 설치

## Classification
* 시뮬레이션

## Code
```java
class Solution {
    boolean[][][] mat;
    
    public int[][] solution(int n, int[][] build_frame) {
        mat = new boolean[n+1][n+1][2];
		
		int len = build_frame.length;
		int size = 0;
		
		for (int i=0; i<len; i++) {
			int y = build_frame[i][0];
			int x = build_frame[i][1];
			int a = build_frame[i][2]; // 0: 기둥, 1: 보
			int b = build_frame[i][3]; // 0: 삭제, 1: 설치
			
			if (b == 0 && mat[x][y][a]) {
                if (a == 0) {
                    mat[x][y][0] = false;
                    boolean check = true;
                    
                    if (x+1 <= n && mat[x+1][y][0]) {
                        check = put1(x+1, y, n);
                    }
                    
                    if (check && x+1 <= n &&  y-1 >= 0 && mat[x+1][y-1][1]) {
                        check = put2(x+1, y-1, n);
                    }
                    
                    if (check && x+1 <= n && mat[x+1][y][1]) {
                        check = put2(x+1, y, n);
                    }
                    
                    if (check) {
					    size--;
                    } else {
                        mat[x][y][0] = true;
                    }
                } else {
                    mat[x][y][1] = false;
                    boolean check = true;
                    
                    if (mat[x][y][0]) {
                        check = put1(x, y, n);
                    }
                    
                    if (check && y+1 <= n && mat[x][y+1][0]) {
                        check = put1(x, y+1, n);
                    }
                    
                    if (check && y-1 >= 0 && mat[x][y-1][1]) {
                        check = put2(x, y-1, n);
                    }
                    
                    if (check && y+1 <= n && mat[x][y+1][1]) {
                        check = put2(x, y+1, n);
                    }
                    
                    if (check) {
					    size--;
                    } else {
                        mat[x][y][1] = true;
                    }
                }
			} else if (b == 1 && !mat[x][y][a]) {
				if (a == 0 && put1(x, y, n)) {
					mat[x][y][0] = true;
					size++;
				} else if (a == 1 && put2(x, y, n)) {
					mat[x][y][1] = true;
					size++;
				}
			}
		}
		
		int[][] answer = new int[size][3];
		int index = 0;
        for (int j=0; j<=n; j++) {
        	for (int i=0; i<=n; i++) {
        		for (int k=0; k<2; k++) {
        			if (mat[i][j][k]) {
        				answer[index][0] = j;
        				answer[index][1] = i;
        				answer[index++][2] = k;
        			}
        		}
        	}
        }
        return answer;
    }
    
    public boolean put1(int x, int y, int n) {
		if (x == 0 || mat[x][y][1] || (x-1 >= 0 && mat[x-1][y][0]) || (y > 0 && mat[x][y-1][1])) {
			return true;
		}
		return false;
	}
	
	public boolean put2(int x, int y, int n) {
		if ((x-1 >= 0 && mat[x-1][y][0]) || (x-1 >= 0 && y+1 <= n && mat[x-1][y+1][0]) || ((y > 0 && mat[x][y-1][1]) && (y+1 <= n && mat[x][y+1][1]))) {
			return true;
		}
		return false;
	}
}
```

## Link
> https://programmers.co.kr/learn/courses/30/lessons/60061
