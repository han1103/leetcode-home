import java.util.ArrayList;
import java.util.List;

public class PathSum {
	List<List<Integer>> listOfList = new ArrayList<>();

	public void hasPathSumRec(TreeNode root, int targetSum, int sumSoFar, List<Integer> list) {
		sumSoFar += root.val;

		if (root.left == null && root.right == null) {
			if (targetSum == sumSoFar) {
				list.add(root.val);
				listOfList.add(list);
			}
			return;
		}

		list.add(root.val);
/*		List<Integer> copyList = new ArrayList<>();
		for (int elem : list)
			copyList.add(elem);
*/
		List<Integer> copyList = new ArrayList<>(list);
		if (root.left != null)
			hasPathSumRec(root.left, targetSum, sumSoFar, list);
		if (root.right != null)
			hasPathSumRec(root.right, targetSum, sumSoFar, copyList);
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<Integer> list = new ArrayList<>();

		if(root!=null)
			hasPathSumRec(root, sum, 0, list);

		return listOfList;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);

		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);

		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);

		List<List<Integer>> retList = new PathSum().pathSum(root, 22);
		
		for(List<Integer> elemList : retList) {
			for(int elem : elemList) {
				System.out.print(elem+"->");
			}
			System.out.println();
		}
	}

}
