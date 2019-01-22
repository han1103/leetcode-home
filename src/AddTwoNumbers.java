
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		
		ListNode ptr1 = l1;
		ListNode ptr2 = l2;
		int val = l1.val+l2.val;
		boolean carry = false;
		if (val>=10) {
			carry = true;
			val-=10;
		}
			
		ListNode result = new ListNode(val);
		ListNode ptr = result;
		ptr1=ptr1.next;
		ptr2=ptr2.next;
				
		while(ptr1!=null || ptr2!=null) {
			val = carry?1:0;
			if (ptr1!=null) {
				val+=ptr1.val;
				ptr1 = ptr1.next;
			}
			if (ptr2!=null) {
				val+=ptr2.val;
				ptr2 = ptr2.next;
			}
 
			carry = false;
			if (val>=10) {
				carry = true;
				val-=10;
			}
			ptr.next = new ListNode(val);
			ptr = ptr.next;
		}
		
		if (carry)
			ptr.next = new ListNode(1);
		
		return result;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode result = new AddTwoNumbers().addTwoNumbers(l1, l2);

		while(result!=null) {
			System.out.print(result.val+"->");
			result = result.next;
		}
		System.out.println();
	}

}