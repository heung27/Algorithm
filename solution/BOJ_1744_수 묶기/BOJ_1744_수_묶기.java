import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1744_수_묶기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb;
	static StringTokenizer st;
	
	static Integer[] minus, plus;
	static int N, answer;
	static int size1, size2;
	static int cnt_one;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		minus = new Integer[N];
		plus = new Integer[N];
		
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == 1) {
				cnt_one++;
				continue;
			}
			
			else if (num > 0) plus[size1++] = num;
			
			else minus[size2++] = num;
		}
		
		Arrays.sort(plus, 0, size1, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		Arrays.sort(minus, 0, size2);
		
		for (int i=1; i<size1; i+=2) {
			answer += plus[i-1] * plus[i];
		}
		if (size1%2 == 1) answer += plus[size1-1];
		
		for (int i=1; i<size2; i+=2) {
			answer += minus[i-1] * minus[i];
		}
		if (size2%2 == 1) answer += minus[size2-1];
		
		answer += cnt_one;
		
		System.out.println(answer);
	}
}
