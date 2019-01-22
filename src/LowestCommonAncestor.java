import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestor {
	public boolean findPath(TreeNode root, TreeNode p, LinkedList<TreeNode> path) {
		if (root == p) {
			path.add(root);
			return true;
		}
		if (root == null) {
			return false;
		}

		path.add(root);
		if (findPath(root.left, p, path))
			return true;
		if (findPath(root.right, p, path))
			return true;
		path.removeLast();
		return false;
	}

	TreeNode findLowestCommonAncestor(Queue<TreeNode> pathP, Queue<TreeNode> pathQ) {
		TreeNode lowestCommonAncestor = null;

		while (!pathP.isEmpty() && !pathQ.isEmpty()) {
			TreeNode headP = pathP.poll();
			TreeNode headQ = pathQ.poll();

			if (headP == headQ)
				lowestCommonAncestor = headP;
			else
				break;
		}

		return lowestCommonAncestor;
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		LinkedList<TreeNode> pathP = new LinkedList<>();
		if (!findPath(root, p, pathP))
			return null;
		else {
			LinkedList<TreeNode> pathQ = new LinkedList<>();
			if (!findPath(root, q, pathQ))
				return null;
			return findLowestCommonAncestor(pathP, pathQ);
		}
	}

	TreeNode ans;
	int found = 0;
	
	boolean traverse(TreeNode node, TreeNode p, TreeNode q) {
		int mid=0, left=0, right=0;
		
		if (node==null)
			return false;
		
		if(node==p || node==q) {
			mid = 1;
			found++;
			if (found==2)
				return true;
		}
		
		if (traverse(node.left, p, q)) {
			left = 1;
		}
		if (traverse(node.right, p, q)) {
			right = 1;
		}
		
		if(mid+left+right==2) {
			ans = node;
		}
		if(mid+left+right>0)
			return true;
			
		return false;
	}
	
    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
        if (mid==1) {
            found++;
            if (found==2)
                return true;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

            

        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }
	
	public TreeNode lowestCommonAncestorFaster(TreeNode root, TreeNode p, TreeNode q) {
		//traverse(root, p, q);
		recurseTree(root, p, q);
		return ans;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);

		root.left = new TreeNode(5);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);

		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		TreeNode common = new LowestCommonAncestor().lowestCommonAncestorFaster(root, root.left, root.left.right.right);

		System.out.println(common.val);
	}
}
