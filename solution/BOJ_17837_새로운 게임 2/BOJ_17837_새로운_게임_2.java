import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class BOJ_17837_새로운_게임_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Node {
		int x, y;
		int d;
		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	static class Map {
		ArrayList<Integer> arr;
		int color;
		public Map(int color) {
			this.arr = new ArrayList<>();
			this.color = color;
		}
	}
	
	static int[] movex = {0, 0, 0, -1, 1};
	static int[] movey = {0, 1, -1, 0, 0};
	
	
	static Map[][] map;
	static Node[] list;
	static int N, K, time;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		
		map = new Map[N+1][N+1]; // 0: 흰, 1: 빨, 2: 파
		list = new Node[K];
		
		for (int i=1; i<=N; i++) {
			str = br.readLine().split(" ");
			for (int j=1; j<=N; j++) {
				map[i][j] = new Map(Integer.parseInt(str[j-1]));
			}
		}
		
		for (int i=0; i<K; i++) {
			str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			int d = Integer.parseInt(str[2]);
			list[i] = new Node(x, y, d);
			map[x][y].arr.add(i);
		}
		
		while (++time <= 1000 && move()) {}
		
		if (time == 1001) System.out.println(-1);
		else System.out.println(time);
	}
	
	static boolean move() {
		boolean check = false;
		
		for (int i=0; i<K; i++) {
			int x = list[i].x, y = list[i].y;
			int d= list[i].d;
			
			int nx = x + movex[d];
			int ny = y + movey[d];
			
			if (nx < 1 || nx > N || ny < 1 || ny > N || map[nx][ny].color == 2) {
				if (!check) {
					if (d == 1) list[i].d = 2;
					else if (d == 2) list[i].d = 1;
					else if (d == 3) list[i].d = 4;
					else if (d == 4) list[i].d = 3;
					
					check = true;
					i--;
				}
				else check = false;
				continue;
			}
			
			ArrayList<Integer> arr = map[x][y].arr;
			
			if (map[nx][ny].color == 1) {
				for (int j=arr.size()-1; j>=0; j--) {
					int num = arr.get(j);
					arr.remove(j);
					list[num].x = nx;
					list[num].y = ny;
					map[nx][ny].arr.add(num);
					if (num == i) break;
				}
			}
			else {
				for (int j=0; j<arr.size(); j++) {
					if (arr.get(j) == i) {
						while (j < arr.size()) {
							int num = arr.get(j);
							map[nx][ny].arr.add(num);
							arr.remove(j);
							list[num].x = nx;
							list[num].y = ny;
						}
						break;
					}
				}
			}
			if (map[nx][ny].arr.size() >= 4) return false;
			check = false;
		}
		return true;
	}
}
