package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.List;

class Node implements Comparable<Node> {
	public int y;
	public int w;
	public Node(int y, int w) {
		this.y = y;
		this.w = w;
	}
	
	@Override
	public int compareTo(Node node) {
		return this.w - node.w;
	}
}

public class BOJ_1753 {
	public static int[] distance;
	public static List<Node>[] mat;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		mat = new ArrayList[V+1];
		distance = new int[V+1];
		
		int start = Integer.parseInt(br.readLine());
		for (int i=0; i<V+1; i++) {
			mat[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}
		
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			mat[v1].add(new Node(v2, w));
		}
		
		dijkstra(start, V);
		
		for (int i=1; i<V+1; i++) {
			if (distance[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(distance[i]);
		}
	}
	
	public static void dijkstra(int start, int V) {
		distance[start] = 0;
		PriorityQueue<Node> Q = new PriorityQueue<>();
		Q.offer(new Node(start, 0));
		while(!Q.isEmpty()) {
			Node node = Q.poll();
			
			if (distance[node.y] < node.w) continue;
			
			for (int i=0; i<mat[node.y].size(); i++) {
				Node n = mat[node.y].get(i);
				int dis = distance[node.y] + n.w;
				if (distance[n.y] > dis) {
					distance[n.y] = dis;
					Q.offer(new Node(n.y, dis));
				}
			}
		}
		
	}
}
