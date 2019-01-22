
public class OddEvenList {
	public ListNode oddEvenList(ListNode head) {
		ListNode oddHead = head;

		if (head != null && head.next != null) {
			ListNode evenHead = head.next;
			ListNode currPtr = evenHead;
			ListNode oddPtr = oddHead;
			ListNode evenPtr = evenHead;
			boolean isOdd = true;
			while (currPtr.next != null) {
				currPtr = currPtr.next;
				if (isOdd) {
					oddPtr.next = currPtr;
					oddPtr = currPtr;
				} else {
					evenPtr.next = currPtr;
					evenPtr = currPtr;
				}
				isOdd = !isOdd;
			}

			oddPtr.next = evenHead;
			evenPtr.next = null;
		}

		return oddHead;
	}

	public ListNode oddEvenListEasy(ListNode head) {
		if(head!=null && head.next!=null) {
			ListNode odd = head;
			ListNode even = head.next;
			ListNode evenHeader = head.next;
			while(even!=null && even.next!=null) {
				odd.next=even.next;
				odd = odd.next;
				even.next=odd.next;
				even = even.next;
			}
			odd.next=evenHeader;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode curr = head;
		curr.next = new ListNode(2);
		curr = curr.next;
		curr.next = new ListNode(3);
		curr = curr.next;
		curr.next = new ListNode(4);
		curr = curr.next;
		curr.next = new ListNode(5);

		ListNode oddEven = new OddEvenList().oddEvenListEasy(head);
		while (oddEven != null) {
			System.out.print(oddEven.val + "->");
			oddEven = oddEven.next;
		}
		System.out.println("NULL");
	}
}
