import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1242_소풍 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int N, K, M;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]); // 퇴장 2
		M = Integer.parseInt(str[2]); // M 번째 학생 3
		
		int answer = 0;
		while (true) {
			answer++;
			int index = K % N; // 퇴장할 위치
			if (index == 0) index = N;
			
			if (index == M) break;
			else if (index < M) { // 동호의 상대적 위치 이동
				M = M - index;
			}
			else {
				M = M - index + N;
			}
			N--;
		}
		System.out.println(answer);
	}
}
