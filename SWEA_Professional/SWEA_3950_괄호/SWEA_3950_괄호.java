import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;

public class SWEA_3950_괄호 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			sb.append("#").append(t).append(" ");
			
			int len = Integer.parseInt(br.readLine());
			char[] str = br.readLine().toCharArray();
			
			if (len % 2 == 1) {
				sb.append(-1).append("\n");
				continue;
			}
			
			Stack<Integer> stack = new Stack<>();
			ArrayList<Integer> arr = new ArrayList<>();
			
			for (int i=0; i<len; i++) {
				if (stack.isEmpty()) {
					if (str[i] == '(') {
						stack.add(i);
					}
					else arr.add(i);
				}
				else {
					if (str[i] == ')') {
						stack.pop();
					}
					else stack.add(i);
				}
			}
			
			int size1 = arr.size(), size2 = stack.size();
			
			if (size1 == 0 && size2 == 0) {
				sb.append(0).append("\n");
			}
			else if (size1 != 0 && size2 == 0) {
				sb.append(1).append("\n");
				sb.append(arr.get(0)).append(" ").append(arr.get((size1-1)/2)).append("\n");
			}
			else if (size2 != 0 && size1 == 0) {
				sb.append(1).append("\n");
				sb.append(stack.get(size2/2)).append(" ").append(stack.peek()).append("\n");
			}
			else {
				sb.append(2).append("\n");
				sb.append(stack.get(0)).append(" ").append(stack.peek()).append("\n");
				
				int x = stack.get(0) + stack.peek();
				while (!stack.isEmpty()) arr.add(Math.abs(stack.pop()-x)); // 인덱스 뒤집기
				
				sb.append(arr.get(0)).append(" ").append(arr.get((arr.size()-1)/2)).append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
