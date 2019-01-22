import java.util.LinkedList;
import java.util.List;

public class PascalTrangle {
	public static void main(String[] args) {
		List<List<Integer>> listOfList = generate(5);
		for(List<Integer> list : listOfList) { 
			for(Integer i : list) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	
    public static List<List<Integer> > generate(int numRows) {
    	List<List<Integer> > listOfList = new LinkedList<>();
    	
    	List<Integer> preList = new LinkedList<>();
    	for(int i=1; i<=numRows; i++) {
    		List<Integer> currList = new LinkedList<>();
    		currList.add(1);
    		for(int j=2; j<i; j++)
    			currList.add(preList.get(j-2)+preList.get(j-1));
    		if(i>1)
    			currList.add(1);
    		listOfList.add(currList);
    		preList = currList;
    	}
    	return listOfList;
    }
}
