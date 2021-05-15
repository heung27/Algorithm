import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_5644_무선_충전 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Tower {
		int x, y;
		int c, p;
		
		public Tower(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}
	
	static int[] movex = {0, -1, 0, 1, 0};
	static int[] movey = {0, 0, 1, 0, -1};
	
	static int[] actA, actB;
	static Tower[] towers;
	static Point posA, posB;
	static int answer;
	
	static int M, A;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=test; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			towers = new Tower[A];
			actA = new int[M+1];
			actB = new int[M+1];
			answer = 0;
			
			posA = new Point(1, 1);
			posB = new Point(10, 10);
			
			actA[0] = actB[0] = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i=1; i<=M; i++) {
				actA[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i=1; i<=M; i++) {
				actB[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken()); // 범위
				int p = Integer.parseInt(st.nextToken()); // 충전량
				
				towers[i] = new Tower(y, x, c, p);
			}
			
			move();
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void move() {
		for (int i=0; i<=M; i++) {
			posA.x += movex[actA[i]];
			posA.y += movey[actA[i]];
			
			posB.x += movex[actB[i]];
			posB.y += movey[actB[i]];
			
			int distA, distB;
			
			int first1 = 0, second1 = 0, first2 = 0, second2 = 0;
			int index1 = -1, index2 = -1;
			
			for (int j=0; j<A; j++) {
				distA = Math.abs(posA.x - towers[j].x) + Math.abs(posA.y - towers[j].y);
				if (distA <= towers[j].c) {
					if (first1 < towers[j].p) {
						second1 = first1;
						first1 = towers[j].p;
						index1 = j;
					}
					else if (second1 < towers[j].p) {
						second1 = towers[j].p;
					}
				}
				
				distB = Math.abs(posB.x - towers[j].x) + Math.abs(posB.y - towers[j].y);
				if (distB <= towers[j].c) {
					if (first2 < towers[j].p) {
						second2 = first2;
						first2 = towers[j].p;
						index2 = j;
					}
					else if (second2 < towers[j].p) {
						second2 = towers[j].p;
					}
				}
			}
			
			if (index1 != index2) {
				answer += first1 + first2;
			}
			else {
				int max = Math.max(second1, second2);
				answer += first1 + max;
			}
		}
	}
}
