import java.util.Arrays;

public class SortTest {
	
	public static void main(String[] args) {
		int[] list = {69, 10, 2, 2, 16};
		
		System.out.println(Arrays.toString(list));
		
//		CountingSort.countingSort(list);
//		MergeSort.mergeSort(list);
		QuickSort.quickSort(list, 0, list.length-1);
		
		System.out.println(Arrays.toString(list));
	}
}
