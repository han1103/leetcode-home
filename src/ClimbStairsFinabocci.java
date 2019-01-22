import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

public class ClimbStairsFinabocci {

	public static void main(String[] args) {
		System.out.println(climbStairs(44));
		/*
		 * List<List<Integer>> listOfList = getStairs(4); for (List<Integer>
		 * list : listOfList) { for (Integer i : list) System.out.print(i + " "
		 * ); System.out.println(); }
		 */ }

	private static List<List<Integer>> getStairs(int n) {
		Map<Integer, List<List<Integer>>> mapStairs = new HashMap<>();

		List<List<Integer>> retStairs = new LinkedList<>();
		List<Integer> listOfStairs = new LinkedList<>();
		listOfStairs.add(1);
		retStairs.add(listOfStairs);
		mapStairs.put(1, retStairs);

		retStairs = new LinkedList<>();
		listOfStairs = new LinkedList<>();
		listOfStairs.add(1);
		listOfStairs.add(1);
		retStairs.add(listOfStairs);
		listOfStairs = new LinkedList<>();
		listOfStairs.add(2);
		retStairs.add(listOfStairs);
		mapStairs.put(2, retStairs);

		for (int i = 3; i <= n; i++) {
			retStairs = new LinkedList<>();
			List<List<Integer>> retStairsNeed2Step = mapStairs.get(i - 2);
			List<List<Integer>> retStairsNeed1Step = mapStairs.get(i - 1);
			for (List<Integer> list : retStairsNeed2Step) {
				list.add(2);
				retStairs.add(list);
			}
			for (List<Integer> list : retStairsNeed1Step) {
				list.add(1);
				retStairs.add(list);
			}
			mapStairs.put(i, retStairs);
		}

		return mapStairs.get(n);
	}

	public static int climbStairs(int n) {
		// return getStairs(n).size();
/*		int[] arr = new int[n];
		arr[0] = 1;
		if (n >= 2) {
			arr[1] = 2;
			for (int i = 3; i <= n; i++)
				arr[i - 1] = arr[i - 3] + arr[i - 2];
		}
		return arr[n - 1];
*/
		if ( n==1 )
			return 1;
		else if (n==2)
			return 2;
		else 
			return climbStairs(n-1)+climbStairs(n-2);
	}

}
