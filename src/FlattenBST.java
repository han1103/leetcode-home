
public class FlattenBST {
	TreeNode flattenRec(TreeNode curr) {
		TreeNode left = curr.left;
		TreeNode visited = curr;
		if (left!=null) {
			visited.left = left;
			visited = flattenRec(left);			
		}
		TreeNode right = curr.right;
		if (right!=null) {
			visited.left = right;
			visited = flattenRec(right);
		}
		
		return visited;
		
	}
	
	void cleanRight(TreeNode root) {
		TreeNode node = root;
		while(node!=null) {
			node.right = node.left;
			node.left = null;
			node = node.right;
		}
	}
	
	public void flatten(TreeNode root) {
		if(root==null)
			return;
		
		flattenRec(root);
		cleanRight(root);
				
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		
		root.right.right = new TreeNode(6);
		
		new FlattenBST().flatten(root);
		
		System.out.println("DONE");
	}
}

