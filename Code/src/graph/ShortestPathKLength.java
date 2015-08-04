package graph;

public class ShortestPathKLength {
	static int INF = Integer.MAX_VALUE;
	static private int[][] graph = {{0, 10, 3, 2}, {INF, 0, INF, 7},
									{INF, INF, 0, 6}, {INF, INF, INF, 0}};
	
	
	/*
	 * Naive approach
	 * worse case, each ledge has to go k-level down
	 * time complexity: O(V^k)
	 */
	public static int shortestKLenPath(int u, int v, int k){
		int[] min = new int[1];
		min[0] = Integer.MAX_VALUE;
		shortestKLenPath(u, v, k, min, 0);
		return min[0];
	}
	
	public static void shortestKLenPath(int u, int v, int k, int[] min, int tmp){
		System.out.println("u: " + u + " v: " + v);
		if(u == v && k == 0){
			System.out.println(tmp);
			if(min[0] > tmp)
				min[0] = tmp;
		}
		
		for(int i = 0; i < graph[0].length; i++){
			 if(graph[u][i] != INF && u != i && u != v){
				 if(k - 1 >= 0){
					 shortestKLenPath(i, v, k - 1, min, tmp + graph[u][i]);
				 }
			 }
		}
	}
	
	/*
	 * Like this algorithm.. super nice.. bad at dp
	 */
	public static int shortestKLenPathII(int u, int v, int k){
		int V = graph.length;
		int[][][] dp = new int[V][V][k];
		for(int e = 0; e <= k; e++){
			for(int i = 0; i < V; i++){
				for(int j = 0; j < V; j++){
					dp[i][j][e] = INF;
					if(e == 0 && i == j)
						dp[i][j][e] = 0;
					
					if(e == 1 && graph[i][j] != INF)
						dp[i][j][e] = graph[i][j];
					
					if(e > 1){
						for(int a = 0; a < V; a++){
							if(graph[i][a] != INF && i != a && j != a && dp[a][j][e - 1] != INF){
								dp[i][j][e] = Math.min(dp[i][j][e], graph[i][a] + dp[a][j][e - 1]);
							}
						}
					}
				}
			}
		}
		return dp[u][v][k];
	}

	
	public static void main(String[] args){
		int res = shortestKLenPath(0, 3, 2);
		System.out.println(res);
	}
}
