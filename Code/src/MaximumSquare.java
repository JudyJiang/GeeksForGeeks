
public class MaximumSquare {
	/*
	 * key is: the square formed before this point t[i][j] = min(t[i-1][j],
	 * t[i][j-1], t[i-1][j-1]) + 1 this is actually means "by point (i, j),
	 * what's the length of the formed square).
	 */
	public static int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int m = matrix.length, n = matrix[0].length;
		int[][] curr = new int[m][n];
		for (int i = 0; i < m; i++) {
			curr[i][0] = Character.getNumericValue(matrix[i][0]);
		}

		for (int j = 0; j < n; j++) {
			curr[0][j] = Character.getNumericValue(matrix[0][j]);
		}

		int max = 0;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1') {
					curr[i][j] = Math.min(curr[i - 1][j - 1],
							Math.min(curr[i - 1][j], curr[i][j - 1])) + 1;
				//	max = Math.max(max, curr[i][j]); not including the 0 position
				}
			}	
		}
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				max = Math.max(curr[i][j], max);
			}
		}
		return max * max;
	}

	public static void main(String[] args) {
		char[][] matrix = { { '1', '0', '1', '0', '0' },
				{ '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '0', '0' } };
		System.out.println(maximalSquare(matrix));
	}
}
