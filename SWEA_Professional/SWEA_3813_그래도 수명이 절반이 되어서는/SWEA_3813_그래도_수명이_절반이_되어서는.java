import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_3813_그래도_수명이_절반이_되어서는 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static boolean[] possible;
	
	static int[] block, input;
	static int N, K;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			block = new int[N];
			possible = new boolean[N];
			
			int max = 0, min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				block[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, block[i]);
				min = Math.min(min, block[i]);
			}
			
			input = new int[K];
			
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<K; j++) {
				input[j] = Integer.parseInt(st.nextToken());
			}
			
			answer = binarySearch(min, max);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static int binarySearch(int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (check(mid)) {
				right = mid-1;
			}
			else {
				left = mid+1;
			}
		}
		return left;
	}
	
	static boolean check(int cnt) {
		for (int i=0; i<N; i++) {
			if (block[i] <= cnt) possible[i] = true;
			else possible[i] = false;
		}
		
		int size = 0, index = 0;
		for (int i=0; i<N; i++) {
			if (possible[i]) size++;
			else {
				size = 0;
				continue;
			}
			
			if (input[index] == size) {
				size = 0;
				index++;
				
				if (index == K) return true;
			}
		}
		return false;
	}
}
