import java.util.LinkedList;
import java.util.Queue;

public class BFSTest {
	static String[] datas = {"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
	static boolean[][] map;
	
	public static void main(String[] args) {
		map = new boolean[9+1][9+1];
		
		map[1][2] = true;
		map[1][3] = true;
		map[1][4] = true;
		
		map[2][5] = true;
		map[2][6] = true;
		
		map[4][7] = true;
		map[4][8] = true;
		map[4][9] = true;
		
		bfs(1);
	}
	
	static void bfs(int start) {
//		큐 생성
//		반복하면서 바뀌어야할 값 저장
//		지금은 한 개 Integer, 2개 int[] => class
		Queue<Data> queue = new LinkedList<>();
//		첫번째 무조건 삽입
		queue.offer(new Data(start));
//		큐가 빌 때까지 할 일 진행
		Data cur;
		while (!queue.isEmpty()) {
//			큐 하나 빼서 할 일 진행
			cur = queue.poll();
			System.out.print(datas[cur.num] + " ");
			
//			경우에 따라선 목표 완료하면 중간에 빠져 나오기
//			if (min > cur.num) {
//				break;
//			}
			
			for (int i=1; i<9+1; i++) {
				if (map[cur.num][i]) { // 다음 작업이 필요한 경우
//					다음 작업을 위해 큐에 삽입
					queue.offer(new Data(i));
				}
				else { // 필요 없는 경우
					
				}
			}
		}
//		경우에 따라선 목표 완료하면 중간에 빠져 나오기
	}
	
	static class Data {
		int num;

		public Data(int num) {
			super();
			this.num = num;
		}
	}
}
