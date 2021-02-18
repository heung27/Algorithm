import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JUNGOL_1828_냉장고 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int ref[][];
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		ref = new int[N][2];
		
		for (int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			ref[i][0] = Integer.parseInt(str[0]);
			ref[i][1] = Integer.parseInt(str[1]);
		}
		
		Arrays.sort(ref, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int diff = o1[1] - o2[1];
				if (diff == 0) return o1[0] - o2[0];
				else return diff;
			}
		});
		
		int cnt = 1, temp = ref[0][1];
		for (int i=1; i<N; i++) {
			if (ref[i][0] > temp) {
				temp = ref[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
