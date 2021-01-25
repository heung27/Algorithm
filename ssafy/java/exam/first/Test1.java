/*
Test1.java : 자판기
 */
//import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("투입금액 : ");
//		int money = sc.nextInt();
//		int price = sc.nextInt();
		int money = 10000;
		int price = 2530;
		int num = money - price;
		System.out.println("투입 금액: "+money+"원");
		System.out.println("상품 금액: "+price+"원");
		System.out.println("거스름돈: "+num+"원");
		System.out.println("--------------------");
		int[] x = {1000, 500, 100, 50, 10};
		int[] result = new int[5];
		for (int i=0; i<5; i++) {
			result[i] = num/x[i];
			num = num%x[i];
		}
		System.out.println("1000원 : "+result[0]+"장");
		System.out.println("500원 : "+result[1]+"개");
		System.out.println("100원 : "+result[2]+"개");
		System.out.println("50원 : "+result[3]+"개");
		System.out.println("10원 : "+result[4]+"개");
	}

}