package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	void backtracking(List<List<Integer>> answer, int[] candidates, int target, int currIndex, List<Integer> currList, int currSum) {
		if(!currList.isEmpty() && currSum==target) {
			answer.add(new ArrayList(currList));
			return;
		}
		if(currSum>target || currList.size()==candidates.length)
			return;
		boolean[] used = new boolean[candidates.length];
		for(int i=currIndex+1; i<candidates.length; i++) {
			if(i>currIndex+1 && candidates[i]==candidates[i-1] 
					//&& used[i-1]
							) {
				used[i]=true;
				continue;
			}
			currList.add(candidates[i]);
			currSum += candidates[i];
			used[i]=true;
			backtracking(answer, candidates, target, i, currList, currSum);
			currList.remove(currList.size()-1);
			currSum-=candidates[i];
		}
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> answer = new ArrayList<>();
		if(candidates==null || candidates.length==0)
			return answer;
		
		Arrays.sort(candidates);
		backtracking(answer, candidates, target, -1, new ArrayList<>(), 0);
		
		return answer;
 	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> answer = new CombinationSum2().combinationSum2(new int[]{1,2,2,2}, 5);
		
		System.out.println("--------------");
		for (List<Integer> list : answer) {
			for (int num : list)
				System.out.print(num + ",");
			System.out.println();
		}		
	}

}
