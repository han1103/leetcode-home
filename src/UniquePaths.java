import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
	private class PositionPair {
		public PositionPair(int column, int row) {
			super();
			this.column = column;
			this.row = row;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + column;
			result = prime * result + row;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PositionPair other = (PositionPair) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if ( (column == other.column || column == other.row) && (row == other.row || row == other.column) )
				return true;
			else
				return false;

		}
		int column;
		int row;
		private UniquePaths getOuterType() {
			return UniquePaths.this;
		}
		
	}
	
	private Map<PositionPair, Integer> uniqPaths = new HashMap<>();
	
	public int uniquePaths(int m, int n) {
		if (m==1 || n==1) {
			return 1;
		}
		if (uniqPaths.containsKey(new PositionPair(m, n)))
			return uniqPaths.get(new PositionPair(m, n));
			
		int numUniqPaths = uniquePaths(m-1, n) + uniquePaths(m, n-1);
		uniqPaths.put(new PositionPair(m, n), numUniqPaths);
		return numUniqPaths;				
	}
	
	public static void main(String[] args) {
		System.out.println(new UniquePaths().uniquePaths(7, 3));
	}
}
