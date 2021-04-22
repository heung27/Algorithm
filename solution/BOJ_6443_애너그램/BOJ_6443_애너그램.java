import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_6443_애너그램 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static int[] cnt = new int[26];
	
	static char[] str, sort_str;
	static int N, len;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			str = br.readLine().toCharArray();
			
			len = str.length;
			sort_str = new char[len];
			
			Arrays.fill(cnt, 0);
			
			for (int i=0; i<len; i++) {
				cnt[str[i]-'a']++;
			}
			
			for (int i=1; i<26; i++) {
				cnt[i] += cnt[i-1];
			}
			
			for (int i=len-1; i>=0; i--) {
				sort_str[--cnt[str[i]-'a']] = str[i];
			}
			
			do {
				sb.append(String.valueOf(sort_str)).append("\n");
	        } while(np());
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
    static boolean np() {
    	int i = len-1;
    	while (i > 0 && sort_str[i-1] >= sort_str[i]) --i;
    		
    	if (i == 0) return false;
    	
    	int j = len-1;
    	while (sort_str[i-1] >= sort_str[j]) --j;
    	
    	swap(i-1, j);
    	
    	int k = len-1;
    	while (i < k) {
    		swap(i++, k--);
    	}
    	return true;
    }
    
    static void swap(int i, int j) {
    	char temp = sort_str[i];
    	sort_str[i] = sort_str[j];
    	sort_str[j] = temp;
    }
}
