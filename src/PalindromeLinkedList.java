import java.util.ArrayList;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		ArrayList<Integer> list = new ArrayList<>();
		
		ListNode itr = head;
		while(itr!=null) {
			list.add(itr.val);
			itr=itr.next;
		}
		
		int len = list.size();
		for(int i=0; i<len/2; i++) {
			if(!list.get(i).equals(list.get(len-1-i)))
				return false;
		}
		
		return true;
	}
	
	ListNode ptr;
	
	boolean isPalindromeRec(ListNode node) {
		if(node==null)
			return true;
		
		if(!isPalindromeRec(node.next))
			return false;
		
		if(node.val!=ptr.val)
			return false;
		
		ptr = ptr.next;
		
		return true;
	}
	
	public boolean isPalindromeSpace(ListNode head) {
		ptr = head;
		
		return isPalindromeRec(head);
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		
		System.out.println(new PalindromeLinkedList().isPalindromeSpace(head));
	}
}
