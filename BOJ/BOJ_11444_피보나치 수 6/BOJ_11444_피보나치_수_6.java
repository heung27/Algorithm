import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11444_피보나치_수_6 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int MOD = 1000000;
	
	public static void main(String[] args) throws IOException {
		long n = Long.parseLong(br.readLine());
		
		long[][] mat = new long[][] {{1, 1}, {1, 0}};
		
		long[][] result = pow(mat, n);
		System.out.println(result[0][1]);
	}
	
	static long[][] pow(long[][] mat, long n) {
		if (n == 1) return mat;
		
		long[][] temp = pow(mat, n/2);
		long[][] result = mul(temp, temp);
		
		if (n % 2 == 0) return result;
		else return mul(result, mat);
	}
	
	static long[][] mul(long[][] mat1, long[][] mat2) {
		long[][] temp = new long[2][2];
		
		temp[0][0] = (mat1[0][0] * mat2[0][0] + mat1[0][1] * mat2[1][0]) % MOD;
		temp[0][1] = (mat1[0][0] * mat2[0][1] + mat1[0][1] * mat2[1][1]) % MOD;
		temp[1][0] = (mat1[1][0] * mat2[0][0] + mat1[1][1] * mat2[1][0]) % MOD;
		temp[1][1] = (mat1[1][0] * mat2[0][1] + mat1[1][1] * mat2[1][1]) % MOD;
		
		return temp;
	}
}
