package backtracking;

public class NQueen {
	public static boolean nQueenSol(int N){
		int[][] board = new int[N][N];
		if(nQueenSol(board, 0, N)){
			printBoard(board);
			return true;
		}
		
		else
			return false;
	}
	
	public static boolean nQueenSol(int[][] board, int index, int N){
		if(index == N){
			return true;
		}
		
		for(int i = 0; i < N; i++){
			if(isSafe(board, i, index)){
				board[i][index] = 1;
				if(nQueenSol(board, index + 1, N))
					return true;
				board[i][index] = 0;
			}
		}
		
		return false;
	}
	
	public static boolean isSafe(int[][] board, int row, int col){
		int i, j, N = board.length;
		for(i = 0; i < col; i++)
			if(board[row][i] == 1)
				return false;
		for(i = row, j = col; i >= 0 && j>= 0; i--, j--){
			if(board[i][j] == 1)
				return false;
		}
		
		for(i = row, j = col; j >= 0 && i < N; i++, j--){
			if(board[i][j] == 1)
				return false;
		}
		
		return true;
	}
	
	public static void printBoard(int[][] board){
		
	}
}
