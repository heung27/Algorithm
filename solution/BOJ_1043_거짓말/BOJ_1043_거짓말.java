import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1043_거짓말 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static ArrayList<Integer>[] list;
	static int[] group, true_person, root;
	static boolean[] person;
	static int N, M, T;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		group = new int[N+1];
		root = new int[N+1];
		person = new boolean[N+1];
		list = new ArrayList[M];
		
		for (int i=1; i<=N; i++) {
			group[i] = i;
		}
		
		str = br.readLine().split(" ");
		T = Integer.parseInt(str[0]);
		true_person = new int[T];
		for (int i=0; i<T; i++) {
			true_person[i] = Integer.parseInt(str[i+1]);
		}
		
		for (int i=0; i<M; i++) {
			str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			list[i] = new ArrayList<>();
			
			int pre = 0, cur = 0;
			for (int j=1; j<=n; j++, pre = cur) {
				cur = Integer.parseInt(str[j]);
				list[i].add(cur);
				if (j == 1) continue;
				union(pre, cur);
			}
		}
		
		for (int i=1; i<=N; i++) {
			root[i] = find(i);
		}
		
		for (int i=0; i<T; i++) {
			int r = root[true_person[i]];
			for (int j=1; j<=N; j++) {
				if (root[j] == r) {
					person[j] = true;
				}
			}
		}
		
		int cnt = 0;
		for (int i=0; i<M; i++) {
			int size = list[i].size();
			for (int j=0; j<size; j++) {
				if (person[list[i].get(j)]) {
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(M-cnt);
	}
	
	static void union(int p1, int p2) {
		int r1 = find(p1);
		int r2 = find(p2);
		
		if (r1 != r2) {
			if (r1 < r2) group[r2] = r1;
			else group[r1] = r2;
		}
	}
	
	static int find(int x) {
		if (group[x] == x) return x;
		return find(group[x]);
	}
}
