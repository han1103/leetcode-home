
public class MergeSort {
	public ListNode mergeSortList(ListNode head) {
		if(head.next==null)
			return head;
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		ListNode middle = slow.next;
		slow.next = null;
		
		return merge(mergeSortList(head), mergeSortList(middle));
	}
	
	
	ListNode merge(ListNode firstList, ListNode secondList) {
		ListNode res;
		ListNode firstPtr = firstList;
		ListNode secondPtr = secondList;
		ListNode currPtr;
		if(firstList.val <= secondList.val) {
			res = firstList;			
			firstPtr = firstPtr.next;
		}
		else {
			res = secondList;
			secondPtr = secondPtr.next;
		}
		currPtr = res;
		
		while(firstPtr!=null && secondPtr!=null) {
			if (firstPtr.val<=secondPtr.val) {
				currPtr.next=firstPtr;
				currPtr = firstPtr;
				firstPtr = firstPtr.next;
			}
			else {
				currPtr.next=secondPtr;
				currPtr = secondPtr;
				secondPtr = secondPtr.next;
			}
		}
		
		if (firstPtr==null)
			currPtr.next = secondPtr;
		else
			currPtr.next = firstPtr;
		
		
		return res;
		
	}
	
	public ListNode sortList(ListNode head) {
		if (head==null)
			return head;
		
		return mergeSortList(head);
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);
		
		ListNode res = new MergeSort().mergeSortList(head);
		while(res!=null) {
			System.out.print(res.val+"->");
			res = res.next;
		}
		
		System.out.println();
	}
}
