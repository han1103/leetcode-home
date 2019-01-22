public class IntersectionNode {
	public static void main(String[] args) {
		ListNode headA = new ListNode(2);
		headA.next = new ListNode(3);
		ListNode headB = headA.next;
		ListNode intersect = new IntersectionNode().getIntersectionNode(headA, headB);
		System.out.println(intersect.val);
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode ptrA = headA;
		ListNode ptrB = headB;

		while (ptrA != null && ptrB != null) {
			if (ptrA == ptrB)
				return ptrA;
			ptrA = ptrA.next;
			ptrB = ptrB.next;
		}

		if (ptrA == null && ptrB == null)
			return null;
		boolean finishedA = false;
		if (ptrA == null) {
			ptrA = headB;
			ptrB=ptrB.next;
			finishedA = true;
		} else if (ptrB == null) {
			ptrB = headA;
			ptrA = ptrA.next;
			finishedA = false;
		}

		while (!(ptrA == null && finishedA) && !(ptrB == null && !finishedA)) {
			if (ptrA == ptrB)
				return ptrA;
			if (ptrB == null)
				ptrB = headA;
			else
				ptrB = ptrB.next;
			if (ptrA == null)
				ptrA = headB;
			else
				ptrA = ptrA.next;
		}

		return null;
	}
}
