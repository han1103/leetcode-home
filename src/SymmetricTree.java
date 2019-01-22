import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SymmetricTree {
	private Map<Integer, List<Integer>> nodeMap = new HashMap<>();

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		//root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		//root.right.right = new TreeNode(3);

		System.out.println(new SymmetricTree().isSymmetric(root));
	}

	private boolean isSymmetricList(List<Integer> list) {
		int middleIndex = list.size() / 2 - 1;
		for (int i = 0; i <= middleIndex; i++) {
			Integer left = list.get(i);
			Integer right = list.get(list.size() - 1 - i);
			if (left != right)
				return false;
		}
		return true;
	}

	public boolean isSymmetric(TreeNode root) {
		buildNodeMap(root, 1);
		//buildNodeMapItr(root);

		for (List<Integer> list : nodeMap.values()) {
			if (!isSymmetricList(list))
				return false;
		}
		return true;
	}

	private void buildNodeMap(TreeNode node, int level) {
		if (level != 1) {
			List<Integer> list = nodeMap.get(level);
			if (list == null) {
				list = new LinkedList<>();
				nodeMap.put(level, list);
			}
			if (node != null)
				list.add(node.val);
			else
				list.add(null);
		}

		if (node != null) {
			buildNodeMap(node.left, level + 1);
			buildNodeMap(node.right, level + 1);
		}

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
	
	private void buildNodeMapItr(TreeNode node) {
		if(node==null)
			return;
		int level = 1;
		Queue<NodeWithLevel> queue = new LinkedList<>();
		queue.add(new NodeWithLevel(node, level));
		
		while(!queue.isEmpty()) {
			NodeWithLevel nodeWithLevel = queue.poll();
			level = nodeWithLevel.level+1;
			List<Integer> list = nodeMap.get(level);
			if (list == null) {
				list = new LinkedList<>();
				nodeMap.put(level, list);
			}							
			list.add(nodeWithLevel.node.left!=null?nodeWithLevel.node.left.val:null);
			list.add(nodeWithLevel.node.right!=null?nodeWithLevel.node.right.val:null);
			if (nodeWithLevel.node.left!=null)
				queue.add(new NodeWithLevel(nodeWithLevel.node.left, level));
			if (nodeWithLevel.node.right!=null)
				queue.add(new NodeWithLevel(nodeWithLevel.node.right, level));
		}
	
	}

}
