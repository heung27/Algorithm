import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_두_용액 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] water;
	static int num1, num2;
	static int N, min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		water = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			water[i] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		
		Arrays.sort(water);
		search(0, N-1);
		
		sb.append(num1).append(" ").append(num2);
		System.out.println(sb);
	}
	
	static void search(int left, int right) {
		int L = left, R = right;
		
		while (L < R) {
			int x = water[R] + water[L];
			int diff = Math.abs(x);
			
			if (min > diff) {
				min = diff;
				num1 = water[L];
				num2 = water[R];
			}
			
			if (x == 0) return;
			else if (x < 0) L++;
			else R--;
		}
	}
}
