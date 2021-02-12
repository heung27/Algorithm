import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1493_박스_채우기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] cube;
	static int N;
	static long len, width, height;
	static long cnt;
	
	public static void main(String[] args) throws IOException {
		String[] str = br.readLine().split(" ");
		len = Integer.parseInt(str[0]);
		width = Integer.parseInt(str[1]);
		height = Integer.parseInt(str[2]);
		
		N = Integer.parseInt(br.readLine());
		cube = new int[N][2];
		for (int i=0; i<N; i++) {
			str = br.readLine().split(" ");
			cube[i][0] = Integer.parseInt(str[0]);
			cube[i][1] = Integer.parseInt(str[1]);
		}
		
		Arrays.sort(cube, new Comparator<int[]>() { // 큐브가 큰 순서대로 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});
		
		solution();
		System.out.println(cnt);
	}
	
	static void solution() {
		long pre_div = 0;
		for (int i=0; i<N; i++) {
			int size = cube[i][0]; // 들어갈 큐브 부피
			pre_div *= 8; // 전에 들어갔던 큐브 부피 계산
			
			long box_div = (len >> size) * (width >> size) * (height >> size); // 상자 전체 부피에서 큐브가 얼마나 들어가는 지
			box_div -= pre_div; // 전에 들어갔던 큐브 부피를 빼줌
			
			long min = Math.min(cube[i][1], box_div); // 들어갈 수 있는 큐브 개수
			pre_div += min; // 전에 들어갔던 큐브 부피에 지금 들어가는 큐브 부피를 더해 줌 (상자의 여유 공간을 알기 위해)
			cnt += min;
		}
		
		if (pre_div != len * width * height) cnt = -1; // 큐브가 들어간 부피와 전체 상자의 부피가 다르면 -1 출력
	}
}
