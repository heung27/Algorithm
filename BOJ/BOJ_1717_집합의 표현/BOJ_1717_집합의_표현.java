import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1717_집합의_표현 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] parents;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		parents = new int[N+1];
		
		for (int i=0; i<=N; i++) {
			parents[i] = i;
		}
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (type == 0) {
				union(a, b);
			} else {
				a = find(a);
				b = find(b);
				if (a == b) {
					sb.append("YES");
				} else {
					sb.append("NO");
				}
				sb.append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b) return false;
		
		if (a < b) {
			parents[a] = b;
		} else {
			parents[b] = a;
		}
		return true;
	}
	
	static int find(int n) {
		if (parents[n] == n) return n;
		return parents[n] = find(parents[n]);
	}
}
