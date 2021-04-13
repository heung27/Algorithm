import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_12907_동물원 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] list = new int[41];
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		String[] str = br.readLine().split(" ");
		for (int i=0; i<N; i++) {
			list[Integer.parseInt(str[i])]++;
		}
		
		boolean check = false;
		int cnt = 0, sum = 0;
		
		for (int i=0; i<N; i++) {
			if (list[i] == 1) {
				if (!check) {
					check = true;
					cnt++;
				}
				sum+=1;
			}
			else if(!check && list[i] == 2) {
				cnt++;
				sum+=2;
			}
			else break;
		}
		
		int result = 0;
		if (sum == N) result = (int)Math.pow(2, cnt);
		
		System.out.println(result);
	}
}
