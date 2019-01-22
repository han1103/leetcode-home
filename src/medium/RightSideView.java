package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class RightSideView {
	List<TreeNode> buildNextLayer(List<TreeNode> currLayer) {
		List<TreeNode> nextLayer = new ArrayList<>();
		for(TreeNode node : currLayer) {
			if(node.right!=null)
				nextLayer.add(node.right);
			if(node.left!=null)
				nextLayer.add(node.left);
		}
			
		return nextLayer;
	}
	
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> view = new ArrayList<>();
		if(root==null)
			return view;
		
		List<List<TreeNode>> layeredNodesFromRight = new ArrayList<>();
		List<TreeNode> currLayer = new ArrayList<>();
		currLayer.add(root);
		layeredNodesFromRight.add(currLayer);
		
		while(true) {
			List<TreeNode> nextLayer = buildNextLayer(currLayer);
			if(nextLayer.isEmpty())
				break;
			layeredNodesFromRight.add(nextLayer);
			currLayer = nextLayer;
		}
				
		for(List<TreeNode> layer : layeredNodesFromRight)
			view.add(layer.get(0).val);
		
		return view;
	}
	
	Map<Integer, Integer> map = new HashMap<>();
	
	void orderVisit(TreeNode root, int layer) {
		if(root==null)
			return;
		if(!map.containsKey(layer))
			map.put(layer, root.val);
		orderVisit(root.right, layer+1);
		orderVisit(root.left, layer+1);
	}
	
	public List<Integer> rightSideViewOrder(TreeNode root) {
		List<Integer> view = new ArrayList<>();
		if(root==null)
			return view;
		
		orderVisit(root, 0);
		int size = map.size();
		for(int i=0; i<size; i++)
			view.add(map.get(i));
		
		return view;
		
	}

	class NodeWithLayer {
		public NodeWithLayer(TreeNode node, int layer) {
			super();
			this.node = node;
			this.layer = layer;
		}
		TreeNode node;
		int layer;
	}
	
	public List<Integer> rightSideViewBFS(TreeNode root) {
		List<Integer> view = new ArrayList<>();
		if(root==null)
			return view;
		
		Queue<NodeWithLayer> queue = new LinkedList<>();
		queue.add(new NodeWithLayer(root, 0));
		
		while(!queue.isEmpty()) {
			NodeWithLayer node = queue.remove();
			map.putIfAbsent(node.layer, node.node.val);
			
			if(node.node.right!=null)
				queue.add(new NodeWithLayer(node.node.right, node.layer+1));
			if(node.node.left!=null)
				queue.add(new NodeWithLayer(node.node.left, node.layer+1));
				
		}

		int size = map.size();
		for(int i=0; i<size; i++)
			view.add(map.get(i));
		

		return view;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
