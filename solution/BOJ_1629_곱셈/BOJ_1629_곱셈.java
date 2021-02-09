import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1629_곱셈 {
	static int X, Y, Z;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		X = Integer.parseInt(str[0]);
		Y = Integer.parseInt(str[1]);
		Z = Integer.parseInt(str[2]);
		
		System.out.println(sol(X,Y));
	}
	
	static long sol(int x, int y) {
		if (y == 0) return 1;
		long num = sol(x, y/2) % Z;
		long pow = num * num % Z;
		if (y % 2 == 0) return pow;
		else return (x * pow) % Z;
	}
}
