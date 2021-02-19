import java.util.Arrays;
import java.util.Scanner;

public class Solution {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int TC = sc.nextInt();
    int res = 0; //출력값, 최소값
    int N;
    int[][] map;
    for(int t = 1 ; t <= TC; t++) {
        res = Integer.MAX_VALUE;
//            입력
            N = sc.nextInt();
            map = new int[N][N];
            for(int i =0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
//            구현
//            부분집합  공집합  ~ 전체집합 경우 중에 N/2인 집합일때 솔루션 구현
//            바이너리카운팅
//            N 6
//            000001  ~ 111111,000001  ~ 011111  64가지 0-31까지 
//            000111 == 111000  , 010101 , 101010

            int len = 1<<N; //전체 집합의 갯수
            int cnt = 0;
            boolean[] food = new boolean[N];
            for(int i = 1; i < len/2; i++) {
                cnt = 0;
                Arrays.fill(food, false);
                for(int j = 0; j < N; j++) {
                    if((i & (1<<j)) != 0) {
                        cnt++;
                        food[j] = true;
                    }
                }
                if(cnt == N/2) {// 두개로 정확히 나누어진 조합
                    int sumA = 0, sumB = 0;
                    for(int k = 0; k < N; k++) {
                        for(int l = 0; l < N; l++) {
                            if(k == l) { // 같은 음식은 조합이 안됨
                                continue;
                            }
                            if(food[k] != food[l]) { //서로 다른 음식 안됨
                                continue;
                            }
                            if(food[k]) { //A 음식
                                sumA += map[k][l];
                            }else { //B음식
                                sumB += map[k][l];
                            }
                        }
                    }
                    res = Math.min(res, Math.abs(sumA - sumB));
                }

            }


//            출력
            System.out.println("#" + t + " " + res);
        }

	}
}
