import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_1062_가르침 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static ArrayList<Character> list = new ArrayList<>();
	static boolean[] check = new boolean[26];
	
	static char[][] word;
	static int N, K, size;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1])-5;
		
		check[0] = check[2] = check[8] = check[13] = check[19] = true;
		word = new char[N][];
		
		for (int i=0; i<N; i++) {
			String temp = br.readLine();
			word[i] = temp.substring(4, temp.length()-4).toCharArray();
			
			for (int j=0; j<word[i].length; j++) {
				if (!check[word[i][j]-'a']) {
					list.add(word[i][j]);
					check[word[i][j]-'a'] = true;
				}
			}
		}
		
		for (Character c : list) check[c-'a'] = false;
	
		size = list.size();
		
		K = Math.min(K, size);
		
		combination(0, 0);
		System.out.println(answer);
	}
	
	static void combination(int cnt, int start) {
		if (cnt == K) {
			int sum = 0;
			for (int i=0; i<N; i++) {
				boolean t = true;
				for (int j=0 ; j<word[i].length; j++) {
					if (!check[word[i][j]-'a']) {
						t = false;
						break;
					}
				}
				if (t) sum++;
			}
			
			answer = Math.max(answer, sum);
			return;
		}
		
		for (int i=start; i<size; i++) {
			check[list.get(i)-'a'] = true;
			combination(cnt+1, i+1);
			check[list.get(i)-'a'] = false;
		}
	}
}
