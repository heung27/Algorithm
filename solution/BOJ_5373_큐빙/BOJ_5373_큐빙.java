import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5373_큐빙 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static int[][][] cube = new int[6][3][3];
	static int[] move = new int[3];
	static int N;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			for (int x=0; x<6; x++) {
				for (int y=0; y<3; y++) {
					for (int z=0; z<3; z++) {
						cube[x][y][z] = x;
					}
				}
			}
//			0: 위, 1: 오른쪽, 2: 아래, 3: 왼쪽, 4: 앞, 5: 뒤
			String[] str = br.readLine().split(" ");
			for (int i=0; i<N; i++) {
				char c = str[i].charAt(0);
				char d = str[i].charAt(1);
				switch (c) {
				case 'U':
					if (d == '-') {
						move_i(0, 0); 
						rotateL(0);
					}
					else {
						move_i(2, 0);
						rotateR(0);
					}
					break;
				case 'D':
					if (d == '-') {
						move_i(2, 2);
						rotateR(2);
					}
					else {
						move_i(0, 2);
						rotateL(2);
					}
					break;
				case 'F':
					if (d == '-') {
						move_ij(4, 2, 0);
						rotateL(4);
					}
					else {
						move_ij(5, 2, 0);
						rotateR(4);
					}
					break;
				case 'B':
					if (d == '-') {
						move_ij(5, 0, 2);
						rotateR(5);
					}
					else {
						move_ij(4, 0, 2);
						rotateL(5);
					}
					break;
				case 'L':
					if (d == '-') {
						move_j(3, 0);
						rotateR(3);
					}
					else {
						move_j(1, 0);
						rotateL(3);
					}
					break;
				case 'R':
					if (d == '-') {
						move_j(1, 2);
						rotateL(1);
					}
					else {
						move_j(3, 2);
						rotateR(1);
					}
					break;
				}
			}
			
			for (int i=0; i<3; i++) {
				for (int j=0; j<3; j++) {
					switch (cube[0][i][j]) {
					case 0: sb.append('w'); break;
					case 1: sb.append('b'); break;
					case 2: sb.append('y'); break;
					case 3: sb.append('g'); break;
					case 4: sb.append('r'); break;
					case 5: sb.append('o'); break;
					}
				}
				sb.append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
//	0: 위, 1: 오른쪽, 2: 아래, 3: 왼쪽, 4: 앞, 5: 뒤
//	2, 3, 5 는 반대편
	static int[][] dir = {{4, 3, 5, 1}, {4, 0, 5, 2}, {4, 1, 5, 3}, {4, 2, 5, 0}, {0, 1, 2, 3}, {0, 3, 2, 1}};
	
	static void move_i(int num, int i) {
		for (int j=0; j<3; j++) {
			move[j] = cube[dir[num][0]][i][j];
		}
		
		int k = 0;
		for ( ; k<3; k++) {
			for (int j=0; j<3; j++) {
				cube[dir[num][k]][i][j] = cube[dir[num][k+1]][i][j];
			}
		}
		for (int j=0; j<3; j++) {
			cube[dir[num][k]][i][j] = move[j];
		}
		
		if (num == 0) reverse_1(num, i, 0);
		else reverse_1(num, i, 1);
	}
	
	static void move_j(int num, int j) {
		for (int i=0; i<3; i++) {
			move[i] = cube[dir[num][0]][i][j];
		}
		
		int k = 0;
		for ( ; k<3; k++) {
			for (int i=0; i<3; i++) {
				cube[dir[num][k]][i][j] = cube[dir[num][k+1]][i][j];
			}
		}
		for (int i=0; i<3; i++) {
			cube[dir[num][k]][i][j] = move[i];
		}
		
		if (num == 3) reverse_2(num, j, 0);
		else reverse_2(num, j, 1);
	}
	
	static void move_ij(int num, int x, int y) {
		for (int z=0; z<3; z++) {
			move[z] = cube[dir[num][0]][x][z];
		}
		
		int k = 0;
		for (int z=0; z<3; z++) {
			cube[dir[num][k]][x][z] = cube[dir[num][k+1]][z][y];
		}
		k++;
		for (int z=0; z<3; z++) {
			cube[dir[num][k]][z][y] = cube[dir[num][k+1]][x][z];
		}
		k++;
		for (int z=0; z<3; z++) {
			cube[dir[num][k]][x][z] = cube[dir[num][k+1]][z][y];
		}
		k++;
		for (int z=0; z<3; z++) {
			cube[dir[num][k]][z][y] = move[z];
		}
		
		if (num == 5) reverse_1(num, x, 0);
		else reverse_2(num, y, 1);
	}
	
	static void reverse_1(int num, int i, int k) {
		for ( ; k<4; k+=2) {
			int temp = cube[dir[num][k]][i][0];
			cube[dir[num][k]][i][0] = cube[dir[num][k]][i][2];
			cube[dir[num][k]][i][2] = temp;
		}
	}
	
	static void reverse_2(int num, int j, int k) {
		for ( ; k<4; k+=2) {
			int temp = cube[dir[num][k]][0][j];
			cube[dir[num][k]][0][j] = cube[dir[num][k]][2][j];
			cube[dir[num][k]][2][j] = temp;
		}
	}
	
	static void rotateL(int num) {
		int[][] temp = new int[3][3];
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				temp[2-j][i] = cube[num][i][j];
			}
		}
		cube[num] = temp;
	}
	
	static void rotateR(int num) {
		int[][] temp = new int[3][3];
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				temp[j][2-i] = cube[num][i][j];
			}
		}
		cube[num] = temp;
	}
}
