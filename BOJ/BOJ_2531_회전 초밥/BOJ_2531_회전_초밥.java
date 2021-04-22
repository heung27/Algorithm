import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2531_회전_초밥 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] sushi, cnt;
	static int N, D, K, C;
	static int answer, sum;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		D = Integer.parseInt(str[1]);
		K = Integer.parseInt(str[2]);
		C = Integer.parseInt(str[3]);
		
		cnt = new int[D+1];
		sushi = new int[N];
		
		for (int i=0; i<N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		int index1 = 0, index2 = K;
		for (int i=index1; i<index2; i++) {
			if (cnt[sushi[i]]++ == 0) sum++;
		}
		
		answer = sum;
		
		while (index1 < N) {
			if (--cnt[sushi[index1++]] == 0) sum--;
			if (cnt[sushi[index2++]]++ == 0) sum++;
			
			if (cnt[C] == 0) {
				if (answer < sum + 1) answer = sum + 1;
			}
			else {
				if (answer < sum) answer = sum;
			}
				
			if (index2 == N) index2 = 0;
		}
		
		System.out.println(answer);
	}
}
