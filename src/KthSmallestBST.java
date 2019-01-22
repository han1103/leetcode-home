
public class KthSmallestBST {
	int itr = 0;
	int k;
	int answer;
	
	void traverse(TreeNode node) {
		if (node.left!=null)
			traverse(node.left);
		itr++;
		if (itr==k) {
			answer=node.val;
			return;
		}
		if (node.right!=null)
			traverse(node.right);
					
	}
	public int kthSmallest(TreeNode root, int k) {
		this.k = k;
		
		traverse(root);
		
		return answer;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		
		root.left.left.left = new TreeNode(1);
		
		System.out.println(new KthSmallestBST().kthSmallest(root, 3));
	}
}
