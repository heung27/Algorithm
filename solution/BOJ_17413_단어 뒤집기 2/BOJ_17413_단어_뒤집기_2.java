import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17413_단어_뒤집기_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		boolean t = false;
		
		for (int i=0; i<str.length(); i++) {
			if (!t) {
				if (str.charAt(i) == '<') {
					t = true;
					while (!stack.isEmpty()) sb.append(stack.pop());
					sb.append(str.charAt(i));
				}
				else if (str.charAt(i) == ' ') {
					while (!stack.isEmpty()) sb.append(stack.pop());
					sb.append(str.charAt(i));
				}
				else {
					stack.add(str.charAt(i));
				}
			}
			else {
				sb.append(str.charAt(i));
				if (str.charAt(i) == '>') t = false;
			}
		}
		while (!stack.isEmpty()) sb.append(stack.pop());
		
		bw.write(sb.toString());
		bw.flush();
	}
}
