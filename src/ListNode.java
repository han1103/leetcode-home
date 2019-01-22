// Definition for singly-linked list
public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	
	public static void print(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
}
