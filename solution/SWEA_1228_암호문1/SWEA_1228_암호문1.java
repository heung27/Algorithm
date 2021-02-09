import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1228_암호문1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int t=1; t<=10; t++) {
			List<String> list = new LinkedList<>();
			int len = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			while (len-- > 0) {
				list.add(st.nextToken());
			}
			
			int act = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			while (act-- > 0) {
				char c = st.nextToken().charAt(0);
				int x, y;
				switch (c) {
				case 'I':
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					while (y-- > 0) list.add(x++, st.nextToken());
					break;
				}
			}
			sb.append("#"+t);
			for (int i=0; i<10; i++) {
				sb.append(" "+list.get(i));
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
