import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_17471_게리맨더링 {
	static List<ArrayList<Integer>> arr;
	static int[] map, number; // 인구 수
	static boolean[] check, check_temp;
	static int N, answer, depth;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1];
		check = new boolean[N+1];
		arr = new ArrayList<ArrayList<Integer>>();
		
		String[] str = br.readLine().split(" ");
		for (int i=1; i<=N; i++) {
			map[i] = Integer.parseInt(str[i-1]);
		}
		
		arr.add(null);
		for (int i=1; i<=N; i++) {
			str = br.readLine().split(" ");
			arr.add(new ArrayList<Integer>());
			for (int j=1; j<=Integer.parseInt(str[0]); j++) {
				 arr.get(i).add(Integer.parseInt(str[j]));
			}
		}
		answer = Integer.MAX_VALUE;
		divide();
		
		if (answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);
	}
	
	static void divide() {
		for (int d=1; d<=N/2; d++) {
			combination(1, d, 0);
		}
	}
	
	static void combination(int node, int depth, int cnt) {
		if (cnt == depth) {
			
			int sum1 = -1, sum2 = -1;
			for (int i=1; i<=N; i++) { // A 구역
				if (check[i]) {
					sum1 = BFS(i, depth, true);
					break;
				}
			}
			for (int i=1; i<=N; i++) { // B 구역
				if (!check[i]) {
					sum2 = BFS(i, N-depth, false);
					break;
				}
			}
			if (sum1 != -1 && sum2 != -1) {
				int temp = Math.abs(sum1-sum2);
				answer = answer < temp ? answer : temp;
			}
		}
		for (int i=node; i<=N; i++) {
			check[i] = true;
			combination(i+1, depth, cnt+1);
			check[i] = false;
		}
	}
	
	static int BFS(int node, int depth, boolean t) { // B 선거구
		check_temp = Arrays.copyOf(check, N+1);
		Queue<Integer> queue = new LinkedList<Integer>();
		int sum = 0;
		
		queue.add(node);
		sum += map[node];
		check_temp[node] = !t;
		
		while (!queue.isEmpty()) {
			int n = queue.poll();
			
			depth--;
			if (depth == 0) return sum;
			
			for (int next : arr.get(n)) {
				if (check_temp[next] == t) {
					sum += map[next];
					check_temp[next] = !t;
					queue.offer(next);
				}
			}
		}
		return -1;
	}
}
