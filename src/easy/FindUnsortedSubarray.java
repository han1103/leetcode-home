package easy;

import java.util.Arrays;

public class FindUnsortedSubarray {
	public int findUnsortedSubarray(int[] nums) {
		if(nums==null || nums.length==0)
			return 0;
		int len = nums.length;
		int[] copy = new int[len];
		for(int i=0; i<len; i++)
			copy[i]=nums[i];
		
		Arrays.sort(copy);				
		int count=0;
		int i=0;
		for(; i<len; i++)
			if(copy[i]!=nums[i])
				break;
		count=i;
		
		int j=len-1;
		for(; j>count; j--)
			if(copy[j]!=nums[j])
				break;				
		count+=(len-j-1);
		
		return len-count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new FindUnsortedSubarray().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
	}

}
