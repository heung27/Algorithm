# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/14.svg" width="30"> 14725. 개미굴

## Classification
* 자료 구조
* 문자열
* 트리
* 트라이

## Code
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_14725_개미굴 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static class Trie {
		Node root;
		
		public Trie() {
			this.root = new Node();
		}
		
		public void insert(String[] words) {
			Node node = root;
			
			for (int i=0; i<words.length; i++) {
				if (!node.child.containsKey(words[i])) {
					node.child.put(words[i], new Node());
				}
				node = node.child.get(words[i]);
			}
		}
		
		public void search() {
			DFS(root.child, 0);
		}
		
		private void DFS(Map<String, Node> nodes, int depth) {
			for (Map.Entry<String, Node> entry : nodes.entrySet()) {
				for (int j=0; j<depth; j++) {
					sb.append("--");
				}
				sb.append(entry.getKey()).append("\n");
				
				DFS(entry.getValue().child, depth+1);
			}
		}
	}
	
	static class Node {
		Map<String, Node> child;
		
		public Node() {
			this.child = new TreeMap<>();
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		Trie trie = new Trie();
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			String[] words = new String[K];
			
			for (int j=0; j<K; j++) {
				words[j] = st.nextToken();
			}
			
			trie.insert(words);
		}
		trie.search();
		bw.write(sb.toString());
		bw.flush();
	}
}
```

## Link
> https://www.acmicpc.net/problem/14725
