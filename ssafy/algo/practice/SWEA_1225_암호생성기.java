import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225_암호생성기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t=1; t<=10; t++) {
			br.readLine();
			Queue<Integer> queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			int x = -1;
			while (x != 0) {
				for (int i=1; i<=5; i++) {
					x = queue.poll()-i;
					if (x < 0) x = 0;
					queue.offer(x);
					if (x == 0) break;
				}
			}
			
			System.out.print("#"+t);
			while (!queue.isEmpty()) {
				System.out.print(" "+queue.poll());
			}
			System.out.println();
		}
	}
}
