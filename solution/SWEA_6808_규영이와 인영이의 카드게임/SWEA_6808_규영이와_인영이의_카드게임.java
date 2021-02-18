import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808_규영이와_인영이의_카드게임 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static boolean[] card_check;
	static int[] card, card2;
	static int sum1, sum2;
	static int win, lose;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int test = Integer.parseInt(br.readLine());
		for (int t=1; t<=test; t++) {
			card_check = new boolean[19];
			card = new int[9];
			card2 = new int[9];
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<9; i++) {
				card[i] = Integer.parseInt(st.nextToken());
				card_check[card[i]] = true;
			}
			int cnt = 0;
			for (int i=1; i<19; i++) {
				if (!card_check[i]) {
					card2[cnt] = i;
					cnt++;
				}
			}
			win = 0;
			lose = 0;
			
			do {
				sum1 = 0;
				sum2 = 0;
				for (int k=0; k<9; k++) {
					if (card2[k] < card[k]) {
						sum1 += card2[k] + card[k];
					}
					else {
						sum2 += card2[k] + card[k];
					}
				}
				if (sum1 > sum2) win++;
				else lose++;
			} while (np());
			
			sb.append("#").append(t).append(" ");
			sb.append(win).append(" ").append(lose);
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	 static boolean np() {
	    	int i = 8;
	    	while (i > 0 && card2[i-1] >= card2[i]) --i;
	    		
	    	if (i == 0) return false;
	    	
	    	int j = 8;
	    	while (card2[i-1] >= card2[j]) --j;
	    	
	    	swap(i-1, j);
	    	
	    	int k = 8;
	    	while (i < k) {
	    		swap(i++, k--);
	    	}
	    	return true;
	    }
	    
	    static void swap(int i, int j) {
	    	int temp = card2[i];
	    	card2[i] = card2[j];
	    	card2[j] = temp;
	    }
}
