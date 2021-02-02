import java.util.Arrays;

public class CombinationBasicTest {

// 4C2 
// nCr     
public static void main(String[] args) {
    numbers = new int[R];
    combination(0,1);
}

static int N=4,R=2;
static int[] numbers;
//    cnt : 현재 선택된 갯수, start : 선택지 위치
    public static void combination(int cnt,int start) {
        if(cnt==R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i=start; i <= N; ++i) {
            numbers[cnt] = i;
            combination(cnt+1, i+1);
        }
    }
}