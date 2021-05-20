import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2263_트리의_순회 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] in, post;
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		in = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			in[num] = i;
		}
		
		post = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			post[i] = Integer.parseInt(st.nextToken());
		}
		
		divide(0, N-1, 0, N-1);
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void divide(int pL, int pR, int iL, int iR) {
		if (pL <= pR) {
			int num = post[pR];
			
			sb.append(num).append(" ");
			
			if (iL == iR) return;
			
			int l = in[num];
			
			divide(pL, pL+l-iL-1, iL, l-1);
			divide(pL+l-iL, pR-1, l+1, iR);
		}
	}
}
