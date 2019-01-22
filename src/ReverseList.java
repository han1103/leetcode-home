
public class ReverseList {
	
	public ListNode reverseList(ListNode head) {		
		if (head==null || head.next==null) {
			return head;
		}
		ListNode restHead = reverseList(head.next);
		ListNode ptr = restHead;
		while(ptr.next!=null)
			ptr = ptr.next;
		ptr.next = head;
		head.next = null;
		
		return restHead;
	}

	public ListNode reverseListItr(ListNode head) {		
		if (head==null || head.next==null) {
			return head;
		}

		ListNode first = null;
		ListNode second = head;
		
		while(second!=null) {
			ListNode temp = second.next;
			second.next = first;
			first = second;
			second = temp;
		}
	
		return first;
	}
}
