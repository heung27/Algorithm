import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
	private char[] nodes;
	private int lastIndex;
	private final int SIZE;
	
	public CompleteBinaryTree(int size) {
		super();
		nodes = new char[size+1];
		SIZE = size;
	}
	
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(char e) {
		if (isFull()) {
			System.out.println("포화상태입니다.");
			return;
		}
		nodes[++lastIndex] = e;
	}
	
	public void bfs() {
		if (isEmpty()) return;
		
		// 탐색 순서 번호를 큐로 관리
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		
		int current;
		while (!queue.isEmpty()) {
			current = queue.poll();
			System.out.println(nodes[current]);
			if (current*2 <= lastIndex) queue.offer(current*2);
			if (current*2+1 <= lastIndex) queue.offer(current*2+1);
		}
	}
	
	public void bfs2() {
		if (isEmpty()) return;
		
		// 탐색 순서 번호를 큐로 관리
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		
		int current, size, level = 0;
		while (!queue.isEmpty()) {
			size = queue.size();
			System.out.print("level"+level+":");
			while (size-- > 0) {
				current = queue.poll();
				System.out.print(nodes[current]);
				if (current*2 <= lastIndex) queue.offer(current*2);
				if (current*2+1 <= lastIndex) queue.offer(current*2+1);
			}
			System.out.println();
			level++;
		}
	}
	
//	tip. alt + 방향키 : 라인 단위로 움직임, ctrl + alt + 방향키 : 라인 복제
//	전위 순회
	public void dfs(int current) {
		if (current > lastIndex) return;
		// VLR
		System.out.println(nodes[current]);
		dfs(current*2); // 왼쪽 자식 노드
		dfs(current*2+1); // 오른쪽 자식 노드
	}
}
