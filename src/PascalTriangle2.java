import java.util.Arrays;
import java.util.List;

public class PascalTriangle2 {
	public List<Integer> getRow(int rowIndex) {
		Integer[] row = new Integer[rowIndex+1];
		Integer[] newRow = new Integer[rowIndex+1];
		newRow[0]=1;
		
		for(int i=1; i<=rowIndex; i++) {
			for(int k=0; k<i; k++)
				row[k] = newRow[k];
			for(int j=0; j<=i; j++)
				if (j==0)
					newRow[j] = row[0];
				else if(j==i)
					newRow[j] = row[j-1];
				else
					newRow[j]=row[j-1]+row[j];				
		}
		
		return Arrays.asList(newRow);
    }
	
	public static void main(String[] args) {
		List<Integer> list = new PascalTriangle2().getRow(4);
		for(int i : list)
			System.out.print(i+"->");
		
		System.out.println();
	}
}
