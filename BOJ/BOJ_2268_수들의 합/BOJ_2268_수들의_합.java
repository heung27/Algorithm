import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2268_수들의_합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static long[] tree;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int temp = 1;
		while (temp < N) {
			temp <<= 1;
		}
		
		tree = new long[temp*2];
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if (a == 1) update(temp+b-1, c);
			else {
				if (b > (int)c) sb.append(get(temp+(int)c-1, temp+b-1)).append("\n");
				else sb.append(get(temp+b-1, temp+(int)c-1)).append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void update(int index, long num) {
		long diff = num - tree[index];
		
		while (index != 0) {
			tree[index] += diff;
			index >>=1;
		}
	}
	
	static long get(int left, int right) {
		long sum = 0;
		
		while (left < right) {
			if ((left & 1) == 1) sum += tree[left++];
			if ((right & 1) == 0) sum += tree[right--];
			
			left >>= 1;
			right >>= 1;
		}
		
		if (left == right) sum += tree[left];
		
		return sum;
	}
}
