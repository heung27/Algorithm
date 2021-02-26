import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Algo31 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] numbers;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			String num = br.readLine();
			numbers = new int[10];
			
			for (int i=0; i<num.length(); i++) {
				int x = num.charAt(i)-'0';
				numbers[x]++;
			}
			
			numbers[6] = (int)Math.ceil((numbers[6] + numbers[9]) / 2);
			
			int max = 0;
			for (int i=0; i<9; i++) {
				if (numbers[i] > max) max = numbers[i];
			}
			sb.append("#"+t+" "+max).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
