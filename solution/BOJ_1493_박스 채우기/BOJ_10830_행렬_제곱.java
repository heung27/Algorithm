import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10830_행렬_제곱 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] mat;
	static int N;
	static long B; // 입력 데이터 범위 주의
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		B = Long.parseLong(str[1]);
		
		mat = new int[N][N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		print(solution(mat, B));
	}
	
	static int[][] solution(int[][] mat, long b) { // 거듭제곱 알고리즘
		if (b == 1) return mat;
		
		int[][] temp = solution(mat, b/2);
		int[][] pow = mul(temp, temp);
		
		if (b%2 == 0) return pow;
		else return mul(pow, mat);
	}
	
	static int[][] mul(int[][] mat1, int[][] mat2) { // 행렬 곱
		int[][] temp = new int[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				for (int k=0; k<N; k++) {
					temp[i][j] += mat1[i][k] * mat2[k][j];
				}
				temp[i][j] %= 1000;
			}
		}
		return temp;
	}
	
	static void print(int[][] mat) {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				sb.append(mat[i][j] % 1000).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
