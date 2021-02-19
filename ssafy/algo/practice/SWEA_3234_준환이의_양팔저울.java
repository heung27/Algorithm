import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_3234_준환이의_양팔저울 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] num;
	static int N;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			N = Integer.parseInt(br.readLine());
			num = new int[N];
			answer = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			Permutation(0);
			
			sb.append("#"+t+" ");
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void SubSet(int cnt, int right, int left) {
        if(right > left) return;
        
        if(cnt == N) {
            answer++;
            return;
        }
        SubSet(cnt+1, right+num[cnt], left);
        SubSet(cnt+1, right, left+num[cnt]);
    }
    
    static void swap(int i, int j) {
    	int temp = num[i];
    	num[i] = num[j];
    	num[j] = temp;
    }
    
    static void Permutation(int cnt) {
    	if (cnt == N) {
    		SubSet(0, 0, 0);
    		return;
    	}
    	for (int i=cnt; i<N; i++) {
    		swap(cnt, i);
    		Permutation(cnt+1);
    		swap(cnt, i);
    	}
    }
}
