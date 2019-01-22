
public class HasPathSum {
	public boolean hasPathSumRec(TreeNode root, int targetSum, int sumSoFar) {
		if (root.left==null && root.right==null)
			if (targetSum==(sumSoFar+root.val))
				return true;
			else
				return false;
		
		sumSoFar+=root.val;
		
		if (root.left!=null)
			if(hasPathSumRec(root.left, targetSum, sumSoFar))
				return true;
		if (root.right!=null)
			if(hasPathSumRec(root.right, targetSum, sumSoFar))
				return true;
		
		return false;
	}
	
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root==null)
    		return false;
    	return hasPathSumRec(root, sum, 0);
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(5);
    	root.left = new TreeNode(4);
    	root.right = new TreeNode(8);
    	
    	root.left.left = new TreeNode(11);
    	root.right.left = new TreeNode(13);
    	root.right.right = new TreeNode(4);
    	
    	root.left.left.left = new TreeNode(7);
    	root.left.left.right = new TreeNode(4);
    	root.right.right.right = new TreeNode(1);
    	
    	System.out.println(new HasPathSum().hasPathSum(root, 22));
    }
}
