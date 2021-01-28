package lab.ssafy.corona.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import lab.ssafy.corona.virus.Corona;
import lab.ssafy.corona.virus.Virus;

public class CoronaTest {

	public static void main(String[] args) {
		
//		Corona c1 = new Corona("Corona5", 5, 5);
//		Corona c2 = new Corona("Corona7", 5, 7);
//		Corona c3 = new Corona("Corona3", 5, 3);
//		Corona c4 = new Corona("Corona9", 5, 9);
//		Corona c5 = new Corona("Corona1", 5, 1);
//		Corona c6 = new Corona("Corona3", 5, 4);
//		Corona c7 = new Corona("Corona9", 5, 9);
//		Corona c8 = new Corona("Corona1", 5, 10);
//		
//		PriorityQueue<Corona> pq = new PriorityQueue<>();
//		pq.add(c1);
//		pq.add(c2);
//		pq.add(c3);
//		pq.add(c4);
//		pq.add(c5);
//		pq.add(c6);
//		pq.add(c7);
//		pq.add(c8);
//		
////		Iterator<Corona> itr = pq.iterator(); // iterator로 priority queue를 접근하면 순서대로 나오지 않음.
////		while(itr.hasNext()) System.out.println(itr.next());
//		
//		while(!pq.isEmpty()) {
//			System.out.println(pq.poll());
//		}
		
		Virus fv1 = new Virus("fv1", 5);
		Virus fv2 = new Virus("fv2", 9);
		Virus fv3 = new Virus("fv3", 1);
		Virus fv4 = new Virus("fv4", 7);
		Virus fv5 = new Virus("fv5", 3);
		
		List<Virus> list = new ArrayList<>();
		list.add(fv1);
		list.add(fv2);
		list.add(fv3);
		list.add(fv4);
		list.add(fv5);
		
//		Collections.sort(list, new Comparator<Virus>() {
//			@Override
//			public int compare(Virus o1, Virus o2) {
//				return o1.getLevel() - o2.getLevel();
//			}
//		});
		
		Collections.sort(list, ( o1, o2 ) -> { // 람다식으로 표현. 인터페이스가 단 한 개의 추상메소드만 가졌을 때 사용.

			return o1.getLevel() - o2.getLevel();
			
		});
		
		for(Virus fv : list) System.out.println(fv);
	}
}
