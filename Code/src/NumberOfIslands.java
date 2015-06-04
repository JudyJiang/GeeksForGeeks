import java.util.*;

/**
 * 11110
 * 11010
 * 11000
 * 00000  1
 * 
 * 
 * 11000
 * 11000
 * 00100
 * 00011  3 
 * @author FengjiaoJiang
 * Good Job, well done.
 * But this problem is very similar to Surrounded areas
 *
 */
public class NumberOfIslands {
	public static int numIslands(char[][] grid){
		if(grid == null || grid.length == 0 || grid.length == 0)
			return 0;
		int m = grid.length, n = grid[0].length, nums = 0;
		LinkedList<Integer> list = new LinkedList<Integer>();
		HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				int pos = i * n + j;
				if(grid[i][j] == '1' && !visited.containsKey(pos)){
					connection(grid, visited, i, j);
					nums++;
				}
			}
		}
		return nums;
	}
	
	public static void connection(char[][] grid, HashMap<Integer, Boolean> visited, int i, int j){
		int m = grid.length, n = grid[0].length;
		int pos = i * n + j;
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(pos);
		while(!list.isEmpty()){
			int top = list.removeFirst();
			if(visited.containsKey(top)){
				continue;
			}
			visited.put(top, true);
			int x = top / n;
			int y = top % n;
			
			
			if(x-1>=0 && grid[x-1][y] == '1' && !visited.containsKey((x-1)*n + y)){
				list.add((x-1)*n+y);
			}
			
			
			if(x+1 <= m - 1 && grid[x+1][y] == '1' && !visited.containsKey((x+1)*n + y)){
				list.add((x+1)*n+y);
			}
			
			if(y-1>=0 && grid[x][y-1] == '1' && !visited.containsKey(x*n+y-1)){
				list.add(x*n+y-1);
			}
			

			if(y+1 <= n-1 && grid[x][y+1] == '1' && !visited.containsKey(x*n+y+1)){
				list.add(x*n+y+1);
			}
		}
	}
	
	public static void main(String[] args){
		char[][] grid = {{'1','1','1','1','0'},
				         {'1','1','0','1','0'},
				         {'1','1','0','0','0'},
				         {'0','0','0','0','0'}};
		
		char[][] gridI = {{'1','1','0','0','0'},
						  {'1','1','0','0','0'},
						  {'0','0','1','0','0'},
						  {'0','0','0','1','1'}};
		int res = numIslands(grid);
		System.out.println(res);
	}
}
