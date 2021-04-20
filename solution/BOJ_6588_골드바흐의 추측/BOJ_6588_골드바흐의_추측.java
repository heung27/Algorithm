import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_6588_골드바흐의_추측 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static int INF = 1000001;
	
	static ArrayList<Integer> list = new ArrayList<>();
	static boolean[] check = new boolean[INF];
	static int N;
	
	public static void main(String[] args) throws IOException {
		for (int i=2; i<INF; i++) {
			if (!check[i]) {
				list.add(i);
				for (int j=i+i; j<INF; j+=i) {
					check[j] = true;
				}
			}
		}
		
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			
			int mid = N / 2;
			boolean t = false;
			for (int a : list) {
				if (a > mid) break;
				
				if (!check[N-a]) {
					sb.append(N).append(" = ").append(a).append(" + ").append(N-a);
					t = true;
					break;
				}
			}
			
			if (!t) sb.append("Goldbach's conjecture is wrong.");
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}
