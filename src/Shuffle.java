import java.util.LinkedList;
import java.util.List;

public class Shuffle {
	int[] nums;
	
	List<List<Integer>> orders;
	int index;
	
	public static void main(String[] args) {
		List<List<Integer>> listOfList = createOrders(10);
		
		for(List<Integer> list : listOfList) {
			for(Integer i:list)
				System.out.print(i+" ");
			System.out.println();
		}
	
		
/*		int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12};
		Shuffle solution = new Shuffle(nums);

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
*/
	}
	
	private static List<Integer> copyList(List<Integer> list) {
		List<Integer> retList = new LinkedList<Integer>();
		for(Integer num:list)
			retList.add(num);
		
		return retList;
	}
	
	private  static List<List<Integer>> createOrders(int n) {
		if(n==1) {
			List<List<Integer>> listOfList = new LinkedList<List<Integer>>();
			List<Integer> list = new LinkedList<Integer>();
			list.add(0);
			listOfList.add(list);
			return listOfList;
		}
		List<List<Integer>> prevListOfList = createOrders(n-1);
		List<List<Integer>> listOfList = new LinkedList<List<Integer>>();
		for(List<Integer> list : prevListOfList) {
			for(int i=0; i<list.size(); i++) {
				List<Integer> copyOfList = copyList(list);
				copyOfList.add(i, n-1);
				listOfList.add(copyOfList);
			}
			List<Integer> copyOfList = copyList(list);
			copyOfList.add(n-1);
			listOfList.add(copyOfList);
		}
		
		return listOfList;
	}
	
    public Shuffle(int[] nums) {
    	this.nums = nums;
    	if (nums!=null && nums.length>0)
    		this.orders = createOrders(nums.length);
    	this.index = 0;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	if (nums==null || nums.length==0) 
    		return nums;
    	
    	int[] retNums = new int[nums.length];
    	List<Integer> list = orders.get(index);
    	for(int i=0; i<nums.length; i++)
    		retNums[i] = nums[list.get(i)];
    	index=(index+1)%nums.length;
    	
        return retNums;
    }
}
