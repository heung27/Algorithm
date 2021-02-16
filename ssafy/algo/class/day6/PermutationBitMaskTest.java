
import java.util.Arrays;
import java.util.Scanner;

public class PermutationBitMaskTest {
    // 1,2,3
    // 3P3 = 3!
    // nPr  3P2
    static int N, R;
    static int[] input,numbers;
    static int totalCount;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        input = new int[N];
        numbers = new int[R];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        permutation(0, 0);
        System.out.println("총 경우의 수 : "+totalCount);
    }

//	1 << N 	=> 1차는 2의 제곱값 구하기
//    		=> 2차는 N+1 번째의 체크용 데이터 만들기
//	data & 	=> 체크용
//  data | 	=> 마스킹
//  ~,   ^	=> 서로 다르면 1, 같으면 0
    private static void permutation(int cnt, int flag) {
	    if(cnt == R) {
	        totalCount++;
	        System.out.println(Arrays.toString(numbers));
	        return;
	    }
	    for(int i=0; i<N; ++i) {
	        if((flag & 1<<i) != 0) continue;
	        numbers[cnt] = input[i];
	        permutation(cnt+1, flag | 1<<i);
	    }
	}
}
