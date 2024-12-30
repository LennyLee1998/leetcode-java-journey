package LinkedList;
//https://leetcode.com/problems/remove-linked-list-elements/
//https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0203.%E7%A7%BB%E9%99%A4%E9%93%BE%E8%A1%A8%E5%85%83%E7%B4%A0.md
public class RemoveElements_203 {
  public static void main(String[] args) {
    int[] arr = {1,2,6,3,4,5,6};
    ListNode head = ListNode.createLinkedList(arr);
//    测试
    ListNode newNode = removeElements(head, 6);

    ListNode current = newNode;
    while (current != null) {
      System.out.println(current.val);
      current = current.next;
    }



  }

  public static ListNode removeElements(ListNode head, int val) {
    ListNode current  = new ListNode(-1, head);
    ListNode newHead = null;
    while (current.next != null) {
      if (current.next.val == val) {
//        此时 current.next.next 是 null，因此 current.next 将被设置为 null，这将正确地删除最后一个节点。
//        NullPointerException 通常会在尝试访问 null 对象的方法或属性时抛出
//        调用 null 对象的方法。
//访问 null 对象的属性。
//将 null 作为数组索引
        current.next = current.next.next;
      } else {
        if (newHead == null) {
          newHead = current.next;
        }
        current = current.next;
      }
    }
    return newHead;
  }

}
