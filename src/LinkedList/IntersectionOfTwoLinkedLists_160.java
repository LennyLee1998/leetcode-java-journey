package LinkedList;

//https://github.com/youngyangyang04/leetcode-master/blob/master/problems/%E9%9D%A2%E8%AF%95%E9%A2%9802.07.%E9%93%BE%E8%A1%A8%E7%9B%B8%E4%BA%A4.md
//https://leetcode.com/problems/intersection-of-two-linked-lists/description/
public class IntersectionOfTwoLinkedLists_160 {
  public static class ListNode {
    int val;
    ListNode next;
  }

  //交点不是数值相等，而是指针相等。
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//    解法一:
    // 1.获取两个链表的长度
    ListNode curA = headA;
    ListNode curB = headB;
    int lenA = 0, lenB = 0;

    // 计算链表A的长度
    while (curA != null) {
      lenA++;
      curA = curA.next;
    }

//  计算链表B的长度
    while (curB != null) {
      lenB++;
      curB = curB.next;
    }
    curA = headA;
    curB = headB;

    // 2.找到较长链表，确保curA是长链表，lenA是长链表的长度
    if (lenB > lenA) {
//    交换curA与curB
      int tempLen = lenA;
      lenA = lenB;
      lenB = tempLen;

//    交换长度
      ListNode tempNode = curA;
      curA = curB;
      curB = tempNode;
    }

    // 3.将长链表指针移动到与短链表指针对齐的位置
    int gap = lenA - lenB;
    while (gap-- > 0) {
      curA = curA.next;
    }


    // 4. 判断两个链表是否相交，使用指针比较地址以找到交点
    while (curA != null) {
      if (curA == curB) {
        return curA;// 返回交点
      } else {
        curA = curA.next;
        curB = curB.next;
      }
    }
    return null; // 没有交点
  }


}
