
public class DeleteNode {
	 public void deleteNode(ListNode node) {
		 ListNode tmp = node.next;
		 
		 node.val = node.next.val;
		 node.next = node.next.next;
		 
		 if (tmp!=null)
			 tmp.next=null;
	 }
}
