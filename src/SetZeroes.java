import java.util.HashSet;
import java.util.Set;

public class SetZeroes {
	public static void main(String[] args) {
		int[][] mat = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		new SetZeroes().setZeroesInMem1(mat);
		System.out.println("OK");
	}

	public void setZeroes(int[][] matrix) {
		if (matrix == null)
			return;
		Set<Integer> zeroRows = new HashSet<>();
		Set<Integer> zeroColumns = new HashSet<>();
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				if (matrix[i][j] == 0) {
					zeroRows.add(i);
					zeroColumns.add(j);
				}

		for (int i : zeroRows)
			for (int j = 0; j < matrix[i].length; j++)
				matrix[i][j] = 0;

/*		for (int i = 0; i < matrix.length; i++)
			if (!zeroRows.contains(i))
				for (int j : zeroColumns)
					matrix[i][j] = 0;*/
		
		for(int j : zeroColumns)
			for(int i=0; i<matrix.length; i++)
				if (!zeroRows.contains(i))
					matrix[i][j] = 0;
	}

	public void setZeroesInMem(int[][] matrix) {
		if (matrix == null)
			return;
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				if (matrix[i][j] == 0) {
					for(int k=0; k < matrix[i].length; k++)
						if (matrix[i][k]!=0)
							matrix[i][k]=Integer.MIN_VALUE;
					for(int k=0; k<matrix.length; k++)
						if (matrix[k][j]!=0)
							matrix[k][j]=Integer.MIN_VALUE;						
				}

		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				if (matrix[i][j] == Integer.MIN_VALUE)
					matrix[i][j] = 0;

	}
	
	public void setZeroesInMem1(int[][] matrix) {
		if (matrix == null)
			return;

		boolean firstColZero = false;
		for(int i=0; i<matrix.length; i++)			
			if (matrix[i][0]==0)
				firstColZero = true;
				
		boolean firstRowZero = false;
		for(int j=0; j<matrix[0].length; j++)
			if (matrix[0][j]==0)
				firstRowZero = true;
		
		for(int i=0; i<matrix.length; i++)
			for(int j=0; j<matrix[0].length; j++) {
				if (matrix[i][j]==0) {
					if ( i!= 0 )
						matrix[i][0]=0;				
					if ( j!=0 )
						matrix[0][j]=0;
				}
			}
		
		for(int i=1; i<matrix.length; i++)		
			if (matrix[i][0]==0)
				for(int j=1; j<matrix[0].length; j++)
					matrix[i][j]=0;

		for(int j=1; j<matrix[0].length; j++)		
			if (matrix[0][j]==0)
				for(int i=1; i<matrix.length; i++)
					matrix[i][j]=0;
		
		if (firstRowZero)
			for(int j=0; j<matrix[0].length; j++)
				matrix[0][j]=0;
			
		if (firstColZero)
			for(int i=0; i<matrix.length; i++)
				matrix[i][0]=0;

	}
}
