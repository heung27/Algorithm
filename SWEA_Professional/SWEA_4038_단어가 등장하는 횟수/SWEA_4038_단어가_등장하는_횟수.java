import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_4038_단어가_등장하는_횟수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] fail;
	static char[] s1, s2;
	
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			s1 = br.readLine().toCharArray();
			s2 = br.readLine().toCharArray();
			
//			 makeFail();
			
			
			sb.append("#").append(t).append(" ").append(findString()).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void makeFail() {
		fail = new int[s2.length];
		
		int i = 1, j = 0;
		while (i < s2.length) {
			if (s2[i] == s2[j]) {
				fail[i++] = ++j;
			}
			else {
				if (j == 0) i++;
				else j = fail[j-1];
			}
		}
	}
	
	static int KMP() {
		int answer = 0;
		int i = 0, j = 0;
		
		while (i < s1.length) {
			if (s1[i] == s2[j]) {
				if (j == s2.length-1) {
					answer++;
					if (j == 0) i++;
					else j = fail[j-1];
				}
				else {
					i++; j++;
				}
			}
			else {
				if (j == 0) i++;
				else j = fail[j-1];
			}
		}
		
		return answer;
	}
	
	static int findString() {
		int answer = 0;
		
		long parentHash = 0, patternHash = 0, pow = 1;
		long D = 257;
		
		for (int i=0; i<=s1.length-s2.length; i++) {
			if (i == 0) {
				for (int j=0; j<s2.length; j++) {
					parentHash += s1[s2.length-j-1] * pow;
					patternHash += s2[s2.length-j-1] * pow;
					
					if (j < s2.length - 1) pow *= D;
				}
			}
			else parentHash = D * (parentHash - s1[i-1] * pow) + s1[s2.length-1+i];
			
			if (parentHash == patternHash) answer++;
		}
		
		return answer;
	}
}
