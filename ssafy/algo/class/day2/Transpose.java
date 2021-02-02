
public class Transpose {
	public static int[][] arr;
	
	public static void main(String[] args) {
		
	}
	
	public static void transpose(int[][] arr) {
	    int temp;
	    final int N= arr.length;
	    for(int i=0; i<N; ++i) {
	        // j가 i보다 커야하므로  j를 i+1부터 시작 : 대각선 기준으로 윗 직각삼각형 영역값 기준으로 swap하면 됨.
	        for(int j=i+1; j<N; ++j) {
	            temp = arr[i][j];
	            arr[i][j] = arr[j][i];
	            arr[j][i] = temp;
	        }
	    }
	}
	public static void print(int[][] arr) {
	    final int N= arr.length;
	    for(int i=0; i<N; ++i) {
	        for(int j=0; j<N; ++j) {
	            System.out.print(arr[i][j]+"\t");
	        }
	        System.out.println();
	    }
	}
}
