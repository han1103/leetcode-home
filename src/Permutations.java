import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permuteRec(int[] nums, int endIndex) {
		List<List<Integer>> retListOfList = new ArrayList<>();
		if (endIndex == 0) {
			List<Integer> list = new ArrayList<>();
			list.add(nums[0]);
			retListOfList.add(list);
		} else {
			List<List<Integer>> preListOfList = permuteRec(nums, endIndex - 1);
			for (List<Integer> listItem : preListOfList) {
				for (int i = 0; i <= listItem.size(); i++) {
					List<Integer> copyListItem = new ArrayList<>();
					copyListItem.addAll(listItem);
					copyListItem.add(i, nums[endIndex]);
					retListOfList.add(copyListItem);
				}
			}
		}

		return retListOfList;
	}

	public List<List<Integer>> permute(int[] nums) {
		if (nums == null || nums.length == 0)
			return new ArrayList<>();
		return permuteRec(nums, nums.length - 1);
	}

	public static void main(String[] args) {
		List<List<Integer>> result = new Permutations().permute(new int[] { 1, 2, 3 });
		for (List<Integer> listItem : result) {
			for (int item : listItem)
				System.out.print(item + ",");
			System.out.println();
		}
	}
}
