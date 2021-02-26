
public class QuickSort {
	
	public static void quickSort(int[] arr, int start, int end) {
		if(start > end) {
			return;
		}
		int pivot = start;
		int L = start+1;
		int R = end;
		int temp;
		while(L <= R) {
			while(arr[pivot] >= arr[L] && L <  end) {
				L++;
			}
			while(arr[pivot] <= arr[R] && R >  start) {
				R--;
			}
			if(L < R) {
				temp = arr[L];
				arr[L] = arr[R];
				arr[R] = temp;
			}else {
				temp = arr[pivot];
				arr[pivot] = arr[R];
				arr[R] = temp;
			}
		}		
		quickSort(arr, start, R-1);
		quickSort(arr, R + 1, end);
	}
}
