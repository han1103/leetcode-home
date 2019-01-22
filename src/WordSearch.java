public class WordSearch {
	private boolean[][] occupied;
	private String word;
	private char[][] board;

	private boolean match(int r, int c, int index) {
		if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || occupied[r][c]
				|| board[r][c] != word.charAt(index))
			return false;
		if (index == word.length() - 1)
			return true;
		occupied[r][c] = true;
		if(match(r - 1, c, index + 1) || match(r + 1, c, index + 1) || match(r, c - 1, index + 1)
				|| match(r, c + 1, index + 1))
			return true;
		else {
			occupied[r][c] = false;
			return false;
		}
	}

	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || word == null || word.length() == 0)
			return false;
		this.word = word;
		this.board = board;

		occupied = new boolean[board.length][];
		for (int i = 0; i < occupied.length; i++)
			occupied[i] = new boolean[board[i].length];

		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0))
					if (match(i, j, 0))
						return true;
			}

		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new WordSearch().exist(new char[][]{{'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}}, "SEE"));
	}
}
