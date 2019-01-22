
public class ValidBST {
    public static boolean isValidBST1(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))return true;
        return isValidBSTHelper(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }

    private static boolean isValidBSTHelper(TreeNode root,long high,long low){
        if(root.val >= high || root.val <= low)return false;
        boolean flag = true;
        if(root.left !=null) flag = isValidBSTHelper(root.left,root.val,low);
        if(root.right !=null) flag = flag && isValidBSTHelper(root.right,high,root.val);
        return flag;
    }
    
	static class LR {
		int min;
		int max;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		System.out.println(isValidBST(root));
		//System.out.println(isValidBST1(root));
		
		root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(7);
		System.out.println(isValidBST(root));
		System.out.println(isValidBST1(root));
	}
	
	public static boolean isValidBSTLeftMinMax(TreeNode root, LR lr) {
		if (root==null)
			return true;
		if ( root.left==null && root.right==null ) {
			lr.min = root.val;
			lr.max = root.val;
			return true;
		}
		if ( root.left == null ) {
			boolean retVal = isValidBSTLeftMinMax(root.right, lr);
			if (!retVal)
				return false;
			else if (root.val > lr.min)
				return false;
			else {
				lr.min = root.val;
		        return true;
			}
		}
		if ( root.right == null ) {
			boolean retVal = isValidBSTLeftMinMax(root.left, lr);
			if (!retVal)
				return false;
			else if (root.val < lr.max)
				return false;
			else {
				lr.max = root.val;
		        return true;
			}
		}
		else {
			boolean retVal = isValidBSTLeftMinMax(root.left, lr);
			if (!retVal)
				return false;
			int copyMin = lr.min;
			if (lr.max > root.val)
				return false;
			retVal = isValidBSTLeftMinMax(root.right, lr);
			if (!retVal)
				return false;
			if (lr.min < root.val)
				return false;
			lr.min = copyMin;
			return true;
		}
		
	}
    public static boolean isValidBST(TreeNode root) {    
        return isValidBSTLeftMinMax(root, new LR());
    }
}
