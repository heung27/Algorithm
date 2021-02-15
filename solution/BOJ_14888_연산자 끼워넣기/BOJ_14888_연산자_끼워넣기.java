/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자_끼워넣기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] op = new int[4];
	static int[] check;
	static int[] num;
	static int N, min, max, aa;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		check = new int[N-1];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		sol(0);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void sol(int cnt) {
		if (cnt == N-1) {
			int sum = num[0];
			for (int k=1; k<N; k++) {
				switch (check[k-1]) {
				case 0:
					sum = sum + num[k];
					break;
				case 1:
					sum = sum - num[k];
					break;
				case 2:
					sum = sum * num[k];
					break;
				case 3:
					if (sum < 0) {
						sum = Math.abs(sum) / num[k];
						sum = -sum;
					}
					else sum = sum / num[k];
					break;
				}
			}
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		
		for (int i=0; i<4; i++) {
			if (op[i] == 0) continue;
			check[cnt] = i;
			op[i]--;
			sol(cnt+1);
			op[i]++;
		}
	}
}

package week4AlgoTest; */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14888_연산자_끼워넣기 {
   
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   
   static StringBuilder sb = new StringBuilder();
   static StringTokenizer st;

   static int N,arr[];
   static long max=Long.MIN_VALUE, min=Long.MAX_VALUE;
   static ArrayList<Integer> c = new ArrayList<Integer>();
   static ArrayList<Integer> permC = new ArrayList<Integer>();
   static boolean v[];
   
   private static void dataInput() throws NumberFormatException, IOException {
      N = Integer.parseInt(br.readLine());
      arr = new int[N];
      v = new boolean[N-1];
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<N; i++){
         arr[i] = Integer.parseInt(st.nextToken());
      }
      st = new StringTokenizer(br.readLine());
      // 1:+   2:-   3:*   4:/
      for(int i=1; i<=4; i++) {
         int cnt = Integer.parseInt(st.nextToken());
         for(int j=0; j<cnt; j++) {
            c.add(i);
         }
      }
   }
   
   private static void calculate() {
      long res = arr[0];
      for(int i=0; i<N-1; i++) {
         if(permC.get(i)==1) {
            res = res+arr[i+1];
         }if(permC.get(i)==2) {
            res = res-arr[i+1];
         }if(permC.get(i)==3) {
            res = res*arr[i+1];
         }if(permC.get(i)==4){
            if(res<0) { // 음수인 경우
               res = Math.abs(res)/arr[i+1];
               res*=-1;
            }else {
               res /= arr[i+1];
            }
         }
      }
      max = Math.max(max, res);
      //System.out.println(permC.toString()+ " " + max);
      min = Math.min(min, res);
      //System.out.println(permC.toString()+ " " + max);
   }
   
   private static void perm(int cnt) {
      if(cnt==N-1) {
//         System.out.println(permC.toString());
         calculate();
         return;
      }else {
         for(int i=0; i<N-1; i++) {
            if(!v[i]) {
               permC.add(c.get(i));
               v[i] = true;
               perm(cnt+1);
               permC.remove(cnt);
//               permC.remove(c.get(i));
               v[i] = false;
            }
         }
      }
      
   }
   
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      dataInput();
      perm(0);
      sb.append(max + "\n");
      sb.append(min);
      bw.write(sb.toString());
      
      bw.flush();
      bw.close();
      br.close();
      
   }
}