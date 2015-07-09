package graph;

import java.util.*;

public class Graph {
	public int V;
	List<List<Integer>> adj = new ArrayList<List<Integer>>();
	
	public Graph(int v){
		this.V = v;
		for(int i = 0; i < V; i++){
			adj.add(i, new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int v, int w){
		this.adj.get(v).add(w);
	}
	
	public void topologicalSort(){
		boolean[] visited = new boolean[V];
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 0; i < V; i++){
			if(!visited[i]){
				topologicalSort(s, visited, i);
			}
		}
		while(!s.isEmpty()){
			System.out.print(s.pop() + " ");
		}
	}
	
	public void topologicalSort(Stack<Integer> s, boolean[] visited, int v){
		visited[v] = true;
		for(int i = 0; i < this.adj.get(v).size(); i++){
			if(!visited[this.adj.get(v).get(i)]){
				topologicalSort(s, visited, this.adj.get(v).get(i));
			}
		}
		s.push(v);
	}
	
	public static void main(String[] args){
		Graph g = new Graph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.topologicalSort();
	}
}
