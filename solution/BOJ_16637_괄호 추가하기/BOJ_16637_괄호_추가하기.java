import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_16637_괄호_추가하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Oper{
		int num1, num2;
		char op;
		
		public Oper(int num1, int num2, char op) {
			this.num1 = num1;
			this.num2 = num2;
			this.op = op;
		}
	}
	
	static Oper[] list;
	static boolean[] check;
	static int N, size;
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		list = new Oper[N/2];
		check = new boolean[N/2];
		
		String str = br.readLine();
		if (N == 1) {
			answer = Integer.parseInt(str);
		}
		else {
			for (int i=2; i<N; i+=2) {
				int num1 = str.charAt(i-2)-48;
				char op = str.charAt(i-1);
				int num2 = str.charAt(i)-48;
				
				list[size++] = new Oper(num1, num2, op);
			}
			Subset(0);
		}
		
		System.out.println(answer);
	}
	
	static void Subset (int i) {
		if (i >= size) {
			int sum = Integer.MIN_VALUE, index = 0;
			for ( ; index<size; index++) {
				if (!check[index]) {
					sum = operator(list[index].num1, list[index].num2, list[index].op);
					index++;
					break;
				}
			}
			for ( ; index<size; index++) {
				if (!check[index]) {
					sum = operator(sum, list[index].num2, list[index].op);
				}
			}
			answer = Math.max(answer, sum);
			return;
		}
		
		int num1 = list[i].num1, num2 = list[i].num2;
		int num = operator(num1, num2, list[i].op);
		
		if (i+1 < size) list[i+1].num1 = num;
		if (i-1 >= 0) list[i-1].num2 = num;
		check[i] = true;
		Subset(i+2);
		
		if (i+1 < size) list[i+1].num1 = num2;
		if (i-1 >= 0) list[i-1].num2 = num1;
		check[i] = false;
		Subset(i+1);
	}
	
//	static void combination(int start) {
//		if (start >= size) {
//			int sum = Integer.MIN_VALUE, index = 0;
//			for ( ; index<size; index++) {
//				if (!check[index]) {
//					sum = operator(list[index].num1, list[index].num2, list[index].op);
//					index++;
//					break;
//				}
//			}
//			for ( ; index<size; index++) {
//				if (!check[index]) {
//					sum = operator(sum, list[index].num2, list[index].op);
//				}
//			}
//			answer = Math.max(answer, sum);
//			return;
//		}
//		int num = 0;
//		for (int i=start; i<size; i++) {
//			int num1 = list[i].num1, num2 = list[i].num2;
//			
//			num = operator(num1, num2, list[i].op);
//			
//			if (i+1 < size) list[i+1].num1 = num;
//			if (i-1 >= 0) list[i-1].num2 = num;
//			check[i] = true;
//			combination(i+2);
//			
//			if (i+1 < size) list[i+1].num1 = num2;
//			if (i-1 >= 0) list[i-1].num2 = num1;
//			check[i] = false;
//			combination(i+2);
//		}
//	}
	
	static int operator(int num1, int num2, char op) {
		int num = 0;
		if (op == '*') num = num1 * num2;
		else if (op == '+') num = num1 + num2;
		else if (op == '-') num = num1 - num2;
		return num;
	}
}
