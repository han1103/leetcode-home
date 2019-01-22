package easy;

public class IsSubtree {
	boolean isSameTree(TreeNode t1, TreeNode t2) {
		if(t1==null || t2==null) {
			if(t1==null && t2==null)
				return true;
			else
				return false;
		}
		
		if(t1.val!=t2.val)
			return false;
		if(!isSameTree(t1.left, t2.left))
			return false;
		if(!isSameTree(t1.right, t2.right))
			return false;
		
		return true;
	}
	
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if(s==null)
			if(t==null)
				return true;
			else
				return false;
		
		if(isSameTree(s,t))
			return true;
		if(isSubtree(s.left,t))
			return true;
		if(isSubtree(s.right,t))
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode s = new TreeNode(6);
		s.right=new TreeNode(5);
		s.right.right=new TreeNode(4);
		s.right.right.right=new TreeNode(3);
		s.right.right.right.right=new TreeNode(1);
		s.right.right.right.right.left=new TreeNode(2);
		/*s.right.right.right.right=new TreeNode(1);
		s.right.right.right.right.left=new TreeNode(2);*/
		
/*		s.right.right.right=new TreeNode(1);
		s.right.right.right.right=new TreeNode(1);
		s.right.right.right.right.right=new TreeNode(1);
		s.right.right.right.right.right.left=new TreeNode(2);
*/		
		TreeNode t = new TreeNode(4);
		t.right=new TreeNode(3);
		t.right.right=new TreeNode(1);
		t.right.right.left=new TreeNode(2);
		
		System.out.println(new IsSubtree().isSubtree(s, t));
		
	}

}
