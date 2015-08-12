package backtracking;

public class KnightTour {
	public static boolean solveKT(int N, int[] xMoves, int[] yMoves){
		int[][] tour = new int[N][N];
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				tour[i][j] = -1;
			}
		}
		tour[0][0] = 0;
		int moveCounts = 0;
		return solveKT(0, 0, xMoves, yMoves, tour, 0);
	}
	
	public static boolean solveKT(int x, int y, int[] xMoves, int[] yMoves, int[][] tour, int moveCounts){
		int n = tour.length;
		if(moveCounts == n * n)
			return true;
		
		int nextX, nextY;
		for(int i = 0; i < xMoves.length; i++){
			nextX = x + xMoves[i];
			nextY = y + xMoves[i];
			if(isSafe(nextX, nextY, n) && tour[nextX][nextY] == -1){
				tour[nextX][nextY] = moveCounts;
				if(solveKT(x, y, xMoves, yMoves, tour, moveCounts + 1)){
					return true;
				}
				else{
					tour[nextX][nextY] = -1;
				}
			}
		}
		return false;
	}
	
	public static boolean isSafe(int x, int y, int N){
		return x >= 0 && y >= 0 && x < N && y < N;
	}
}
