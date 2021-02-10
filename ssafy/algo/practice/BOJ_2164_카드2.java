import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_카드2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		for (int i=1; i<=N; i++) {
			queue.offer(i);
		}
		int x = 1;
		while (true) {
			queue.poll();
			if (queue.isEmpty()) break;
			x = queue.poll();
			queue.offer(x);
		}
		System.out.println(x);
	}
}
