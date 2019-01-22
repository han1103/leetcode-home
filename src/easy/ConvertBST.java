package easy;

import java.util.ArrayList;
import java.util.List;

public class ConvertBST {
	List<Integer> list = new ArrayList<>();
	int sum;
	int seq=0;
	
	void buildList(TreeNode root) {
		if(root==null)
			return;
		buildList(root.left);
		list.add(root.val);
		buildList(root.right);
	}
		
	void convertBSTRec(TreeNode root) {
		if(root==null)
			return;
		convertBSTRec(root.left);
		int temp=root.val;
		root.val = sum;
		sum-=temp;
		convertBSTRec(root.right);
	}
	
	public TreeNode convertBST(TreeNode root) {
		buildList(root);
		for(int num: list)
			sum+=num;		
		
		convertBSTRec(root);
		
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(13);
		
		root = new ConvertBST().convertBST(root);
		System.out.println();
	}

}
