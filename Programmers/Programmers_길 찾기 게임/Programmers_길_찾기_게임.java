import java.util.*;

public class Programmers_길_찾기_게임 {
    
	class Solution {
	    
	    class Node {
	    	int num;
	    	Node left, right;
	    	
			public Node(int num) {
				this.num = num;
			}
	    }
	    
	    int[][] answer;
	    int index;
	    
	    public int[][] solution(int[][] nodeinfo) {
	        
	        int[][] temp = new int[nodeinfo.length][3];
	        answer = new int[2][nodeinfo.length];
	        
	        for (int i=0; i<nodeinfo.length; i++) {
	            temp[i][0] = i+1;
	            temp[i][1] = nodeinfo[i][0];
	            temp[i][2] = nodeinfo[i][1];
	        }
	        
	        Arrays.sort(temp, (o1, o2) -> o2[2] - o1[2]);
	        
	        Node root = new Node(temp[0][0]);
	        for (int i=1; i<temp.length; i++) {
	        	insert(root, nodeinfo, temp[i]);
	        }
	        
	        index = 0;
	        pre(root);
	        
	        index = 0;
	        post(root);
	        
	        return answer;
	    }
	    
	    public void insert(Node parent, int[][] nodeinfo, int[] node) {
			while (true) {
				if (nodeinfo[parent.num-1][0] > node[1]) {
					if (parent.left == null) {
						parent.left = new Node(node[0]);
						break;
					}
					else parent = parent.left;
				}
				else {
					if (parent.right == null) {
						parent.right = new Node(node[0]);
						break;
					}
					else parent = parent.right;
				}
			}
		}
	    
	    public void pre(Node tree) {
	    	if (tree != null) {
		        answer[0][index++] = tree.num;
		        pre(tree.left);
		        pre(tree.right);
	    	}
	    }
	    
	    public void post(Node tree) {
	    	if (tree != null) {
		        post(tree.left);
		        post(tree.right);
		        answer[1][index++] = tree.num;
	    	}
	    }
	}
}
