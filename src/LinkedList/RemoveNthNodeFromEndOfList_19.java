package LinkedList;

public class RemoveNthNodeFromEndOfList_19 {
  public static class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
//    方法二: 快慢指针 始终保持N个节点的距离
    ListNode dummyNode = new ListNode(0, head);
    ListNode fastIndex = dummyNode;
    ListNode slowIndex = dummyNode;
//    只要快慢指针相差 n 个结点即可
    for (int i = 0; i <= n; i++) {
      fastIndex = fastIndex.next;
    }

    while(fastIndex != null) {
      fastIndex = fastIndex.next;
      slowIndex = slowIndex.next;
    }

    if (slowIndex.next != null) {
      slowIndex.next = slowIndex.next.next;
    }
    return dummyNode.next;
//    方法一: 两次遍历
//    int size = 0;
//    ListNode cur = head;
//    while (cur != null) {
//      cur = cur.next;
//      size++;
//    }
//    if (n > size || n < 0) return null;
//    ListNode dummyHead = new ListNode(0, head);
//    ListNode prev = dummyHead;
//    for (int i = 0; i < size - n; i++) {
//      prev = prev.next;
//    }
//    prev.next = prev.next.next;
//    return dummyHead.next;
  }
}
