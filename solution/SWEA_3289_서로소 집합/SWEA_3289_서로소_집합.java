import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_3289_서로소_집합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static int[] parents;
	static int N, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);
			
			parents = new int[N+1];
			
			for (int i=1; i<=N; i++) {
				parents[i] = i;
			}
			
			sb.append("#").append(t).append(" ");
			
			while (M-- > 0) {
				str = br.readLine().split(" ");
				int x = Integer.parseInt(str[0]);
				int y = Integer.parseInt(str[1]);
				int z = Integer.parseInt(str[2]);
				
				if (x == 0) union(y, z);
				else sb.append(find(y)==find(z)?1:0);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static boolean union(int a, int b) {
		int r1 = find(a);
		int r2 = find(b);
		
		if (r1 == r2) return false;
		else if (r1 < r2) parents[r2] = r1;
		else parents[r1] = r2;
		return true;
	}
	
	static int find(int x) {
		if (x == parents[x]) return x;
		return parents[x] = find(parents[x]);
	}
}
