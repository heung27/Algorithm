import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2527_직사각형 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] pos1 = new int[4];
	static int[] pos2 = new int[4];
	
	public static void main(String[] args) throws IOException {
		for (int i=0; i<4; i++) {
			String[] str = br.readLine().split(" ");
			
			for (int j=0; j<4; j++) {
				pos1[j] = Integer.parseInt(str[j]);
			}
			for (int j=0; j<4; j++) {
				pos2[j] = Integer.parseInt(str[4+j]);
			}
			
			if ((pos1[0] == pos2[2] || pos1[2] == pos2[0]) && (pos1[1] == pos2[3] || pos1[3] == pos2[1])) {
				sb.append("c");
			}
			else if (pos1[0] == pos2[2] || pos1[2] == pos2[0] || pos1[1] == pos2[3] || pos1[3] == pos2[1]) {
				sb.append("b");
			}
			else if ((pos1[0] > pos2[0] && pos1[0] > pos2[2]) || (pos1[2] < pos2[0] && pos1[2] < pos2[2])
					|| (pos1[1] > pos2[1] && pos1[1] > pos2[3]) || (pos1[3] < pos2[1] && pos1[3] < pos2[3])) {
				sb.append("d");
			}
			else sb.append("a");
			
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
