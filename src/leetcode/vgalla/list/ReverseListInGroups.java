package leetcode.vgalla.list;

public class ReverseListInGroups {
	
	public static ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode firstNode = head;
		ListNode secondNode = head.next;
		firstNode.next = null;
		ListNode reverseOfSecondNode = reverse(secondNode);
		secondNode.next = firstNode;
		
		return reverseOfSecondNode;
	}
    
    public static ListNode reverseKGroup(ListNode head, int k) {
    	if (k <= 1) {
    		return head;
    	}
        int tempK = k-1;
		ListNode lastNode = head;
		while (tempK > 0 && lastNode != null) {
			tempK--;
			lastNode = lastNode.next;
		}
		if (tempK == 0 && lastNode != null) {
			ListNode secondKHead = lastNode.next;
			lastNode.next = null;
			ListNode reverseFirstK = reverse(head);
			head.next = reverseKGroup(secondKHead, k);
			return reverseFirstK;
		}
		return head;
    }
 
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		one.next = new ListNode(2);
		one.next.next = new ListNode(3);
		one.next.next.next = new ListNode(4);
		one.next.next.next.next = new ListNode(5);
		
		ListNode reverse = reverseKGroup(one, 1);
		while(reverse != null) {
			System.out.print(reverse.val + " ");
			reverse = reverse.next;
		}
	}

}
