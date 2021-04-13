import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_16916_부분_문자열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static char[] str1, str2;
	static int[] fail;
	
	public static void main(String[] args) throws IOException {
		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		
		fail = new int[str2.length];
		
		makeFail();
		if (KMP()) System.out.println(1);
		else System.out.println(0);
	}
	
	static void makeFail() {
		int i=1, j=0;
		while (i < str2.length) {
			if (str2[i] == str2[j]) {
				fail[i++] = ++j;
			}
			else {
				if (j == 0) i++;
				else j = fail[j-1];
			}
		}
	}
	
	static boolean KMP() {
		int i = 0, j = 0;
		while (i < str1.length) {
			if (str1[i] == str2[j]) {
				i++; j++;
				if (j == str2.length) return true;
			}
			else {
				if (j == 0) i++;
				else j = fail[j-1];
			}
		}
		return false;
	}
}
