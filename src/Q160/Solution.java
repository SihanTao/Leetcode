package Q160;

public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode result;
    ListNode p1 = headA;
    ListNode p2 = headB;

    while (true) {

      if (p1 == p2) {
        result = p1;
        break;
      }

      if (p1 == null) {
        p1 = headB;
      } else {
        p1 = p1.next;
      }

      if (p2 == null) {
        p2 = headA;
      } else {
        p2 = p2.next;
      }
    }
    return result;
  }
}
