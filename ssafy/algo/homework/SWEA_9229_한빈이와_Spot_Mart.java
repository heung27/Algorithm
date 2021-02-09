import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229_한빈이와_Spot_Mart {
	static int[] arr = new int[1000];
	static int N, M, answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);
			answer = -1;
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			sol(0, 0, 0);
			System.out.println("#"+t+" "+answer);
		}
	}
	static void sol(int cnt, int start, int weight) {
		if (weight > M) return;
		if (cnt == 2) {
			if (weight > answer) answer = weight;
			return;
		}
		for (int i=start; i<N; i++) {
			sol(cnt+1, i+1, weight+arr[i]);
		}
	}
}
