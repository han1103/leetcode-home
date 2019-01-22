import java.util.HashSet;
import java.util.Set;

public class ValidSudoKu {
	public boolean isValidSudoku(char[][] board) {
		for (int j = 0; j < board.length; j++) {
			Set<Character> set = new HashSet<>();
			for (int i = 0; i < board.length; i++) {
				if (board[i][j] != '.')
					if (set.contains(board[i][j]))
						return false;
					else
						set.add(board[i][j]);
			}
		}

		for (int i = 0; i < board.length; i++) {
			Set<Character> set = new HashSet<>();
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != '.')
					if (set.contains(board[i][j]))
						return false;
					else
						set.add(board[i][j]);
			}
		}

		for (int i = 0; i < board.length - 2; i+=3)
			for (int j = 0; j < board.length - 2; j+=3) {
				Set<Character> set = new HashSet<>();
				for (int i1 = i; i1 <= i + 2; i1++)
					for (int j1 = j; j1 <= j + 2; j1++)
						if (board[i1][j1] != '.')
							if (set.contains(board[i1][j1]))
								return false;
							else

								set.add(board[i1][j1]);
			}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[][] {
			  {'8','3','.','.','7','.','.','.','.'},
			  {'6','.','.','1','9','5','.','.','.'},
			  {'.','9','8','.','.','.','.','6','.'},
			  {'8','.','.','.','6','.','.','.','3'},
			  {'4','.','.','8','.','3','.','.','1'},
			  {'7','.','.','.','2','.','.','.','6'},
			  {'.','6','.','.','.','.','2','8','.'},
			  {'.','.','.','4','1','9','.','.','5'},
			  {'.','.','.','.','8','.','.','7','9'}			
		};
		System.out.println(new ValidSudoKu().isValidSudoku(board));
	}

}
