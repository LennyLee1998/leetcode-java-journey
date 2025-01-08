package LinkedList;

import java.util.List;

//https://leetcode.com/problems/linked-list-cycle-ii/description/
//https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0142.%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8II.md
//https://claude.ai/chat/14ee7cf1-1412-485d-afb9-65af1a74724f

//因为快指针速度是慢指针的2倍，所以：x + y + n(y + z) = 2(x + y)
//推导过程：
//x + y + n(y + z) = 2(x + y)
//x = (n-1)(y + z) + z
//当 n = 1 时：
//公式简化为 x = z
//这意味着：从头节点到环入口的距离 = 从相遇点到环入口的距离
//实际应用：
//在相遇点放一个指针（index1）
//在头节点放一个指针（index2）
//两个指针同时每次走一步
//它们会在环形入口处相遇
//这就像两个人以相同的速度走路：
//一个人从链表头出发，要走x步到入口
//另一个人从相遇点出发，要走z步到入口
//因为 x = z，所以他们会同时到达入口点

public class LinkedListCysleII_142 {
  public static class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }

  /**
   * 1.使用快慢指针检查是否存在环
   * 2.快慢指针相遇时,将慢指针重置到head
   * 3.让两个指针以相同速度移动,相遇点就是环的入口
   * @param head 头节点
   * @return 如果存在环,返回环的入口节点,否则返回null
   */
  public ListNode detectCycle(ListNode head) {
//    边界条件判断
    if (head == null || head.next == null) return null;

    ListNode fast = head;
    ListNode slow = head;

    // 1.使用快慢指针检查是否有环
    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      // 2.找到相遇点
      if (slow == fast) {
//        3.查环的入口
//        将慢指针重置回头节点, 快指针在相遇点
        slow = head;
//      两个指针以相同的速度进行移动, 知道相遇
        while (slow != fast) {
          slow = slow.next;
          fast = fast.next;
        }
        return fast;//环的起点
      }
    }

    return null;//没有cycle
  }
}
