import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<int[]> s = new Stack<>();
		
		for (int i=1; i<=num; i++) {
			int x = Integer.parseInt(st.nextToken());
			while (!s.isEmpty()) {
				if (s.peek()[0] >= x) {
					sb.append(s.peek()[1]).append(" ");
					break;
				}
				else s.pop();
			}
			if (s.isEmpty()) sb.append("0 ");
			s.add(new int[] {x,i});
		}
		System.out.println(sb);
	}
}
