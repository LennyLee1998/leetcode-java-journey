package LinkedList;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/design-linked-list/description/
//https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0707.%E8%AE%BE%E8%AE%A1%E9%93%BE%E8%A1%A8.md
public class DesignLinkedList {
  public static void main(String[] args) {
  }

}
//双链表实现
class MyLinkedList {
  class DoublyListNode {
    int val;
    DoublyListNode next, prev;

    public DoublyListNode(int val) {
      this.val = val;
    }
  }

  private DoublyListNode head, tail;
  private int size;

  public MyLinkedList() {
    this.size = 0;
    this.head = new DoublyListNode(0);
    this.tail = new DoublyListNode(0);
    this.head.next = tail;
    this.tail.prev = head;
  }
  public int get(int index) {
    if (index >= size || index < 0) {
      return -1;
    }
    DoublyListNode cur = head;
    if (index >= size /2) {
      cur = tail;
      for (int i = 0; i < size - index; i++) {
        cur = cur.prev;
      }
    }else {
      for (int i = 0; i <= index; i++) {
        cur = cur.next;
      }
    }
    return cur.val;
  }

  public void addAtHead(int val) {
    addAtIndex(0, val);

  }

  public void addAtTail(int val) {
    addAtIndex(size, val);

  }

  public void addAtIndex(int index, int val) {
    if (index < 0 || index > size) {
      return;
    }
    DoublyListNode prev = head;
    for (int i = 0; i < index; i++) {
      prev = prev.next;
    }
    DoublyListNode newNode = new DoublyListNode(val);
    newNode.next = prev.next;
    prev.next.prev = newNode;
    newNode.prev = prev;
    prev.next = newNode;
    size++;
  }

  public void deleteAtIndex(int index) {
    if (index < 0 || index >= size) {
      return;
    }
    DoublyListNode pre= head;
    for (int i = 0; i < index; i++) {
      pre = pre.next;
    }
    pre.next = pre.next.next;
    pre.next.next.prev = pre;
  }

}
//单链表实现
class MyLinkedList2 {
// dummynode在增删节点是比较有用的, dummy node本身不能为null,否则的话取不到next属性, 也就没有意义了
//  避免处理空链表或者链表边界
  private ListNode dummyHead;
  private int size;

  public MyLinkedList2() {
    this.size = 0;
    this.dummyHead = new ListNode(0);
  }

  public int get(int index) {

    if (index < 0 || index >= size) {
      return -1;
    }

    ListNode cur = dummyHead;
    for (int i = 0; i <= index; i++) {
      cur = cur.next;
    }

    return cur.val;
  }

  public void addAtHead(int val) {
    ListNode newNode = new ListNode(val);

    newNode.next = dummyHead.next;
    dummyHead.next = newNode;
    size++;

  }

  public void addAtTail(int val) {
    ListNode newNode = new ListNode(val);
    ListNode cur = dummyHead;
    while (cur.next != null) {
      cur = cur.next;
    }
    cur.next = newNode;
    size++;
  }

  public void addAtIndex(int index, int val) {
    if (index < 0 || index > size) {
      return;
    }
    ListNode newNode = new ListNode(val);
    ListNode last = dummyHead;
    for (int i = 0; i < index; i++) {
      last = last.next;
    }
    newNode.next = last.next;
    last.next = newNode;
    size++;
  }

  public void deleteAtIndex(int index) {
    if (index < 0 || index >= size) {
      return;
    }
    ListNode last = dummyHead;
    for (int i = 0; i < index; i++) {
      last = last.next;
    }
    last.next = last.next.next;
    size--;
  }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

