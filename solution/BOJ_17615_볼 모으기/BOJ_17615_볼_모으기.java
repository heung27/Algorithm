import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17615_볼_모으기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		boolean check = false;
		int left1 = 0, left2 = 1;
		char c = str.charAt(0);
		for (int i=1; i<num; i++) {
			if (check) {
				if (c == str.charAt(i)) left1++;
				else left2++;
			}
			else {
				if (c != str.charAt(i)) check = true;
			}
		}
		int left = left1<left2?left1:left2;
		
		check = false;
		int right1 = 0, right2 = 1;
		c = str.charAt(num-1);
		for (int i=num-2; i>=0; i--) {
			if (check) {
				if (c == str.charAt(i)) right1++;
				else right2++;
			}
			else {
				if (c != str.charAt(i)) check = true;
			}
		}
		int right = right1<right2?right1:right2;
		
		System.out.println(left<right?left:right);
	}
}
