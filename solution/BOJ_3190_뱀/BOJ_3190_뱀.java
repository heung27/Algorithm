import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_3190_뱀 {
	static class Snake {
		int[] head;
		int[] tail;
		public Snake(int[] head, int[] tail) {
			this.head = head;
			this.tail = tail;
		}
	}
	static int[][] map;
	static int[] moveX = {0, 1, 0, -1}; // 우, 하, 좌, 상
	static int[] moveY = {1, 0, -1, 0};
	static int N, d, d2; // d: 머리 방향 인덱스, d2: 꼬리 방향 인덱스
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			String[] str = br.readLine().split(" ");
			map[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = -1; // 사과 위치 저장
		}
		
		Queue<int[]> queue = new LinkedList<>();
		n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			String[] str = br.readLine().split(" ");
			int t = Integer.parseInt(str[0]);
			int dir = str[1].charAt(0) - 'H'; // D: -4, L: 4
			queue.offer(new int[] {t,dir}); // 방향 회전 정보 저장
		}
		
		Snake snake = new Snake(new int[] {1, 1}, new int[] {1, 1}); // 머리, 꼬리 좌표 초기화
		map[snake.head[0]][snake.head[1]] = 1;
		int t = 1;
		while (true) {
			snake.head[0] += moveX[d]; // 머리 전진
			snake.head[1] += moveY[d];
			if (snake.head[0] <= 0 || snake.head[0] > N || snake.head[1] <= 0 || snake.head[1] > N
					|| map[snake.head[0]][snake.head[1]] == 1) break; // 종료 조건
			
			if (map[snake.head[0]][snake.head[1]] != -1) { // 뱀의 머리가 사과에 닿지 않았을 때는 꼬리가 움직임
				
				if (map[snake.tail[0]][snake.tail[1]] == -4) d2 = (d2 + 1) % 4; // 꼬리 회전 R
				else if(map[snake.tail[0]][snake.tail[1]] == 4) d2 = (d2 - 1 + 4) % 4; // 꼬리 회전 L
				
				map[snake.tail[0]][snake.tail[1]] = 0; // 꼬리 위치 없애줌
				
				snake.tail[0] += moveX[d2]; // 꼬리 전진
				snake.tail[1] += moveY[d2];
			}
			
			map[snake.head[0]][snake.head[1]] = 1;
			
			if (!queue.isEmpty() && queue.peek()[0] == t) {
				map[snake.head[0]][snake.head[1]] = queue.peek()[1];
				if (queue.peek()[1] == -4) d = (d + 1) % 4; // D 일 때 오른쪽으로 회전
				else d = (d - 1 + 4) % 4; // L 일 때 왼쪽으로 회전
				queue.poll();
			}
			t++;
		}
		System.out.println(t);
	}
}
