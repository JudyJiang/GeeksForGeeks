
import java.util.*;
/*
 * Move to "pay attention list"
 * Notice: maybe suce board questions or this type that needs recursive, think about bfs...
 * BFS and DFS and surprisingly useful in interview questions...
 * 
 * This board question, normally will need a HashMap or LinkedList to serve as a storage staff.
 * (visited or aovid the resursive calls)
 * 
 * 
 */
public class SurroundedRegions {
	private static Queue<Integer> queue = new LinkedList<Integer>(); 
	//change the original "merge" to "bfs", which uses the queue
	
	public static void printBoard(char[][] board){
		int m = board.length, n = board[0].length;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	public static void solve(char[][] board){
		if(board == null || board.length == 0)
			return;
		int m = board.length, n = board[0].length;
		//first sovle the four edges. from left to right, up to bottom
		for(int i = 0; i < m; i++){
			if(board[i][0] == 'O'){
			//	merge(board, i, 0);
				bfs(board, i, 0);
			}
			if(board[i][n - 1] == 'O'){
				//merge(board, i, n - 1);
				bfs(board, i, n - 1);
			}
		}
		
		for(int j = 0; j < n; j++){
			if(board[0][j] == 'O'){
				//merge(board, 0, j);
				bfs(board, 0, j);
			}
			if(board[m - 1][j] == 'O'){
				//merge(board, m - 1, j);
				bfs(board, m - 1, j);
			}
		}
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(board[i][j] == 'O')
					board[i][j] = 'X';
				else if(board[i][j] == '#')
					board[i][j] = 'O';
			}
		}
	}
	
	public static void merge(char[][] board, int i, int j){
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length)
			return;
		if(board[i][j] != 'O')
			return;
		board[i][j] = '#';
		merge(board, i + 1, j);
		merge(board, i - 1, j);
		merge(board, i, j + 1);
		merge(board, i, j - 1);
	}
	
	
	public static void bfs(char[][] board, int i, int j){
		int m = board.length, n = board[0].length;
		fillCell(board, i, j);
		while(!queue.isEmpty()){
			int curr = queue.poll();
			int x = curr / m;
			int y = curr % m;
			fillCell(board, x + 1, y);
			fillCell(board, x - 1, y);
			fillCell(board, x, y + 1);
			fillCell(board, x, y - 1);
		}
	}
	
	public static void fillCell(char[][] board, int i, int j){
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O')
			return;
		//add this cell to queue...
		queue.offer(i * board.length + j);
		board[i][j] = '#';
	}
	
	
	public static void main(String[] args){
		char[][] board1 = {{'X','X','X','X'},
				           {'X','O','O','X'},
				           {'X','X','O','X'},
				           {'X','O','X','X'}};
		solve(board1);
		printBoard(board1);
	}
}