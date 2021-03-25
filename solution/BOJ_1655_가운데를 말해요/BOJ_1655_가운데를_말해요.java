import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BOJ_1655_가운데를_말해요 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static PriorityQueue<Integer> max_queue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
	static PriorityQueue<Integer> min_queue = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
	
	static int size1, size2;
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		int mid = Integer.parseInt(br.readLine());
		min_queue.offer(mid);
		size2++;
		sb.append(mid).append("\n");
		
		for (int i=1; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (mid > num) {
				max_queue.offer(num);
				size1++;
			}
			else {
				min_queue.offer(num);
				size2++;
			}
			
			if (size1 < size2) {
				max_queue.offer(min_queue.poll());
				size2--; size1++;
			}
			else if (size1 > size2){
				min_queue.offer(max_queue.poll());
				size1--; size2++;
			}
			
			if (size2 > size1) mid = min_queue.peek();
			else mid = max_queue.peek();
			
			sb.append(mid).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}
