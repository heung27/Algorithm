import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_16562_친구비 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] arr, parents;
	static boolean[] visit;
	static int N, M, K;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		K = Integer.parseInt(str[2]);
		
		arr = new int[N+1];
		parents = new int[N+1];
		visit = new boolean[N+1];
		
		for (int i=1; i<=N; i++) {
			parents[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		for (int i=1; i<=N; i++) {
			parents[i] = find(i);
			arr[parents[i]] = Math.min(arr[parents[i]], arr[i]);
		}
		
		for (int i=1; i<=N; i++) {
			if (!visit[parents[i]]) {
				answer += arr[i];
				visit[parents[i]] = true;
			}
		}
		
		if (K >= answer) System.out.println(answer);
		else System.out.println("Oh no");
		
	}
	
	static boolean union(int a, int b) {
		int r1 = find(a);
		int r2 = find(b);
		
		if (r1 == r2) return false;
		else if (r1 < r2) parents[r2] = r1;
		else parents[r1] = r2;
		
		return true;
	}
	
	static int find(int n) {
		if (parents[n] == n) return n;
		return parents[n] = find(parents[n]);
	}
}
