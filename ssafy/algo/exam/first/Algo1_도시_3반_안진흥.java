import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo1_도시_3반_안진흥 {
	static boolean[] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			map = new boolean[N+1]; // 간식의 위치를 저장할 배열
			int x = Integer.parseInt(str[1]);
			map[x] = true; // 간식의 위치
			int act = Integer.parseInt(str[2]);
			while (act-- > 0) {
				String[] input = br.readLine().split(" ");
				int a = Integer.parseInt(input[0]);
				int b = Integer.parseInt(input[1]);
				boolean temp = map[a]; // a와 b 종이컵의 위치를 바꿔준다.
				map[a] = map[b];
				map[b] = temp;
			}
			int index = 0;
			for (int i=1; i<=N; i++) {
				if (map[i]) { // 모든 종이컵을 확인하면서 ture(간식)이 나오면 그 인덱스를 저장하고 break
					index = i;
					break;
				}
			}
			System.out.println("#"+t+" "+index);
		}
	}
}
