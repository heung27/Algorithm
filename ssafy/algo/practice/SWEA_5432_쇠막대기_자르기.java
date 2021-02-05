import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5432_쇠막대기_자르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t=1; t<=tc; t++) {
			int cnt = 0, result = 0;
			String str = br.readLine();
			for (int i=0; i<str.length(); i++) {
				if (str.charAt(i) == '(') cnt++; // 막대기 중첩 수 증가
				else {
					cnt--; 
					if (str.charAt(i-1) == '(') result += cnt; // 막대기의 중첩 수 계산
					else result++; // 막대기의 끝 부분
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
