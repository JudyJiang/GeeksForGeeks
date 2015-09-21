package dynamicprogramming;

public class MaximumPlus {
	public static int getMax(int[][] met){
		int max = 0;
		int m = met.length, n = met[0].length;
		int[][] dp = new int[m][n];
		
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(met[i][j] == 1){
					int left = getLevel(met, dp, i, j - 1, 'l');
					int right = getLevel(met, dp, i, j + 1, 'r');
					int up = getLevel(met, dp, i - 1, j, 'u');
					int down = getLevel(met, dp, i + 1, j, 'd');
					dp[i][j] = Math.min(Math.min(left, right),  Math.min(up, down)) + 1;
				}
			}
		}
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return max;
	}
	
	
	
	public static int getLevel(int[][] met, int[][] dp, int x, int y, char direction){
		if(x < 0 || y < 0 || x >= met.length || y >= met[0].length)
			return 0;
		int level = 0;
		
		if(dp[x][y] != 0)
			return dp[x][y];
		
		switch(direction){
		case 'l':
			while(y >= 0 && met[x][y] == 1){
				level++;
				y--;
			}
			return level;

		case 'r':
			while(y < met[0].length && met[x][y] == 1){
				level++;
				y++;
			}
			return level;
			
		case 'u':
			while(x >= 0 && met[x][y] == 1){
				level++;
				x--;
			}
			return level;
			
		case 'd':
			while(y < met.length && met[x][y] == 1){
				level++;
				y++;
			}
			return level;
		}
		return level; 
	}
	
	public static void main(String[] args){
		int[][] met = {{0, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}};
		getMax(met);
	}
}
