import java.util.ArrayList;
import java.util.List;

public class ZigzagLevelOrder {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;

		List<TreeNode> currRow = new ArrayList<>();
		List<TreeNode> nextRow = new ArrayList<>();
		int lineNum = 1;
		currRow.add(root);

		while (!currRow.isEmpty()) {
			// Prepare nextRow which is always left->right
			for (TreeNode node : currRow) {
				if (node.left != null)
					nextRow.add(node.left);
				if (node.right != null)
					nextRow.add(node.right);
			}

			// Odd line, vist node from left to right
			List<Integer> currRowList = new ArrayList<>();
			// Odd line, vist node from left to right
			if (lineNum % 2 == 1) {
				for (int i = 0; i < currRow.size(); i++)
					currRowList.add(currRow.get(i).val);
			}
			// Even line, vist node from right to left
			else {
				for (int i = currRow.size()-1; i >= 0; i--)
					currRowList.add(currRow.get(i).val);
			}
			list.add(currRowList);

			// Prepare next iteration
			currRow = nextRow;
			nextRow = new ArrayList<>();
			lineNum++;
		}

		return list;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		List<List<Integer>> list = new ZigzagLevelOrder().zigzagLevelOrder(root);

		for (List<Integer> row : list) {
			for (int i : row)
				System.out.print(i + ",");
			System.out.println();
		}
	}
}