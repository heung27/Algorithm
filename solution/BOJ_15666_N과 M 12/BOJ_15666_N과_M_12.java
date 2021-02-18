import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15666_N과_M_12 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] num, numbers;
	static int N, M, size;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		num = new int[N];
		numbers = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		int temp = num[0];
		for (int i=1; i<N; i++) {
			if (temp != num[i]) {
				num[size++] = temp;
				temp = num[i];
			}
		}
		num[size] = temp;
		
		permutation(0, 0);
		
		System.out.print(sb);
	}
	
	static void permutation(int cnt, int start) {
		if (cnt == M) {
			for (int k=0; k<M; k++) {
				sb.append(numbers[k]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i=start; i<=size; i++) {
			numbers[cnt] = num[i];
			permutation(cnt+1, i);
		}
	}
}
