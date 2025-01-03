package LinkedList;

//https://leetcode.com/problems/design-linked-list/description/
//https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0707.%E8%AE%BE%E8%AE%A1%E9%93%BE%E8%A1%A8.md
//双向链表实现
public class DesignLinkedList {

  // 双向链表节点定义为私有静态内部类
  private static class DoublyListNode {
    int val;
    DoublyListNode next, prev;

    DoublyListNode(int val) {
      this.val = val;
    }
  }

   DoublyListNode head, tail;
   int size;


  public DesignLinkedList() {
    size = 0;
    head = new DoublyListNode(0);
    tail = new DoublyListNode(0);
    head.next = tail;
    tail.prev = head;
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




