import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public void bfs(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode head = queue.poll();
			System.out.print(head.val+"->");
			if(head.left!=null)
				queue.add(head.left);
			if(head.right!=null)
				queue.add(head.right);			
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		root.left.left.left = new TreeNode(8);
		root.left.right.right = new TreeNode(9);
		
		new BFS().bfs(root);
	}
}
