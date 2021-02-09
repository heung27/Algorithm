import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_도시_3반_안진흥 {
	static int[][] map;
	static boolean[] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		map = new int[N][3]; // 모든 사람의 능력치를 저장할 배열
		check = new boolean[N]; // 가입조건이 통과된 동아리 체크 배열
		int S = Integer.parseInt(str[1]);
		int M = Integer.parseInt(str[2]);
		
		int cnt = 0;
		for (int i=0; i<N; i++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] < M) { // 동아리의 어떤 한 사람의 개인 능력치가 기준 미달되면 break
					sum = 0; // 그 동아리는 탈락
					break;
				}
				sum += map[i][j]; // 동아리 멤버의 능력치 합
			}
			if (sum >= S) { //팀원들의 능력치 합이 높으면 통과
				cnt++; // 통과된 동아리 카운트
				check[i] = true; // 통과된 동아리 체크
			}
		}
		sb.append(cnt).append("\n"); // 통과된 동아리 개수 출력
		for (int i=0; i<N; i++) {
			if (check[i]) { // 통과된 동아리만 true
				for (int j=0; j<3; j++) {
					sb.append(map[i][j]+" "); // 통과된 동아리의 팀원들 능력치 출력
				}
			}
		}
		System.out.println(sb);
	}
}
