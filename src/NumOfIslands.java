import java.util.LinkedList;
import java.util.Queue;

public class NumOfIslands {
	char[][] grid;

	class Point {
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		int i, j;
	}

	boolean isValidPoint(int i, int j, char[][] grid) {
		if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length)
			return true;
		return false;
	}

	void visitAdjIslands(char[][] grid, int i, int j) {

		//Queue<Point> queue = new LinkedList<>();
		//queue.add(new Point(i, j));
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{i, j});
		grid[i][j] = 'X';

		while (!queue.isEmpty()) {
/*			Point point = queue.poll();
			i = point.i;
			j = point.j;
*/
			int[] point = queue.poll();
			i = point[0];
			j = point[1];

			if (isValidPoint(i - 1, j, grid) && grid[i - 1][j] == '1') {
				grid[i - 1][j] = 'X';
				//queue.add(new Point(i - 1, j));
				queue.add(new int[]{i-1, j});
			}
			if (isValidPoint(i + 1, j, grid) && grid[i + 1][j] == '1') {
				grid[i + 1][j] = 'X';
				//queue.add(new Point(i + 1, j));
				queue.add(new int[]{i+1, j});
			}
			if (isValidPoint(i, j - 1, grid) && grid[i][j - 1] == '1') {
				grid[i][j - 1] = 'X';
				//queue.add(new Point(i, j - 1));
				queue.add(new int[]{i, j-1});
			}
			if (isValidPoint(i, j + 1, grid) && grid[i][j + 1] == '1') {
				grid[i][j + 1] = 'X';
				//queue.add(new Point(i, j + 1));
				queue.add(new int[]{i, j+1});
			}

		}

		/*
		 * grid[i][j] = 'X'; System.out.println("i="+i+"j="+j); if
		 * (isValidPoint(i-1, j, grid) && grid[i-1][j]=='1')
		 * visitAdjIslands(grid, i-1, j); if (isValidPoint(i+1, j, grid) &&
		 * grid[i+1][j]=='1') visitAdjIslands(grid, i+1, j); if (isValidPoint(i,
		 * j-1, grid) && grid[i][j-1]=='1') visitAdjIslands(grid, i, j-1); if
		 * (isValidPoint(i, j+1, grid) && grid[i][j+1]=='1')
		 * visitAdjIslands(grid, i, j+1);
		 */
	}

	public int numIslandsStraight(char[][] grid) {
		int num = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++)
				if (grid[i][j] == '1') {
					visitAdjIslands(grid, i, j);
					num++;
				}

		return num;
	}

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		return numIslandsStraight(grid);
	}

	public static void main(String[] args) {
		System.out.println(new NumOfIslands().numIslands(new char[][] { { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '1', '0' }, { '1', '1', '1', '1', '0' }, { '0', '0', '0', '0', '0' } }));
		System.out.println(new NumOfIslands().numIslands(new char[][] { { '1', '1', '0', '0', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } }));

		System.out.println(new NumOfIslands().numIslands(new char[][] {
				{ '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '0', '1', '1' },
				{ '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '0' },
				{ '1', '0', '1', '1', '1', '0', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '1', '0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1' },
				{ '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1' },
				{ '1', '0', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '0' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '0' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
						'1' } }));

	}
}
