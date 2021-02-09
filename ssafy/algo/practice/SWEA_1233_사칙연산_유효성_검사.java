import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1233_사칙연산_유효성_검사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t=1; t<=10; t++) {
			sb.append("#"+t+" ");
			int n = Integer.parseInt(br.readLine());
			boolean check = false;
			while (n-- > 0) {
				if (check) br.readLine();
				else {
					String[] str = br.readLine().split(" ");
					int node = str[1].charAt(0)-'0';
					if (node >= 1 && node <= 9) {
						if (str.length > 2) {
							sb.append(0);
							check = true;
						}
					}
					if (n == 0) sb.append(1);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
