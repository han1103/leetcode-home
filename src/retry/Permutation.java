package retry;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	void backfill(List<List<Integer>> answer, int[] nums, List<Integer> currIndexList, List<Integer> missingIndexList) {
		if(missingIndexList.isEmpty()) {
			List<Integer> currAnswer = new ArrayList<>();
			for(int i : currIndexList)
				currAnswer.add(nums[i]);
			answer.add(currAnswer);
			return;
		}
		
		for(int i : missingIndexList) {
			currIndexList.add(i);
			List<Integer> copyMissingIndexList = new ArrayList<>(missingIndexList);
			copyMissingIndexList.remove(new Integer(i));
			backfill(answer, nums, currIndexList, copyMissingIndexList);
			currIndexList.remove(new Integer(i));			
		}
			
	}

	void backfill1(List<List<Integer>> answer, int[] nums, List<Integer> currIndexList) {
		if(currIndexList.size()==nums.length) {
			List<Integer> currAnswer = new ArrayList<>();
			for(int i : currIndexList)
				currAnswer.add(nums[i]);
			answer.add(currAnswer);
			return;
		}
		
		for(int i=0; i<nums.length; i++) {
			if(currIndexList.contains(i))
				continue;
			currIndexList.add(i);
			backfill1(answer, nums, currIndexList);
			currIndexList.remove(new Integer(i));			
		}
			
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> answer = new ArrayList<>();
		List<Integer> currIndexList = new ArrayList<>();
		List<Integer> missingIndexList = new ArrayList<>();
		for(int i=0; i<nums.length; i++)
			missingIndexList.add(i);
		
		//backfill(answer, nums, currIndexList, missingIndexList);
		backfill1(answer, nums, currIndexList);
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> answer = new Permutation().permute(new int[]{1,2,3});
		
		for (List<Integer> list : answer) {
			for (int num : list)
				System.out.print(num + ",");
			System.out.println();
		}

	}

}
