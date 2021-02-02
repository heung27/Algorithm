import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1208_Flatten {
	public static int[] mat;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = 10;
		for (int t=1; t<=test; t++) {
			mat = new int[100];
			int num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<100; i++) {
				mat[i] = Integer.parseInt(st.nextToken());
			}
			while (num-- > 0) {
				Arrays.sort(mat);
				mat[0]++;
				mat[99]--;
			}
			Arrays.sort(mat);
			System.out.println("#"+t+" "+(mat[99]-mat[0]));
		}
	}
}
