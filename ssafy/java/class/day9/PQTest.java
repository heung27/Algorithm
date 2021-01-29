package com.ssafy.day9;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQTest {
// 스택, 큐, 데큐, 리스트, 링크드 리스트 => 자료구조 구현
	
	public PQTest() {
		// 큐 (선입선출)
		// 우선순위 큐 내부가 정렬되어 있다. (힙Tree로 정렬)
		
		// 출력 순서(오름차순)대로 빼오고 싶다.
		// 시간복잡도, 삽입 => logN, 출력 => 1
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		pq1.offer(5);
		pq1.offer(3);
		pq1.offer(4);
		pq1.offer(7);
		pq1.offer(6);
		pq1.offer(2);
		System.out.println(String.format("현재 갯수 : %d", pq1.size()));
		System.out.println(pq1.poll());
		System.out.println(String.format("현재 갯수 : %d", pq1.size()));
		
		if (!pq1.isEmpty()) {
			System.out.println(pq1.poll());
		}
		System.out.println();
		
		// 내림차순으로 빼오고 싶다.
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
			
		});
		pq2.offer(5);
		pq2.offer(3);
		pq2.offer(4);
		pq2.offer(7);
		pq2.offer(6);
		pq2.offer(2);
		while (!pq2.isEmpty()) {
			System.out.println(pq2.poll());
		}
	}
	
	public static void main(String[] args) {
		new PQTest();
	}
}
