import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_5052_전화번호_목록 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static class Node {
		Node[] child;
		boolean isLast;
		boolean isPass;
		
		public Node() {
			this.child = new Node[10];
			this.isLast = false;
		}
	}
	
	static class Trie {
		Node root;

		public Trie() {
			this.root = new Node();
		}
		
		public boolean insert(String word) {
			Node node = root;
			
			for (int i=0; i<word.length(); i++) {
				int next = word.charAt(i)-'0';
				
				Node[] child = node.child;
				if (child[next] == null) child[next] = new Node();
				
				node = child[next];
				
				if (node.isLast) return false;
				if (i != word.length()-1) node.isPass = true;
			}
			
			if (node.isPass) return false;
			node.isLast = true;
			node.isPass = true;
			return true;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			Trie trie = new Trie();
			
			int N = Integer.parseInt(br.readLine());
			String[] str = new String[N];
			boolean check = true;
			
			for (int i=0; i<N; i++) {
				str[i] = br.readLine();
			}
			
			for (int i=0; i<N; i++) {
				if (!trie.insert(str[i])) {
					check = false;
					break;
				}
			}
			
			if (check) sb.append("YES");
			else sb.append("NO");
			
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}

