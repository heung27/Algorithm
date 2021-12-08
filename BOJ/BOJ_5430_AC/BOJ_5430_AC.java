import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5430_AC {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			char[] str = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());
			
			String input = br.readLine();
			String[] arr = input.substring(1, input.length()-1).split(",");
			
			int front = 0, back = N-1;
			boolean reverse = false, isError = false;
			
			for (int i=0; i<str.length; i++) {
				if (str[i] == 'R') {
					int temp = front;
					front = back;
					back = temp;
					reverse = !reverse;
				} else {
					if (!reverse) {
						if (front > back) {
							isError = true;
							break;
						}
						front++;
					} else {
						if (front < back) {
							isError = true;
							break;
						}
						front--;
					}
				}
			}
			
			if (isError) {
				sb.append("error");
			} else {
				int add = 1;
				if (reverse) {
					add = -1;
				}
				
				sb.append("[");
				if ((!reverse && front <= back) || (reverse && front >= back)) {
					int index = front;
					while (true) {
						sb.append(arr[index]);
						if (index != back) sb.append(",");
						else break;
						index += add;
					}
				}
				sb.append("]");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
