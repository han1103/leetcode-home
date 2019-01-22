
public class MaxSquare {

	int maxSquare(int i, int j, int numOfRows, int numOfCols, char[][] matrix) {
		int ii = i + 1;
		int jj = j + 1;
		while (ii < numOfRows && jj < numOfCols) {
			for (int c = j; c <= jj; c++)
				if (matrix[ii][c] != '1') {
					return (jj - j) * (jj - j);
				}
			for (int r = i; r <= ii; r++)
				if (matrix[r][jj] != '1') {
					return (jj - j) * (jj - j);
				}
			ii++;
			jj++;
		}
		return (ii - i) * (ii - i);
	}

	public int maximalSquare(char[][] matrix) {
		int maxSoFar = 0;

		if (matrix != null && matrix.length != 0) {
			int numOfRows = matrix.length;
			int numOfCols = matrix[0].length;

			for (int i = 0; i < numOfRows; i++) {
				if ((numOfRows - i) * (numOfRows - i) <= maxSoFar)
					return maxSoFar;
				for (int j = 0; j < numOfCols; j++) {
					if ((numOfCols - j) * (numOfCols - j) <= maxSoFar)
						break;
					if (matrix[i][j] == '1') {
						maxSoFar = Math.max(maxSoFar, maxSquare(i, j, numOfRows, numOfCols, matrix));
					}
				}
			}
		}

		return maxSoFar;
	}

	public int maximalSquareFast(char[][] matrix) {
		int maxSoFar = 0;

		if (matrix != null && matrix.length != 0) {
			int numOfRows = matrix.length;
			int numOfCols = matrix[0].length;

			int[][] dp = new int[numOfRows][numOfCols];

			for (int i = 0; i < numOfRows; i++) {
				dp[i][0] = (matrix[i][0] == '1' ? 1 : 0);
				maxSoFar = Math.max(maxSoFar, dp[i][0]);
			}
			for (int j = 0; j < numOfCols; j++) {
				dp[0][j] = (matrix[0][j] == '1' ? 1 : 0);
				maxSoFar = Math.max(maxSoFar, dp[0][j]);
			}

			for (int d = 1; d < Math.min(numOfCols, numOfRows); d++) {
				for (int i = 1; i < d; i++)
					if (matrix[i][d] == '1') {
						dp[i][d] = Math.min(Math.min(dp[i - 1][d], dp[i][d - 1]), dp[i - 1][d - 1]) + 1;
						maxSoFar = Math.max(maxSoFar, dp[i][d]);
					}
					
				for (int j = 1; j < d; j++)
					if (matrix[d][j] == '1') {
						dp[d][j] = Math.min(Math.min(dp[d-1][j], dp[d][j-1]), dp[d-1][j-1]) + 1;
						maxSoFar = Math.max(maxSoFar, dp[d][j]);
					}
				
				if (matrix[d][d] == '1') {
					dp[d][d] = Math.min(Math.min(dp[d - 1][d], dp[d][d - 1]), dp[d - 1][d - 1]) + 1;
					maxSoFar = Math.max(maxSoFar, dp[d][d]);
				}
			}

			if (numOfRows > numOfCols) {
				for (int i = numOfCols; i < numOfRows; i++)
					for (int j = 1; j < numOfCols; j++) {
						if (matrix[i][j] == '1') {
							dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
							maxSoFar = Math.max(maxSoFar, dp[i][j]);
						}
					}
			} else if (numOfRows < numOfCols) {
				for (int j = numOfRows; j < numOfCols; j++)
					for (int i = 1; i < numOfRows; i++) {
						if (matrix[i][j] == '1') {
							dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
							maxSoFar = Math.max(maxSoFar, dp[i][j]);
						}
					}
			}
		}

		return maxSoFar * maxSoFar;

	}

	public int maximalSquare1(char[][] matrix) {
		int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
		int[][] dp = new int[rows + 1][cols + 1];
		int maxsqlen = 0;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
					maxsqlen = Math.max(maxsqlen, dp[i][j]);
				}
			}
		}
		return maxsqlen * maxsqlen;
	}

	public int maximalSquareFaster(char[][] matrix) {
		int maxSoFar = 0;

		if (matrix != null && matrix.length != 0) {
			int numOfRows = matrix.length;
			int numOfCols = matrix[0].length;

			int[][] dp = new int[numOfRows][numOfCols];

			for (int i = 0; i < numOfRows; i++) {
				dp[i][0] = (matrix[i][0] == '1' ? 1 : 0);
				maxSoFar = Math.max(maxSoFar, dp[i][0]);
			}
			for (int j = 0; j < numOfCols; j++) {
				dp[0][j] = (matrix[0][j] == '1' ? 1 : 0);
				maxSoFar = Math.max(maxSoFar, dp[0][j]);
			}

			for (int i = 1; i < numOfRows; i++) {
				for (int j = 1; j < numOfCols; j++)
					if (matrix[i][j] == '1') {
						dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
						maxSoFar = Math.max(maxSoFar, dp[i][j]);
					}
			}

		}

		return maxSoFar * maxSoFar;

	}

	public static void main(String[] args) {

		System.out.println(new MaxSquare().maximalSquareFast(new char[][] {
				 {'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}
				//{ '0', '1' } 
				}));
		 System.out.println(new MaxSquare().maximalSquareFast(new char[][] { {
		 '1', '1' }, { '1', '0' } }));

		
		  System.out.println(new MaxSquare().maximalSquareFast(new char[][] { 
			  {'1','0', '1', '0', '0'}, 
			  {'1', '0', '1', '1', '1'}, 
			  {'1', '1', '1', '1','1'}, 
			  {'1', '0', '0', '1', '0'} }));
		  }
}
