package graph;

import java.util.*;

public class LongestPath {
	static class Graph {
		static class GraphNode {
			int v;
			int weight;

			public GraphNode(int v, int w) {
				this.v = v;
				this.weight = w;
			}
		}
		
		
		int V;
		List<List<GraphNode>> adj;
		
		public Graph(int V){
			this.V = V;
			this.adj = new ArrayList<List<GraphNode>>();
			for(int i = 0; i < V; i++){
				this.adj.add(i, new ArrayList<GraphNode>());
			}
		}
		
		public void addEdge(int v, int w, int weight){
			this.adj.get(v).add(new GraphNode(w, weight));
		}
		
		public void longestPath(int start){
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			boolean[] visited = new boolean[this.V];
			for(int i = 0; i < V; i++){
				map.put(i, Integer.MIN_VALUE);
			}
			map.put(start, 0);
			longestPath(start, 0, map, visited);
		}
		
		public void longestPath(int node, int value, HashMap<Integer, Integer> map, boolean[] visited){
			visited[node] = true;
			
			for(int i = 0; i < this.adj.get(node).size(); i++){
				GraphNode gNode = this.adj.get(node).get(i);
				if(map.get(gNode.v) < value + gNode.weight)
					map.put(gNode.v, value + gNode.weight);
				if(!visited[gNode.v]){
					longestPath(gNode.v, value + gNode.weight, map, visited);
				}
			}
		}
	}
}
