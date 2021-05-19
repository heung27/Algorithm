import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662_이중_우선순위_큐 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static TreeMap<Integer, Integer> queue = new TreeMap<>();
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int K = Integer.parseInt(br.readLine());
			queue.clear();
			
			for (int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				
				char op = st.nextToken().charAt(0);
				int N = Integer.parseInt(st.nextToken());
				
				if (op == 'I') {
					queue.put(N, queue.getOrDefault(N, 0)+1);
				}
				else {
					if (queue.isEmpty()) continue;
					
					int key = 0;
					
					if (N == 1) key = queue.lastKey();
					else key = queue.firstKey();
					
					if (queue.put(key, queue.get(key)-1) == 1) {
						queue.remove(key);
					}
				}
			}
			
			if (queue.isEmpty()) {
				sb.append("EMPTY");
			}
			else {
				sb.append(queue.lastKey()).append(" ").append(queue.firstKey());
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}
