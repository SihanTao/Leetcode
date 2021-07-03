/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next; ListNode(int x) { val
 * = x; next = null; } }
 */
class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

public class LinkedListCycleII_142 {
  public ListNode detectCycle(ListNode head) {
    ListNode fast, slow;
    fast = slow = head;
    do {
      if (fast == null || fast.next == null) return null;
      fast = fast.next.next;
      slow = slow.next;
    } while (fast != slow);

    fast = head;
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }
}
