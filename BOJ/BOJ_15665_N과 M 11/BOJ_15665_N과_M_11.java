import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_15665_N과_M_11 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static ArrayList<Integer> list = new ArrayList<>();
	static int[] mount = new int[10001];
	
	static int[] numbers;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		numbers = new int[M];
		
		str = br.readLine().split(" ");
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(str[i]);
			if (mount[num]++ == 0) list.add(num);
		}
		
		Collections.sort(list);
		
		DFS(0);
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void DFS(int cnt) {
		if (cnt == M) {
			for (int i=0; i<cnt; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i=0; i<list.size(); i++) {
			numbers[cnt] = list.get(i);
			DFS(cnt + 1);
		}
	}
}
