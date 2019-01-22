
public class SortedArrayToBST {
	public static void main(String[] args) {
		TreeNode node = new SortedArrayToBST().sortedArrayToBST(new int[]{-19,-10,-3,0,5,9,12,15,20});
		
		System.out.println(node.val);
	}
	
    public TreeNode sortedArrayToBST(int[] nums) {
    	if(nums==null || nums.length==0)
    		return null;
    	return sortedArrayToBSTHelper(nums, 0, nums.length-1);
    }
    
    private TreeNode sortedArrayToBSTHelper (int[] nums, int start, int end) {
    	if (start==end) {
    		TreeNode node = new TreeNode(nums[start]);
    		return node;
    	}
    	else if ( end-start==1) {
    		TreeNode node = new TreeNode(nums[end]);
    		TreeNode leftNode = new TreeNode(nums[start]);
    		node.left=leftNode;
    		return node;
    	}
    	else {
    		int indexMiddle = (start+end)/2;
    		TreeNode node = new TreeNode(nums[indexMiddle]);
    		node.left = sortedArrayToBSTHelper(nums, start, indexMiddle-1);
    		node.right = sortedArrayToBSTHelper(nums, indexMiddle+1, end);
    		return node;
    	}
    	
    }
}
