package matrix;

public class RotateMatrix {
	public static void rotateMatrix(int[][] matrix){
		int m = matrix.length;
		
		int[][] result = new int[m][m];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < m; j++){
				result[j][m - 1 - i] = matrix[i][j];
			}
		}
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < m; j++){
				matrix[i][j] = result[i][j];
			}
		}
	}
	
	
	public static void inPlaceRotate(int[][] matrix){
		int m = matrix.length;
		for(int i = 0; i < (m/2); i++){
			for(int j = 0; j < (m/2); j++){
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[m-1-j][i];
				matrix[m-1-j][i] = matrix[m-1-j][m-1-j];
				//matrix[m-1-j][m-1-j] = matrix[][];
			}
		}
	}
}
