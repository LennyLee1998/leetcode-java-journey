package LinkedList;
//https://leetcode.com/problems/reverse-linked-list/
//https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0206.%E7%BF%BB%E8%BD%AC%E9%93%BE%E8%A1%A8.md
public class ReverseLinkedList_206 {
  public static class ListNode {
     int val;
     ListNode next;

  }
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode cur = head;
    ListNode next = null;
    while (cur != null) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
}
