import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LamdaTest3 {
	public static void main(String[] args) {

		PriorityQueue<Data> queue = 
				new PriorityQueue<Data>((o1, o2) -> o1.cnt == o2.cnt ? o2.x - o1.x : o1.cnt - o2.cnt);
		
		queue.offer(new Data(3,5,10));
		queue.offer(new Data(30,5,20));
		queue.offer(new Data(31,5,10));
		queue.offer(new Data(40,5,40));
		queue.offer(new Data(22,5,30));
		
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
//		List<Data> list = new ArrayList<Data>();
//		list.add(new Data(3,5,10));
//		list.add(new Data(30,5,20));
//		list.add(new Data(31,5,10));
//		list.add(new Data(40,5,40));
//		list.add(new Data(22,5,30));
		
//		Collections.sort(list, (o1, o2) -> o1.cnt == o2.cnt ? o2.x - o1.x : o1.cnt - o2.cnt);
//		
//		Collections.sort(list, (o1, o2) -> o1.cnt - o2.cnt);
//		
//		Collections.sort(list, new Comparator<Data>() {
//			@Override
//			public int compare(Data o1, Data o2) {
//				return o1.cnt - o2.cnt;
//			}
//		});
	}
}
