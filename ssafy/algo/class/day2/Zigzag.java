
public class Zigzag {
	public static int ROW, COL;
	public static int[][] arr;
	
	public static void main(String[] args) {
		
	}
	
	public static void searchByZigzag0() {
        for(int i=0; i<ROW; ++i) {
            if(i%2==0) {
                for(int j=0; j<COL; ++j) {
                    System.out.print(arr[i][j]+"\t");
                }
            }else {
                for(int j=COL-1; j>=0; --j) {
                    System.out.print(arr[i][j]+"\t");
                }
            }
            System.out.println();
        }
    }

	public static void searchByZigzag() {
	    int temp=0;
	    for(int i=0; i<ROW; ++i) {
	        for(int j=0; j<COL; ++j) {
	            temp = j+(COL-1-2*j)*(i%2); // 괄호 빼먹지 말것.
	            System.out.print(arr[i][temp]+"\t");
	        }
	        System.out.println();
	    }
	}
}
