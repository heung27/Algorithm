import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_16172_나는_친구가_적다_Large {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	public static void main(String[] args) throws IOException {
		String input = br.readLine();
		
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			if (c >= '0' && c <= '9') continue;
			sb.append(c);
		}
		
		char[] str = sb.toString().toCharArray();
		char[] word = br.readLine().toCharArray();
		
		int[] fail = makeFailFunc(str);
		
		System.out.println(KMP(fail, str, word));
	}
	
	static int[] makeFailFunc(char[] input) {
		int[] fail = new int[input.length];
		
		int i = 1, j = 0;
		while (i < input.length) {
			if (input[i] == input[j]) {
				fail[i++] = ++j;
			}
			else {
				if (j == 0) i++;
				else j = fail[j-1];
			}
		}
		return fail;
	}
	
	static int KMP(int[] fail, char[] str1, char[] str2) {
		int i = 0, j = 0;
		while (i < str1.length) {
			if (str1[i] == str2[j]) {
				i++; j++;
				if (j == str2.length) {
					return 1;
				}
			}
			else {
				if (j == 0) i++;
				else j = fail[j-1];
			}
		}
		return 0;
	}
}
