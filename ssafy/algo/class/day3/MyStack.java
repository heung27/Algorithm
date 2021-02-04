import java.util.Stack;

public class MyStack {
//	문자 Stack
	static char[] map = new char[100];
	static int top = -1;
	
	public static void main(String[] args) {
//		MyStack stack = new MyStack();
		Stack<Character> stack = new Stack<>();
		
		stack.push('A');
		stack.push('B');
		stack.push('C');
		System.out.println("개수 : "+stack.size());
		if (!stack.isEmpty()) System.out.println(stack.pop());
		System.out.println("개수 : "+stack.size());
		if (!stack.isEmpty()) System.out.println(stack.peek());
		System.out.println("개수 : "+stack.size());
		if (!stack.isEmpty()) System.out.println(stack.pop());
		System.out.println("개수 : "+stack.size());
		if (!stack.isEmpty()) System.out.println(stack.pop());
		if (!stack.isEmpty()) System.out.println(stack.pop());
		if (!stack.isEmpty()) System.out.println(stack.pop());
		
		System.out.println("end");
	}
	
	void push(char data) {
		map[++top] = data;
	}
	
	char pop() {
		if (isEmpty()) return '\u0000';
		else return map[top--];

	}
	
	int size() {
		return top + 1;
	}
	
	boolean isEmpty() {
		return top == -1;
	}
	
	char peek() {
		if (isEmpty()) return '\u0000';
		else return map[top];
	}
}
