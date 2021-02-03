import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2564_경비원 {
	public static int[][] store;
	public static int W, H;
	public static int dir, dis; // 동근이의 방향, 거리
	public static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		W = Integer.parseInt(str[0]);
		H = Integer.parseInt(str[1]);
		int num = Integer.parseInt(br.readLine());
		store = new int[num][2];
		answer = 0;
		for (int i=0; i<num; i++) {
			str = br.readLine().split(" ");
			store[i][0] = Integer.parseInt(str[0]);
			store[i][1] = Integer.parseInt(str[1]);
		}
		str = br.readLine().split(" ");
		dir = Integer.parseInt(str[0]);
		dis = Integer.parseInt(str[1]);
		
		for (int i=0; i<num; i++) {
			switch (dir) {
			case 1: sol1(i); break;
			case 2: sol2(i); break;
			case 3: sol3(i); break;
			case 4: sol4(i); break;
			}
		}
		System.out.println(answer);
	}
	
	public static void sol1(int i) {
		int left;
		switch (store[i][0]) {
		case 2:
			left = dis + store[i][1];
			if (left < W) answer += left+H;
			else answer += 2*W-left+H;
			break;
		case 1:
			left = dis - store[i][1];
			if (left < 0) answer += -left;
			else answer += left;
			break;
		case 3:
			answer += dis+store[i][1];
			break;
		case 4:
			answer += W-dis+store[i][1];
		}
	}
	
	public static void sol2(int i) {
		int left;
		switch (store[i][0]) {
		case 1:
			left = dis + store[i][1];
			if (left < W) answer += left+H;
			else answer += 2*W-left+H;
			break;
		case 2:
			left = dis - store[i][1];
			if (left < 0) answer += -left;
			else answer += left;
			break;
		case 3:
			answer += dis+H-store[i][1];
			break;
		case 4:
			answer += W-dis+H-store[i][1];
		}
	}
	
	public static void sol3(int i) {
		int height;
		switch (store[i][0]) {
		case 4:
			height = dis + store[i][1];
			if (height < H) answer += height+W;
			else answer += 2*H-height+W;
			break;
		case 3:
			height = dis - store[i][1];
			if (height < 0) answer += -height;
			else answer += height;
			break;
		case 1:
			answer += dis+store[i][1];
			break;
		case 2:
			answer += H-dis+store[i][1];
		}
	}
	
	public static void sol4(int i) {
		int height;
		switch (store[i][0]) {
		case 3:
			height = dis + store[i][1];
			if (height < H) answer += height+W;
			else answer += 2*H-height+W;
			break;
		case 4:
			height = dis - store[i][1];
			if (height < 0) answer += -height;
			else answer += height;
			break;
		case 1:
			answer += dis+W-store[i][1];
			break;
		case 2:
			answer += H-dis+W-store[i][1];
		}
	}
}
