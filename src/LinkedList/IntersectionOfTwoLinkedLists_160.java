package LinkedList;
//https://github.com/youngyangyang04/leetcode-master/blob/master/problems/%E9%9D%A2%E8%AF%95%E9%A2%9802.07.%E9%93%BE%E8%A1%A8%E7%9B%B8%E4%BA%A4.md
//https://leetcode.com/problems/intersection-of-two-linked-lists/description/
public class IntersectionOfTwoLinkedLists_160 {
  public static class ListNode {
    int val;
    ListNode next;
  }
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      ListNode curA = headA;
      ListNode curB = headB;
      int lenA = 0, lenB = 0;
//      求链表A的长度
      while (curA != null) {
        lenA++;
        curA = curA.next;
      }
//      求链表B的长度
      while (curB != null) {
        lenB++;
        curB = curB.next;
      }
      curA = headA;
      curB = headB;
//      让curA为最长链表的头, lenA为其长度
    if (lenB > lenA) {
//      交换len
      int tempLen = lenA;
      lenA = lenB;
      lenB = tempLen;
//      交换cur
      ListNode tempNode = curA;
      curA = curB;
      curB = tempNode;
    }
//    求长度差
    int gap = lenA - lenB;
    while (gap-- > 0) {
      curA = curA.next;
    }
    while(curA!= null) {
      if (curA == curB) {
        return curA;
      }
      curA = curA.next;
      curB = curB.next;
    }
  return null;
  }



}
