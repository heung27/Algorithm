import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2629_양팔저울 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static boolean[][] check; // 추를 이용해 도달할 수 있는 무게
	static int[] weight; // 주 배열
	static int N, M; // N: 추의 개수, M: 확인할 구슬의 개수
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		weight = new int[N];
		check = new boolean[N+1][40001];
		
		String[] str = br.readLine().split(" ");
		for (int i=0; i<N; i++) {
			weight[i] = Integer.parseInt(str[i]); // 추의 무게들 저장
		}
		
		SubSet(0, 0);
		
		M = Integer.parseInt(br.readLine());
		str = br.readLine().split(" ");
		for (int i=0; i<M; i++) {
			if (check[N][Integer.parseInt(str[i])]) sb.append("Y").append(" "); // 목표하는 무게가 도달할 수 있는지 확인
			else sb.append("N").append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void SubSet(int cnt, int sum) { // 모든 경우의 수 확인
		if (check[cnt][sum]) return; // 같은 레벨에 이미 도달했으면 보지않음
		
		check[cnt][sum] = true; // 도달할 수 있는 무게 체크
		
		if (cnt == N) return;
		
		SubSet(cnt+1, sum+weight[cnt]); // 추를 올려놓을 경우
		SubSet(cnt+1, sum); // 올려놓지 않을 경우
		SubSet(cnt+1, Math.abs(sum-weight[cnt])); // 반대쪽에 올려놓을 경우
	}
}
