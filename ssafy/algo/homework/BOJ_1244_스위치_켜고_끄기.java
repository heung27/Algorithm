import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.BitSet;

public class BOJ_1244_스위치_켜고_끄기 {
	public static BitSet switchBit;
	public static int size;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		switchBit = new BitSet(size+1);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=size; i++) {
			if (Integer.parseInt(st.nextToken()) != 0) switchBit.set(i);
		}
		int num = Integer.parseInt(br.readLine());
		while (num-- > 0) {
			String[] str = br.readLine().split(" ");
			int gender = Integer.parseInt(str[0]);
			int index = Integer.parseInt(str[1]);
			if (gender == 1) man(index);
			else woman(index);
		}
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=size; i++) {
			sb.append(switchBit.get(i)?1:0);
			if (i%20 == 0) sb.append("\n");
			else sb.append(" ");
		}
		System.out.println(sb);
	}
	
	public static void man(int index) {
		int temp = index;
		while (temp <= size) {
			switchBit.flip(temp);
			temp += index;
		}
	}
	
	public static void woman(int index) {
		int i = 1;
		while (index-i >= 1 && index+i <= size) {
			if (switchBit.get(index-i) ^ switchBit.get(index+i)) break;
			i++;
		}
		switchBit.flip(index-i+1, index+i);
	}
}
