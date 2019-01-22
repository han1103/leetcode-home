import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ClimbStairs {
	private static Map<Integer, List<List<Integer>>> stairsMap = new HashMap();

	public static void main(String[] args) {
		List<List<Integer>> listOfList = getStairs(4);
		for (List<Integer> list : listOfList) {
			for (Integer i : list)
				System.out.print(i + " ");
			System.out.println();
		}
	}

	private static void addAndCheckDupItemList(List<List<Integer>> retStairs, List<Integer> itemList) {
		for (List<Integer> currItemList : retStairs) {
			boolean equal = true;
			if (currItemList.size() != itemList.size())
				equal = false;
			else
				for (int i = 0; i < currItemList.size(); i++) {
					if (!currItemList.get(i).equals(itemList.get(i))) {
						equal = false;
						break;
					}
				}
			if (equal)
				return;

		}
		retStairs.add(itemList);
	}

	private static List<Integer> cloneList(List<Integer> itemList) {
		List<Integer> cloneItemList = new LinkedList<>();
		for (Integer i : itemList)
			cloneItemList.add(i);
		return cloneItemList;
	}

	private static void addItemList(List<List<Integer>> retStairs, List<Integer> itemList) {
		for (int i = 0; i < itemList.size(); i++) {
			List<Integer> cloneItemList = cloneList(itemList);
			cloneItemList.add(i, 1);
			addAndCheckDupItemList(retStairs, cloneItemList);
		}
		List<Integer> cloneItemList = cloneList(itemList);
		cloneItemList.add(1);
		addAndCheckDupItemList(retStairs, cloneItemList);

		for (int i = 0; i < itemList.size(); i++) {
			cloneItemList = cloneList(itemList);
			if (cloneItemList.get(i) == 1) {
				cloneItemList.set(i, 2);
				addAndCheckDupItemList(retStairs, cloneItemList);
			}
		}
	}

	private static List<List<Integer>> getStairs(int n) {
		if (n == 1) {
			List<List<Integer>> retStairs = new LinkedList<>();
			List<Integer> listOfStairs = new LinkedList<>();
			listOfStairs.add(1);
			retStairs.add(listOfStairs);
			return retStairs;
		} else {
			List<List<Integer>> retStairs;
			if (!stairsMap.containsKey(n)) {
				List<List<Integer>> prevStairs = getStairs(n - 1);
				retStairs = new LinkedList<>();
				for (List<Integer> itemList : prevStairs) {
					addItemList(retStairs, itemList);
				}
				stairsMap.put(n, retStairs);
			} else {
				retStairs = stairsMap.get(n);
			}

			return retStairs;
		}
	}

	public static int climbStairs(int n) {
		return getStairs(n).size();
	}
}
