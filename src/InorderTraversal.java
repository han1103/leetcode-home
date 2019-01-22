import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);

		List<Integer> list = new InorderTraversal().inorderTraversalStack(root);

		for (int i : list)
			System.out.print(i + ",");
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null)
			return new LinkedList<>();
		else {
			List<Integer> list = inorderTraversal(root.left);
			list.add(root.val);
			list.addAll(inorderTraversal(root.right));
			return list;
		}
	}

	class TreeNodePlus {
		public TreeNodePlus(TreeNode node, boolean processed) {
			super();
			this.node = node;
			this.processed = processed;
		}

		TreeNode node;
		boolean processed;
	};

	public List<Integer> inorderTraversalStack(TreeNode root) {
		List<Integer> retList = new LinkedList<>();

		if (root == null)
			return retList;

		TreeNode curr = root;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			while (curr.left != null) {
				stack.push(curr.left);
				curr = curr.left;
			}
			while (!stack.isEmpty()) {
				curr = stack.pop();
				retList.add(curr.val);
				if (curr.right != null) {
					stack.push(curr.right);
					curr = curr.right;
					break;
				}
			}
		}

		return retList;
	}

	public List<Integer> inorderTraversalItr(TreeNode root) {
		List<Integer> retList = new LinkedList<>();

		if (root == null)
			return retList;

		List<TreeNodePlus> listNode = new LinkedList<>();
		listNode.add(new TreeNodePlus(root, false));

		while (!listNode.isEmpty()) {
			TreeNodePlus head = listNode.remove(0);
			if (!head.processed) {
				if (head.node.left != null) {
					listNode.add(0, new TreeNodePlus(head.node.left, false));
					listNode.add(1, new TreeNodePlus(head.node, true));
					if (head.node.right != null)
						listNode.add(2, new TreeNodePlus(head.node.right, false));
				} else {
					retList.add(head.node.val);
					if (head.node.right != null)
						listNode.add(0, new TreeNodePlus(head.node.right, false));
				}
			} else {
				retList.add(head.node.val);
			}
		}

		return retList;
	}
}
