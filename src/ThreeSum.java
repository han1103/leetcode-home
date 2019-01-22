import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		List<List<Integer>> listOfList = new ThreeSum().threeSumFast(new int[] {0,0,0,0});
		for (List<Integer> list : listOfList) {
			for (Integer i : list)
				System.out.print(i + ",");
			System.out.println();
		}
	}

	private List<List<Integer>> sums(List<Integer> indexes, int[] nums, int numOfNums) {
		List<List<Integer>> list = new LinkedList<>();

		if (indexes.size() + 1 == numOfNums) {
			int target = 0;
			for (int i : indexes)
				target -= nums[i];

			for (int i = 0; i < nums.length && !indexes.contains(i); i++) {
				if (nums[i] == target) {
					List<Integer> oneList = new LinkedList<>();
					oneList.add(nums[i]);
					list.add(oneList);
				}
			}
		} else {
			for (int i = 0; i < nums.length && !indexes.contains(i); i++) {
				List<Integer> indexesClone = new ArrayList<>();
				for (Integer index : indexes)
					indexesClone.add(index);
				indexesClone.add(i);
				List<List<Integer>> prevList = sums(indexesClone, nums, numOfNums);
				if (prevList != null && !prevList.isEmpty())
					for (List<Integer> prev : prevList) {
						prev.add(nums[i]);
						list.add(prev);
					}
			}
		}

		return list;

	}

	private void sort(List<Integer> list) {
		int indexMin = 0;
		for (int i = 1; i < 3; i++)
			if (list.get(i) < list.get(indexMin)) {
				indexMin = i;
			}
		int temp = list.get(0);
		list.set(0, list.get(indexMin));
		list.set(indexMin, temp);

		if (list.get(1) > list.get(2)) {
			temp = list.get(1);
			list.set(1, list.get(2));
			list.set(2, temp);
		}

	}

	private boolean equalSortedList(List<Integer> list1, List<Integer> list2) {
		if (list1.size() != list2.size())
			return false;
		else {
			for (int i = 0; i < list1.size(); i++)
				if (list1.get(i) != list2.get(i))
					return false;
		}
		return true;
	}

	private boolean equals(List<Integer> list1, List<Integer> list2) {
		if (list1.size() != list2.size())
			return false;
		else {
			sort(list1);
			sort(list2);
			for (int i = 0; i < list1.size(); i++)
				if (list1.get(i) != list2.get(i))
					return false;
		}

		return true;
	}

	private List<List<Integer>> twoSum(int i, int[] nums, List<List<Integer>> list) {
		int target = -nums[i];
		i++;
		if (nums[i]>target)
			return list;
		int j = nums.length-1;
		while(i<j) {
			if ( nums[i]+nums[j] > target) {
				j--;
			}
			else if ( nums[i]+nums[j] < target) {
				i++;
			}
			else {
				while(nums[i+1]==nums[i] && i+1<j)
					i++;
				while(nums[j-1]==nums[j] && i<j-1)
					j--;				
				List<Integer> intList = new ArrayList<>();
				intList.add(-target);
				intList.add(nums[i]);
				intList.add(nums[j]);
				list.add(intList);
				i++;
				j--;											
			}
		}
		
		return list;
	}
	
	private List<List<Integer>> threeSumFast(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		if (nums == null || nums.length < 3)
			return list;

		Arrays.sort(nums);

		for(int i=0; i<nums.length-2; i++) {
			while (i>0 && i<nums.length && nums[i-1]==nums[i])
				i++;
			if (i<nums.length-2)
				twoSum(i, nums, list);
		}
			
		return list;
	}
	
	private List<List<Integer>> threeSumItr(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		if (nums == null || nums.length < 3)
			return list;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length && nums[i] <= 0 ; i++) {
			if (i>0 && nums[i]==nums[i-1])
				continue;
			for (int j = i + 1; j < nums.length && nums[i]+nums[j] <= 0 ; j++) {
				if (j>i+1 && nums[j]==nums[j-1])
					continue;				
				for (int k = j + 1; k < nums.length && nums[i] + nums[j] + nums[k] <= 0; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> innerList = new ArrayList<>();
						innerList.add(nums[i]);
						innerList.add(nums[j]);
						innerList.add(nums[k]);
						list.add(innerList);
						break;
					}
				}
			}
		}

		return list;
	}

	public List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length < 3)
			return new ArrayList<>();
		List<List<Integer>> origList = sums(new ArrayList<>(), nums, 3);
		List<List<Integer>> finalList = new ArrayList<>();
		for (int i = 0; i < origList.size(); i++) {
			boolean found = false;
			List<Integer> list1 = origList.get(i);
			for (int j = i + 1; j < origList.size() && !found; j++)
				if (equals(list1, origList.get(j)))
					found = true;

			if (!found)
				finalList.add(list1);
		}

		return finalList;
	}
}
