import java.util.Scanner;

public class NQueenTest {
	static int ans, N;
	static int[] col;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		col = new int[N+1];
		
		setQueen(0);
		System.out.println(ans);
	}
	
	static void setQueen(int rowNo) {
		// 현재 노드가 유망하지 않다면 돌아가기
		if (!isAvailable(rowNo)) {
			return;
		}
		
		if (rowNo == N) {
			ans++;
			return;
		}
		
		// 자식노드의 가지를 파생
		for (int i=1; i<=N; i++) {
			col[rowNo+1] = i;
			setQueen(rowNo+1);
		}
	}

	static boolean isAvailable(int rowNo) {
		for (int i = 1; i < rowNo; i++) {
			// 퀸이 서로 위협적인 위치면 false
			if (col[rowNo] == col[i] || Math.abs(col[rowNo] - col[i]) == rowNo - i) { // 같은 열에 있는지 || 대각선에 위치해 있는지
				return false;
			}
		}
		return true;
	}
}

