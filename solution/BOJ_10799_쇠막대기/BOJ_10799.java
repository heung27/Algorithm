package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0, result = 0;
		String str = br.readLine();
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) == '(') cnt++;
			else {
				cnt--;
				if (str.charAt(i-1) == '(') result += cnt;
				else result++;
			}
		}
		System.out.println(result);
	}
}





ㅇ
