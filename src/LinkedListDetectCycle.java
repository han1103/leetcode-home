import java.util.HashSet;
import java.util.Set;

public class LinkedListDetectCycle {
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		
		ListNode index = head;
		index.next = new ListNode(1);
		
		index = index.next;
		index.next = new ListNode(2);
		
		//ListNode node=index.next;
		index = index.next;
		index.next = new ListNode(3);
		
		index = index.next;
		//index.next = node;
				
		System.out.println("\n cycle:"+hasCycle2Runner(head));
	}

    public static boolean hasCycle2Runner(ListNode head) {
    	if (head==null)
    		return false;
    	ListNode slow = head;
    	ListNode fast = head.next;
    	
    	while(slow!=null && fast!=null) {
    		if (fast==slow)
    			return true;
    		if ( fast.next == null)
    			return false;
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	
    	return false;
    }

    public static boolean hasCycle(ListNode head) {
    	Set<ListNode> set = new HashSet<>();
    	while(head!=null) {
    		if(set.contains(head))
    			return true;
    		ListNode temp = head;
    		set.add(temp);
    		head=head.next;
    	}
    	return false;
    }
}
