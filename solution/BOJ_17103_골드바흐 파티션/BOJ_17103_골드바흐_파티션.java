import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_17103_골드바흐_파티션 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static int INF = 1000001;
	
	static boolean[] check = new boolean[INF];
	static int answer;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i=2; i<INF; i++) {
			if (!check[i]) {
				list.add(i);
				for (int j=i+i; j<INF; j+=i) {
					check[j] = true;
				}
			}
		}
		
		while (test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			answer = 0;
			for (int x : list) {
				int y = n - x;
				if (x <= y && !check[y]) {
					answer += 1;
				}
			}
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
