
import java.util.Arrays;
import java.util.Scanner;

public class PermutationBasicTest {
    // 1,2,3
    // 3P3 = 3!
    // nPr  3P2
    static int N, R;
    static int[] input,numbers;
    static boolean[] isSelected;
    static int totalCount;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        input = new int[N];
        isSelected = new boolean[N];
        numbers = new int[R];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        permutation(0);
        System.out.println("총 경우의 수 : "+totalCount);
    }

	private static void permutation(int cnt) {
	    if(cnt == R) {
	        totalCount++;
	        System.out.println(Arrays.toString(numbers));
	        return;
	    }
	    for(int i=0; i<N; ++i) {
	        if(isSelected[i]) continue;
	        numbers[cnt] = input[i];
	        isSelected[i] = true;
	        permutation(cnt+1);
	        isSelected[i] = false;
	    }
	}
}
