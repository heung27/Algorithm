import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15809_전국시대 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] list, parents;
	static int N, M, cnt;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = N;
		
		list = new int[N];
		parents = new int[N];
		
		for (int i=0; i<N; i++) {
			list[i] = Integer.parseInt(br.readLine());
			parents[i] = i;
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int o = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			union(a, b, o);
		}
		
		Arrays.sort(list);
		
		sb.append(cnt).append("\n");
		for (int i=N-cnt; i<N; i++) {
			sb.append(list[i]).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void union(int a, int b, int o) {
		a = find(a);
		b = find(b);
		
		if (list[a] == list[b] && o == 2) {
			list[a] = list[b] = 0;
			cnt -= 2;
			return;
		}
		
		if (list[a] < list[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		parents[b] = a;
		if (o == 1) list[a] += list[b];
		else list[a] -= list[b];
		list[b] = 0;
		cnt--;
	}
	

	static int find(int n) {
		if (parents[n] == n) return n;
		return parents[n] = find(parents[n]);
	}
}
