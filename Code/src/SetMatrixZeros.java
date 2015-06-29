import java.util.Random;

/**
 * This one is more successful than I thought it would be
 * @author FengjiaoJiang
 *
 */
public class SetMatrixZeros {
	//This needs additional two matrix to serve as 'index vector'
	public static void setZeros(int[][] matrix){
		if(matrix == null || matrix.length == 0)
			return;
		
		int m = matrix.length, n = matrix[0].length;
		boolean[] row = new boolean[n], column = new boolean[m];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(matrix[i][j] == 0){
					column[i] = true;
					row[j] = true;
				}
			}
		}
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++)
				if(column[i] || row[j])
					matrix[i][j] = 0;
		}
	}
	
	
	public static void setZerosII(int[][] matrix){
		if(matrix == null || matrix.length == 0)
			return ;
		//first record if first row,column has zeros, if so, then use boolean
		//value to mark it.
		boolean rowZero = false, columnZero = false;
		int m = matrix.length, n = matrix[0].length;
		for(int i = 0; i < m; i++){
			if(matrix[i][0] == 0){
				columnZero = true;
				break;
			}
		}
		
		for(int j = 0; j < n; j++){
			if(matrix[0][j] == 0){
				rowZero = true;
				break;
			}
		}
		
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				if(matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				if(matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			}
		}
		
		if(columnZero){
			for(int i = 0; i < m; i++)
				matrix[i][0] = 0;
		}
		if(rowZero){
			for(int j = 0; j < n; j++)
				matrix[0][j] = 0;
		}
	}
	
	
	public static int[] randomArray(int n){
		int[] arr = new int[n];
		Random r = new Random();
		for(int i = 0; i < n; i++)
			arr[i] = r.nextInt(2);
		return arr;
	}
	
	public static void printMatrix(int[][] matrix, int m, int n){
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}
	
	
	public static void main(String[] args){
		int m = 5, n = 5;
		int[][] matrix = new int[m][m];
		for(int i = 0; i < m; i++)
			matrix[i] = randomArray(n);
		
		printMatrix(matrix, m, n);
		setZeros(matrix);
		System.out.println();
		printMatrix(matrix, m, n);
	}
}
