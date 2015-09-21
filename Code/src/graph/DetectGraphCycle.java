package graph;

import java.util.*;

public class DetectGraphCycle {
	
	public static class Edge {
		int src, dest;
	}
	
	public static class Graph {
		int V;
		int E;
		Edge[] edges;
		
		public Graph(){
			
		}
		
		public Graph(int v, int e){
			this.V = v;
			this.E = e;
			edges = new Edge[this.E];
		}
	}
	
	public static int find(int[] parent, int i){
		if(parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}
	
	public static void union(int[] parent, int x, int y){
		int xset = find(parent, x);
		int yset = find(parent, y);
		parent[xset] = yset;
	}
	
	public static boolean isCycle(Graph g){
		int size = g.V;
		int[] parent = new int[size];
		Arrays.fill(parent,  -1);
		
		for(int i = 0; i < g.E; i++){
			int x = find(parent, g.edges[i].src);
			int y = find(parent, g.edges[i].dest);
			if(x == y)
				return true;
			union(parent, x, y);
		}
		return false;
	}
	
	public static void main(String[] args){
		Graph g = new Graph(3, 3);
		g.edges[0] = new Edge();
		g.edges[0].src = 0;
		g.edges[0].dest = 1;
		
		g.edges[1] = new Edge();
		g.edges[1].src = 1;
		g.edges[1].dest = 2;
		
		g.edges[2] = new Edge();
		g.edges[2].src = 0;
		g.edges[2].dest = 2;
		
		System.out.println(isCycle(g));
	}
}
