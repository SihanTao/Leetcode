package Q19;

public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode p = head;
    int nums = 0;
    while (p != null) {
      p = p.next;
      nums++;
    }

    if (n == nums) {
      return head.next;
    }

    p = head;
    for (int cnt = 1; cnt < nums - n; cnt++) {
      p = p.next;
    }
    p.next = p.next.next;
    return head;
  }
}
