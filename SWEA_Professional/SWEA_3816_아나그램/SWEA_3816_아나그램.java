import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 슬라이딩 윈도우
public class SWEA_3816_아나그램 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] cnt, temp;
	
	static char[] str1, str2;
	static int len1, len2;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			st = new StringTokenizer(br.readLine());
			str1 = st.nextToken().toCharArray();
			str2 = st.nextToken().toCharArray();
			
			len1 = str1.length;
			len2 = str2.length;
			answer = 0;
			
			cnt = new int[26];
			temp = new int[26];
			
			for (int i=0; i<str1.length; i++) {
				cnt[str1[i]-'a']++;
				temp[str2[i]-'a']++;
			}
			
			for (int i=len1; ; i++) {
				boolean check = true;
				
				for (int j=0; j<26; j++) {
					if (cnt[j] != temp[j]) {
						check = false;
						break;
					}
				}
				
				if (check) answer++;
				
				if (i == len2) break;
				
				temp[str2[i-len1]-'a']--;
				temp[str2[i]-'a']++;
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
