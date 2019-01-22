package easy;

public class MergeTrees {
	TreeNode dupTree(TreeNode t) {
		TreeNode d = new TreeNode(t.val);
		if(t.left!=null)
			d.left= dupTree(t.left);
		if(t.right!=null)
			d.right= dupTree(t.right);
				
		return d;
	}
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1==null && t2==null)
			return null;
		if(t1==null && t2!=null)
			return dupTree(t2);
		if(t1!=null && t2==null)
			return dupTree(t1);
		
		TreeNode t = new TreeNode(t1.val+t2.val);
		TreeNode left = mergeTrees(t1.left, t2.left);
		if(left!=null)
			t.left = left;
		TreeNode right = mergeTrees(t1.right, t2.right);
		if(right!=null)
			t.right = right;
		
		return t;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
