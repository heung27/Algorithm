import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473_세_용액 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] arr, answer;
	static int N;
	static long min;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		answer = new int[3];
		min = Long.MAX_VALUE;
		
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i=0; i<N; i++) {
			sol(i);
		}
		
		System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
	}
	
	static void sol(int index) {
		int left = index+1, right = N-1;
		
		while (left < right) {
			long sum = (long)arr[index] + arr[left] + arr[right];
			long temp = Math.abs(sum);
			if (min > temp) {
				answer[0] = arr[index];
				answer[1] = arr[left];
				answer[2] = arr[right];
				min = temp;
			}
			
			if (sum < 0) left++;
			else if (sum > 0) right--;
			else break;
		}
	}
}
