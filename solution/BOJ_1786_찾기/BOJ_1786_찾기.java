import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1786_찾기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static int[] fail;
	static char[] T, P;
	static int sizeT, sizeP;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		T = br.readLine().toCharArray();
		P = br.readLine().toCharArray();
		sizeT = T.length;
		sizeP = P.length;
		
		fail = new int[sizeP];
		
		makeFunc();
		KMP();
		
		bw.write(answer+"\n"+sb.toString());
		bw.flush();
	}
	
	static void makeFunc() { // 실패함수 만들기
		int i = 1, j = 0;
		while (i < sizeP) {
			if (P[i] == P[j]) {
				fail[i++] = ++j;
			}
			else {
				if (j == 0) i++;
				else j = fail[j-1];
			}
		}
	}
	
	static void KMP() {
		int i = 0, j = 0;
		while (i < sizeT) {
			if (T[i] == P[j]) {
				if (j == sizeP-1) {
					answer++;
					sb.append(i-sizeP+2).append(" ");
					if (j == 0) i++;
					else j = fail[j-1];
				}
				else {
					j++; i++;
				}
			}
			else {
				if (j == 0) i++;
				else j = fail[j-1];
			}
		}
	}
}
