import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTNextRightPtr {
	public void connectLinkedList(TreeLinkNode root) {
		List<TreeLinkNode> currentRow = new LinkedList<>();

		currentRow.add(root);

		while (!currentRow.isEmpty()) {
			int size = currentRow.size();
			for (int i = 0; i < size; i++) {
				TreeLinkNode node = currentRow.get(i);
				if (node.left != null)
					currentRow.add(node.left);
				if (node.right != null)
					currentRow.add(node.right);

				if (i + 1 < size)
					node.next = currentRow.get(i + 1);

			}

			for (int i = 0; i < size; i++) {
				currentRow.remove(0);
			}
		}

	}

	public void connectLinkedListF(TreeLinkNode root) {
		List<TreeLinkNode> currentRow = new LinkedList<>();

		currentRow.add(root);

		while (!currentRow.isEmpty()) {
			int size = currentRow.size();
			for (int i = 0; i < size; i++) {
				TreeLinkNode node = currentRow.remove(0);
				if (node.left != null)
					currentRow.add(node.left);
				if (node.right != null)
					currentRow.add(node.right);

				if (i + 1 < size)
					node.next = currentRow.get(0);
				
			}

		}

	}

	public void connectQueue(TreeLinkNode root) {
		Queue<TreeLinkNode> currentRow = new LinkedList<>();

		currentRow.add(root);

		while (!currentRow.isEmpty()) {
			int size = currentRow.size();
			for (int i = 0; i < size; i++) {
				TreeLinkNode node = currentRow.poll();
				if (node.left != null)
					currentRow.add(node.left);
				if (node.right != null)
					currentRow.add(node.right);

				if (i + 1 < size)
					node.next = currentRow.peek();
			}
		}

	}

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		connectLinkedList(root);
	}

	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);

		new BSTNextRightPtr().connect(root);

		System.out.println("DONE");
	}
}
