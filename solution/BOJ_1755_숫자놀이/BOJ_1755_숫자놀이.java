import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BOJ_1755_숫자놀이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	static ArrayList<Integer> list = new ArrayList<>();
	static int[] numbers = {10, 5, 9, 8, 3, 2, 7, 6, 1, 4}; // 각 영어단어에 대한 우선순위를 저장
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		for (int i=N; i<=M; i++) {
			list.add(i); // N ~ M 까지의 숫자를 리스트에 저장
		}
		
		Collections.sort(list, new Comparator<Integer>() { // comparator를 이용하여 정렬
			@Override
			public int compare(Integer o1, Integer o2) {
				char[] str1 = o1.toString().toCharArray(); // 각 숫자를 char[]로 변경
				char[] str2 = o2.toString().toCharArray();
				
				int len = Math.min(str1.length, str2.length); // 둘 중 작은 길이까지만 비교
				for (int i=0; i<len; i++) {
					if (str1[i] != str2[i]) { // 두 자리수가 다르면 우선순위로 비교하여 정렬
						return numbers[str1[i]-'0'] - numbers[str2[i]-'0'];
					}
				}
				return str1.length - str2.length; // 작은 자리수까지 다 같으면 둘 중 짧은 길이의 숫자 먼저 정렬
			}
		});
		
		for (int i=0; i<list.size();) {
			sb.append(list.get(i)).append(" ");
			i++;
			if (i % 10 == 0) sb.append("\n"); // 10개씩 끊어서 출력
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}