import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호_만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] numbers;
	static char[] list;
	static int L, C;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		L = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		list = new char[C];
		numbers = new int[C];
		
		str = br.readLine().split(" ");
		for (int i=0; i<C; i++) {
			list[i] = str[i].charAt(0);
		}
		Arrays.sort(list); // 정렬
		permutation(0, 0);
		
		System.out.println(sb);
	}
	
	static void permutation(int start, int cnt) { // 순열같은 조합
		if (cnt == L) {
			int cnt1 = 0, cnt2 = 0;
			for (int i=0; i<L; i++) {
				switch(list[numbers[i]]) {
				case 'a': case 'e': case 'i': case 'o': case 'u':
					cnt1++;
					break;
				default :
					cnt2++;
				}
			}
			if (cnt1 >= 1 && cnt2 >= 2) {
				for (int i=0; i<L; i++) {
					sb.append(list[numbers[i]]);
				}
				sb.append("\n");
			}
			return;
		}
		for (int i=start; i<C; i++) {
			numbers[cnt] = i;
			permutation(i+1, cnt+1);
		}
	}
}
