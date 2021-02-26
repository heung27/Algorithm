
public class MergeSort {
	
	public static void mergeSort(int[] list) {
		mergeSort(list, 0, list.length-1);
	}
	
	private static void mergeSort(int[] list, int start, int end) {
		if (start == end) return;
		
		// 두 집합으로 분할하여 각각 정렬 시킴
		int middle = (start+end)/2;
		mergeSort(list, start, middle); // 왼쪽 집합
		mergeSort(list, middle+1, end); // 오른쪽 집합
		
		// 정렬된 두 집합을 이용하여 병합
		merge(list, start, middle, end);
		
	}
	
	private static void merge(int[] list, int start, int middle, int end) {
		int[] newArr = new int[end-start+1];
		
		int left = start, right = middle+1;
		
		int i = 0; // 결과 배열 인덱스
		do {
			if (list[left] < list[right]) {
				newArr[i++] = list[left++];
			}
			else {
				newArr[i++] = list[right++];
			}
			
		} while(left <= middle && right <= end);
		
		while (left <= middle) {
			newArr[i++] = list[left++];
		}
		
		while (right <= end) {
			newArr[i++] = list[right++];
		}
		
		System.arraycopy(newArr, 0, list, start, newArr.length);
	}
}
