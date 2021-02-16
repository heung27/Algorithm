import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11723_집합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int flag;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			String[] str = br.readLine().split(" ");
			String op = str[0];
			int x = 0;
			if (str.length > 1) x = Integer.parseInt(str[1]);
			
			switch (op) {
			case "add": add(x); break;
			case "remove": remove(x); break;
			case "check": sb.append(check(x)).append("\n"); break;
			case "toggle": toggle(x); break;
			case "all": all(); break;
			case "empty": empty();
			}
		}
		System.out.print(sb);
	}
	
	static void add(int i) {
		flag |= 1<<i;
	}
	
	static void remove(int i) {
		flag &= ~(1<<i);
	}
	
	static int check(int i) {
		if ((flag & 1<<i) != 0) return 1;
		else return 0;
	}
	
	static void toggle(int i) {
		flag ^= 1<<i;
	}
	
	static void all() {
		flag = ~0;
	}
	
	static void empty() {
		flag = 0;
	}
}
