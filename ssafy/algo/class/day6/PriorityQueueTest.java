
import java.util.PriorityQueue;

public class PriorityQueueTest {
   public static void main(String[] args) {
      
      PriorityQueue<Student> pQueue = new PriorityQueue<Student>();
      pQueue.offer(new Student(4,20));
      pQueue.offer(new Student(3,50));
      pQueue.offer(new Student(1,60));
      
      System.out.println(pQueue.poll());
      System.out.println(pQueue.poll());
      System.out.println(pQueue.poll());
   }
}
