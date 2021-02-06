import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1218_괄호_짝짓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine());
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			stack.add('x');
			a : for (int i=0; i<N; i++) {
				char c = str.charAt(i);
				switch (c) {
				case '(': case '[': case '{': case '<':
					stack.add(c);
					break;
				case ')':
					if (stack.peek() == '(') stack.pop();
					else {
						System.out.println("#"+t+" 0");
						break a;
					}
					break;
				case ']':
					if (stack.peek() == '[') stack.pop();
					else {
						System.out.println("#"+t+" 0");
						break a;
					}
					break;
				case '}':
					if (stack.peek() == '{') stack.pop();
					else {
						System.out.println("#"+t+" 0");
						break a;
					}
					break;
				case '>':
					if (stack.peek() == '<') stack.pop();
					else {
						System.out.println("#"+t+" 0");
						break a;
					}
				}
				if (i == N-1) System.out.println("#"+t+" 1");
			}
		}
	}
}
