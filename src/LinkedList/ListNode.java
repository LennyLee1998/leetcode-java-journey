package LinkedList;

public class ListNode {
  int val;
//  next是LinkNode对象 LinkNode对象本身就是地址 使用这个来找下一个节点 来组成链表
  ListNode next;

  public ListNode() {
  }

  public ListNode(int value) {
    this.val = value;
  }

  public ListNode(int value, ListNode next) {
    this.val = value;
    this.next = next;
  }



  public static ListNode createLinkedList(int[] arr) {
    ListNode head;
    ListNode last = null;
    for (int i = arr.length - 1; i >= 0; i--) {
      ListNode node = new ListNode(arr[i]);
      node.next = last;
      last = node;
    }
    head = last;
    return head;
  }


}
