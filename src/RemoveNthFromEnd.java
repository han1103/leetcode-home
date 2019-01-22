
public class RemoveNthFromEnd {
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	        ListNode slow = head;
	        ListNode fast = head;
	    	
	        for(int i=0; i<n; i++)
	        	fast = fast.next;
	        if ( fast == null ) {
	        	ListNode tmp =head;
	        	head = head.next;
	        	tmp.next=null;
	        	return head;
	        }
	        	
	        while(fast.next!=null) {
	        	fast = fast.next;
	        	slow = slow.next;
	        }
	        ListNode tmp = slow.next;
	        slow.next = slow.next.next;
	        tmp.next = null;
	        
	    	return head;
	    }

	    public ListNode removeNthFromEnd1(ListNode head, int n) {
	    	ListNode dummy = new ListNode(0);
	    	dummy.next = head; 
	    			
	        ListNode slow = dummy;
	        ListNode fast = dummy;
	    	
	        for(int i=0; i<n; i++)
	        	fast = fast.next;
	        while(fast.next!=null) {
	        	fast = fast.next;
	        	slow = slow.next;
	        }
	        ListNode tmp = slow.next;
	        slow.next = slow.next.next;
	        tmp.next = null;
	        
	    	return dummy.next;
	    }

}
