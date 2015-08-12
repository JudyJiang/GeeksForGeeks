package backtracking;

/**
 * It's not hard, but requires a little thinking on the "isSafe" part.
 * http://www.geeksforgeeks.org/backttracking-set-5-m-coloring-problem/
 * @author FengjiaoJiang
 *
 */
public class MColors_Solvable {
	public static boolean mColors(boolean[][] graph, int m){
		int n = graph.length;
		int[] colors = new int[n];
		//int painted = 0;
		boolean res = mColors(graph, colors, m, 0);
		//return color allocation colors
		return res;
	}
	
	public static boolean mColors(boolean[][] graph, int[] colors, int m, int node){
		int n = graph.length;
		if(node == n)
			return true;
		
		for(int i = 1; i <= m; i++){
			if(isSafe(graph, node, colors, i)){
				colors[node] = i;
				if(mColors(graph, colors, m, node + 1))
					return true;
				colors[node] = 0;
			}
		}
		return false;
	}
	
	public static boolean isSafe(boolean[][] graph, int node, int[] colors, int color){
		for(int i = 0; i < graph.length; i++)
			if(graph[i][node] && colors[i] == color)
				return false;
		return true;
	}
}
