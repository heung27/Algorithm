package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

class Heap {
	
	private ArrayList<Integer> heap;
	
	public Heap() {
		heap = new ArrayList<>();
		heap.add(0);
	}
	
	public void insert(int data) {
		heap.add(data);
		
		int data_index = heap.size() - 1;
		int parent_index = data_index / 2;
		
		while (data_index > 1 && heap.get(parent_index) > heap.get(data_index)) {
			int temp = heap.get(data_index);
			heap.set(data_index, heap.get(parent_index));
			heap.set(parent_index, temp);
			
			data_index = parent_index;
			parent_index = parent_index / 2;
		}
	}
	
	public void delete() {
		if (heap.size()-1 < 1) {
			System.out.println(0);
		}
		else {
			System.out.println(heap.get(1));
			
			heap.set(1,  heap.get(heap.size()-1));
			heap.remove(heap.size()-1);
			
			int parent_index = 1;
			int child_index = parent_index * 2;
			
			while (child_index < heap.size()) {
				int temp = heap.get(child_index);
				int temp_index = child_index;
				
				if (child_index+1 < heap.size()) {
					if (temp > heap.get(child_index+1)) {
						temp = heap.get(child_index+1);
						temp_index = child_index+1;
					}
				}
				if (heap.get(parent_index) < temp) break;
				
				int parent = heap.get(parent_index);
				heap.set(parent_index, temp);
				heap.set(temp_index, parent);
				
				parent_index = temp_index;
				child_index = temp_index * 2;
			}
		}
	}
}

public class BOJ_1927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Heap h = new Heap();
		int n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) h.delete();
			else h.insert(num);
		}
		br.close();
	}
}
