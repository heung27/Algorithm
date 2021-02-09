
public class DFSTest {
	static String[] datas = {"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
	static boolean[][] map;
	
	public static void main(String[] args) {
		map = new boolean[9+1][9+1];
		
		map[1][2] = true;
		map[1][3] = true;
		map[1][4] = true;
		
		map[2][5] = true;
		map[2][6] = true;
		
		map[4][7] = true;
		map[4][8] = true;
		map[4][9] = true;
		
		dfs(1);
		System.out.println();
	}
	
	static void dfs(int idx) {
//		종료
//		실행
		System.out.println(datas[idx]);
//		자신 호출
		for (int i=1; i<9+1; i++) {
			if (!map[idx][i]) { // 가지치기
//				재귀호출
				continue;
			}
			dfs(i);
		}
	}
}
