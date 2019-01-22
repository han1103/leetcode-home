import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
	private List<List<Integer>> nodeListList = new LinkedList<>();

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(3);

		List<List<Integer>> listList = new LevelOrder().levelOrder(root);
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		//buildNodeListList(root, 1);
		buildNodeListItr(root);

		return nodeListList;
	}

	private void buildNodeListList(TreeNode node, int level) {
		if (node==null)
			return;
		List<Integer> list = null;
		if ( level-1 < nodeListList.size() )
			list = nodeListList.get(level - 1);
		if (list == null) {
			list = new LinkedList<>();
			nodeListList.add(level - 1, list);
		}
		list.add(node.val);

		if (node.left != null)
			buildNodeListList(node.left, level + 1);
		if (node.right != null)
			buildNodeListList(node.right, level + 1);
	}

	
	private static class NodeWithLevel {
		public NodeWithLevel(TreeNode node, int level) {
			super();
			this.node = node;
			this.level = level;
		}
		TreeNode node;
		int level;
	}
	
	private void buildNodeListItr(TreeNode node) {
		if(node==null)
			return;
		Queue<NodeWithLevel> queue = new LinkedList<>();
		queue.add(new NodeWithLevel(node, 1));
		
		while(!queue.isEmpty()) {
			NodeWithLevel nodeWithLevel = queue.poll();
			List<Integer> list = null;
			if ( nodeWithLevel.level-1 < nodeListList.size() )
				list = nodeListList.get(nodeWithLevel.level - 1);
			if (list == null) {
				list = new LinkedList<>();
				nodeListList.add(nodeWithLevel.level - 1, list);
			}
			list.add(nodeWithLevel.node.val);
			
			if (nodeWithLevel.node.left!=null)
				queue.add(new NodeWithLevel(nodeWithLevel.node.left, nodeWithLevel.level+1));
			if (nodeWithLevel.node.right!=null)
				queue.add(new NodeWithLevel(nodeWithLevel.node.right, nodeWithLevel.level+1));
		}
	}
	 
}
