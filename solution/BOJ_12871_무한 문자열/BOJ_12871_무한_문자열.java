import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_12871_무한_문자열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		StringBuilder s1 = new StringBuilder(str1);
		StringBuilder s2 = new StringBuilder(str2);
		
		int len1 = str1.length();
		int len2 = str2.length();
		
		int size1 = len1, size2 = len2;
		
		while (size1 != size2) {
			if (size1 < size2) {
				s1.append(str1);
				size1 += len1;
			}
			else {
				s2.append(str2);
				size2 += len2;
			}
		}
		
		if (s1.toString().equals(s2.toString())) System.out.println(1);
		else System.out.println(0);
	}
}
