import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class BOJ_2800_괄호_제거 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static ArrayList<Integer> list = new ArrayList<>();
	static Set<String> set = new TreeSet<>();
	static boolean[] check;
	static char[] str;
	static int[] arr;
	static boolean visit;
	
	public static void main(String[] args) throws IOException {
		str = br.readLine().toCharArray();
		check = new boolean[str.length];
		arr = new int[str.length];
		
		Stack<Integer> stack = new Stack<>();
		for (int i=0; i<str.length; i++) {
			if (str[i] == '(') {
				list.add(i);
				stack.add(i);
			} else if (str[i] == ')') {
				int temp = stack.pop();
				arr[temp] = i;
			}
		}
		DFS(0);
		for (String temp : set) {
			sb.append(temp).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	public static void DFS(int cnt) {
		if (cnt == list.size()) {
			if (visit) {
				StringBuilder temp = new StringBuilder();
				for (int i=0; i<str.length; i++) {
					if (!check[i]) temp.append(str[i]);
				}
				set.add(temp.toString());
			} else visit = true;
			return;
		}
		
		DFS(cnt+1);
		int index = list.get(cnt);
		check[index] = true;
		check[arr[index]] = true;
		DFS(cnt+1);
		check[index] = false;
		check[arr[index]] = false;
	}
}
