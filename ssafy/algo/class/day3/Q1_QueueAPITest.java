import java.util.LinkedList;
import java.util.Queue;

public class Q1_QueueAPITest {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		System.out.println(queue.isEmpty()+"//"+queue.size());
		queue.offer("김태희");
		queue.offer("윤여진");
		queue.offer("노효진");
		queue.offer("변성문");
		queue.offer("최우선");
		
		System.out.println(queue.isEmpty()+"//"+queue.size());
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty()+"//"+queue.size());
		
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
		System.out.println(queue.poll());
	}
}
