import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo3_도시_3반_안진흥 {
	static boolean[] num;
	static int[] pw;
	static int size, N, MAX, answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		MAX = Integer.parseInt(br.readLine());
		size = 20;
		num = new boolean[size];
		
		N = Integer.parseInt(br.readLine());
		pw = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			pw[i] = Integer.parseInt(st.nextToken());
		}
		sol(0, 0);
		System.out.println(answer);
	}
	
	static void sol(int cnt, int sum) { // 모든 2진수 순열을 탐색하여 모든 자리수 비교
		if (cnt == size) {
			if (sum > MAX) return;
			int min = Integer.MAX_VALUE;
			for (int i=0; i<N; i++) {
				int level = 0;
				int n = pw[i];
				for (int j=0; j<size; j++) { // 자리수 비교
					// 하...
					boolean x = n%2 == 1? true : false;
					if (num[j] != x) level++; // 자리수의 값이 서로 다르면 보안성 증가
					n = n/2; 
				}
				if (min > level) min = level; // 해커가 시도하는 비밀번호들 중 최소 보안성 채택
			}
			if (answer < min) answer = min; // 해커가 시도하는 비밀번호들 중 최소 보안성 중 최대값 저장
			return;
		}
		num[cnt] = false;
		sol(cnt+1, sum);
		num[cnt] = true;
		sol(cnt+1, sum+(int)Math.pow(2, cnt));
	}
}
