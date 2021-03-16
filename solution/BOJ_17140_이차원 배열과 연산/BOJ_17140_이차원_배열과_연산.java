import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_17140_이차원_배열과_연산 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[][] map = new int[100][100];
	static int[] num = new int[101];
	static int X = 3, Y = 3;
	static int R, C, K;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0])-1;
		C = Integer.parseInt(str[1])-1;
		K = Integer.parseInt(str[2]);
		
		for (int i=0; i<3; i++) {
			str = br.readLine().split(" ");
			for (int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		while (map[R][C] != K && answer <= 100) {
			if (X >= Y) sortR();
			else sortC();
			answer++;
		}
		
		if (answer <= 100) System.out.println(answer);
		else System.out.println(-1);
	}
	
	static Integer[] temp = new Integer[100];
	
	static void  sortR() {
		int max = Y;
		for (int i=0; i<X; i++) {
			int cnt = 0;
			
			for (int j=0; j<Y; j++) {
				if (map[i][j] == 0) continue;
				
				if (num[map[i][j]] == 0) {
					temp[cnt++] = map[i][j];
				}
				num[map[i][j]]++;
				map[i][j] = 0;
			}
			
			if (cnt == 0) break;
			
			Arrays.sort(temp, 0, cnt, (o1, o2) -> {
				int diff = num[o1] - num[o2];
				if (diff == 0) return o1 - o2;
				else return diff;
			});
			
			int j=0;
			for (int z=0; z<cnt; j+=2, z++) {
				map[i][j] = temp[z];
				map[i][j+1] = num[temp[z]];
				num[temp[z]] = 0;
			}
			
			if (max < j) max = j;
		}
		Y = max;
	}
	
	static void  sortC() {
		int max = X;
		for (int j=0; j<Y; j++) {
			int cnt = 0;
			
			for (int i=0; i<X; i++) {
				if (map[i][j] == 0) continue;
				
				if (num[map[i][j]] == 0) {
					temp[cnt++] = map[i][j];
				}
				num[map[i][j]]++;
				map[i][j] = 0;
			}
			
			if (cnt == 0) break;
			
			Arrays.sort(temp, 0, cnt, (o1, o2) -> {
				int diff = num[o1] - num[o2];
				if (diff == 0) return o1 - o2;
				else return diff;
			});
			
			int i=0;
			for (int z=0; z<cnt; i+=2, z++) {
				map[i][j] = temp[z];
				map[i+1][j] = num[temp[z]];
				num[temp[z]] = 0;
			}
			
			if (max < i) max = i;
		}
		X = max;
	}
}
