import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1592_영식이와_친구들 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] cnt;
	static int N, M, L;
	static int pos, answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		L = Integer.parseInt(str[2]);
		
		cnt = new int[N];
		
		while (true) {
			cnt[pos]++; // 받은 횟수
			if (cnt[pos] == M) break;
			answer++; // 던진 횟수
			
			if (cnt[pos]%2 == 1) { // 받은 횟수가 홀수일 때 시계방향으로 + L
				pos = (pos + L) % N;
			}
			else { // 받은 횟수가 짝수일 때 시계방향으로 - L
				pos = (pos - L + N) % N; // 인덱스가 음수가 되는것을 방지하기 위해 + N
			}
		}
		System.out.println(answer);
	}
}
