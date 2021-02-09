import java.util.Arrays;

public class A2_TransposedMatrixTest {
	static int[][] arr = {
	         {1,2,3},
	         {4,5,6},
	         {7,8,9}
	     };
	
	public static void main(String[] args) {
	 print(arr);
	 System.out.println("===================");
	 transpose(arr);
	 print(arr);
	 System.out.println("===================");
	 transpose(arr);
	 print(arr);
	}

 	public static void print(int[][] arr) {
		 final int N= arr.length;
		 for(int i=0; i<N; ++i) {
			 System.out.println(Arrays.toString(arr[i]));
		 }
 	}
 
	 public static void transpose(int[][] arr) {
		 final int N= arr.length;
		 for(int i=0; i<N; ++i) {
		     // j가 i보다 커야하므로  j를 i+1부터 시작 : 대각선 기준으로 윗 직각삼각형 영역값 기준으로 swap하면 됨.
		     for(int j=i+1; j<N; ++j) {
		         swap(i, j);
		     }
		 }
	 } 
 
 	public static void transpose0(int[][] arr) {
		 final int N= arr.length;
		 for(int i=0; i<N; ++i) {
		     for(int j=0; j<N; ++j) {
		         if(i<j) {
		        	 swap(i, j);
		         }
		     }
		 }
	 }
 	
 	private static void swap(int i, int j) {
 		int temp = arr[i][j];
 		arr[i][j] = arr[j][i];
 		arr[j][i] = temp;
 	}
}