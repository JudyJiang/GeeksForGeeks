package graph;

public class DijkstraShortestPath {
	private static int INF = Integer.MAX_VALUE;
	private static int[][] graph = 
		{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
		 {4, 0, 8, 0, 0, 0, 0, 11, 0},
		 {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
		 {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
		 {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
		 {0, 0, 4, 0, 10, 0, 2, 0, 0}, 
		 {0, 0, 0, 14, 0, 2, 0, 1, 6}, 
		 {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
		 {0, 0, 2, 0, 0, 0, 6, 7, 0}};
	
	public static int findSmallestPath(int[] dist, boolean[] visited){
		int minIndex = -1, min = INF;
		for(int i = 0; i < dist.length; i++){
			if(!visited[i] && dist[i] < min){
				min = dist[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	public static void dijstraShortestPath(int source){
		int V = graph.length;
		int[] dist = new int[V];
		boolean[] visited = new boolean[V];//already updated (spanned node)
		
		for(int i = 0; i < V; i++)
			dist[i] = INF;
		
		dist[source] = 0;
		for(int node = 0; node < V; node++){
			int minIndex = findSmallestPath(dist, visited);
			
			visited[minIndex] = true;
			for(int v = 0; v < V; v++){
				if(!visited[v] && graph[minIndex][v] != INF){
					if(dist[v] > (dist[minIndex] + graph[minIndex][v]))
						dist[v] = dist[minIndex] + graph[minIndex][v];
				}
			}
		}
	}
}
