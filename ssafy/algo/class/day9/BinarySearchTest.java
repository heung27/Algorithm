import java.util.Arrays;

public class BinarySearchTest {
	public static void main(String[] args) {
		int[] arr = {3, 11, 15, 20, 21, 29, 45};
		Arrays.sort(arr);
		System.out.println(binarySearch(arr, 46));
		System.out.println(binarySearch(arr, 44, 0, arr.length-1));
		
		System.out.println(Arrays.binarySearch(arr, 100));
		System.out.println(Arrays.binarySearch(arr, 0, arr.length, 14));
		// Arrays.binarySearch는 값을 찾지 못 하였을 경우, -insertionpoint-1 (-원래 있어야할 자리-1) return
	}
	
	// 반복문
	static int binarySearch(int[] arr, int key) {
		int start = 0, end = arr.length-1;
		
		while (start <= end) {
			int mid = (start + end)/2;
			
			if (arr[mid] == key) return mid;
			else if (arr[mid] < key) {
				start = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		return -1;
	}
	
	// 재귀
	static int binarySearch(int[] arr, int key, int start, int end) {
		if (start <= end) {
			int mid = (start + end)/2;
			
			if (arr[mid] == key) return mid;
			else if (arr[mid] < key) {
				return binarySearch(arr, key, mid+1, end);
			}
			else {
				return binarySearch(arr, key, start, mid-1);
			}
		}
		else return -1;
	}
}
