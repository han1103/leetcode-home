
public class InvertTree {
	public void invertTreeRec(TreeNode root) {
		if(root==null)
			return;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTreeRec(root.left);
		invertTreeRec(root.right);
	}
	
	public TreeNode invertTree(TreeNode root) {
		invertTreeRec(root);
		
		return root;			
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(7);
		root.right = new TreeNode(2);
		
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(6);
		
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(1);
		
		TreeNode resultRoot = new InvertTree().invertTree(root);
		
		System.out.println("finish");
	}
}
