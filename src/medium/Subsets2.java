package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
	int numOfSame(int[] nums, int currIndex) {
		int answer = 0;
		for(int i=currIndex-1; i>=0; i--) {
			if(nums[i]==nums[currIndex])
				answer++;
			else
				break;
		}
		
		return answer;
	}
	
	boolean containNumOfTimes(int numOfSame, int num, List<Integer> list) {
		int numOfTimes = 0;
		for(int n : list) {
			if(n==num)
				numOfTimes++;
		}
		
		return numOfSame==numOfTimes;
	}
	List<List<Integer>> subsetsRec(int[] nums, int currIndex) {
		List<List<Integer>> answer = new ArrayList<>();
		if (currIndex == 0) {
			answer.add(new ArrayList<>());
			List<Integer> list = new ArrayList<>();
			list.add(nums[0]);
			answer.add(list);

			return answer;
		}

		List<List<Integer>> prevAnswer = subsetsRec(nums, currIndex - 1);
		answer.addAll(prevAnswer);

		int numOfSame = numOfSame(nums, currIndex);
		if (numOfSame==0) {
			for (List<Integer> listItem : prevAnswer) {
				List<Integer> newList = new ArrayList<>(listItem);
				newList.add(nums[currIndex]);
				answer.add(newList);
			}
		} else {
			for (List<Integer> listItem : prevAnswer) {
				if (containNumOfTimes(numOfSame, nums[currIndex], listItem)) {
					List<Integer> newList = new ArrayList<>(listItem);
					newList.add(nums[currIndex]);
					answer.add(newList);
				}
			}
		}

		return answer;
	}

	public List<List<Integer>> subsetsWithDup2(int[] nums) {
		Arrays.sort(nums);
		return subsetsRec(nums, nums.length - 1);
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backTracking(answer, nums, -1, new ArrayList<>());

		return answer;
	}

	void backTracking(List<List<Integer>> answer, int[] nums, int currIndex, List<Integer> currList) {
		answer.add(new ArrayList<>(currList));
		for (int i = currIndex + 1; i < nums.length; i++) {
			if (i > currIndex + 1 && nums[i] == nums[i - 1])
				continue;
			currList.add(nums[i]);
			backTracking(answer, nums, i, currList);
			currList.remove(currList.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<List<Integer>> answer = new Subsets2().subsetsWithDup2(new int[] { 2,2,2 });

		for (List<Integer> list : answer) {
			for (int num : list)
				System.out.print(num + ",");
			System.out.println();
		}
	}

}
