import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Shuffle2 {
	int[] nums;
	Random random;

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12};
		Shuffle2 solution = new Shuffle2(nums);

		// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
		nums = solution.shuffle();
		for(int i:nums)
			System.out.print(i+" ");
		System.out.println();
		
		// Resets the array back to its original configuration [1,2,3].
		nums = solution.reset();
		for(int i:nums)
			System.out.print(i+" ");
		System.out.println();

		// Returns the random shuffling of array [1,2,3].
		nums = solution.shuffle();
		for(int i:nums)
			System.out.print(i+" ");
		System.out.println();

		nums = solution.shuffle();
		for(int i:nums)
			System.out.print(i+" ");
		System.out.println();

		nums = solution.shuffle();
		for(int i:nums)
			System.out.print(i+" ");
		System.out.println();

		nums = solution.shuffle();
		for(int i:nums)
			System.out.print(i+" ");
		System.out.println();

		nums = solution.shuffle();
		for(int i:nums)
			System.out.print(i+" ");
		System.out.println();

		nums = solution.shuffle();
		for(int i:nums)
			System.out.print(i+" ");
		System.out.println();

	}
	
	private static List<Integer> toList(int[] arr) {
		List<Integer> retList = new LinkedList<>();
		for(int num:arr)
			retList.add(num);
		
		return retList;
	}
	
    public Shuffle2(int[] nums) {
    	this.nums = nums.clone();
    	this.random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	if (nums==null || nums.length==0) 
    		return nums;
    	
    	List<Integer> list = toList(nums);
    	int[] retNums = new int[nums.length];
    	
    	for(int i=0; i<nums.length; i++)
    		retNums[i] = list.remove(random.nextInt(list.size()));    	
    	
        return retNums;
    }
}
