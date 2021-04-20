import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2661_좋은수열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static int[] numbers;
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N];
		
		numbers[0] = 1;
		DFS(1);
		
		for (int i=0; i<N; i++) sb.append(numbers[i]);

		bw.write(sb.toString());
		bw.flush();
	}
	
	static boolean DFS(int cnt) {
		if (cnt == N) return true;
		
		for (int n=1; n<=3; n++) {
			numbers[cnt] = n;
			if (!check(cnt)) continue;
			
			if (DFS(cnt+1)) return true;
		}
		
		return false;
	}
	
	static boolean check(int cnt) {
		for (int len=1; len <= (cnt-1)/2+1; len++) { // 비교할 문자열 길이
			int index = cnt-len, temp = cnt;
			
			boolean t = true;
			for (int i=0; i<len; i++) { // 두 문자열이 같은지
				if (numbers[index--] != numbers[temp--]) {
					t = false;
					break;
				}
			}
			
			if (t) return false; // 두 문자열이 같으면 false
		}
		
		return true;
	}
}
