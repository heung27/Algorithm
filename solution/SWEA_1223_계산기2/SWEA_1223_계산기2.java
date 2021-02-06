import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1223_계산기2 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t=1; t<=10; t++) {
			sb.append("#").append(t).append(" ");
			int num = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Integer> stack = new Stack<>();
			for (int i=0; i<num; i++) {
				if (str.charAt(i) == '*') {
					i++;
					stack.add(stack.pop() * (str.charAt(i)-'0'));
				}else if (str.charAt(i) != '+') {
					stack.add(str.charAt(i)-'0');
				}
			}
			int answer = 0;
			while (!stack.isEmpty()) {
				answer += stack.pop();
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
