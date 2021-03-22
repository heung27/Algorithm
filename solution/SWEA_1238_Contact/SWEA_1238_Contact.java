import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238_Contact {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static class Node {
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
	}
	
	static Node[] list;
	static boolean[] check;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		for (int t=1; t<=10; t++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0])/2;
			int start = Integer.parseInt(str[1]);
			
			answer = 0;
			list = new Node[101];
			check = new boolean[101];
			
			st = new StringTokenizer(br.readLine());
			while (N-- > 0) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				list[from] = new Node(to, list[from]);
			}
			
			BFS(start);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		check[start] = true;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			answer = 0;
			
			while (size-- > 0) {
				int num = queue.poll();
				if (answer < num) answer = num;
				
				for (Node temp = list[num]; temp != null; temp = temp.next) {
					if (!check[temp.vertex]) {
						queue.offer(temp.vertex);
						check[temp.vertex] = true;
					}
				}
			}
		}
	}
}
