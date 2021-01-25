/*
Test2.java : 팀원 평균

[테스트케이스]

6
5 50 50 70 80 100
7 100 95 90 80 70 60 50
3 70 90 80
3 70 90 81
9 100 99 98 97 96 95 94 93 91
4 75 70 83 68

*/
import java.util.Scanner;

public class Test2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int k=0; k<T; k++) {
			int num = sc.nextInt();
			int sum = 0;
			int[] arr = new int[num];
			for (int i=0; i<num; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			int avg = sum/num;
			int up = 0;
			for (int i=0; i<num; i++) {
				if (avg < arr[i]) up++;
			}
			double result = ((double)up/num) * 100;
			System.out.print("#"+(k+1)+" ");
			System.out.printf("%.3f",result);
			System.out.println("%");
		}
		sc.close();
	}
	
}