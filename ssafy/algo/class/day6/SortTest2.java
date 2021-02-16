
import java.util.Arrays;
import java.util.Comparator;

public class SortTest2 {

   public static void main(String[] args) {
      int[][] students = { {1,10},{3,50},{4,10},{1,100}};   //이렇게 되면 comparable을 못씀(원소 스스로랑 비교 불가능..)
      print(students);
      Arrays.sort(students,new Comparator<int[]>() {  //따라서 Comparator사용!

         @Override
         public int compare(int[] o1, int[] o2) {
//            int diff = o1[0] - o2[0];  // 1열 기준 오른차순 정렬.   양수 - 음수 -> 두수의합이 되버리면서 오버플로우 날수도있음.
            int diff = Integer.compare(o1[0], o2[0]);
            return diff != 0 ? diff : o2[1] -o1[1];  //1열이 같을 때 2열이 내림차순으로 되게 정렬.
         }
         
      });
      print(students);
   }

   
   private static void print(int[][] arr) {
      for(int[] is : arr) {
         System.out.print(Arrays.toString(is));
      }
      System.out.println();
   }
}