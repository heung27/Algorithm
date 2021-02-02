import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
//		팩토리얼 구하기
//		4! 4 * 3 * 2 * 1;
		Scanner sc = new Scanner(System.in);
//		재귀하면서 변화되는 값을 매개변수로 사용한다.
//		변화되는 값을 객체의 멤버변수로 사용한다.
		int num = sc.nextInt();
		int res = fact(num);
		System.out.println(res);
//		1! => 1
//		0! => 1
	}
	static int fact(int num) {
//		종료조건
		if (num == 0 || num == 1) {
			return 1; // 상수와 변수
		}
//		유도파트(실행문) && 재귀호출
		return num * fact(num-1);
	}
}
