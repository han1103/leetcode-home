package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {

	void backfill(List<List<Integer>> answer, int[] nums, List<Integer> currIndexList) {
		if (currIndexList.size() == nums.length) {
			List<Integer> currAnswer = new ArrayList<>();
			for (int i : currIndexList)
				currAnswer.add(nums[i]);
			answer.add(currAnswer);
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (currIndexList.contains(i) || (i > 0 && nums[i - 1] == nums[i] && !currIndexList.contains(i - 1)))
				continue;
			currIndexList.add(i);
			backfill(answer, nums, currIndexList);
			currIndexList.remove(new Integer(i));
		}

	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> answer = new ArrayList<>();
		List<Integer> currIndexList = new ArrayList<>();
		Arrays.sort(nums);
		backfill(answer, nums, currIndexList);

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> answer = new Permutation2().permute(new int[] { 1, 2, 2 });

		for (List<Integer> list : answer) {
			for (int num : list)
				System.out.print(num + ",");
			System.out.println();
		}

	}

}
