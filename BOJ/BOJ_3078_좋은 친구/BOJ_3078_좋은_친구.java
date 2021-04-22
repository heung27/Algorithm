import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_3078_좋은_친구 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	@SuppressWarnings("unchecked")
	static Queue<Integer>[] list = new LinkedList[21];
	static int N, K;
	static long answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		
		for (int i=0; i<N; i++) {
			int len = br.readLine().length();
			
			if (list[len] == null) list[len] = new LinkedList<>();
			
			while (!list[len].isEmpty()) {
				if (i - list[len].peek() <= K) {
					answer += list[len].size();
					break;
				}
				list[len].poll();
			}
			
			list[len].offer(i);
		}
		
		System.out.println(answer);
	}
}
