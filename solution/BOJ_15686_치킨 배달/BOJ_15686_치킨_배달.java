import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686_치킨_배달 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static ArrayList<int[]> list_Chicken = new ArrayList<>(); 
	static ArrayList<int[]> list_House = new ArrayList<>(); 
	static int[] indexs;
	static int N, M, answer;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		indexs = new int[M];
		answer = Integer.MAX_VALUE;
		
		int x;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				x = Integer.parseInt(st.nextToken());
				if (x == 2) list_Chicken.add(new int[] {i,j});
				else if (x == 1) list_House.add(new int[] {i,j});
			}
		}
		
		combination(0, 0);
		System.out.println(answer);
	}
	
	static void combination(int start, int cnt) { // 조합
		if (cnt == M) {
			int[] house, chicken;
			int min, sum = 0;
			for (int i=0; i<list_House.size(); i++) {
				house = list_House.get(i);
				min = Integer.MAX_VALUE;
				for (int j=0; j<M; j++) {
					chicken = list_Chicken.get(indexs[j]);
					min = Math.min(min, Math.abs(house[0]-chicken[0]) + Math.abs(house[1]-chicken[1]));
				}
				sum += min;
			}
			answer = Math.min(answer, sum);
			return;
		}
		for (int i=start; i<list_Chicken.size(); i++) {
			indexs[cnt] = i;
			combination(i+1, cnt+1);
		}
	}
}
