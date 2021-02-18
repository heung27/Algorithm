import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3040_백설공주와_일곱_난쟁이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] num = new int[9];
	static int[] numbers = new int[7];
	static boolean check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int i=0; i<9; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		combination(0, 0, 0);
		for (int i=0; i<7; i++) {
			sb.append(num[numbers[i]]).append("\n");
		}
		System.out.print(sb);
	}
	
	static void combination(int cnt, int start, int sum) {
		if (cnt == 7) {
			if (sum == 100) check = true;
			return;
		}
		for (int i=start; i<9; i++) {
			numbers[cnt] = i;
			combination(cnt+1, i+1, sum+num[i]);
			if (check) return;
		}
	}
}
