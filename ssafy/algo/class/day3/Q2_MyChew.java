import java.util.LinkedList;
import java.util.Queue;

public class Q2_MyChew {
	public static void main(String[] args) {
		int N = 20;
		int person = 1;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {person,1});
		
		int[] p;
		int availableCnt = 0;
		while (N>0) {
			p = queue.poll();
			availableCnt = (N>=p[1])?p[1]:N;
			N -= availableCnt;
			if (N==0) {
				System.out.println("마지막 마이쮸를 가저간 사람 : "+p[0]+","+availableCnt+"개");
			}else {
				System.out.println(p[0]+"번 사람이 마이쮸를 가져갑니다. 남은 개수"+N+"개");
				p[1]++;
				queue.offer(p);
				queue.offer(new int[] {++person, 1});
			}
		}
	}
}
