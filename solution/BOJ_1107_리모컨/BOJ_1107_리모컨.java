import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static boolean[] check;
	static int N, M, size;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		String s = br.readLine();
		size = s.length();
		
		N = Integer.parseInt(s);
		M = Integer.parseInt(br.readLine());
		check = new boolean[10];
		answer = Math.abs(N-100);
		
		if (M > 0) {
			String[] str = br.readLine().split(" ");
			for (int i=0; i<M; i++) {
				check[Integer.parseInt(str[i])] = true;
			}
		}
		
		Permutation(0, 0);
		System.out.println(answer);
	}
	
	static void Permutation(int cnt, int sum) {
		if (cnt != 0 && cnt >= size-1) {
			int diff = Math.abs(N - sum) + cnt;
			answer = Math.min(answer,  diff);
		}
		if (cnt == size+1) {
			return;
		}
		for (int i=0; i<10; i++) {
			if (!check[i]) {
				Permutation(cnt+1, sum + i * (int)Math.pow(10, cnt));
			}
		}
	}
}
