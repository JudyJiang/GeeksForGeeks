package graph;

import java.util.Arrays;

public class primMST {
	
	public static int findMinKey(int[] key, boolean[] mstSet){
		int minValue = Integer.MAX_VALUE, minIndex = -1;
		for(int i = 0; i < key.length; i++){
			if(mstSet[i] == false && key[i] < minValue){
				minValue = key[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	
	public static void primMSTUtility(int[][] graph){
		int n = graph.length;
		int[] key = new int[n];
		boolean[] mstSet = new boolean[n];
		int[] parent = new int[n];
		Arrays.fill(mstSet, false);
		
		for(int i = 0; i < n; i++){
			key[i] = Integer.MAX_VALUE;
		}
		key[0] = 0;
		
		for(int count = 0; count < n - 1; count++){
			int u = findMinKey(key, mstSet);
			mstSet[u] = true;//key[0] is the minimum
			
			for(int v = 0; v < n - 1; v++){
				if(graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]){
					key[v] = graph[u][v];
					parent[v] = u;
				}
			}
		}
	}
}
