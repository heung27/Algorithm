import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9935_문자열_폭발 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static char[] str, bomb, result;
	static int strLen, bombLen;
	
	public static void main(String[] args) throws IOException {
		str = br.readLine().toCharArray();
		bomb = br.readLine().toCharArray();
		
		strLen = str.length;
		bombLen = bomb.length;
		
		result = new char[strLen];
		
		int index = 0;
		for (int i=0; i<str.length; i++, index++) {
			result[index] = str[i];
			if (index < bombLen-1) continue;
			
			if (result[index] == bomb[bombLen-1]) {
				boolean check = true;
				for (int j=0; j<bombLen; j++) {
					if (result[index - j] != bomb[bombLen-1 - j]) {
						check = false;
						break;
					}
				}
				if (check) index -= bombLen;
			}
		}
		
		if (index == 0) sb.append("FRULA");
		else {
			for (int i=0; i<index; i++) sb.append(result[i]);
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}
