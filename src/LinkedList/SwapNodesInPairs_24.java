package LinkedList;

public class SwapNodesInPairs_24 {
  public static class ListNode {
    int val;
    ListNode next;
  }
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode next = head.next;
    ListNode newNode = swapPairs(next.next);
    next.next = head;
    head.next = newNode;

    return next;

  }
}
