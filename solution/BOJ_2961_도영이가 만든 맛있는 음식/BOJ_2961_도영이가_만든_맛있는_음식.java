import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가_만든_맛있는_음식 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] cook;
	static int N;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		cook = new int[N][2];
		min = Integer.MAX_VALUE;
		
		for (int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			cook[i][0] = Integer.parseInt(str[0]);
			cook[i][1] = Integer.parseInt(str[1]);
		}
		
		SubSet(1<<N);
		System.out.println(min);
	}
	
	static void SubSet(int caseCount) {
		for (int flag=1; flag<caseCount; flag++) {
			int sum1 = 1, sum2 = 0;
			for (int j=0; j<N; j++) {
				if ((flag & 1<<j) != 0) {
					sum1 *= cook[j][0];
					sum2 += cook[j][1];
				}
			}
			min = Math.min(min, Math.abs(sum1-sum2));
		}
	}
}
