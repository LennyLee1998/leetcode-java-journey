package LinkedList;
//https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle_141 {
  public static class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }

  /**
   * 判断链表是否有环, 使用快慢指针进行判断, 如果有环的话, 则有一个瞬间快慢指针会指向同一个节点
   * @param head
   * @return 是否有环
   */
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (fast == slow) return true;
    }

    return false;
  }
}
