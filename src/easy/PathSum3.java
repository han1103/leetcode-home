package easy;

public class PathSum3 {
	
	int pathSumStartingWithHead(TreeNode root, int sum) {
		if(root==null)
			return 0;
		
		int count = root.val==sum ? 1 : 0;
		count+=pathSumStartingWithHead(root.left, sum-root.val);
		count+=pathSumStartingWithHead(root.right, sum-root.val);
		
		return count;			
	}
	
	public int pathSum(TreeNode root, int sum) {
		int tot = 0;
		if(root==null)
			return 0;
		tot+=pathSumStartingWithHead(root, sum);
		tot += pathSum(root.left, sum);
		tot += pathSum(root.right, sum);
		return tot;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);

		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.right.right = new TreeNode(11);

		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(8);
		root.left.right.right = new TreeNode(1);

		System.out.println(new PathSum3().pathSum(root, 8));
	}

}

