import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1708_블록_껍질 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static class Point {
		long x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static Point[] list;
	static Point bottom;
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		list = new Point[N];
		
		bottom = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[i] = new Point(a, b);
			
			if (bottom.y > list[i].y || (bottom.y == list[i].y && bottom.x > list[i].x)) {
				bottom = list[i];
			}
		}
		
		Arrays.sort(list, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				//	아크탄젠트로 정렬하는 방법
				//	double radian1 = Math.atan2(o1.y-bottom.y, o1.x-bottom.x);
				//	double radian2 = Math.atan2(o2.y-bottom.y, o2.x-bottom.x);
				//				
				//	int diff = Double.compare(radian1, radian2);
				//	if (diff == 0) {
				//	return dist(bottom, o1) - dist(bottom, o2);
				//	}
				//	else return diff;
				
				//	ccw로 정렬하는 방법
				int diff = CrossProduct(bottom, o1, o2);
				if (diff > 0) return -1;
				else if (diff < 0) return 1;
				else return dist(bottom, o1) - dist(bottom, o2);
			}
		});
		
		Stack<Point> stack = new Stack<>();
		stack.add(list[0]);
		
		for (int i=1; i<N; i++) {
			while (stack.size() > 1 &&  CrossProduct(stack.get(stack.size()-2), stack.peek(), list[i]) <= 0) {
				stack.pop();
			}
			stack.add(list[i]);
		}
		System.out.println(stack.size());
	}
	
	static int CrossProduct(Point p1, Point p2, Point p3) {
		long CrossProduct = (p1.x*p2.y - p2.x*p1.y) + (p2.x*p3.y - p3.x*p2.y) + (p3.x*p1.y - p1.x*p3.y);
		
		if (CrossProduct < 0) return -1;
		else if (CrossProduct > 0) return 1;
		else return 0;
	}
	
	static int dist(Point p1, Point p2) {
		return (int)(Math.abs(p2.x - p1.x) + Math.abs(p2.y - p1.y));
	}
}
